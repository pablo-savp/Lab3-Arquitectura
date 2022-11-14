package co.edu.javeriana.domain.ports.out;

import co.edu.javeriana.domain.model.Estudio;

import java.util.List;

public interface EstudioPort {
    Boolean crear(Estudio estudio);
    Boolean delete(Estudio estudio);
    Boolean update(Estudio estudio);

    List<Estudio> findAll();
    Estudio findByIdCcAndId(Integer cc, Integer id);
    Long count();

}
