package com.conferenceIT.conferenceIT.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {

    @RequestMapping("/")
    public String start()  {
        return "index";
    }

}
