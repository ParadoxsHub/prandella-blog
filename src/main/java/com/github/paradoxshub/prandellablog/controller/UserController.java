package com.github.paradoxshub.prandellablog.controller;

import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.output.BaseResponse;
import com.github.paradoxshub.prandellablog.output.InsertUserOutput;
import com.github.paradoxshub.prandellablog.output.Response;
import com.github.paradoxshub.prandellablog.output.SelectUserOutput;
import com.github.paradoxshub.prandellablog.service.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
            @RequestParam int offset
    ) {
        return BaseResponse.ok(userService.selectUser(limit, offset));
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


}
