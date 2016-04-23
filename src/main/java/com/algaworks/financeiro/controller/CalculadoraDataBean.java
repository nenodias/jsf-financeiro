package com.algaworks.financeiro.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CalculadoraDataBean implements Serializable{

	private static final long serialVersionUID = 6707933509446513191L;
	
	private Date dataBase;
	
	private Integer dias;
	
	private Date resultado;
	
	public void adicionar(){
		Calendar dataCalculo = Calendar.getInstance();
		dataCalculo.setTime(this.dataBase);
		dataCalculo.add(Calendar.DAY_OF_MONTH, dias);
		this.resultado = dataCalculo.getTime();
	}

	public Date getDataBase() {
		return dataBase;
	}

	public void setDataBase(Date dataBase) {
		this.dataBase = dataBase;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Date getResultado() {
		return resultado;
	}

	public void setResultado(Date resultado) {
		this.resultado = resultado;
	}
	
}
