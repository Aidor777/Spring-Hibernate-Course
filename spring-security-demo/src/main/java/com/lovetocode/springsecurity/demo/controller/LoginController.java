package com.lovetocode.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLoginPage() {
        // return "plain-login";
        return "fancy-login";
    }

    @GetMapping("/accessDenied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
