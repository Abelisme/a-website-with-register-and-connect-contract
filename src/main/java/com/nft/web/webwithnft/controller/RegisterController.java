package com.nft.web.webwithnft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.web.webwithnft.model.Register;
import com.nft.web.webwithnft.service.RegisterService;
import com.nft.web.webwithnft.utils.AesUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/register")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("register");
    }
    
    @RequestMapping(value = "/register-test")
    public ModelAndView goRegisterTest(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("register_test");
    }

    @RequestMapping(value = "/go-register")
    public ModelAndView goRegister(HttpServletRequest request, HttpServletResponse response, @RequestBody Register register){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        try {
            //encode
            String encryptAddr = AesUtils.encrypt(register.getAddress());
            //save into db
            Register insertRegister = new Register();
            insertRegister.setAddress(encryptAddr);
            int result = registerService.insert(insertRegister);
            System.out.println("result: " + result);
            modelAndView.addObject("result", result);
        } catch (Exception e) {
            modelAndView.addObject("errorMsg", e.getMessage());
        }
        
        return modelAndView;
    }
    
}
