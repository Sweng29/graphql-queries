package com.example.graphqlqueries.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Integer id;
    private String title;
    private String text;
    private String category;
    private Author author;
    private List<Comment> comments;

    public Post(Integer id, String title, String text, String category, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.category = category;
        this.comments = comments;
    }
}
