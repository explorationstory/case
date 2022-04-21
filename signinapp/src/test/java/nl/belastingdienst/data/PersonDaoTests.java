/*
 *
 *  ---------------------------------------------------------------------------------------------------------
 *              Titel: PersonDaoTests.java
 *             Auteur: spekj06
 *    Creatietijdstip: 21-4-2022 10:07
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
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nl.belastingdienst.models.Person;

/**
 * Unittesten voor PersonDao klasse
 *
 * @author spekj06
 */
public class PersonDaoTests {
	Person person;
	PersonDao personDao;

	@BeforeEach
	void setUp() {
		personDao = new PersonDao();
		person = new Person("Jamie", "Spekman ", "0622334456", LocalDateTime.now(), "Tom Cruise",
				666);
	}

	@Test
	void givenIdOfPerson_whenGetOne_ThenReturnPersonFromDatabase() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("signin-db");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		em.persist(person);
		transaction.commit();

		Optional<Person> personOptional = personDao.getOne(1);
		String expectedName = "Jamie";
		String expectedPhoneNumber = "0622334456";

		Assertions.assertEquals(expectedName,personOptional.get().getFirstName());
		Assertions.assertEquals(expectedPhoneNumber,person.getPhoneNumber());
		em.clear();
		em.close();
	}


}
