package co.edu.javeriana.mongo.repository;

import co.edu.javeriana.mongo.document.TelefonoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoRepository extends MongoRepository<TelefonoDocument, String> {

    @Query("{num:  ?0}")
    TelefonoDocument findByNum(String num);

}
