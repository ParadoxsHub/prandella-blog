package com.github.paradoxshub.prandellablog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class PingController {

    @RequestMapping(method = RequestMethod.GET, value = "/ping")
    public static String pingController() {
        return "pong";
    }
}
