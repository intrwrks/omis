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
package omis.assessment.domain.impl;

import omis.assessment.domain.RatingScaleGroup;

/**
 * Implementation of rating scale group.
 * 
 * @author Josh Divine
 * @version 0.1.0 (Apr 3, 2018)
 * @since OMIS 3.0
 */
public class RatingScaleGroupImpl implements RatingScaleGroup {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String scaleName;
	
	/**
	 * Instantiates an implementation of rating scale group.
	 */
	public RatingScaleGroupImpl() {
		// Default instantiation
	}
	
	/** {@inheritDoc} */
	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	/** {@inheritDoc} */
	@Override
	public Long getId() {
		return id;
	}

	/** {@inheritDoc} */
	@Override
	public void setScaleName(final String scaleName) {
		this.scaleName = scaleName;
	}

	/** {@inheritDoc} */
	@Override
	public String getScaleName() {
		return scaleName;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RatingScaleGroup)) {
			return false;
		}
		RatingScaleGroup that = (RatingScaleGroup) obj;
		if (this.getScaleName() == null ) {
			throw new IllegalStateException("Scale name required.");
		}
		if (!this.getScaleName().equals(that.getScaleName())) {
			return false;
		}
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		if (this.getScaleName() == null ) {
			throw new IllegalStateException("Scale name required.");
		}
		int hashCode = 14;
		hashCode = 29 * hashCode + this.getScaleName().hashCode();
		return hashCode;
	}
}