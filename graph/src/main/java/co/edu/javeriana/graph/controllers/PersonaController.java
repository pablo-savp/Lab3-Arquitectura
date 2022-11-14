package co.edu.javeriana.graph.controllers;

import co.edu.javeriana.domain.logic.PersonaLogic;
import co.edu.javeriana.domain.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;

public class PersonaController {

    @Autowired
    private PersonaLogic personaLogic;

    @QueryMapping
    public List<Persona> findAllPersonas(@Argument int persistence) {
        return personaLogic.findAll(persistence);
    }


    @QueryMapping
    public Persona findPersonaByIdAndCC(@Argument int persona_cc,  @Argument int persistence) {
        return personaLogic.findByCC(persona_cc, persistence);
    }

    @QueryMapping
    public Long count(@Argument int persistence) {
        return personaLogic.count(persistence);
    }

    @MutationMapping
    public Boolean createPersona(@Argument int cc_persona, @Argument String nombre, @Argument String apellido, @Argument Character genero, @Argument int edad, @Argument int persistence) {
        Persona a = new Persona();
        a.setCc(cc_persona);
        a.setEdad(edad);
        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setGenero(genero);
        return personaLogic.create(a, persistence);
    }

    @MutationMapping
    public Boolean updatePersona(@Argument int cc_persona, @Argument String nombre, @Argument String apellido, @Argument Character genero, @Argument int edad, @Argument int persistence) {
        Persona a = new Persona();
        a.setCc(cc_persona);
        a.setEdad(edad);
        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setGenero(genero);
        return personaLogic.update(a, persistence);
    }

    @MutationMapping
    public Boolean deletePersona(@Argument int cc_persona, @Argument String nombre, @Argument String apellido, @Argument Character genero, @Argument int edad, @Argument int persistence) {
        Persona a = new Persona();
        a.setCc(cc_persona);
        a.setEdad(edad);
        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setGenero(genero);
        return personaLogic.delete(a, persistence);
    }


}
