package com.demosecureapi.demosecureapi.repository;

import com.demosecureapi.demosecureapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByUserName(String userName);
}
