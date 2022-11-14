package co.edu.javeriana.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Profesion {
    private Integer id;
    private String nombre;
    private String descripcion;
    private List<Estudio> estudios;
}
