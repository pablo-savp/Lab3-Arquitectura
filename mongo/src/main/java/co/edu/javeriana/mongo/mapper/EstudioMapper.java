package co.edu.javeriana.mongo.mapper;

import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.mongo.document.EstudioDocument;

public interface EstudioMapper {
    public Estudio fromDocumentToDomain(EstudioDocument document);
    public EstudioDocument fromDomainToDocument(Estudio domain);

}
