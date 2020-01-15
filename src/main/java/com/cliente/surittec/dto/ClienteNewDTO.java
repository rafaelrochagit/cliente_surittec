package com.cliente.surittec.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.cliente.surittec.domain.Cliente;
import com.cliente.surittec.domain.Telefone;
import com.cliente.surittec.enums.TipoTelefone;
import com.cliente.surittec.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="{campo.obrigatorio}")
	@Length(min=3, max=100, message="Tamanho dever ser de 3 a 100")
	@Pattern(regexp = "[\\d|A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$", message="{campo.invalido.letras.e.numeros}")
	private String nome;

	@NotEmpty(message="{campo.obrigatorio}")
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message="{campo.invalido.cpf}")
	private String cpf;
	
	@NotEmpty(message="{campo.obrigatorio}")
	private String cep;

	@NotEmpty(message="{campo.obrigatorio}")
	private String logradouro;

	@NotEmpty(message="{campo.obrigatorio}")
	private String bairro;

	@NotEmpty(message="{campo.obrigatorio}")
	private String cidade;

	@NotEmpty(message="{campo.obrigatorio}")
	private String uf;
	
	private String complemento;
	
	@NotEmpty(message = "{campo.lista.email.obrigatorio}")
	private Set<@Email String> emails;

	@NotEmpty(message = "{campo.lista.telefone.obrigatorio}")
	private List<@Valid TelefoneDTO> telefones;
	
	public ClienteNewDTO() {
		
	}
	
	public ClienteNewDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public List<Telefone> getTelefones() {
		List<Telefone> telefones = this.telefones.stream().map(
				telefone -> new Telefone(telefone.getId(),telefone.getNumeroSemMascara(), TipoTelefone.toEnum(telefone.getTipo()))
				).collect(Collectors.toList());
		return telefones;
	}

	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}
	
	

	
}
