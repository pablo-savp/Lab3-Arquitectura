package co.edu.javeriana.domain.logic;

import co.edu.javeriana.domain.model.Telefono;

import java.util.List;

public interface TelefonoLogic {
    Boolean create(Telefono telefono, int persistence);
    Boolean delete(Telefono telefono, int persistence);
    Boolean update(Telefono telefono, int persistence);

    List<Telefono> findAll(int persistence);
    Telefono findByNum(String num, int persistence);
    Long count(int persistence);
}
