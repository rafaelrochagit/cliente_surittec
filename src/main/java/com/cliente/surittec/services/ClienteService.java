package com.cliente.surittec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cliente.surittec.domain.Cliente;
import com.cliente.surittec.domain.Endereco;
import com.cliente.surittec.dto.ClienteDTO;
import com.cliente.surittec.dto.ClienteNewDTO;
import com.cliente.surittec.repositories.ClienteRepository;
import com.cliente.surittec.repositories.EnderecoRepository;
import com.cliente.surittec.services.exceptions.DataIntegrityException;
import com.cliente.surittec.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente find(Integer idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		return cliente.orElse(null);
	}
	
	@Transactional
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		cliente = clienteRepository.save(cliente);
		return cliente;
	}
	
	public Cliente update(Cliente cliente) {
		Cliente newCliente = this.find(cliente.getId());
		if (newCliente == null) throw new ObjectNotFoundException("Não foi possível encontrar cliente de id " + cliente.getId());
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
	
	public Cliente fromDTO(ClienteNewDTO clienteDTO) {
		Cliente cliente =  new Cliente(null, clienteDTO.getNome(), clienteDTO.getCpf(), null, null, null);
		
		Endereco endereco = new Endereco(null, clienteDTO.getCep(), clienteDTO.getLogradouro(), clienteDTO.getBairro(), 
				clienteDTO.getCidade(), clienteDTO.getUf(), clienteDTO.getComplemento());
		
		cliente.setEndereco(endereco);
		cliente.setTelefones(clienteDTO.getTelefones());
		cliente.setEmails(clienteDTO.getEmails());
		return cliente;
	}
	
	private void updateData(Cliente newCliente, Cliente cliente) {
		newCliente.setNome(cliente.getNome());
		newCliente.setCpf(cliente.getCpf());
		newCliente.setEmails(cliente.getEmails());
		newCliente.setEndereco(cliente.getEndereco());
		newCliente.setId(cliente.getId());
		newCliente.setTelefones(cliente.getTelefones());
	}

}
