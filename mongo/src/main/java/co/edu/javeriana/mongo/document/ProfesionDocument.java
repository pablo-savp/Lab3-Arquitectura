package co.edu.javeriana.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profesion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesionDocument {

    @Id
    private Integer id;
    private String nom;
    private String des;
}
