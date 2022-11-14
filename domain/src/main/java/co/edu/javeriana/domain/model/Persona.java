package co.edu.javeriana.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Persona {
    private Integer cc;
    private String nombre;
    private String apellido;
    private Character genero;
    private Integer edad;
    private List<Telefono> telefonos;
    private List<Estudio> estudios;
}
