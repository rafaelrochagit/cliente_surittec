package com.cliente.surittec.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cliente.surittec.domain.Usuario;
import com.cliente.surittec.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario buscar(Integer idUsuario) {
		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		return usuario.orElse(null);
	}
	
	public Usuario findByNome(String nome) {
		Example<Usuario> exampleUsuario = Example.of(new Usuario(null, nome, null));
		Optional<Usuario> usuario = usuarioRepository.findOne(exampleUsuario);
		return usuario.orElse(null);
	}

}
