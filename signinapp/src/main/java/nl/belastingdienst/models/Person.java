/*
 *
 *  ---------------------------------------------------------------------------------------------------------
 *              Titel: Person.java
 *             Auteur: spekj06
 *    Creatietijdstip: 20-4-2022 14:19
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
package nl.belastingdienst.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * TODO: spekj06: beschrijf deze klasse !
 *
 * @author spekj06
 */
@Entity
public class Person {
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private LocalDateTime arrivalDateAndTime;
	private LocalDateTime departureDateAndTime;
	private String nameContactPerson;
	private int location;

	public Person() {
	}

	public Person(String firstName, String lastName, String phoneNumber, LocalDateTime arrivalDateTime, String contactPerson,
			int location) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setArrivalDateAndTime(arrivalDateTime);
		setNameContactPerson(contactPerson);
		setLocation(location);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getArrivalDateAndTime() {
		return arrivalDateAndTime;
	}

	public void setArrivalDateAndTime(LocalDateTime arrivalDateAndTime) {
		this.arrivalDateAndTime = arrivalDateAndTime;
	}

	public LocalDateTime getDepartureDateAndTime() {
		return departureDateAndTime;
	}

	public void setDepartureDateAndTime(LocalDateTime departureDateAndTime) {
		this.departureDateAndTime = departureDateAndTime;
	}

	public String getNameContactPerson() {
		return nameContactPerson;
	}

	public void setNameContactPerson(String nameContactPerson) {
		this.nameContactPerson = nameContactPerson;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	private String formatDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return arrivalDateAndTime.format(formatter);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Naam : ");
		sb.append(firstName + " ");
		sb.append(lastName + "|  " );
		sb.append("TelefoonNr: " + phoneNumber);
		sb.append("| Aankomsttijd: " + formatDateTime());
		sb.append("| Vertrektijd: " + departureDateAndTime);
		sb.append("| Locatie: " + location);
		sb.append("| Contactpersoon: " + nameContactPerson);

		return sb.toString();
	}
}
