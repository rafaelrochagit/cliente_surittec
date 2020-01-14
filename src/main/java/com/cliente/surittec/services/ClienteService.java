package com.cliente.surittec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cliente.surittec.domain.Cliente;
import com.cliente.surittec.dto.ClienteDTO;
import com.cliente.surittec.repositories.ClienteRepository;
import com.cliente.surittec.services.exceptions.DataIntegrityException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente find(Integer idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		return cliente.orElse(null);
	}
	
	public Cliente update(Cliente cliente) {
		Cliente newCliente = this.find(cliente.getId());
		updateData(newCliente, cliente);
		return clienteRepository.save(cliente);
	}
	
	public void delete(Integer id) {
		this.find(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir cliente que possui telefones, emails ou endereço");
		}
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), null, null, null, null);
	}
	
	private void updateData(Cliente newCliente, Cliente cliente) {
		newCliente.setNome(cliente.getNome());
	}

}
