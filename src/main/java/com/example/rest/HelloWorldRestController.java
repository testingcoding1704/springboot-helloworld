package com.example.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
    @RequestMapping("/")
    public String helloWorld() {
        String result = "Hello World";
        String helloWorldTo = System.getenv("VERSION");
        if (helloWorldTo != null && !"".equals(helloWorldTo)) {
            result += " VERSION=" + helloWorldTo;
        }
        return result;
    }
}