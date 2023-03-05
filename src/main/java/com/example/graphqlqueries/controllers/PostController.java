package com.example.graphqlqueries.controllers;

import com.example.graphqlqueries.dto.Author;
import com.example.graphqlqueries.dto.Post;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class PostController {

    List<Author> authors = List.of(
            new Author(1, "Kashif Ali", "/img"),
            new Author(2, "Haider Ali", "/png"),
            new Author(3, "Zain ul Abidin", "/jpeg"),
            new Author(4, "Kamran Ali", "/jpg")
    );

    List<Post> posts = List.of(
        new Post(1, "GraphQL", "Hello GraphQL!", "Technology", authors.get(0)),
        new Post(2, "Java", "Hello Java!", "Technology", authors.get(1)),
        new Post(3, "C++", "Hello C++ World!", "Technology", authors.get(2))
    );

    @QueryMapping
    public Flux<Post> recentPosts(){
        return Flux.fromIterable(this.posts);
    }

    @SchemaMapping(typeName="Post", field="author")
    public Mono<Author> author(Post post) {
        return Mono.just(post.getAuthor());
    }

}
