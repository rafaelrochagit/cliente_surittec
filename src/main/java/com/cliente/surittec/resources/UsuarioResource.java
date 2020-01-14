package com.cliente.surittec.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.surittec.domain.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Usuario> listar() {
		
		Usuario usuario1 = new Usuario(1, "admin", "123456");
		Usuario usuario2 = new Usuario(2, "comum", "123456");
		
		List<Usuario> listaUsuarios = new ArrayList<>();
		listaUsuarios.add(usuario1);
		listaUsuarios.add(usuario2);
		
		return listaUsuarios;
	}
}
