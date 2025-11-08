package com.saihoz.login.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saihoz.login.Model.User.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);

}
