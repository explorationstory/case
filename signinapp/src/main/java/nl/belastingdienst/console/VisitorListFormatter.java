/*
 *
 *  ---------------------------------------------------------------------------------------------------------
 *              Titel: VisitorListFormatter.java
 *             Auteur: spekj06
 *    Creatietijdstip: 21-4-2022 14:08
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

import java.util.List;

import nl.belastingdienst.models.Person;

/**
 * TODO: spekj06: beschrijf deze klasse !
 *
 * @author spekj06
 */
public class VisitorListFormatter {

	private List<Person> personList;

//	public VisitorListFormatter(List<Person> personList) {
//		this.personList = personList;
//	}

	public void printEvacuationList() {
		System.out.println();

		String formatList = "| %10$3s | %30$10s";

		System.out.format(formatList,1,"jamie");
	}
}
