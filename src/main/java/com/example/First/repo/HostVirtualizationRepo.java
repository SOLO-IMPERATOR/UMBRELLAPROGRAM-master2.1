package com.example.First.repo;

import com.example.First.ClassEntity.HostVirtualization;
import com.example.First.ClassEntity.InformationSystem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HostVirtualizationRepo extends CrudRepository<HostVirtualization,Long> {
        List<HostVirtualization> findByInformationSystem(InformationSystem informationSystem);
}
