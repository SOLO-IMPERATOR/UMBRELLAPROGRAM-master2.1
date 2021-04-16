package com.example.First.ClassEntity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class InformationSystemAdress{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Region;
    private String City;
    private String Street;
    private String House;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "infsys_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private InformationSystem informationSystem;

    public InformationSystemAdress() {
    }

    public InformationSystemAdress(Long id, String region, String city, String street, String house, InformationSystem informationSystem) {
        this.id = id;
        Region = region;
        City = city;
        Street = street;
        House = house;
        this.informationSystem = informationSystem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getHouse() {
        return House;
    }

    public void setHouse(String house) {
        House = house;
    }

    public InformationSystem getInformationSystem() {
        return informationSystem;
    }

    public void setInformationSystem(InformationSystem informationSystem) {
        this.informationSystem = informationSystem;
    }
}
