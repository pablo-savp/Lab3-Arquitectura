package co.edu.javeriana.mongo.mapper;

import co.edu.javeriana.domain.model.Profesion;
import co.edu.javeriana.domain.model.Telefono;
import co.edu.javeriana.mongo.document.ProfesionDocument;
import co.edu.javeriana.mongo.document.TelefonoDocument;
import org.modelmapper.ModelMapper;

public class TelefonoMapperImpl implements TelefonoMapper{
    private ModelMapper mapper;

    public TelefonoMapperImpl() {
        mapper = new ModelMapper();
        mapper.typeMap(TelefonoDocument.class, Telefono.class).addMappings(mapping -> {
            mapping.map(TelefonoDocument::getNum, Telefono::setNumero);
            mapping.map(TelefonoDocument::getOper, Telefono::setOperador);
            mapping.map(TelefonoDocument::getDuenio, Telefono::setDuenio);
        });
    }

    @Override
    public Telefono fromDocumentToDomain(TelefonoDocument document) {
        return null;
    }

    @Override
    public TelefonoDocument fromDomainToDocument(Telefono domain) {
        return null;
    }
}
