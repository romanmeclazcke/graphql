package org.example.graphql.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.graphql.Entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edge<T> { // Clase que representa un borde en una conexión GraphQL, contiene un nodo y un cursor
    private T node; //informacion
    private String cursor; // Cursor es una cadena codificada en Base64 que representa la posición del usuario en la lista

}
