package com.cliente.surittec.dto;

import java.io.Serializable;

public class UsuarioAutenticacaoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String username;
	private String senha;
	
	public UsuarioAutenticacaoDTO() {}

	public UsuarioAutenticacaoDTO(String username, String senha) {
		super();
		this.username = username;
		this.senha = senha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
