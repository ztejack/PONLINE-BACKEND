package com.api.ponline.controllers.jadwal;

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

import com.api.ponline.dao.Request.JadwalDetailsRequest;
import com.api.ponline.dao.Response.AbstractResponse;
import com.api.ponline.model.Entity.jadwal.JadwalDetails;
import com.api.ponline.services.jadwal.JadwalDetailServices;

@RestController
@RequestMapping("/jadwaldetails")
public class JadwalDetailsController {

    @Autowired
    private JadwalDetailServices jadwalDetailServices;
    
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<AbstractResponse<JadwalDetails>> create(@Valid @RequestBody JadwalDetailsRequest jadwalDetailsRequest, Errors errors ) {
    
        AbstractResponse<JadwalDetails> responseData = new AbstractResponse<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        JadwalDetails jadwalDetails = modelMapper.map(jadwalDetailsRequest, JadwalDetails.class);
        responseData.setStatus(true);
        responseData.setPayLoad(jadwalDetailServices.save(jadwalDetails));
        return ResponseEntity.ok(responseData);       

    }

    @PutMapping
    public ResponseEntity<AbstractResponse<JadwalDetails>> update(@Valid @RequestBody JadwalDetailsRequest jadwalDetailsRequest, Errors errors ) {
    
        AbstractResponse<JadwalDetails> responseData = new AbstractResponse<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        JadwalDetails jadwalDetails = modelMapper.map(jadwalDetailsRequest, JadwalDetails.class);
        responseData.setStatus(true);
        responseData.setPayLoad(jadwalDetailServices.save(jadwalDetails));
        return ResponseEntity.ok(responseData);       

    }

    @GetMapping
    public Iterable<JadwalDetails> findAll() {
        return jadwalDetailServices.findAll();
    }
    
}
