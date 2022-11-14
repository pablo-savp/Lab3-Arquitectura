package co.edu.javeriana.domain.ports.out;

import co.edu.javeriana.domain.model.Persona;

import java.util.List;

public interface PersonaPort {
    Boolean crear(Persona persona);
    Boolean delete(Persona persona);
    Boolean update(Persona persona);

    List<Persona> findAll();
    Persona findByCC(Integer cc);
    Long count();

}
