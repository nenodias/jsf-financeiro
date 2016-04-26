package com.algaworks.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.financeiro.domain.Lancamento;

public class LancamentoRepository implements Serializable{

	private static final long serialVersionUID = -8691917533208639313L;
	
	@Inject
	private EntityManager manager;

	public List<Lancamento> findAll(){
		TypedQuery<Lancamento> query = manager.createQuery("FROM Lancamento", Lancamento.class);
		List<Lancamento> retorno = query.getResultList();
		return retorno;
	}
	
	public void add(Lancamento lancamento) {
		this.manager.persist(lancamento);
	}
	
	public void save(Lancamento lancamento) {
		this.manager.merge(lancamento);
	}
	
	public void remove(Lancamento lancamento){
		this.manager.remove(lancamento);
	}
	
	public Lancamento findById(Long id) {
		return this.manager.find(Lancamento.class, id);
	}
	
	public List<String> contains(String descricao) {
		TypedQuery<String> query = manager.createQuery("select distinct descricao from Lancamento where upper(descricao) like upper(:descricao)", String.class);
		query.setParameter("descricao", "%" + descricao + "%");
		return query.getResultList();
	}
	
}
