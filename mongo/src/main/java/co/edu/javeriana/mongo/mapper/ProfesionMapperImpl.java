package co.edu.javeriana.mongo.mapper;

import co.edu.javeriana.domain.model.Profesion;
import co.edu.javeriana.mongo.document.ProfesionDocument;
import org.modelmapper.ModelMapper;

public class ProfesionMapperImpl implements ProfesionMapper{
    private ModelMapper mapper;

    public ProfesionMapperImpl() {
        mapper = new ModelMapper();
        mapper.typeMap(ProfesionDocument.class, Profesion.class).addMappings(mapping -> {
            mapping.map(ProfesionDocument::getId, Profesion::setId);
            mapping.map(ProfesionDocument::getNom, Profesion::setNombre);
            mapping.map(ProfesionDocument::getDes, Profesion::setDescripcion);
        });
    }

    @Override
    public Profesion fromDocumentToDomain(ProfesionDocument document) {
        return mapper.map(document, Profesion.class);
    }

    @Override
    public ProfesionDocument fromDomainToDocument(Profesion domain) {
        return mapper.map(domain, ProfesionDocument.class);
    }
}
