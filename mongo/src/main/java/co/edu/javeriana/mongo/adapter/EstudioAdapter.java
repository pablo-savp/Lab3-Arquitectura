package co.edu.javeriana.mongo.adapter;

import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.domain.ports.out.mongo.EstudioPortMongo;
import co.edu.javeriana.mongo.document.EstudioDocument;
import co.edu.javeriana.mongo.mapper.EstudioMapper;
import co.edu.javeriana.mongo.repository.EstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class EstudioAdapter implements EstudioPortMongo {
    @Autowired
    EstudioRepository estudioRepository;
    @Autowired
    EstudioMapper estudioMapper;

    @Override
    public Boolean crear(Estudio estudio) {
        try {
            EstudioDocument estudioDocument = estudioMapper.fromDomainToDocument(estudio);
            estudioRepository.save(estudioDocument);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean delete(Estudio estudio) {
        try {
            EstudioDocument estudioDocument = estudioMapper.fromDomainToDocument(estudio);
            estudioRepository.delete(estudioDocument);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean update(Estudio estudio) {
        try {
            List<EstudioDocument> estudios = estudioRepository.findByCc_perAndId_prof(estudio.getCc_persona(), estudio.getId_profesion());
            if(estudios.isEmpty())
                return Boolean.FALSE;
            estudioRepository.save(estudioMapper.fromDomainToDocument(estudio));
        }
        catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return null;
    }

    @Override
    public List<Estudio> findAll() {
        return estudioRepository.findAll().stream().map(e -> estudioMapper.fromDocumentToDomain(e)).collect(Collectors.toList());
    }

    @Override
    public Estudio findByIdCcAndId(Integer cc, Integer id) {
        List<EstudioDocument> found = estudioRepository.findByCc_perAndId_prof(cc, id);
        if(found.isEmpty())
            return null;
        return estudioMapper.fromDocumentToDomain(found.get(0));
    }

    @Override
    public Long count() {
        return estudioRepository.count();
    }
}
