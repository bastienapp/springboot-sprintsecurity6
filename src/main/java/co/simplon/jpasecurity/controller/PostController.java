package co.simplon.jpasecurity.controller;

import co.simplon.jpasecurity.entity.Post;
import co.simplon.jpasecurity.repository.PostRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository posts;

    public PostController(PostRepository posts) {
        this.posts = posts;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Iterable findAll() {
        return posts.findAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Post findById(@PathVariable("id") Post post) {
        return post;
    }

}
