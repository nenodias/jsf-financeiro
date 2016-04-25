package com.algaworks.financeiro.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.algaworks.financeiro.domain.Lancamento;
import com.algaworks.financeiro.repository.LancamentoRepository;
import com.algaworks.financeiro.util.Transactional;

@javax.faces.view.ViewScoped
public class CadastroLancamentosService implements Serializable {

	private static final long serialVersionUID = -4397272654697343855L;

	@Inject
	private LancamentoRepository lancamentoRepository;

	@Transactional
	public void save(Lancamento entitade) throws NegocioException {
		if (entitade.getDataPagamento() != null && entitade.getDataPagamento().after(new Date())) {
			throw new NegocioException("Data de pagamento não pode ser uma data futura.");
		}
		this.lancamentoRepository.add(entitade);
	}
}
