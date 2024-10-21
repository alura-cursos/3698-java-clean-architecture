package br.com.alura.codechella.infra.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {
}
