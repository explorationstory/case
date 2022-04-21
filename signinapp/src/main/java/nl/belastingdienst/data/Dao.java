/*
 *
 *  ---------------------------------------------------------------------------------------------------------
 *              Titel: Dao.java
 *             Auteur: spekj06
 *    Creatietijdstip: 21-4-2022 09:53
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

/**
 * Data Access Object(DAO) abstracte interface voor het scheiden van
 * business laag van de datalaag
 * @author spekj06
 */
public interface Dao<T> {

	Optional<T> getOne(int id);

	List<T> getAll();

	void save(T entity);
}
