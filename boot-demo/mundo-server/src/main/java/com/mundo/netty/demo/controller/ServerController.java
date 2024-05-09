package com.mundo.netty.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("server")
public class ServerController {

    @RequestMapping("test")
    public String server() {
        return "success";
    }


}
