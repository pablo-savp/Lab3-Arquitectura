package co.edu.javeriana.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "estudios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudioDocument {
    private Integer id_prof;
    private Integer cc_per;
    private LocalDate fecha;
    private String univer;

//    public EstudioDocument(EstudioPK id, LocalDate fecha, String univer) {
//        this.id = id;
//        this.fecha = fecha;
//        this.univer = univer;
//    }

//    public EstudioDocument(Integer id_prof, Integer cc_per, LocalDate fecha, String univer) {
//        this.id_prof = id_prof;
//        this.cc_per = cc_per;
//        this.fecha = fecha;
//        this.univer = univer;
//    }
}
