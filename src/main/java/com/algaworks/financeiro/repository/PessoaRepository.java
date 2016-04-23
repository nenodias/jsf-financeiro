package com.algaworks.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.financeiro.domain.Pessoa;

public class PessoaRepository implements Serializable{

	private static final long serialVersionUID = 8323918551617639584L;
	
	private EntityManager manager;

	public PessoaRepository(EntityManager manager){
		this.manager = manager;
	}
	
	public Pessoa findById(Long id) {
		return manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> findAll(){
		TypedQuery<Pessoa> query = manager.createQuery("FROM Pessoa", Pessoa.class);
		List<Pessoa> retorno = query.getResultList();
		return retorno;
	}
	
	public void add(Pessoa entidade) {
		this.manager.persist(entidade);
	}
	
}
