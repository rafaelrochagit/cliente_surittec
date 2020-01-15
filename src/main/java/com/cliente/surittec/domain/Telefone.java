package com.cliente.surittec.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cliente.surittec.enums.TipoTelefone;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Telefone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String numero;
	
	@Column(nullable = false)
	private Integer tipo;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	public Telefone(){}
	

	public Telefone(Integer id, String numero, TipoTelefone tipo) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipo = tipo != null ? tipo.getCod() : null;
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

	public void setNumero(String numero) {
		this.numero = numero.replace("/[^0-9]+/g","");
	}

	public TipoTelefone getTipo() {
		return TipoTelefone.toEnum(this.tipo);
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo.getCod();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
