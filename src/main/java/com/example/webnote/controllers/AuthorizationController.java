package com.example.webnote.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//@Controller
public class AuthorizationController {
    @GetMapping("authorization")
    public String authorization(Model model) {
        return "authorization";
    }
}
