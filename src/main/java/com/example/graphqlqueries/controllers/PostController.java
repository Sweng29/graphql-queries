package com.example.graphqlqueries.controllers;

import com.example.graphqlqueries.dto.Author;
import com.example.graphqlqueries.dto.Comment;
import com.example.graphqlqueries.dto.Post;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class PostController {

    List<Comment> comments = List.of(
            new Comment(1, "This is awasome", 2, 1, "url/comment-1"),
            new Comment(2, "This is great", 3, 2, "url/comment-2"),
            new Comment(3, "This is nice", 7, 0, "url/comment-3"),
            new Comment(4, "This is beautiful", 5, 3, "url/comment-4"),
            new Comment(4, "This is good", 1, 0, "url/comment-5")
    );

    List<Author> authors = List.of(
            new Author(1, "Kashif Ali", "/img"),
            new Author(2, "Haider Ali", "/png"),
            new Author(3, "Zain ul Abidin", "/jpeg"),
            new Author(4, "Kamran Ali", "/jpg")
    );

    List<Post> posts = List.of(
        new Post(1, "GraphQL", "Hello GraphQL!", "Technology", authors.get(0), List.of(comments.get(0), comments.get(1))),
        new Post(2, "Java", "Hello Java!", "Technology", authors.get(1), List.of(comments.get(2), comments.get(3))),
        new Post(3, "C++", "Hello C++ World!", "Technology", authors.get(2), List.of(comments.get(2), comments.get(4), comments.get(1)))
    );

    @QueryMapping
    public Flux<Post> recentPosts(){
        return Flux.fromIterable(this.posts);
    }

    @SchemaMapping(typeName="Post", field="author")
    public Mono<Author> author(Post post) {
        return Mono.just(post.getAuthor());
    }

    @BatchMapping(typeName = "Post", field = "comments")
    public Map<Post, List<Comment>> comments(List<Post> posts){
        return posts.stream().collect(Collectors.toMap(post -> post, Post::getComments));
    }

}
