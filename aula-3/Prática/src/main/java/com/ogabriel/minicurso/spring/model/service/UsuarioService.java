package com.ogabriel.minicurso.spring.model.service;

import com.ogabriel.minicurso.spring.consumer.RandomUserServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogabriel.minicurso.spring.model.entity.Usuario;
import com.ogabriel.minicurso.spring.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final RandomUserServiceConsumer randomUserServiceConsumer;
	
	@Autowired
	public UsuarioService (UsuarioRepository usuarioRepository, RandomUserServiceConsumer randomUserServiceConsumer) {
		this.usuarioRepository = usuarioRepository;
		this.randomUserServiceConsumer = randomUserServiceConsumer;
	}
	
	public void save(String nome) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		this.usuarioRepository.save(usuario);
	}

	public Usuario findUserByNomeAndSenha(String nome, String senha) {

		return this.usuarioRepository.findByNomeAndSenha(nome, senha);
	}

	public String getRandomUser() {
		return randomUserServiceConsumer.getRandomUser();
	}
	
	public Usuario findUserByName(String nome) {
		return this.usuarioRepository.findByNome(nome);
	}
}
