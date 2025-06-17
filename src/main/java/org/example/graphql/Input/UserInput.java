package org.example.graphql.Input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {
    private String name;
    private String lastName;
    private List<String> courseIds;
}
