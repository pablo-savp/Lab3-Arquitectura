package co.edu.javeriana.domain.logic;

import co.edu.javeriana.domain.model.Persona;

import java.util.List;

public interface PersonaLogic {
    Boolean create(Persona persona, int persistence);
    Boolean delete(Persona persona, int persistence);
    Boolean update(Persona persona, int persistence);

    List<Persona> findAll(int persistence);
    Persona findByCC(Integer cc, int persistence);
    Long count(int persistence);
}
