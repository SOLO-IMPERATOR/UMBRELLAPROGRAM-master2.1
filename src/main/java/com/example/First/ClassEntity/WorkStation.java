package com.example.First.ClassEntity;

import com.example.First.ClassEntity.InformationSystem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class WorkStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "placeProccesing_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PlaceProccesingData placeProccesingData;

    public WorkStation(Long id, PlaceProccesingData placeProccesingData) {
        this.id = id;
        this.placeProccesingData = placeProccesingData;
    }

    public WorkStation() {
    }

    public PlaceProccesingData getPlaceProccesingData() {
        return placeProccesingData;
    }

    public void setPlaceProccesingData(PlaceProccesingData placeProccesingData) {
        this.placeProccesingData = placeProccesingData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
