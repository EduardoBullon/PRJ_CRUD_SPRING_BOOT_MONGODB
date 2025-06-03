package com.tecsup.demo.modelo.daos;
import com.tecsup.demo.modelo.documents.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoRepository extends MongoRepository<Curso, String> {
}


