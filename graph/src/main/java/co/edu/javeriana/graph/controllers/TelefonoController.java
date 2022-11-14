package co.edu.javeriana.graph.controllers;

import co.edu.javeriana.domain.logic.TelefonoLogic;
import co.edu.javeriana.domain.model.Telefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;

public class TelefonoController {

    @Autowired
    private TelefonoLogic telefonoLogic;

    @QueryMapping
    public List<Telefono> findAllTelefonos(@Argument int persistence) {
        return telefonoLogic.findAll(persistence);
    }

    @QueryMapping
    public Telefono findTelefonoByNumero(@Argument String number, @Argument int persistence) {
        return telefonoLogic.findByNum(number, persistence);
    }

    @QueryMapping
    public Long count(@Argument int persistence) {
        return telefonoLogic.count(persistence);
    }

    @MutationMapping
    public Boolean createTelefono(@Argument String number, @Argument String operador, @Argument int duenio, @Argument int persistence) {
        Telefono t = new Telefono();
        t.setDuenio(duenio);
        t.setOperador(operador);
        t.setNumero(number);
        return telefonoLogic.create(t, persistence);
    }

    @MutationMapping
    public Boolean updateTelefono(@Argument String number, @Argument String operador, @Argument int duenio, @Argument int persistence) {
        Telefono t = new Telefono();
        t.setDuenio(duenio);
        t.setOperador(operador);
        t.setNumero(number);
        return telefonoLogic.update(t, persistence);
    }

    @MutationMapping
    public Boolean deleteTelefono(@Argument String number, @Argument String operador, @Argument int duenio, @Argument int persistence) {
        Telefono t = new Telefono();
        t.setDuenio(duenio);
        t.setOperador(operador);
        t.setNumero(number);
        return telefonoLogic.delete(t, persistence);
    }

}
