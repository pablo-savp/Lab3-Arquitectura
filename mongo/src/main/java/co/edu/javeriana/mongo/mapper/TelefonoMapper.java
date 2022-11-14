package co.edu.javeriana.mongo.mapper;

import co.edu.javeriana.domain.model.Telefono;
import co.edu.javeriana.mongo.document.TelefonoDocument;

public interface TelefonoMapper {
    public Telefono fromDocumentToDomain(TelefonoDocument document);
    public TelefonoDocument fromDomainToDocument(Telefono domain);
}
