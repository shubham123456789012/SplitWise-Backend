package com.example.backend.split_wise.repository;

import com.example.backend.split_wise.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDao,Long> {

}
