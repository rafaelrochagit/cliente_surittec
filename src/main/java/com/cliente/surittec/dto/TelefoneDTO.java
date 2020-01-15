package com.cliente.surittec.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.cliente.surittec.domain.Telefone;

public class TelefoneDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="{campo.obrigatorio}")
	@Pattern(regexp = "[(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})]+$", message="{campo.invalido.telefone}")
	private String numero;
	
	@NotNull(message="{campo.obrigatorio}")
	private Integer tipo;
	
	public TelefoneDTO() {}
	
	public TelefoneDTO(Telefone Telefone) {
		super();
		this.id = Telefone.getId();
		this.numero = Telefone.getNumero();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	
	public String getNumeroSemMascara() {
		return numero.replaceAll("[^\\d ]", "");
	}
	
	public void setNumero(String Numero) {
		this.numero = Numero;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	

	
}
