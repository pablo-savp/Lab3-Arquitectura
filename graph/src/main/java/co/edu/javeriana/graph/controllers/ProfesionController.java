package co.edu.javeriana.graph.controllers;

import co.edu.javeriana.domain.logic.ProfesionLogic;
import co.edu.javeriana.domain.model.Profesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;

public class ProfesionController {

    @Autowired
    private ProfesionLogic profesionLogic;

    @QueryMapping
    public List<Profesion> findAllProfesiones(@Argument int persistence) {
        return profesionLogic.findAll(persistence);
    }

    @QueryMapping
    public Profesion findById(@Argument int id, @Argument int persistence) {
        return profesionLogic.findById(id, persistence);
    }

    @QueryMapping
    public Long count(@Argument int persistence) {
        return profesionLogic.count(persistence);
    }

    @MutationMapping
    public Boolean createProfesion(@Argument int id, @Argument String nombre, @Argument String descripcion, @Argument int persistence) {
        Profesion p = new Profesion();
        p.setId(id);
        p.setNombre(nombre);
        p.setDescripcion(descripcion);

        return profesionLogic.create(p, persistence);
    }

    @MutationMapping
    public Boolean updateProfesion(@Argument int id, @Argument String nombre, @Argument String descripcion, @Argument int persistence) {
        Profesion p = new Profesion();
        p.setId(id);
        p.setNombre(nombre);
        p.setDescripcion(descripcion);

        return profesionLogic.update(p, persistence);
    }

    @MutationMapping
    public Boolean deleteProfesion(@Argument int id, @Argument String nombre, @Argument String descripcion, @Argument int persistence) {
        Profesion p = new Profesion();
        p.setId(id);
        p.setNombre(nombre);
        p.setDescripcion(descripcion);

        return profesionLogic.delete(p, persistence);
    }


}
