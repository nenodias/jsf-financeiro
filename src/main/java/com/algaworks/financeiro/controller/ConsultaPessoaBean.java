package com.algaworks.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.financeiro.domain.Lancamento;
import com.algaworks.financeiro.domain.Pessoa;
import com.algaworks.financeiro.repository.LancamentoRepository;
import com.algaworks.financeiro.repository.PessoaRepository;
import com.algaworks.financeiro.service.CadastroLancamentosService;
import com.algaworks.financeiro.service.NegocioException;
import com.algaworks.financeiro.service.PessoaService;

@Named
@ViewScoped
public class ConsultaPessoaBean implements Serializable{

	private static final long serialVersionUID = -4094033283619071345L;
	
	private List<Pessoa> pessoas;
	
	private Pessoa pessoaSelecionada;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	@Inject
	private PessoaService pessoaService;
	
	public void consultar(){
		this.pessoas = pessoaRepository.findAll();
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			pessoaService.delete(pessoaSelecionada);
			this.consultar();
			context.addMessage(null, new FacesMessage("Lançamento excluído com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}
	
}
