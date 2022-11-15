package com.api.ponline.controllers.komunitas;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.ponline.dao.Request.KomunitasRequest;
import com.api.ponline.dao.Response.AbstractResponse;
import com.api.ponline.model.Entity.komunitas.Komunitas;
import com.api.ponline.services.komunitas.KomunitasServices;

@RestController
@RequestMapping("/komunitas")
public class KomunitasController {
    
    @Autowired
    private KomunitasServices komunitasServices;
    
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<AbstractResponse<Komunitas>> create(@Valid @RequestBody KomunitasRequest komunitasRequest, Errors errors ) {
    
        AbstractResponse<Komunitas> responseData = new AbstractResponse<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Komunitas komunitas = modelMapper.map(komunitasRequest, Komunitas.class);
        responseData.setStatus(true);
        responseData.setPayLoad(komunitasServices.save(komunitas));
        return ResponseEntity.ok(responseData);       

    }

    @PutMapping
    public ResponseEntity<AbstractResponse<Komunitas>> update(@Valid @RequestBody KomunitasRequest komunitasRequest, Errors errors ) {
    
        AbstractResponse<Komunitas> responseData = new AbstractResponse<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Komunitas komunitas = modelMapper.map(komunitasRequest, Komunitas.class);
        responseData.setStatus(true);
        responseData.setPayLoad(komunitasServices.save(komunitas));
        return ResponseEntity.ok(responseData);       

    }
    
    @GetMapping
    public Iterable<Komunitas> findAll(){
        return komunitasServices.findAll();
    }

    @GetMapping("/find")
    public Komunitas findOne(@RequestParam Long id) {
        return komunitasServices.findOne(id);
    }
}
