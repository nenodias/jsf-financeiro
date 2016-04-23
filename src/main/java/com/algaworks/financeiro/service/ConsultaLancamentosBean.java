package com.algaworks.financeiro.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import com.algaworks.financeiro.domain.Lancamento;
import com.algaworks.financeiro.repository.LancamentoRepository;
import com.algaworks.financeiro.util.JPAUtil;

@ManagedBean
@ViewScoped
public class ConsultaLancamentosBean implements Serializable{

	private static final long serialVersionUID = -4094033283619071345L;
	
	private List<Lancamento> lancamentos;
	
	public void consultar(){
		EntityManager manager = JPAUtil.getEntityManager();
		LancamentoRepository repository = new LancamentoRepository(manager);
		this.lancamentos = repository.findAll();
		manager.close();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
}
