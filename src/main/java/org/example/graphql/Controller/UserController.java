package org.example.graphql.Controller;

import org.example.graphql.Entity.Course;
import org.example.graphql.Entity.User;
import org.example.graphql.Input.UserInput;
import org.example.graphql.Repository.CourseRepository;
import org.example.graphql.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;


    @QueryMapping
    public List<User> findAllUser(){
        return this.userRepository.findAll();
    }

    @MutationMapping
    public User createUser(@Argument("input") UserInput input) {
        List<Long> ids = input.getCourseIds().stream().map(Long::valueOf).collect(Collectors.toList());
        List<Course> courses = this.courseRepository.findAllById(ids);

        User user = new User();
        user.setName(input.getName());
        user.setLastName(input.getLastName());
        user.setCourses(courses);
        return userRepository.save(user);
    }
}

