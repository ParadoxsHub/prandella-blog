package com.github.paradoxshub.prandellablog.controller;

import com.github.paradoxshub.prandellablog.common.ErrorCode;
import com.github.paradoxshub.prandellablog.common.ErrorMessage;
import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.output.BaseResponse;
import com.github.paradoxshub.prandellablog.output.InsertUserOutput;
import com.github.paradoxshub.prandellablog.output.Response;
import com.github.paradoxshub.prandellablog.service.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    final private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiResponse(responseCode = "200", description = "insert a user success",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = InsertUserOutput.class)) })
    @RequestMapping(value = "/api/v1/users", method = RequestMethod.POST)
    @ResponseBody
    public Response insertUser(
            @RequestBody @Validated InsertUserInput input
    ) {

        // 这里检查参数格式，并调用service, 返回对象

        // check param like
        // 用户名长度小于5，则返回错误
//        if (input.getUsername().length() < 5) {
//            return new BaseResponse(ErrorCode.usernameIsTooShort, ErrorMessage.usernameIsTooShort);
//        }

        InsertUserOutput output = userService.insertUser(input);
        return BaseResponse.ok(output);
    }


}
