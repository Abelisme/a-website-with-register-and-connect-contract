package com.nft.web.webwithnft.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.web.webwithnft.model.Register;
import com.nft.web.webwithnft.service.RegisterService;
import com.nft.web.webwithnft.utils.AesUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/go-register", produces = "application/json;charset=UTF-8")
    public @ResponseBody Map<String, Object> goRegister(HttpServletRequest request, HttpServletResponse response, @RequestBody Register register){
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try {
            //encode
            String encryptAddr = AesUtils.encrypt(register.getAddress());
            //save into db
            Register insertRegister = new Register();
            insertRegister.setAddress(encryptAddr);
            int result = registerService.insert(insertRegister);
            jsonMap.put("result", result);
        } catch (Exception e) {
            jsonMap.put("errorMsg", e.getMessage());
        }
        
        return jsonMap;
    }
}
