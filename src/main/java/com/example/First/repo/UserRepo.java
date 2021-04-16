package com.example.First.repo;

import com.example.First.Security.USER;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<USER,Long> {
    USER findByUsername(String username);
}
