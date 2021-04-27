package com.example.First.ClassEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class HostVirtualization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String netname;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id", nullable = false)
    private List<ServerDevices> servers;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "infsys_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private InformationSystem informationSystem;
    public HostVirtualization() {
    }

    public InformationSystem getInformationSystem() {
        return informationSystem;
    }

    public void setInformationSystem(InformationSystem informationSystem) {
        this.informationSystem = informationSystem;
    }

    public HostVirtualization(Long id, String netname, List<ServerDevices> servers, InformationSystem informationSystem) {
        this.id = id;
        this.netname = netname;
        this.servers = servers;
        this.informationSystem = informationSystem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNetname() {
        return netname;
    }

    public void setNetname(String netname) {
        this.netname = netname;
    }

    public List<ServerDevices> getServers() {
        return servers;
    }

    public void setServers(List<ServerDevices> servers) {
        this.servers = servers;
    }
}
