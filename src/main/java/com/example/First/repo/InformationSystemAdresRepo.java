package com.example.First.repo;

import com.example.First.ClassEntity.InformationSystem;
import com.example.First.ClassEntity.InformationSystemAdress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InformationSystemAdresRepo extends CrudRepository<InformationSystemAdress, Long> {
    List<InformationSystemAdress> findByInformationSystem(InformationSystem informationSystem);
}
