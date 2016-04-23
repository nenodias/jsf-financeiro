package com.algaworks.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.financeiro.domain.Lancamento;

public class LancamentosRepositry implements Serializable{

	private static final long serialVersionUID = -8691917533208639313L;
	
	private EntityManager manager;

	public LancamentosRepositry(EntityManager manager){
		this.manager = manager;
	}
	
	public List<Lancamento> findAll(){
		TypedQuery<Lancamento> query = manager.createQuery("FROM Lancamento", Lancamento.class);
		List<Lancamento> retorno = query.getResultList();
		return retorno;
	}
}
