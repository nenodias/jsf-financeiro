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
        
        private Pessoa pessoa = new Pessoa();
        
        public void initialize() {
        if (this.pessoa == null) {
            this.pessoa = new Pessoa();
        }
    }
	
	public void cadastrar(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = null;
		try{
			pessoaService.save(pessoa);
			mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.", "Cliente "+ pessoa.getNome() + " cadastrado com sucesso.");
		}catch(NegocioException ex){
			mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro.", "Cliente "+ pessoa.getNome() + " não foi cadastrado.");
		}
		context.addMessage(null, mensagem);
	}
        
        public Pessoa getPessoa(){
            return this.pessoa;
        }
        
        public void setPessoa(Pessoa pessoa){
            this.pessoa = pessoa;
        }
	
}
