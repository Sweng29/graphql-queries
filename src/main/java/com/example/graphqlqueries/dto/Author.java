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
public class Author {

    Integer id;
    String name;
    String thumbnail;
    List<Post> posts;

    public Author(Integer id, String name, String thumbnail) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
    }

}
