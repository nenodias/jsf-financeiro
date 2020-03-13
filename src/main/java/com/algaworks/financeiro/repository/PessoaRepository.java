package com.algaworks.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.financeiro.domain.Pessoa;

public class PessoaRepository implements Serializable{

	private static final long serialVersionUID = 8323918551617639584L;
	
	@Inject
	private EntityManager manager;

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
        
        public void save(Pessoa entidade) {
            this.manager.merge(entidade);
        }
        
        public void remove(Pessoa entidade) {
            this.manager.remove(entidade);
        }
	
}
