package com.github.paradoxshub.prandellablog.controller;

import com.github.paradoxshub.prandellablog.common.ErrorCode;
import com.github.paradoxshub.prandellablog.common.ErrorMessage;
import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.input.LoginInput;
import com.github.paradoxshub.prandellablog.input.RegisterUserInput;
import com.github.paradoxshub.prandellablog.input.UpdateUserInput;
import com.github.paradoxshub.prandellablog.output.*;
import com.github.paradoxshub.prandellablog.service.UserService;
import com.github.paradoxshub.prandellablog.util.AesEncryptUtils;
import com.github.paradoxshub.prandellablog.util.TokenUtils;
import com.github.paradoxshub.prandellablog.util.RSAUtils;
import com.github.paradoxshub.prandellablog.util.ServletUtil;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.*;


@RestController
public class UserController {
    final private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiResponse(responseCode = "200", description = "register success",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = RegisterUserOutput.class))})
    @RequestMapping(value = "/api/v1/register", method = RequestMethod.POST)
    @ResponseBody
    public Response register(
            @RequestBody @Validated RegisterUserInput input
    ) throws Exception {

        byte[] key = "1234567890abcdef".getBytes("UTF-8");
        // AES对称解密
        String originPassword = Arrays.toString(AesEncryptUtils.decrypt(key,input.getFirstPassword()));

        // 判断第一次密码和第二次输入的密码是否相同
        if (!Objects.equals(input.getFirstPassword(), input.getSecondPassword())){
            return BaseResponse.error(ErrorCode.passwordIsDifferent, ErrorMessage.passwordIsDifferent);
        }

        // RSA非对称加密
        // 获取公钥加密
        RSAUtils.Key key1 = new RSAUtils.Key("key1");
        byte[] encrypted = key1.encrypt(originPassword.getBytes());
        input.setFirstPassword(Arrays.toString(encrypted));
        input.setSecondPassword(Arrays.toString(encrypted));

        return BaseResponse.ok(userService.register(input));
    }

    @ApiResponse(responseCode = "200", description = "login success",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = LoginOutput.class))})
    @RequestMapping(value = "api/v1/login", method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestBody @Validated LoginInput input){
        System.out.println(ServletUtil.getIpAddr());
        LoginOutput output = userService.login(input);
        if (Objects.equals(output.getMessage(), "登陆成功")){
            return BaseResponse.ok(output);
        } else if (output.getMessage().equals("登陆失败，密码错误")){
            return BaseResponse.error(ErrorCode.passwordIsFalse,ErrorMessage.passwordIsFalse);
        } else if (output.getMessage().equals("该账户未注册")) {
            return BaseResponse.error(ErrorCode.userIsNotRegistered,ErrorMessage.userIsNotRegistered);
        }
        return BaseResponse.ok(output);
    }

    @ApiResponse(responseCode = "200", description = "search login success",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = LoginOutput.class))})
    @RequestMapping(value = "api/v1/loginHistory", method = RequestMethod.GET)
    @ResponseBody
    public Response loginHistory(@RequestParam int limit,
                                 @RequestParam int offset){
        // limit 2 offset 1,指的从第一条开始取两条
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(attributes)) {
            throw new RuntimeException();
        }
        // 获取Request的方法
        // ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // HttpServletRequest request= Objects.requireNonNull(attributes).getRequest();

        // 验证令牌
        if (!TokenUtils.verifyToken()) {
            return BaseResponse.error(ErrorCode.userIsNotAuthorized,ErrorMessage.userIsNotAuthorized);
        }
        LoginHistoryListOutput output = userService.selectLoginHistory(limit,offset);
        return BaseResponse.ok(output);
    }



    @ApiResponse(responseCode = "200", description = "insert a user success",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = InsertUserOutput.class))})
    @RequestMapping(value = "/api/v1/users", method = RequestMethod.POST)
    @ResponseBody
    public Response insertUser(
            @RequestBody @Validated InsertUserInput input
    ) {
        InsertUserOutput output = userService.insertUser(input);
        return BaseResponse.ok(output);
    }

    @ApiResponse(responseCode = "200", description = "update a user success",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UpdateUserOutput.class))})
    @RequestMapping(value = "/api/v1/users", method = RequestMethod.PUT)
    @ResponseBody
    public Response updateUser(
            @RequestBody @Validated UpdateUserInput input
    ) {
        UpdateUserOutput output = userService.updateUser(input);
        return BaseResponse.ok(output);
    }

    @ApiResponse(responseCode = "200", description = "select a user success",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = SelectUserOutput.class))})
    @RequestMapping(value = "/api/v1/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Response selectUserById(
            @PathVariable Long id
    ) {
        return BaseResponse.ok(userService.selectUserById(id));
    }

    @ApiResponse(responseCode = "200", description = "select user list success",
            content = {@Content(mediaType = "application/json")})
    @RequestMapping(value = "/api/v1/users", method = RequestMethod.GET)
    @ResponseBody
    public Response selectUser(
            @RequestParam int limit,
            @RequestParam int offset,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phonenumber
    ) {
        Object output = null;
        if (StringUtils.isNoneEmpty(username)){
            output = userService.selectUserByUserName(username);
        } else if (StringUtils.isNoneEmpty(email)) {
            output = userService.selectUserByEmail(email);
        }else if (StringUtils.isNoneEmpty(phonenumber)){
            output = userService.selectUserByPhonenumber(phonenumber);
        }else {
            output = userService.selectUser(limit, offset);
        }
        return BaseResponse.ok(output);
    }


    @ApiResponse(responseCode = "200", description = "delete a user success",
            content = {@Content(mediaType = "application/json")})
    @RequestMapping(value = "/api/v1/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Response deleteUser(
            @PathVariable Long id
    ) {
        return BaseResponse.ok(userService.deleteUserById(id));
    }

    @ApiResponse(responseCode = "200",description = "ban a user success",
            content={@Content(mediaType = "application/json")})
    @RequestMapping(value = "/api/v1/user/{userId}/ban",method = RequestMethod.PATCH)
    @ResponseBody
    public Response banUser(
            @PathVariable Long userId
    ){
        Long success=userService.banUser(userId);
        if (success!=null&&success>0) {
            return BaseResponse.ok(userId);
        } else {
            return BaseResponse.error("Failed to ban user with ID "+userId+".");
        }
    }
}
