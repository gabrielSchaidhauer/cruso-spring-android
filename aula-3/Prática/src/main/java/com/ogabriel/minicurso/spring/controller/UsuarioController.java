package com.ogabriel.minicurso.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ogabriel.minicurso.spring.model.entity.Usuario;
import com.ogabriel.minicurso.spring.model.service.UsuarioService;

@RestController
@RequestMapping(path="/api/usuarios")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@RequestMapping(path="/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> createUser(@RequestBody String nome) {
		this.usuarioService.save(nome);
		ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(path="/{nome}")
	@ResponseBody
	public ResponseEntity<Usuario> findUsuarioByNome (@PathVariable("nome") String nome) {
		Usuario usuario = this.usuarioService.findUserByName(nome);
		ResponseEntity<Usuario> response = new ResponseEntity<>(usuario, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(path="/exception", method=RequestMethod.GET)
	public void exception() {
		throw new NullPointerException();
	}
}
