package co.edu.javeriana.mongo.repository;

import co.edu.javeriana.mongo.document.EstudioDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudioRepository extends MongoRepository<EstudioDocument, String> {

    @Query("{'cc_per':?0, }")
    List<EstudioDocument> findByCc_per(int cc_per);

    @Query("{cc_per:?0, id_prof: ?1 }")
    List <EstudioDocument> findByCc_perAndId_prof(int cc_per, int id_prof);

}
