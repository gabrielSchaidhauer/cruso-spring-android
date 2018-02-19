package com.ogabriel.minicurso.spring.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ogabriel.minicurso.spring.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Usuario findByNome(String nome);
}
