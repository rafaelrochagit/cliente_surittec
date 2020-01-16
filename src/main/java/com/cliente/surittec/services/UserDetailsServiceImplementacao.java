package com.cliente.surittec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cliente.surittec.domain.Usuario;
import com.cliente.surittec.repositories.UsuarioRepository;
import com.cliente.surittec.security.UserSS;

@Service
public class UserDetailsServiceImplementacao implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repo.findByNome(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		UserSS u = new UserSS(user.getId(), user.getNome(), user.getSenha(), user.getPerfis());
		return u;
	}

}
