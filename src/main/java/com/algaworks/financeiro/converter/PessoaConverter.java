package com.algaworks.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import com.algaworks.financeiro.domain.Pessoa;
import com.algaworks.financeiro.repository.PessoaRepository;
import com.algaworks.financeiro.util.JPAUtil;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Pessoa retorno = null;
		EntityManager manager = JPAUtil.getEntityManager();
		try {
			if (value != null && !"".equals(value) && !value.equals("null")) {
				PessoaRepository repository = new PessoaRepository(manager);
				retorno = repository.findById(new Long(value));
			}else{
				retorno = null;
			}
		} finally {
			manager.close();
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
