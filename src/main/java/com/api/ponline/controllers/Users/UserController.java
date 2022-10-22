package com.api.ponline.controllers.Users;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ponline.Dto.ResponseData;
import com.api.ponline.Dto.Users.UserData;
import com.api.ponline.Models.Entity.Users.User;
import com.api.ponline.Services.Users.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService usersService;

    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping("/register")
    public ResponseEntity<ResponseData<User>> register(@Valid @RequestBody UserData userData, Errors errors) {
    
        ResponseData<User> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        
        User user = modelMapper.map(userData, User.class);
        responseData.setPayLoad(usersService.registeUser(user));
        responseData.setStatus(true);
        responseData.getMessages().add("User saved");
        return ResponseEntity.ok(responseData);       

    }

    @GetMapping("/readall")
    public Iterable<User> findAll(){
        return usersService.findAll();
    }

    @GetMapping
    public String welcome(){
        return "Welcome to API PONLINE for User";
    }
    
}
