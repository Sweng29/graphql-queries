package com.example.graphqlqueries;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    
    @QueryMapping
    public String greeting() {
        return "Hello, world!";
    }

    @QueryMapping
    public String greetingWithArgument(@Argument String name){
        return "Hello, " + name;
    }

}
