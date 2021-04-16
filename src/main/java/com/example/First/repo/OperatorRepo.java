package com.example.First.repo;

import com.example.First.ClassEntity.InformationSystem;
import com.example.First.ClassEntity.OperatorPersData;
import com.example.First.Security.USER;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperatorRepo extends CrudRepository<OperatorPersData,Long> {
    List<OperatorPersData> findByUser(USER user);
    List<OperatorPersData> findByIdAndUser(Long id,USER user);

}
