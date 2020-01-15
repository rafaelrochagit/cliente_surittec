package com.cliente.surittec.enums;

public enum TipoTelefone {
	
	RESIDENCIAL(1, "Residencial"),
	COMERCIAL(2, "Residencial"),
	CELULAR(3, "Residencial");
	
	private int cod;
	private String descricao;
	
	private TipoTelefone(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static TipoTelefone toEnum(Integer cod) {
		if (cod == null) return null;
		
		for (TipoTelefone x : TipoTelefone.values()) {
			if (cod.equals(x.getCod())) return x;
		}
		
		throw new IllegalArgumentException("Cod inválido " + cod);
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
	
}
