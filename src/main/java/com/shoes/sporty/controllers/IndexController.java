package com.shoes.sporty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "/")
public class IndexController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
