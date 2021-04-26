package com.example.First.ClassEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ServerRack {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;
    private int countunit;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "placepd_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PlaceProccesingData placeProccesingData;

    public ServerRack() {
    }

    public ServerRack(long id, int number, int countunit, PlaceProccesingData placeProccesingData) {
        this.id = id;
        this.number = number;
        this.countunit = countunit;
        this.placeProccesingData = placeProccesingData;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCountunit() {
        return countunit;
    }

    public void setCountunit(int countunit) {
        this.countunit = countunit;
    }

    public PlaceProccesingData getPlaceProccesingData() {
        return placeProccesingData;
    }

    public void setPlaceProccesingData(PlaceProccesingData placeProccesingData) {
        this.placeProccesingData = placeProccesingData;
    }
}
