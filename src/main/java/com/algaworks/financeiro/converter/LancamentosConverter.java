package com.algaworks.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.algaworks.financeiro.domain.Lancamento;
import com.algaworks.financeiro.repository.LancamentoRepository;

@FacesConverter(forClass = Lancamento.class)
public class LancamentosConverter  implements Converter{
	
	@Inject
	private LancamentoRepository lancamentoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Lancamento retorno = null;
		if(value  != null && !"".equals(value)){
			retorno = lancamentoRepository.findById( new Long(value) );
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if(value != null){
			Lancamento lancamento = (Lancamento)value;
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return null;
	}

}
