package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
public class TestController {
    @RequestMapping("/worker")
    @ResponseBody
    public String worker(String name,String pwd){
        System.out.println("name="+name+"  "+pwd);
        return "hello springmvc";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
