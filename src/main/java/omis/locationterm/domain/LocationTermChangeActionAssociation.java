/*
 * OMIS - Offender Management Information System
 * Copyright (C) 2011 - 2017 State of Montana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package omis.locationterm.domain;

import omis.audit.domain.Creatable;
import omis.audit.domain.Updatable;

/**
 * Association of location term to change action.
 * 
 * @author Stephen Abson
 * @version 0.0.1 (Jul 9, 2018)
 * @since OMIS 3.0
 */
public interface LocationTermChangeActionAssociation
			extends Creatable, Updatable {

	/**
	 * Sets ID.
	 * 
	 * @param id ID
	 */
	void setId(Long id);
	
	/**
	 * Returns ID.
	 * 
	 * @return ID
	 */
	Long getId();
	
	/**
	 * Sets location term.
	 * 
	 * @param locationTerm location term
	 */
	void setLocationTerm(LocationTerm locationTerm);
	
	/**
	 * Returns location term.
	 * 
	 * @return location term
	 */
	LocationTerm getLocationTerm();
	
	/**
	 * Sets change action.
	 * 
	 * @param changeAction change action
	 */
	void setChangeAction(LocationTermChangeAction changeAction);
	
	/**
	 * Returns change action.
	 * 
	 * @return change action
	 */
	LocationTermChangeAction getChangeAction();
	
	/**
	 * Compares {@code this} and {@code obj} for equality.
	 * 
	 * <p>Any mandatory property may be used in the comparison. If a  mandatory
	 * property of {@code this} that is used in the comparison is {@code null}
	 * an {@code IllegalStateException} will be thrown.
	 * 
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
	 * 
	 * <p>Any mandatory property of {@code this} may be used in the hash code.
	 * If a mandatory property that is used in the hash code is {@code null} an
	 * {@code IllegalStateException} will be thrown.
	 * 
	 * @return hash code
	 * @throws IllegalStateException if a mandatory property of {@code this}
	 * that is used in the hash code is {@code null}
	 */
	@Override
	int hashCode();
	
	/**
	 * Returns string representation of {@code this} including location term
	 * and change action.
	 * 
	 * @return string representation of {@code this} including location term
	 * and change action
	 */
	@Override
	String toString();
}