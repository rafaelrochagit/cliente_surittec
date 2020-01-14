package com.cliente.surittec.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliente.surittec.domain.Cliente;
import com.cliente.surittec.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Integer idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		return cliente.orElse(null);
	}

}
