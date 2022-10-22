package com.api.ponline.controllers.Documentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/documentation")
public class DocumentationController {
    
    @GetMapping("/users")
    public RedirectView users() {
        return new RedirectView("/documentation/users.html");
    }

    @GetMapping()
    public String welcome() {
        return "Welcome to documentation API PONLINE";
    }
    
}
