package org.example.proyectofinalspringsecurity.repository;

import org.example.proyectofinalspringsecurity.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Long> {
}
