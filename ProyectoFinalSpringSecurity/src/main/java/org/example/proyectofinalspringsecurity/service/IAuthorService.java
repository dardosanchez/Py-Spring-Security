package org.example.proyectofinalspringsecurity.service;

import org.example.proyectofinalspringsecurity.model.Author;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    public List<Author> getAllAuthors();
    public Optional<Author> getAuthorById(Long id);
    public Author saveAuthor(Author author);
    public void deleteAuthor(Long id);
    public Author updateAuthor(Author author,Long id);
}
