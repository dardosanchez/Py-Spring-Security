package org.example.proyectofinalspringsecurity.controller;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.example.proyectofinalspringsecurity.dto.AuthLoginRequestDTO;
import org.example.proyectofinalspringsecurity.dto.AuthResponseDTO;
import org.example.proyectofinalspringsecurity.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImp userDetailsService;


    @PostMapping("/login")
    @PermitAll
    public ResponseEntity<AuthResponseDTO> login (@RequestBody @Valid AuthLoginRequestDTO userRequest){
        return new ResponseEntity<>(this.userDetailsService.loginUser(userRequest), HttpStatus.OK);
    }

}
