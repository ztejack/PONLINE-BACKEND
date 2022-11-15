package com.api.ponline.controllers.komunitas;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ponline.dao.Request.AnggotaRequest;
import com.api.ponline.dao.Response.AbstractResponse;
import com.api.ponline.model.Entity.komunitas.Anggota;
import com.api.ponline.model.Entity.komunitas.Komunitas;
import com.api.ponline.model.Entity.user.User;
import com.api.ponline.model.repository.user.UserRepository;
import com.api.ponline.services.komunitas.AnggotaServices;
import com.api.ponline.services.komunitas.KomunitasServices;

@RestController
@RequestMapping("/anggota")
public class AnggotaController {

    @Autowired
    private AnggotaServices anggotaServices;

    @Autowired
    private KomunitasServices komunitasServices;

    @Autowired
    private UserRepository userRepository;
    

    @PostMapping
    public ResponseEntity<AbstractResponse<Anggota>> create(@Valid @RequestBody AnggotaRequest anggotaRequest, Errors errors ) {
    
        AbstractResponse<Anggota> responseData = new AbstractResponse<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Komunitas komunitas = komunitasServices.findOne(anggotaRequest.getKomunitas().getId());
        User user = userRepository.findOneById(anggotaRequest.getUser().getId());
        Anggota anggota = new Anggota();
        anggota.setKomunitas(komunitas);
        anggota.setUser(user);
        responseData.setStatus(true);
        responseData.setPayLoad(anggotaServices.save(anggota));
        return ResponseEntity.ok(responseData);       

    }

    @PutMapping
    public ResponseEntity<AbstractResponse<Anggota>> upsate(@Valid @RequestBody AnggotaRequest anggotaRequest, Errors errors ) {
    
        AbstractResponse<Anggota> responseData = new AbstractResponse<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Komunitas komunitas = komunitasServices.findOne(anggotaRequest.getKomunitas().getId());
        User user = userRepository.findOneById(anggotaRequest.getUser().getId());
        Anggota anggota = new Anggota();
        anggota.setKomunitas(komunitas);
        anggota.setUser(user);
        responseData.setStatus(true);
        responseData.setPayLoad(anggotaServices.save(anggota));
        return ResponseEntity.ok(responseData);       

    }

    @GetMapping
    public Iterable<Anggota> findAll() {
        return anggotaServices.findAll();
    }

    @GetMapping("/user/{user}")
    public List<Anggota> findByUser(@PathVariable("user") User user) {
        return anggotaServices.findByUser(user);
    }

    @GetMapping("/komunitas/{komunitas}")
    public List<Anggota> findByKomunitas(@PathVariable("komunitas") Komunitas komunitas) {
        return anggotaServices.findByKomunitas(komunitas);
    }
    
}
