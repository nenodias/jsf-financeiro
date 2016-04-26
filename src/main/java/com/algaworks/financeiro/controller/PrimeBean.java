package com.algaworks.financeiro.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PrimeBean implements Serializable{

	private static final long serialVersionUID = -8181130248268893117L;

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
