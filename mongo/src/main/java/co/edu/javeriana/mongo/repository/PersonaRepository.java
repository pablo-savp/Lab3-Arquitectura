package co.edu.javeriana.mongo.repository;

import co.edu.javeriana.domain.model.Persona;
import co.edu.javeriana.mongo.document.PersonaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends MongoRepository<PersonaDocument, String> {

    @Query("{cc_per: ?0}")
    List<PersonaDocument> findByCc(Integer cc_per);

}
