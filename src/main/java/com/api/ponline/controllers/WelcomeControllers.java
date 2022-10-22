package com.api.ponline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class WelcomeControllers {
    
    @GetMapping
    public RedirectView welcome() {
        return new RedirectView("documentation");
    }
    
}
