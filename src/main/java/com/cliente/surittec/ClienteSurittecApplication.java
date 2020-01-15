package com.cliente.surittec;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cliente.surittec.domain.Usuario;
import com.cliente.surittec.enums.Perfil;
import com.cliente.surittec.repositories.UsuarioRepository;

@SpringBootApplication
public class ClienteSurittecApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ClienteSurittecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuario1 = new Usuario(null, "admin", bCryptPasswordEncoder.encode("123456"));
		Usuario usuario2 = new Usuario(null, "comum", bCryptPasswordEncoder.encode("123456"));
		usuario1.addPerfil(Perfil.ADMIN);
		usuario2.addPerfil(Perfil.COMUM);
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
	}

}
