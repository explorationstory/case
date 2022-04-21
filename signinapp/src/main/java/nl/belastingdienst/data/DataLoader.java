/*
 *
 *  ---------------------------------------------------------------------------------------------------------
 *              Titel: DataLoader.java
 *             Auteur: spekj06
 *    Creatietijdstip: 21-4-2022 10:02
 *          Copyright: (c) 2022 Belastingdienst / Centrum voor Applicatieontwikkeling en Onderhoud,
 *                     All Rights Reserved.
 *  ---------------------------------------------------------------------------------------------------------
 *                                              |   Unpublished work. This computer program includes
 *     De Belastingdienst                       |   Confidential, Properietary Information and is a
 *     Postbus 9050                             |   trade Secret of the Belastingdienst. No part of
 *     7300 GM  Apeldoorn                       |   this file may be reproduced or transmitted in any
 *     The Netherlands                          |   form or by any means, electronic or mechanical,
 *     http://belastingdienst.nl/               |   for the purpose, without the express written
 *                                              |   permission of the copyright holder.
 *  ---------------------------------------------------------------------------------------------------------
 *
 */
package nl.belastingdienst.data;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import nl.belastingdienst.models.Person;

/**
 * TODO: spekj06: beschrijf deze klasse !
 *
 * @author spekj06
 */
public class DataLoader {

	private final EntityManagerFactory emf;
	private final EntityManager em;
	private final EntityTransaction transaction;

	public DataLoader() {
		emf = Persistence.createEntityManagerFactory("signin-db");
		em = emf.createEntityManager();
		transaction = em.getTransaction();
	}

	public void loadVisitorsInDatabase(){
		Person person1 = new Person("Jamie","Spekman ","0622334456", LocalDateTime.now(),"Tom", 666);
		Person person2 = new Person("Eric","de Soff ","0622323456", LocalDateTime.now(),"Joris", 2);
		Person person3 = new Person("Coen","Hoogduin","068968786", LocalDateTime.now(),"Joris", 5);
		Person person4 = new Person("Martin","Bunt","0622334456", LocalDateTime.now(),"Joris", 8);
		Person person5 = new Person("Jamie","Spekman ","0622334456", LocalDateTime.now(),"Joris",8);

		transaction.begin();

		em.persist(person1);
		em.persist(person2);
		em.persist(person3);
		em.persist(person4);
		em.persist(person5);

		transaction.commit();

		em.clear();
	}

	public void getEvacuationList() {

		String jpqlQuery = "SELECT p FROM Person p";
		TypedQuery<Person> query = em.createQuery(jpqlQuery,Person.class);
		List<Person> bezoekers =query.getResultList();

		printEvacuationList(bezoekers);
	}

	private void printEvacuationList(List<Person> personList) {
		System.out.println("Evacuatielijst: \n");
		for(Person person : personList) {
			System.out.println(person);
		}
	}
}
