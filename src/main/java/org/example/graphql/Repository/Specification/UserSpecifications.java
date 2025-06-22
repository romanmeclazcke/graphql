package org.example.graphql.Repository.Specification;

import org.example.graphql.Entity.User;
import org.example.graphql.Input.UserFilters;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


//Specification yo build filters
public class UserSpecifications {

    private static final Function<String, String> toLowerAndInclude =
            value -> "%" + value.toLowerCase() + "%";

    public static Specification<User> build(UserFilters filters) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filters != null) {
                if (filters.getName() != null) {
                    predicates.add(cb.like(cb.lower(root.get("name")), toLowerAndInclude.apply(filters.getName())));
                }

                if (filters.getLastName() != null) {
                    predicates.add(cb.like(root.get("lastName"), toLowerAndInclude.apply(filters.getLastName())));
                }

                if (filters.getId() != null) {
                    predicates.add(cb.equal(root.get("id"), filters.getId()));
                }

                if (filters.getCourse() != null) {
                    predicates.add(cb.equal(root.get("course"), filters.getCourse()));
                }
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}