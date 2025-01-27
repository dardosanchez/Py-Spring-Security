package org.example.proyectofinalspringsecurity.repository;

import org.example.proyectofinalspringsecurity.model.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserSec,Long> {
    Optional<UserSec> findUserEntityByUsername(String username);
}
