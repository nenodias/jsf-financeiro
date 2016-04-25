package com.algaworks.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.algaworks.financeiro.domain.Pessoa;
import com.algaworks.financeiro.repository.PessoaRepository;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	@Inject
	private PessoaRepository pessoaRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Pessoa retorno = null;
		if (value != null && !"".equals(value) && !value.equals("null")) {
			retorno = pessoaRepository.findById(new Long(value));
		}else{
			retorno = null;
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			return ((Pessoa) value).getId().toString();
		}
		return null;
	}

}
