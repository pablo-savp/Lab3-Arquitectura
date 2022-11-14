package co.edu.javeriana.domain.ports.out;

import co.edu.javeriana.domain.model.Telefono;

import java.util.List;

public interface TelefonoPort {
    Boolean crear(Telefono telefono);
    Boolean delete(Telefono telefono);
    Boolean update(Telefono estutelefonodio);

    List<Telefono> findAll();
    Telefono findByNum(String num);
    Long count();
}
