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
package nl.belastingdienst.person;

import java.util.Scanner;

/**
 * TODO: spekj06: beschrijf deze klasse !
 *
 * @author spekj06
 */
public class Menu {
	VisitorDatabaseOperations databaseOperations;

	public Menu(VisitorDatabaseOperations databaseOperations) {
		this.databaseOperations = databaseOperations;
	}

	public void initMenu() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			choice = showMenuOptions(scanner);

			switch (choice) {
			case 1:
				System.out.println("Tonen bezoekerslijst ");
				databaseOperations.getEvacuationList();
				break;
			case 2:
				System.out.println("Invoeren bezoeker....");
				break;
			}

		} while (choice != 0);
	}

	public int showMenuOptions(Scanner scanner) {
		System.out.println("Welkom by Sign in!\n Maak uw keuze\n");
		System.out.println("1. Toon actuele presentielijst");
		System.out.println("2. Bezoeker invoeren");
		System.out.print("   Voer u keuze in : ");

		return scanner.nextInt();
	}
}
