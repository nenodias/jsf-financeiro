package com.algaworks.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.financeiro.domain.Lancamento;
import com.algaworks.financeiro.domain.Pessoa;
import com.algaworks.financeiro.domain.TipoLancamento;
import com.algaworks.financeiro.repository.PessoaRepository;
import com.algaworks.financeiro.service.CadastroLancamentosService;
import com.algaworks.financeiro.service.NegocioException;

@Named
@ViewScoped
public class CadastroLancamentoBean implements Serializable{

	private static final long serialVersionUID = -9110159161567952434L;

	private Lancamento lancamento = new Lancamento();
	
	private List<Pessoa> pessoas;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	@Inject
	private CadastroLancamentosService cadastroLancamentoService;
	
	public void initialize(){
		this.pessoas = pessoaRepository.findAll();
	}
	
	public void save(){
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			cadastroLancamentoService.save(lancamento);
			
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso") );
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}
	
	public void dataVencimentoAlterada(AjaxBehaviorEvent event) {
		if (this.lancamento.getDataPagamento() == null) {
			this.lancamento.setDataPagamento(this.lancamento.getDataVencimento());
		}
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public TipoLancamento[] getTiposLancamentos(){
		return TipoLancamento.values();
	}
	
}
