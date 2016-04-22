package com.algaworks.financeiro.domain;

import java.io.Serializable;

public class Livro implements Serializable{

	private static final long serialVersionUID = 7054124745147931807L;
	
	private String titulo;
	private String autor;

	public Livro(){}
	
	public Livro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
