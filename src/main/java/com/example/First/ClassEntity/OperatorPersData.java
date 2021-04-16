package com.example.First.ClassEntity;

import com.example.First.Security.USER;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class OperatorPersData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String shortname;
    private String inn;
    private String kpp;
    private String dateofcreate;
    private String urad;
    private String factad;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private USER user;

    public USER getUserId() {
        return user;
    }

    public void setUser(USER user) {
        this.user= user;
    }

    public OperatorPersData() {
    }

    public OperatorPersData(String name, String shortname, String inn, String kpp, String date, String urad, String factad,long id,USER user) {
        this.name = name;
        this.shortname = shortname;
        this.inn = inn;
        this.kpp = kpp;
        this.dateofcreate = date;
        this.urad = urad;
        this.factad = factad;
        this.id = id;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getDate() {
        return dateofcreate ;
    }

    public void setDate(String date) {
        this.dateofcreate  = date;
    }

    public String getUrad() {
        return urad;
    }

    public void setUrad(String urad) {
        this.urad = urad;
    }

    public String getFactad() {
        return factad;
    }

    public void setFactad(String factad) {
        this.factad = factad;
    }
}
