package com.example.First.repo;

import com.example.First.ClassEntity.ServerDevices;
import com.example.First.ClassEntity.ServerRack;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServerDevicesRepo extends CrudRepository<ServerDevices,Long> {
    List<ServerDevices> findByserverRack(ServerRack serverRack);
}
