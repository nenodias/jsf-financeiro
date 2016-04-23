package com.algaworks.financeiro.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("pessoaValidator")
public class PessoaValidator implements Validator {
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if (value == null) {
			FacesMessage facesMessage = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Data inválida.", "A data informada não é um dia útil.");
			throw new ValidatorException(facesMessage);
		}
	}
}
