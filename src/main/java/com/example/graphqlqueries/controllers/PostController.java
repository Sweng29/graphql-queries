package com.example.graphqlqueries.controllers;

import com.example.graphqlqueries.dto.Author;
import com.example.graphqlqueries.dto.Comment;
import com.example.graphqlqueries.dto.Post;
import com.example.graphqlqueries.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.util.ParallelSorter;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @QueryMapping
    public Flux<Post> recentPosts(){
        return Flux.fromIterable(postService.findAllPosts());
    }

    @SchemaMapping(typeName="Post", field="author")
    public Mono<Author> author(Post post) {
        return Mono.just(post.getAuthor());
    }

    @BatchMapping(typeName = "Post", field = "comments")
    public Map<Post, List<Comment>> comments(List<Post> posts){
        return posts.stream().collect(Collectors.toMap(post -> post, Post::getComments));
    }

    @MutationMapping
    public Post addPost(@Argument String title, @Argument String text, @Argument String category) {
        return postService.addPost(title, text, category);
    }

}
