package co.edu.javeriana.mongo.mapper;

import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.domain.model.Persona;
import co.edu.javeriana.mongo.document.EstudioDocument;
import co.edu.javeriana.mongo.document.PersonaDocument;
import org.modelmapper.ModelMapper;

public class PersonaMapperImpl implements PersonaMapper{
    private ModelMapper mapper;

    public PersonaMapperImpl() {
        mapper = new ModelMapper();
        mapper.typeMap(PersonaDocument.class, Persona.class).addMappings(mapping -> {
            mapping.map(PersonaDocument::getCc, Persona::setCc);
            mapping.map(PersonaDocument::getNombre, Persona::setNombre);
            mapping.map(PersonaDocument::getApellido, Persona::setApellido);
            mapping.map(PersonaDocument::getGenero, Persona::setGenero);
            mapping.map(PersonaDocument::getEdad, Persona::setEdad);
        });
    }

    @Override
    public Persona fromDocumentToDomain(PersonaDocument document) {
        return mapper.map(document, Persona.class);
    }

    @Override
    public PersonaDocument fromDomainToDocument(Persona domain) {
        return mapper.map(domain, PersonaDocument.class);
    }
}
