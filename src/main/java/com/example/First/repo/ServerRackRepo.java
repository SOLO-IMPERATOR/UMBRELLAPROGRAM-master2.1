package com.example.First.repo;

import com.example.First.ClassEntity.PlaceProccesingData;
import com.example.First.ClassEntity.ServerRack;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServerRackRepo extends CrudRepository<ServerRack,Long> {
    List<ServerRack> findByplaceProccesingData(PlaceProccesingData placeProccesingData);
}
