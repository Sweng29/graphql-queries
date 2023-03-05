package com.example.graphqlqueries.service;

import com.example.graphqlqueries.dto.Author;
import com.example.graphqlqueries.dto.Comment;
import com.example.graphqlqueries.dto.Post;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PostService {

    List<Comment> comments = new CopyOnWriteArrayList<>();
    List<Author> authors = new CopyOnWriteArrayList<>();
    List<Post> posts = new CopyOnWriteArrayList<>();

    public PostService()
    {
        processAndBuildCommentsData();
        processAndBuildAuthorsData();
        processAndBuildPostsData();
    }

    private void processAndBuildPostsData() {
        this.posts.add(new Post(1, "GraphQL", "Hello GraphQL!", "Technology", authors.get(0), List.of(comments.get(0), comments.get(1))));
        this.posts.add(new Post(2, "Java", "Hello Java!", "Technology", authors.get(1), List.of(comments.get(2), comments.get(3))));
        this.posts.add(new Post(3, "C++", "Hello C++ World!", "Technology", authors.get(2), List.of(comments.get(2), comments.get(4), comments.get(1))));
    }

    private void processAndBuildAuthorsData() {
        this.authors.add(new Author(1, "Kashif Ali", "/img"));
        this.authors.add(new Author(2, "Haider Ali", "/png"));
        this.authors.add(new Author(3, "Zain ul Abidin", "/jpeg"));
        this.authors.add(new Author(4, "Kamran Ali", "/jpg"));
    }

    private void processAndBuildCommentsData() {
        this.comments.add(new Comment(1, "This is awasome", 2, 1, "url/comment-1"));
        this.comments.add(new Comment(2, "This is great", 3, 2, "url/comment-2"));
        this.comments.add(new Comment(3, "This is nice", 7, 0, "url/comment-3"));
        this.comments.add(new Comment(4, "This is beautiful", 5, 3, "url/comment-4"));
        this.comments.add(new Comment(4, "This is good", 1, 0, "url/comment-5"));
    }

    public List<Post> findAllPosts() {
        return this.posts;
    }

    public Post addPost(String title, String text, String category) {
        Post post = new Post(posts.size() + 1, title, text, category, Collections.emptyList());
        posts.add(post);
        return post;
    }
}
