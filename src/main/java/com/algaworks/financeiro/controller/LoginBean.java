package com.algaworks.financeiro.controller;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 4823120414135551508L;
	
	@Inject
	private Usuario usuario;
	
	private String nome;
	
	private String senha;
	
	public String login(){
		FacesContext context = FacesContext.getCurrentInstance();
		if("admin".equals(this.nome) && "123".equals(this.senha)){
			this.usuario.setNome(nome);
			this.usuario.setDataLogin(new Date());
			return "Consulta?faces-redirect-true";
		}else{
			FacesMessage mensagem = new FacesMessage(
				"Usuário/senha inválidos!"
			);
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext()
		.invalidateSession();
		return "/Login?faces-redirect=true";
	}
}
