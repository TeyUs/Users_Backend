package com.example.ogrBackend.repository;

import com.example.ogrBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByUserName(String userName);
}
