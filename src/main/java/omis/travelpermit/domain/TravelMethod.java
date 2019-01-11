/*
 *  OMIS - Offender Management Information System
 *  Copyright (C) 2011 - 2017 State of Montana
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package omis.travelpermit.domain;

import java.io.Serializable;

/**
 * Travel method.
 * @author Yidong Li
 * @version 0.1.0 (May 17, 2018)
 * @since OMIS 3.0
 */
public interface TravelMethod
		extends Serializable {
	/**
	 * Sets the ID.
	 * @param id ID
	 */
	void setId(Long id);
	
	/**
	 * Returns the ID.
	 * @return ID
	 */
	Long getId();
	
	/**
	 * Sets name.
	 * 
	 * @param name name
	 */
	void setName(String name);
	
	/**
	 * Returns name.
	 * 
	 * @return name
	 */
	String getName();
	
	/**
	 * Sets the descriptionRequired.
	 * @param descriptionRequired descriptionRequired
	 */
	void setDescriptionRequired(Boolean descriptionRequired);
	
	/**
	 * Returns descriptionRequired.
	 * @return descriptionRequired descriptionRequired
	 */
	Boolean getDescriptionRequired();
	
	/**
	 * Sets the descriptionName.
	 * @param descriptionName descriptionName
	 */
	void setDescriptionName(String descriptionName);
	
	/**
	 * Returns descriptionName.
	 * @return descriptionName descriptionName
	 */
	String getDescriptionName();
	
	/**
	 * Sets the numberName.
	 * @param numberName numberName
	 */
	void setNumberName(String numberName);
	
	/**
	 * Returns numberName.
	 * @return numberName numberName
	 */
	String getNumberName();
	
	/**
	 * Sets the sortOrder.
	 * @param sortOrder sortOrder
	 */
	void setSortOrder(Short sortOrder);
	
	/**
	 * Returns sortOrder.
	 * @return sortOrder sortOrder
	 */
	Short getSortOrder();

	/**
	 * Compares {@code this} and {@code obj} for equality.
	 * <p>
	 * Any mandatory property may be used in the comparison. If a  mandatory
	 * property of {@code this} that is used in the comparison is {@code null}
	 * an {@code IllegalStateException} will be thrown.
	 * @param obj reference object with which to compare {@code this}
	 * @return {@code true} if {@code this} and {@code obj} are equal;
	 * {@code false} otherwise
	 * @throws IllegalStateException if a mandatory property of {@code this}
	 * that is used in the comparison is {@code null} 
	 */
	@Override
	boolean equals(Object obj);
	
	/**
	 * Returns a hash code for {@code this}.
	 * <p>
	 * Any mandatory property of {@code this} may be used in the hash code. If
	 * a mandatory property that is used in the hash code is {@code null} an
	 * {@code IllegalStateException} will be thrown.
	 * @return hash code
	 * @throws IllegalStateException if a mandatory property of {@code this}
	 * that is used in the hash code is {@code null}
	 */
	@Override
	int hashCode();
}