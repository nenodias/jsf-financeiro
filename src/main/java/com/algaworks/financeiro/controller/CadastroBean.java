package com.algaworks.financeiro.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.financeiro.domain.Pessoa;
import com.algaworks.financeiro.service.NegocioException;
import com.algaworks.financeiro.service.PessoaService;

@Named
@ViewScoped
public class CadastroBean implements Serializable{
	
	private static final long serialVersionUID = -7875104833498113525L;

	@Inject
	private PessoaService pessoaService;

	private String nome;
	
	public void cadastrar(){
		FacesContext context = FacesContext.getCurrentInstance();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(this.nome);
		FacesMessage mensagem = null;
		try{
			pessoaService.save(pessoa);
			mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.", "Cliente "+ this.nome + " cadastrado com sucesso.");
		}catch(NegocioException ex){
			mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro.", "Cliente "+ this.nome + " não foi cadastrado.");
		}
		context.addMessage(null, mensagem);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
