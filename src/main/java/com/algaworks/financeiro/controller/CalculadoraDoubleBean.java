package com.algaworks.financeiro.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CalculadoraDoubleBean implements Serializable{

	private static final long serialVersionUID = 4643860857344826363L;
	
	private Double valorA;
	
	private Double valorB;
	
	private Double resultado;
	
	public void somar(){
		this.resultado = valorA + valorB;
	}

	public Double getValorA() {
		return valorA;
	}

	public void setValorA(Double valorA) {
		this.valorA = valorA;
	}

	public Double getValorB() {
		return valorB;
	}

	public void setValorB(Double valorB) {
		this.valorB = valorB;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}

}
