package org.example.proyectofinalspringsecurity.service;

import org.example.proyectofinalspringsecurity.model.Post;
import org.example.proyectofinalspringsecurity.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService{

    @Autowired
    public IPostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Post post, Long id) {

        Optional<Post> optionalPost = postRepository.findById(id);


        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();

            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            existingPost.setCreatedAt(post.getCreatedAt());

            return postRepository.save(existingPost);
        } else {
            // Si el post no existe, lanzar una excepción o manejarlo como prefieras
            throw new RuntimeException("Post not found");
        }
    }
}
