package co.edu.javeriana.mongo.adapter;

import co.edu.javeriana.domain.model.Persona;
import co.edu.javeriana.domain.ports.out.mongo.PersonaPortMongo;
import co.edu.javeriana.mongo.document.PersonaDocument;
import co.edu.javeriana.mongo.mapper.PersonaMapper;
import co.edu.javeriana.mongo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class PersonaAdapter implements PersonaPortMongo {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    PersonaMapper personaMapper;

    @Override
    public Boolean crear(Persona persona) {
        try {
            PersonaDocument personaDocument = personaMapper.fromDomainToDocument(persona);
            personaRepository.save(personaDocument);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Persona persona) {
        try {
            PersonaDocument personaDocument = personaMapper.fromDomainToDocument(persona);
            personaRepository.delete(personaDocument);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean update(Persona persona) {
        try {
            List<PersonaDocument> personas = personaRepository.findByCc(persona.getCc());
            if(personas.isEmpty())
                return Boolean.FALSE;
            personaRepository.save(personaMapper.fromDomainToDocument(persona));
        }
        catch (Exception e) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll().stream().map(e -> personaMapper.fromDocumentToDomain((e))).collect(Collectors.toList());
    }

    @Override
    public Persona findByCC(Integer cc) {
        List<PersonaDocument> found = personaRepository.findByCc(cc);
        if(found.isEmpty())
            return null;
        return personaMapper.fromDocumentToDomain(found.get(0));
    }

    @Override
    public Long count() {
        return personaRepository.count();
    }
}
