package com.example.First.ClassEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ServerDevices{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String typedevice;
    private String model;
    private String serial;
    private int beginunit;
    private int endunit;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "srvrack_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ServerRack serverRack;

    public ServerDevices(long id, String typedevice, String model, String serial, int beginunit, int endunit, ServerRack serverRack) {
        this.id = id;
        this.typedevice = typedevice;
        this.model = model;
        this.serial = serial;
        this.beginunit = beginunit;
        this.endunit = endunit;
        this.serverRack = serverRack;
    }

    public ServerDevices() {
    }

    public int getBeginunit() {
        return beginunit;
    }

    public void setBeginunit(int beginunit) {
        this.beginunit = beginunit;
    }

    public int getEndunit() {
        return endunit;
    }

    public void setEndunit(int endunit) {
        this.endunit = endunit;
    }

    public ServerRack getServerRack() {
        return serverRack;
    }

    public void setServerRack(ServerRack serverRack) {
        this.serverRack = serverRack;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypedevice() {
        return typedevice;
    }

    public void setTypedevice(String typedevice) {
        this.typedevice = typedevice;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}