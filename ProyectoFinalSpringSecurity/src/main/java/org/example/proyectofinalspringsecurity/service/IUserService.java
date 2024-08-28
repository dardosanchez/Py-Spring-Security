package org.example.proyectofinalspringsecurity.service;

import org.example.proyectofinalspringsecurity.model.UserSec;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<UserSec> findAll();
    public Optional<UserSec> findById(Long id);
    public UserSec save(UserSec userSec);
    public void deleteById(Long id);
    public void update(UserSec userSec);
    public String encriptPassword(String password);
}
