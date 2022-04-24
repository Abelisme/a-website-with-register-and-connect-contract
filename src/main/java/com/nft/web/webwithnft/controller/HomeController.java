package com.nft.web.webwithnft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomeController
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    // @ResponseBody
    public ModelAndView goInit(HttpServletRequest request,HttpServletResponse response){
        return new ModelAndView("common");
    }

    @RequestMapping(value = "/home")
    // @ResponseBody
    public ModelAndView goHome(HttpServletRequest request,HttpServletResponse response){
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/bayc-sample")
    public ModelAndView goBaycSample(HttpServletRequest request,HttpServletResponse response){
        return new ModelAndView("bayc-sample");
    }

}