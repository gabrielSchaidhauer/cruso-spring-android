package com.ogabriel.minicurso.spring.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogabriel.minicurso.spring.model.entity.Usuario;
import com.ogabriel.minicurso.spring.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService (UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public void save(String nome) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		this.usuarioRepository.save(usuario);
	}
	
	public Usuario findUserByName(String nome) {
		return this.usuarioRepository.findByNome(nome);
	}
}
