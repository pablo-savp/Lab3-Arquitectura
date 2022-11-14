package co.edu.javeriana.mongo.adapter;

import co.edu.javeriana.domain.model.Profesion;
import co.edu.javeriana.domain.ports.out.mongo.ProfesionPortMongo;
import co.edu.javeriana.mongo.document.ProfesionDocument;
import co.edu.javeriana.mongo.mapper.ProfesionMapper;
import co.edu.javeriana.mongo.repository.ProfesionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ProfesionAdapter implements ProfesionPortMongo {

    @Autowired
    ProfesionRepository profesionRepository;

    @Autowired
    ProfesionMapper profesionMapper;

    @Override
    public Boolean crear(Profesion profesion) {
        try {
            ProfesionDocument profesionDocument = profesionMapper.fromDomainToDocument(profesion);
            profesionRepository.save(profesionDocument);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean delete(Profesion profesion) {
        try {
            ProfesionDocument profesionDocument = profesionMapper.fromDomainToDocument(profesion);
            profesionRepository.delete(profesionDocument);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean update(Profesion profesion) {
        try {
            ProfesionDocument profesionDocument = profesionRepository.findById(profesion.getId());
            if(profesionDocument == null)
                return false;

            profesionRepository.save(profesionMapper.fromDomainToDocument(profesion));
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    @Override
    public List<Profesion> findAll() {
        return profesionRepository.findAll().stream().map(e -> profesionMapper.fromDocumentToDomain(e)).collect(Collectors.toList());
    }

    @Override
    public Profesion findById(Integer id) {
        return profesionMapper.fromDocumentToDomain(profesionRepository.findById(id));
    }

    @Override
    public Long count() {
        return profesionRepository.count();
    }
}
