package com.github.paradoxshub.prandellablog.controller;

import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.input.UpdateUserInput;
import com.github.paradoxshub.prandellablog.output.*;
import com.github.paradoxshub.prandellablog.service.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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
            @RequestParam(required = false) String email
    ) {
        Object output = null;
        if (StringUtils.isNoneEmpty(username)){
            output = userService.selectUserByUserName(username);
        } else if (StringUtils.isNoneEmpty(email)) {
            output = userService.selectUserByEmail(email);
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
