package com.marcuschiu.testframeworkexampleboot221.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Default1Controller {

    public Integer i = 0;

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }
}
