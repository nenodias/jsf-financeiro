package com.algaworks.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.financeiro.domain.Lancamento;
import com.algaworks.financeiro.domain.Pessoa;
import com.algaworks.financeiro.domain.TipoLancamento;
import com.algaworks.financeiro.repository.LancamentoRepository;
import com.algaworks.financeiro.repository.PessoaRepository;
import com.algaworks.financeiro.service.CadastroLancamentosService;
import com.algaworks.financeiro.service.NegocioException;
import com.algaworks.financeiro.util.JPAUtil;

@ManagedBean
public class CadastroLancamentoBean implements Serializable{

	private static final long serialVersionUID = -9110159161567952434L;

	private Lancamento lancamento = new Lancamento();
	
	private List<Pessoa> pessoas;
	
	public void initialize(){
		EntityManager manager = JPAUtil.getEntityManager();
		try{
			PessoaRepository pessoaRepository = new PessoaRepository(manager);
			this.pessoas = pessoaRepository.findAll();
		}finally{
			manager.close();
		}
	}
	
	public void save(){
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			tx.begin();
			LancamentoRepository lancamentoRepository = new LancamentoRepository(manager);
			CadastroLancamentosService cadastro = new CadastroLancamentosService(lancamentoRepository);
			cadastro.save(lancamento);
			
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso") );
			tx.commit();
		} catch (NegocioException e) {
			tx.rollback();
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} finally {
		manager.close();
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
