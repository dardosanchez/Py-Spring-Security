package org.example.proyectofinalspringsecurity.repository;

import org.example.proyectofinalspringsecurity.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post,Long> {
}
