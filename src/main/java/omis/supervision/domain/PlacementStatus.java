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
package omis.supervision.domain;

/**
 * Placement status.
 * 
 * <p>Determines whether an offender is placed, escaped, absconded or has
 * returned from an escape or absconding during the term of a placement.
 *
 * @author Stephen Abson
 * @version 0.0.1
 * @since OMIS 3.0
 */
public enum PlacementStatus {

	/** Placed. */
	PLACED,
	
	/** Escaped. */
	ESCAPED,
	
	/** Absconded. */
	ABSCONDED,
	
	/** Returns from escape. */
	RETURNED_FROM_ESCAPE,
	
	/** Returned from abscond. */
	RETURNED_FROM_ABSCOND;
	
	/**
	 * Returns {@code this.name()}.
	 * 
	 * <p>See {@link Enum#name()}.
	 * 
	 * @return {@code this.name()}
	 */
	public String getName() {
		return this.name();
	}
}