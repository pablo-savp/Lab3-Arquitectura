package co.edu.javeriana.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDocument {

    @Id
    private Integer cc;
    private String nombre;
    private String apellido;
    private String genero;
    private String edad;
}
