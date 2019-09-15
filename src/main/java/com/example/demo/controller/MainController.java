package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/delete/{id}")
    public String rrt2(@PathVariable int id) {
        System.out.println("MainController +" + id);
        return "Hello2";
    }

    @RequestMapping(value = "/pageEmptyParam")
    public String pageEmptyParam() {
        return "pageEmptyParam";
    }

    @RequestMapping(value = "/pageEmptyDelete")
    public String pageEmptyDelete() {
        return "pageEmptyDelete";
    }

    @RequestMapping(value = "/pageFraud")
    public String pageFraud() {
        return "pageFraud";
    }

    @RequestMapping(value = "/wrongParameterDelete")
    public String wrongParameterDelete() {
        return "wrongParameterDelete";
    }
}
