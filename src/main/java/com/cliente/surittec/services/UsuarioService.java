package com.cliente.surittec.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

}
