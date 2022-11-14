package co.edu.javeriana.mongo.adapter;

import co.edu.javeriana.domain.model.Telefono;
import co.edu.javeriana.domain.ports.out.mongo.TelefonoPortMongo;
import co.edu.javeriana.mongo.document.TelefonoDocument;
import co.edu.javeriana.mongo.mapper.TelefonoMapper;
import co.edu.javeriana.mongo.repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class TelefonoAdapter implements TelefonoPortMongo {

    @Autowired
    TelefonoRepository telefonoRepository;

    @Autowired
    TelefonoMapper telefonoMapper;

    @Override
    public Boolean crear(Telefono telefono) {
        try {
            TelefonoDocument telefonoDocument = telefonoMapper.fromDomainToDocument(telefono);
            telefonoRepository.save(telefonoDocument);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Telefono telefono) {
        try {
            TelefonoDocument telefonoDocument = telefonoMapper.fromDomainToDocument(telefono);
            telefonoRepository.delete(telefonoDocument);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean update(Telefono telefono) {
        try{
            TelefonoDocument telefonoDocument = telefonoRepository.findByNum(telefono.getNumero());
            if(telefonoDocument == null)
                return false;

            telefonoRepository.save(telefonoMapper.fromDomainToDocument(telefono));
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Telefono> findAll() {
        return telefonoRepository.findAll().stream().map(e -> telefonoMapper.fromDocumentToDomain(e)).collect(Collectors.toList());
    }

    @Override
    public Telefono findByNum(String num) {
        return telefonoMapper.fromDocumentToDomain(telefonoRepository.findByNum(num));
    }

    @Override
    public Long count() {
        return telefonoRepository.count();
    }

}
