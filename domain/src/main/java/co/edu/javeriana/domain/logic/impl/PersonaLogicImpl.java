package co.edu.javeriana.domain.logic.impl;

import co.edu.javeriana.domain.logic.PersonaLogic;
import co.edu.javeriana.domain.model.Persona;
import co.edu.javeriana.domain.ports.out.maria.PersonaPortMaria;
import co.edu.javeriana.domain.ports.out.mongo.PersonaPortMongo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PersonaLogicImpl implements PersonaLogic {

    @Autowired
    private PersonaPortMaria personaPortMaria;

    @Autowired
    private PersonaPortMongo personaPortMongo;

    @Override
    public Boolean create(Persona persona, int persistence) {
        if (persistence == 1){
            return personaPortMaria.crear(persona);
        }
        else if (persistence == 2) {
            return personaPortMongo.crear(persona);
        }
        else {
            return personaPortMaria.crear(persona) && personaPortMongo.crear(persona);
        }
    }

    @Override
    public Boolean delete(Persona persona, int persistence) {
        if (persistence == 1){
            return personaPortMaria.delete(persona);
        }
        else if (persistence == 2) {
            return personaPortMongo.delete(persona);
        }
        else {
            return personaPortMaria.delete(persona) && personaPortMongo.delete(persona);
        }
    }

    @Override
    public Boolean update(Persona persona, int persistence) {
        if (persistence == 1){
            return personaPortMaria.update(persona);
        }
        else if (persistence == 2) {
            return personaPortMongo.update(persona);
        }
        else {
            return personaPortMaria.update(persona) && personaPortMongo.update(persona);
        }
    }

    @Override
    public List<Persona> findAll(int persistence) {
        if (persistence == 1){
            return personaPortMaria.findAll();
        }
        else if (persistence == 2) {
            return personaPortMongo.findAll();
        }
        else {
            List<Persona> list = new ArrayList<>();
            list.addAll(personaPortMaria.findAll());
            list.addAll(personaPortMongo.findAll());
            return list;
        }
    }

    @Override
    public Persona findByCC(Integer cc, int persistence) {
        if (persistence == 1){
            return personaPortMaria.findByCC(cc);
        }
        else if (persistence == 2) {
            return personaPortMongo.findByCC(cc);
        }
        else {
//            return personaPortMaria.findByCC(cc) && personaPortMongo.findByCC(cc);
        }
        return null;
    }

    @Override
    public Long count(int persistence) {
        if (persistence == 1){
            return personaPortMaria.count();
        }
        else if (persistence == 2) {
            return personaPortMongo.count();
        }
        else {
            return personaPortMaria.count() + personaPortMongo.count();
        }
    }


}
