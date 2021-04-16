package com.example.First.ClassEntity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class PlaceProccesingData{
    @Id

    private Long id;
    private String place;
    private int floor;
    private Blob image;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "infsysadres_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private InformationSystemAdress informationSystemAdress;

    public PlaceProccesingData() {
    }

    public PlaceProccesingData(Long id, String place, int floor, Blob image, InformationSystemAdress informationSystemAdress) {
        this.id = id;
        this.place = place;
        this.floor = floor;
        this.image = image;
        this.informationSystemAdress = informationSystemAdress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public InformationSystemAdress getInformationSystemAdress() {
        return informationSystemAdress;
    }

    public void setInformationSystemAdress(InformationSystemAdress informationSystemAdress) {
        this.informationSystemAdress = informationSystemAdress;
    }
}
