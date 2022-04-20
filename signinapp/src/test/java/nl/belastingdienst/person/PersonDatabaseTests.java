/*
 *
 *  ---------------------------------------------------------------------------------------------------------
 *              Titel: PersonDatabaseTests.java
 *             Auteur: spekj06
 *    Creatietijdstip: 20-4-2022 11:04
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
package nl.belastingdienst.person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for person functionalities
 *
 * @author spekj06
 */
public class PersonDatabaseTests {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction transaction;

	@BeforeEach
	void setUp() {
		emf = Persistence.createEntityManagerFactory("signin-db");
		em = emf.createEntityManager();
	}

	@Test
	void testDatabaseConnection() {
		Assertions.assertThat(em).isNotNull();
	}
}
