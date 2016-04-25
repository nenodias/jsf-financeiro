package com.algaworks.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaTabelas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FinanceiroPU");
		factory.close();
	}
	
}
