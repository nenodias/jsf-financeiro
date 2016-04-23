package com.algaworks.financeiro.service;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algaworks.financeiro.domain.Lancamento;
import com.algaworks.financeiro.repository.LancamentoRepository;

@ManagedBean
@ViewScoped
public class CadastroLancamentosService implements Serializable {

	private static final long serialVersionUID = -4397272654697343855L;

	private LancamentoRepository repository;

	public CadastroLancamentosService(LancamentoRepository repository) {
		this.repository = repository;
	}

	public void save(Lancamento entitade) throws NegocioException {
		if (entitade.getDataPagamento() != null && entitade.getDataPagamento().after(new Date())) {
			throw new NegocioException("Data de pagamento não pode ser uma data futura.");
		}
		this.repository.add(entitade);
	}
}
