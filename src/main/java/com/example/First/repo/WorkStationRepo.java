package com.example.First.repo;

import com.example.First.ClassEntity.PlaceProccesingData;
import com.example.First.ClassEntity.WorkStation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkStationRepo extends CrudRepository<WorkStation,Long> {
    List<WorkStation> findByplaceProccesingData(PlaceProccesingData placeProccesingData);
    WorkStation findById(long id);
}
