/*
 *
 *  ---------------------------------------------------------------------------------------------------------
 *              Titel: Menu.java
 *             Auteur: spekj06
 *    Creatietijdstip: 20-4-2022 11:20
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
package nl.belastingdienst.console;

import java.util.Scanner;

import nl.belastingdienst.data.PersonDao;
import nl.belastingdienst.services.PersonService;

/**
 * Console menu met verschillende opties
 *
 * @author spekj06
 */
public class Menu {
	PersonDao personDao;
	PersonService personService;

	public Menu(PersonDao personDataAccessObject) {
		this.personDao = personDataAccessObject;
		personService = new PersonService(personDao);
	}

	public void initMenu() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {

			System.out.print(menuOptions());
			choice = getUserMenuOptions(scanner, personService);

			switch (choice) {

			case 1:
				personService.getAllVisitorsFromDatabase();
				break;

			case 2:
				personService.getVisitorDetailsFromConsoleInput(scanner);
				break;
			}

		} while (choice != 0);
	}

	public int getUserMenuOptions(Scanner scanner, PersonService personService) {
		personService.validateInput(scanner, "Kies invoer 1 of 2", menuOptions());
		return scanner.nextInt();
	}

	public String menuOptions() {
		StringBuilder sb = new StringBuilder("\nWelkom by Sign in!\n Maak uw keuze\n");
		sb.append("1. Toon actuele presentielijst\n");
		sb.append("2. Bezoeker invoeren\n");
		sb.append("   voer u keuze in : ");

		return sb.toString();
	}
}
