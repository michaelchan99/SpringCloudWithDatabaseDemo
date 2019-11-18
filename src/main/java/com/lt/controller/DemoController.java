package com.lt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demoController() {

        System.out.println("Michael");

        return "Michael";
    }
}
