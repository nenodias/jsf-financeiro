package com.algaworks.financeiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algaworks.financeiro.domain.Livro;

@ManagedBean
@ViewScoped
public class LivrosBean {

	private List<Livro> livros;
	private Livro livro;
	
	public LivrosBean(){
		this.livro = new Livro();
		this.livros = new ArrayList<>();
		this.livros.add( new Livro("Python Primeiros Códigos", "Felipe Cruz") );
		this.livros.add( new Livro("Python Fluente", "Luciano Ramalho") );
	}
	
	public void adicionar(){
		this.livros.add(this.livro);
		this.livro = new Livro();
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
