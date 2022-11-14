package co.edu.javeriana.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Estudio {
    private LocalDate fecha;
    private String universidad;
    private Integer id_profesion;
    private Integer cc_persona;
}
