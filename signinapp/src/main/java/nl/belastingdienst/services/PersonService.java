/*
 *
 *  ---------------------------------------------------------------------------------------------------------
 *              Titel: PersonService.java
 *             Auteur: spekj06
 *    Creatietijdstip: 21-4-2022 11:48
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
package nl.belastingdienst.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import nl.belastingdienst.data.Dao;
import nl.belastingdienst.models.Person;

/**
 * TODO: spekj06: beschrijf deze klasse !
 *
 * @author spekj06
 */
public class PersonService {
	private final Dao personDao;

	public PersonService(Dao personDao) {
		this.personDao = personDao;
	}

	public void saveVisitor(Person person) {
		personDao.save(person);
	}

	public void getAllVisitorsFromDatabase() {
		printEvacuationList(personDao.getAll());
	}

	public Person getVisitorDetailsFromConsoleInput(Scanner scanner) {
		String locationNumberFromInputMessage = "Voer locatienummer in: ";
		System.out.print("Voer voornaam in: ");
		String firstName = scanner.next();

		System.out.print("Voer achternaam in: ");
		String lastName = scanner.next();

		System.out.print("Voer telefoonnummerin: ");
		String phoneNumber = scanner.next();

		System.out.print("Voer volledige naam contactpersoon in: ");
		String contactPerson = scanner.next();

		System.out.print(locationNumberFromInputMessage);
		validateInput(scanner, "Invoer moet bestaan uit nummers",locationNumberFromInputMessage);
		int location = scanner.nextInt();

		Person person = new Person(firstName, lastName, phoneNumber, LocalDateTime.now(),
				contactPerson, location);
		saveVisitor(person);

		return person;
	}

	public void validateInput(Scanner scanner, String errorMessage, String inputMessage) {

		while(!scanner.hasNextInt()){
			System.err.println(errorMessage);
			System.out.print(inputMessage);
			scanner.next();
		}
	}

	private void printEvacuationList(List<Person> personList) {
		System.out.println("Evacuatielijst: \n");
		for (Person person : personList) {
			System.out.println(person);
		}
	}
}
