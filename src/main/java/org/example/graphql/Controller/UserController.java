package org.example.graphql.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.graphql.Entity.User;
import org.example.graphql.Input.UserFilters;
import org.example.graphql.Input.UserInput;
import org.example.graphql.Model.Connection;
import org.example.graphql.Model.Edge;
import org.example.graphql.Service.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

    @Autowired
    private UserService userService;



    @QueryMapping
    public Connection<Edge<User>> findAllUser(
            @Argument("size") Integer size,
            @Argument("after") String after,
            @Argument("first") Integer first,
            @Argument("filters") UserFilters filters
    ) {
        return this.userService.findAllUser(size, after, first,filters);
    }

    @MutationMapping
    public User createUser(@Argument("input") UserInput input) {
       return this.userService.createUser(input);
    }
}

