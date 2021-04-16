package com.example.First.repo;

import com.example.First.ClassEntity.InformationSystem;
import com.example.First.ClassEntity.OperatorPersData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InformationSystemRepo extends CrudRepository<InformationSystem,Long> {
    List<InformationSystem> findByOperator(OperatorPersData operator);
    List<InformationSystem> findByIdAndOperator(Long id,OperatorPersData operator);
}
