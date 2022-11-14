package co.edu.javeriana.mongo.mapper;

import co.edu.javeriana.domain.model.Persona;
import co.edu.javeriana.mongo.document.PersonaDocument;

public interface PersonaMapper {
    public Persona fromDocumentToDomain(PersonaDocument document);
    public PersonaDocument fromDomainToDocument(Persona domain);
}
