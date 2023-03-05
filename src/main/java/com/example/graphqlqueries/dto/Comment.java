package com.example.graphqlqueries.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Integer id;
    private String text;
    private Integer likes;
    private Integer dislikes;
    private String shareUrl;
}
