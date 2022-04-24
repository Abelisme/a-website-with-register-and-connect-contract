package com.nft.web.webwithnft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
    @RequestMapping(value = "/register")
    public ModelAndView goRegister(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("register");
    }
    
    @RequestMapping(value = "/register-test")
    public ModelAndView goRegisterTest(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("register_test");
    }
}
