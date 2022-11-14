package co.edu.javeriana.mongo.repository;

import co.edu.javeriana.mongo.document.ProfesionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionRepository extends MongoRepository<ProfesionDocument, String> {

    @Query("{id: ?0}")
    ProfesionDocument findById(Integer id);

}

