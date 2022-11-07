package com.api.ponline.model.Entity.komunitas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.api.ponline.model.Entity.user.User;

@Entity
@Table(name = "TAB_ANGGOTA")
public class Anggota implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qriijjxteb")
    private Long id;
    
    @ManyToOne
    private Komunitas komunitas;
    
    @OneToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Komunitas getKomunitas() {
        return komunitas;
    }

    public void setKomunitas(Komunitas komunitas) {
        this.komunitas = komunitas;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
