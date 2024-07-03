package com.github.paradoxshub.prandellablog.controller;

import com.github.paradoxshub.prandellablog.Input.AddUserInput;
import com.github.paradoxshub.prandellablog.entity.User;
import com.github.paradoxshub.prandellablog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/v1/user/add",method = RequestMethod.POST)
    @ResponseBody
    public List<User> addUser(
            @RequestBody AddUserInput addUserInput
            ){
        return userService.addUser(addUserInput);
    }

    @RequestMapping(value = "/api/v1/user/update",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String updateUser(

    ){

    }

}
