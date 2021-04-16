package com.example.First.ClassEntity.WorkStation;

import com.example.First.ClassEntity.InformationSystem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class WorkStation {
    @Id
    private Long id;
    private String modelBox;
    private String serialBox;
    private String modelMonitor;
    private String serialMonitor;
    private String modelMouse;
    private String serialMouse;
    private String modelKeyboard;
    private String serialKeyboard;
    private String modelSound;
    private String serialSound;
    private String modelPrinter;
    private String serialPrinter;
    private String modelScaner;
    private String serialScaner;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "infsys_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private InformationSystem informationSystem;

    public WorkStation(Long id, String modelBox, String serialBox, String modelMonitor, String serialMonitor, String modelMouse, String serialMouse, String modelKeyboard, String serialKeyboard, String modelSound, String serialSound, String modelPrinter, String serialPrinter, String modelScaner, String serialScaner) {
        this.id = id;
        this.modelBox = modelBox;
        this.serialBox = serialBox;
        this.modelMonitor = modelMonitor;
        this.serialMonitor = serialMonitor;
        this.modelMouse = modelMouse;
        this.serialMouse = serialMouse;
        this.modelKeyboard = modelKeyboard;
        this.serialKeyboard = serialKeyboard;
        this.modelSound = modelSound;
        this.serialSound = serialSound;
        this.modelPrinter = modelPrinter;
        this.serialPrinter = serialPrinter;
        this.modelScaner = modelScaner;
        this.serialScaner = serialScaner;
    }

    public WorkStation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelBox() {
        return modelBox;
    }

    public void setModelBox(String modelBox) {
        this.modelBox = modelBox;
    }

    public String getSerialBox() {
        return serialBox;
    }

    public void setSerialBox(String serialBox) {
        this.serialBox = serialBox;
    }

    public String getModelMonitor() {
        return modelMonitor;
    }

    public void setModelMonitor(String modelMonitor) {
        this.modelMonitor = modelMonitor;
    }

    public String getSerialMonitor() {
        return serialMonitor;
    }

    public void setSerialMonitor(String serialMonitor) {
        this.serialMonitor = serialMonitor;
    }

    public String getModelMouse() {
        return modelMouse;
    }

    public void setModelMouse(String modelMouse) {
        this.modelMouse = modelMouse;
    }

    public String getSerialMouse() {
        return serialMouse;
    }

    public void setSerialMouse(String serialMouse) {
        this.serialMouse = serialMouse;
    }

    public String getModelKeyboard() {
        return modelKeyboard;
    }

    public void setModelKeyboard(String modelKeyboard) {
        this.modelKeyboard = modelKeyboard;
    }

    public String getSerialKeyboard() {
        return serialKeyboard;
    }

    public void setSerialKeyboard(String serialKeyboard) {
        this.serialKeyboard = serialKeyboard;
    }

    public String getModelSound() {
        return modelSound;
    }

    public void setModelSound(String modelSound) {
        this.modelSound = modelSound;
    }

    public String getSerialSound() {
        return serialSound;
    }

    public void setSerialSound(String serialSound) {
        this.serialSound = serialSound;
    }

    public String getModelPrinter() {
        return modelPrinter;
    }

    public void setModelPrinter(String modelPrinter) {
        this.modelPrinter = modelPrinter;
    }

    public String getSerialPrinter() {
        return serialPrinter;
    }

    public void setSerialPrinter(String serialPrinter) {
        this.serialPrinter = serialPrinter;
    }

    public String getModelScaner() {
        return modelScaner;
    }

    public void setModelScaner(String modelScaner) {
        this.modelScaner = modelScaner;
    }

    public String getSerialScaner() {
        return serialScaner;
    }

    public void setSerialScaner(String serialScaner) {
        this.serialScaner = serialScaner;
    }
}
