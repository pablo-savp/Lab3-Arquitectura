package co.edu.javeriana.mongo;

import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.mongo.mapper.EstudioMapper;
import co.edu.javeriana.mongo.mapper.EstudioMapperImpl;
import co.edu.javeriana.mongo.repository.EstudioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class MongoApplicationTests {

	@Autowired
	EstudioRepository estudioRepository;

	EstudioMapper estudioMapper = new EstudioMapperImpl();


	@Test
	void updateEstudio() {
		Estudio e = new Estudio();
		e.setCc_persona(1);
		e.setId_profesion(1);
		e.setUniversidad("La Sabana");
		e.setFecha(LocalDate.now());
		estudioRepository.save(estudioMapper.fromDomainToDocument(e));
	}

	@Test
	void findAllEstudios() {
		List<Estudio> estudios = estudioRepository.findAll().stream().map(e -> estudioMapper.fromDocumentToDomain(e)).collect(Collectors.toList());
		System.out.println(estudios.size());
		System.out.println(estudioRepository.count());
	}

}
