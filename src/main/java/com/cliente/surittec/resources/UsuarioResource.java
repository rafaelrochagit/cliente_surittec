package com.cliente.surittec.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.surittec.domain.Usuario;
import com.cliente.surittec.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Usuario usuario = usuarioService.buscar(id);
		
		return ResponseEntity.ok().body(usuario);
	}
}
