/*
 *
 *  ---------------------------------------------------------------------------------------------------------
 *              Titel: VisitorDatabaseOperations.java
 *             Auteur: spekj06
 *    Creatietijdstip: 20-4-2022 15:24
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

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import nl.belastingdienst.models.Person;

/**
 * Data Access Object voor het persisteren van personen
 *
 * @author spekj06
 */
public class PersonDao implements Dao<Person> {

	private final EntityManagerFactory emf;
	private EntityManager em;
	private final EntityTransaction transaction;

	public PersonDao() {
		emf = Persistence.createEntityManagerFactory("signin-db");
		em = emf.createEntityManager();
		transaction = em.getTransaction();
	}

	@Override
	public Optional<Person> getOne(int id) {
		em = emf.createEntityManager();
		return Optional.ofNullable(em.find(Person.class,id));
	}

	@Override
	public List<Person> getAll() {
		em = emf.createEntityManager();
		String jpqlQuery = "SELECT p FROM Person p";
		TypedQuery<Person> query = em.createQuery(jpqlQuery,Person.class);
		return query.getResultList();
	}

	@Override
	public void save(Person entity) {
		beginTransaction(transaction);
		em.persist(entity);
		endTransaction(transaction,em);
	}

	private void beginTransaction(EntityTransaction transaction) {
		transaction.begin();
	}

	private void endTransaction(EntityTransaction transaction, EntityManager em){
		transaction.commit();
		em.clear();
		em.close();
	}
}
