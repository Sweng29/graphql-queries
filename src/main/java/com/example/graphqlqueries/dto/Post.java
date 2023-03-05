package com.example.graphqlqueries.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    Integer id;
    String title;
    String text;
    String category;
    Author author;

    public Post(Integer id, String title, String text, String category) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.category = category;
    }
}
