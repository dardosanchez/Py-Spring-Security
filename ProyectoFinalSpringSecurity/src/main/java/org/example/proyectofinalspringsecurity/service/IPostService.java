package org.example.proyectofinalspringsecurity.service;

import org.example.proyectofinalspringsecurity.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    public List<Post> getAllPosts();
    public Optional<Post> getPostById(Long id);
    public Post savePost(Post post);
    public void deletePost(Long id);
    public Post updatePost(Post post,Long id);
}
