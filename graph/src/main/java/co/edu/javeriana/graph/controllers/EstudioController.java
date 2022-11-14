package co.edu.javeriana.graph.controllers;

import co.edu.javeriana.domain.logic.EstudioLogic;
import co.edu.javeriana.domain.model.Estudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EstudioController {

    @Autowired
    private EstudioLogic estudioLogic;

    @QueryMapping
    public List<Estudio> findAllEstudios(@Argument int persistence) {
        return estudioLogic.findAll(persistence);
    }

    @QueryMapping
    public Estudio findEstudioByIdAndCC(@Argument int profesion_id, @Argument int persona_cc, @Argument int persistence) {
        return estudioLogic.findByIdCc(persona_cc, profesion_id, persistence);
    }

    @QueryMapping
    public Long count(@Argument int persistence) {
        return estudioLogic.count(persistence);
    }

    @MutationMapping
    public Boolean createEstudio(@Argument int cc_persona, @Argument int id_profesion, @Argument String fecha, @Argument String universidad, @Argument int persistence) {
        Estudio e = new Estudio();
        e.setFecha(LocalDate.parse(fecha));
        e.setCc_persona(cc_persona);
        e.setId_profesion(id_profesion);
        e.setUniversidad(universidad);

        return estudioLogic.create(e, persistence);
    }

    @MutationMapping
    public Boolean updateEstudio(@Argument int cc_persona, @Argument int id_profesion, @Argument String fecha, @Argument String universidad, @Argument int persistence) {
        Estudio e = new Estudio();
        e.setFecha(LocalDate.parse(fecha));
        e.setCc_persona(cc_persona);
        e.setId_profesion(id_profesion);
        e.setUniversidad(universidad);

        return estudioLogic.update(e, persistence);
    }

    @MutationMapping
    public Boolean deleteEstudio(@Argument int cc_persona, @Argument int id_profesion, @Argument String fecha, @Argument String universidad, @Argument int persistence) {
        Estudio e = new Estudio();
        e.setFecha(LocalDate.parse(fecha));
        e.setCc_persona(cc_persona);
        e.setId_profesion(id_profesion);
        e.setUniversidad(universidad);

        return estudioLogic.delete(e, persistence);
    }

}
