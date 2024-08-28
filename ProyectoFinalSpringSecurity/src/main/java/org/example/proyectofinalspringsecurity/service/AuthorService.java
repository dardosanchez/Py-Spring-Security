package org.example.proyectofinalspringsecurity.service;

import org.example.proyectofinalspringsecurity.model.Author;
import org.example.proyectofinalspringsecurity.model.Post;
import org.example.proyectofinalspringsecurity.repository.IAuthorRepository;
import org.example.proyectofinalspringsecurity.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private IAuthorRepository authorRepository;
    @Autowired
    private IPostRepository postRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthor(Author author, Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        Post readPost;
        Set<Post> postList = new HashSet<>();

        if (authorOptional.isPresent()) {
            Author Newauthor = authorOptional.get();
            Newauthor.setName(author.getName());
            Newauthor.setEmail(author.getEmail());

            for(Post po : author.getPosts()) {
                readPost = postRepository.findById(po.getId()).orElse(null);
                if(readPost != null){
                    postList.add(readPost);
                }
            }

            Newauthor.setPosts(postList);
            return authorRepository.save(Newauthor);
        }
        return null;
    }
}
