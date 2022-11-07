package com.api.ponline.model.Entity.kolam;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.api.ponline.model.Entity.komunitas.Komunitas;

@Entity
@Table(name = "TAB_KOLAM")
public class Kolam implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bwvecxxrfj")
    private Long id;

    @Column(name = "jvvagcwjau", length = 50)
    private String name;

    @ManyToOne
    private Komunitas komunitas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Komunitas getKomunitas() {
        return komunitas;
    }

    public void setKomunitas(Komunitas komunitas) {
        this.komunitas = komunitas;
    }

    
    
}
