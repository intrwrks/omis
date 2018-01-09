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
package omis.supervision.domain.impl;

import omis.supervision.domain.PlacementTermChangeReason;

/**
 * Implementation of change reason for placement terms.
 * 
 * @author Stephen Abson
 * @version 0.1.0 (Aug 1, 2013)
 * @since OMIS 3.0
 */
public class PlacementTermChangeReasonImpl
		implements PlacementTermChangeReason {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String name;

	private Short sortOrder;

	private Boolean validStartReason;

	private Boolean validEndReason;
	
	/**
	 * Instantiates a default implementation of change reason for placement
	 * terms.
	 */
	public PlacementTermChangeReasonImpl() {
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
		return this.id;
	}

	/** {@inheritDoc} */
	@Override
	public void setName(final String name) {
		this.name = name;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return this.name;
	}

	/** {@inheritDoc} */
	@Override
	public void setSortOrder(final Short sortOrder) {
		this.sortOrder = sortOrder;
	}

	/** {@inheritDoc} */
	@Override
	public Short getSortOrder() {
		return this.sortOrder;
	}

	/** {@inheritDoc} */
	@Override
	public void setValidStartReason(final Boolean validStartReason) {
		this.validStartReason = validStartReason;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getValidStartReason() {
		return this.validStartReason;
	}

	/** {@inheritDoc} */
	@Override
	public void setValidEndReason(final Boolean validEndReason) {
		this.validEndReason = validEndReason;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getValidEndReason() {
		return this.validEndReason;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof PlacementTermChangeReason)) {
			return false;
		}
		PlacementTermChangeReason that = (PlacementTermChangeReason) obj;
		if (this.getName() == null) {
			throw new IllegalStateException("Name required");
		}
		if (!this.getName().equals(that.getName())) {
			return false;
		}
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		if (this.getName() == null) {
			throw new IllegalStateException("Name required");
		}
		int hashCode = 14;
		hashCode = 29 * hashCode + this.getName().hashCode();
		return hashCode;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return this.getName();
	}
}