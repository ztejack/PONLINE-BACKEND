package com.api.ponline.controllers.kolam;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ponline.dao.Request.KolamRequest;
import com.api.ponline.dao.Response.AbstractResponse;
import com.api.ponline.model.Entity.kolam.Kolam;
import com.api.ponline.services.kolam.KolamServices;

@RestController
@RequestMapping("/kolam")
public class KolamController {

    @Autowired
    private KolamServices kolamServices;
    
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<AbstractResponse<Kolam>> create(@Valid @RequestBody KolamRequest kolamRequest, Errors errors ) {
    
        AbstractResponse<Kolam> responseData = new AbstractResponse<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Kolam kolam = modelMapper.map(kolamRequest, Kolam.class);
        responseData.setStatus(true);
        responseData.setPayLoad(kolamServices.save(kolam));
        return ResponseEntity.ok(responseData);       

    }

    @PutMapping
    public ResponseEntity<AbstractResponse<Kolam>> update(@Valid @RequestBody KolamRequest kolamRequest, Errors errors ) {
    
        AbstractResponse<Kolam> responseData = new AbstractResponse<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Kolam kolam = modelMapper.map(kolamRequest, Kolam.class);
        responseData.setStatus(true);
        responseData.setPayLoad(kolamServices.save(kolam));
        return ResponseEntity.ok(responseData);       

    }


    @GetMapping
    public Iterable<Kolam> findAll() {
        return kolamServices.findAll();
    }

    
}
