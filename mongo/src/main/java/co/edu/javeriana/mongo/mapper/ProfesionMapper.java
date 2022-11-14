package co.edu.javeriana.mongo.mapper;

import co.edu.javeriana.domain.model.Profesion;
import co.edu.javeriana.mongo.document.ProfesionDocument;

public interface ProfesionMapper {
    public Profesion fromDocumentToDomain(ProfesionDocument document);
    public ProfesionDocument fromDomainToDocument(Profesion domain);
}
