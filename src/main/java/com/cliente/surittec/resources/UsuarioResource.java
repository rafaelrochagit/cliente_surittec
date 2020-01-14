package com.cliente.surittec.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@RequestMapping(method=RequestMethod.GET)
	public String testar() {
		return "Funcionando";
	}
}
