package org.example.graphql.Service.Implementation;

import lombok.RequiredArgsConstructor;
import org.example.graphql.Entity.Course;
import org.example.graphql.Entity.User;
import org.example.graphql.Input.UserInput;
import org.example.graphql.Model.Connection;
import org.example.graphql.Model.Edge;
import org.example.graphql.Model.PageInfo;
import org.example.graphql.Repository.CourseRepository;
import org.example.graphql.Repository.UserRepository;
import org.example.graphql.Service.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Connection<Edge> findAllUser(Integer size, String after, Integer first) {
        // Si first no está definido, usamos el valor por defecto de 10
        int pageSize = (first != null) ? first : (size != null ? size : 10);

        // Calculamos la página basada en el cursor
        int page = 0;
        if (after != null && !after.isEmpty()) {
            try {
                String decodedCursor = new String(Base64.getDecoder().decode(after));
                page = Integer.parseInt(decodedCursor);
            } catch (Exception e) {
                // Si hay un error al decodificar, empezamos desde la primera página
                page = 0;
            }
        }

        // Obtenemos la página de usuarios
        Page<User> userPage = userRepository.findAll(PageRequest.of(page,pageSize));

        // Creamos los edges
        List<Edge> edges = userPage.getContent().stream()
                .map(user -> new Edge(user, Base64.getEncoder().encodeToString(
                        String.valueOf(user.getId()).getBytes()
                )))
                .collect(Collectors.toList());

        // Calculamos los cursores
        boolean hasNextPage = userPage.hasNext();
        boolean hasPreviousPage = userPage.hasPrevious();
        String startCursor = edges.isEmpty() ? null : edges.get(0).getCursor();
        String endCursor = edges.isEmpty() ? null : edges.get(edges.size() - 1).getCursor();

        // Creamos el objeto PageInfo
        PageInfo pageInfo = new PageInfo(
                hasNextPage,
                hasPreviousPage,
                startCursor,
                endCursor
        );

        // Retornamos la conexión con los usuarios paginados
        return new Connection<Edge>(
                edges,
                pageInfo,
                (int) userPage.getTotalElements()
        );
    }

    @Override
    public User createUser(UserInput input) {
        List<Long> ids = input.getCourseIds().stream().map(Long::valueOf).collect(Collectors.toList());
        List<Course> courses = this.courseRepository.findAllById(ids);
        User user = new User();
        user.setName(input.getName());
        user.setLastName(input.getLastName());
        user.setCourses(courses);
        return userRepository.save(user);

    }
}
