package com.example.First.repo;

import com.example.First.ClassEntity.WorkStation;
import com.example.First.ClassEntity.externalDevice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ExternalDeviceRepo extends CrudRepository<externalDevice,Long> {
    List<externalDevice> findByworkStation(WorkStation workStation);
    Optional<externalDevice> findById(Long id);
}
