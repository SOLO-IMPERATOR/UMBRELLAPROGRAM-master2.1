package com.example.First.ClassEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class InformationSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private String shortName;
    private String dateofcreate;
    private int countPhysicalServer;
    private int countWorkStation;
    private int countHostVirtualization;
    private int countVirtualServer;
    private int countSystemSaveData;
    private int countLaptop;
    private int countMonoblock;
    private int countTablet;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "operator_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private OperatorPersData operator;

    public InformationSystem() {
    }

    public OperatorPersData getOperator() {
        return operator;
    }

    public void setOperatorid(OperatorPersData operator) {
        this.operator = operator;
    }

    public InformationSystem(String fullName, String shortName, String date, int countPhysicalServer, int countWorkStation, int countHostVirtualization, int countVirtualServer, int countSystemSaveData, int countLaptop, int countMonoblock, OperatorPersData operator, int countTablet) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.dateofcreate = date;
        this.countPhysicalServer = countPhysicalServer;
        this.countWorkStation = countWorkStation;
        this.countHostVirtualization = countHostVirtualization;
        this.countVirtualServer = countVirtualServer;
        this.countSystemSaveData = countSystemSaveData;
        this.countLaptop = countLaptop;
        this.countMonoblock = countMonoblock;
        this.operator = operator;
        this.countTablet = countTablet;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDate() {
        return dateofcreate;
    }

    public void setDate(String date) {
        this.dateofcreate = date;
    }

    public int getCountPhysicalServer() {
        return countPhysicalServer;
    }

    public void setCountPhysicalServer(int countPhysicalServer) {
        this.countPhysicalServer = countPhysicalServer;
    }

    public int getCountWorkStation() {
        return countWorkStation;
    }

    public void setCountWorkStation(int countWorkStation) {
        this.countWorkStation = countWorkStation;
    }

    public int getCountHostVirtualization() {
        return countHostVirtualization;
    }

    public void setCountHostVirtualization(int countHostVirtualization) {
        this.countHostVirtualization = countHostVirtualization;
    }

    public int getCountVirtualServer() {
        return countVirtualServer;
    }

    public void setCountVirtualServer(int countVirtualServer) {
        this.countVirtualServer = countVirtualServer;
    }

    public int getCountSystemSaveData() {
        return countSystemSaveData;
    }

    public void setCountSystemSaveData(int countSystemSaveData) {
        this.countSystemSaveData = countSystemSaveData;
    }

    public int getCountLaptop() {
        return countLaptop;
    }

    public void setCountLaptop(int countLaptop) {
        this.countLaptop = countLaptop;
    }

    public int getCountMonoblock() {
        return countMonoblock;
    }

    public void setCountMonoblock(int countMonoblock) {
        this.countMonoblock = countMonoblock;
    }

    public int getCountTablet() {
        return countTablet;
    }

    public void setCountTablet(int countTablet) {
        this.countTablet = countTablet;
    }



}
