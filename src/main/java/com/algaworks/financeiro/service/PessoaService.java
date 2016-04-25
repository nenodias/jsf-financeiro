package com.algaworks.financeiro.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.financeiro.domain.Pessoa;
import com.algaworks.financeiro.repository.PessoaRepository;
import com.algaworks.financeiro.util.Transactional;

@javax.faces.view.ViewScoped
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 8740169754463029683L;
	
	@Inject
	private PessoaRepository pessoaRepository;

	@Transactional
	public void save(Pessoa entitade) throws NegocioException {
		this.pessoaRepository.add(entitade);
	}
}
