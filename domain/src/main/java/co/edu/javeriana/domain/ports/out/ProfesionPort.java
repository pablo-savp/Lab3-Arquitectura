package co.edu.javeriana.domain.ports.out;

import co.edu.javeriana.domain.model.Profesion;

import java.util.List;

public interface ProfesionPort {
    Boolean crear(Profesion profesion);
    Boolean delete(Profesion profesion);
    Boolean update(Profesion profesion);

    List<Profesion> findAll();
    Profesion findById(Integer id);
    Long count();

}
