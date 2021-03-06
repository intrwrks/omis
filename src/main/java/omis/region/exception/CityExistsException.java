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
package omis.region.exception;

import omis.exception.DuplicateEntityFoundException;
import omis.region.domain.City;

/**
 * Thrown if city exists.
 * 
 * @author Stephen Abson
 * @version 0.0.1 (Nov 15, 2017)
 * @since OMIS 3.0
 */
public class CityExistsException
		extends DuplicateEntityFoundException {
	
	private static final long serialVersionUID = 1L;
	
	private final City city;

	/** Instantiates exception thrown if city exists. */
	public CityExistsException() {
		this.city = null;
	}
	
	/**
	 * Instantiates exception thrown if city exists with message, cause and
	 * city.
	 * 
	 * @param message message
	 * @param cause cause
	 * @param city city
	 */
	public CityExistsException(
			final String message, final Throwable cause, final City city) {
		super(message, cause);
		this.city = city;
	}
	
	/**
	 * Instantiates exception thrown if city exists with message.
	 * 
	 * @param message message
	 */
	public CityExistsException(final String message) {
		super(message);
		this.city = null;
	}
	
	/**
	 * Instantiates exception thrown if city exists with cause.
	 * 
	 * @param cause cause
	 */
	public CityExistsException(final Throwable cause) {
		super(cause);
		this.city = null;
	}
	
	/**
	 * Instantiates exception thrown if city exists with city.
	 * 
	 * @param city city
	 */
	public CityExistsException(final City city) {
		this.city = city;
	}
	
	/**
	 * Returns city.
	 * 
	 * @return city
	 */
	public City getCity() {
		return this.city;
	}
}