package com.algaworks.financeiro.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.financeiro.domain.Lancamento;
import com.algaworks.financeiro.repository.LancamentoRepository;

@Named
@ViewScoped
public class ConsultaLancamentosBean implements Serializable{

	private static final long serialVersionUID = -4094033283619071345L;
	
	private List<Lancamento> lancamentos;
	
	@Inject
	private LancamentoRepository lancamentosRepository; 
	
	public void consultar(){
		this.lancamentos = lancamentosRepository.findAll();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
}
