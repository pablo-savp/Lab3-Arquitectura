package co.edu.javeriana.domain.logic;

import co.edu.javeriana.domain.model.Profesion;

import java.util.List;

public interface ProfesionLogic {
    Boolean create(Profesion profesion, int persistence);
    Boolean delete(Profesion profesion, int persistence);
    Boolean update(Profesion profesion, int persistence);

    List<Profesion> findAll(int persistence);
    Profesion findById(Integer id,int persistence);
    Long count(int persistence);
}
