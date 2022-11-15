package com.api.ponline.dao.Request;

import javax.validation.constraints.NotEmpty;

public class KomunitasRequest {

    private Long Id;

    @NotEmpty(message = "Nama Harus Di isi")
    private String nama;

    @NotEmpty(message = "Alamat Harus Di isi")
    private String alamat;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    

    

    
}
