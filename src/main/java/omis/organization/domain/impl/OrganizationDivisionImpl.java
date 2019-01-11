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
package omis.organization.domain.impl;

import omis.organization.domain.Organization;
import omis.organization.domain.OrganizationDivision;

/**
 * Organization division implementation.
 *
 * @author Sheronda Vaughn
 * @author Stephen Abson
 * @version 0.1.0 (Apr 14, 2016)
 * @since OMIS 3.0
 */

final public class OrganizationDivisionImpl implements OrganizationDivision {

	private static final long serialVersionUID = 1L;
	
	private Organization organization;
	
	private Long id;
	
	private String name;
	
	private Boolean active;

	/**
	 * Instantiates a default instance of organization department.
	 */
	public OrganizationDivisionImpl() {
		// Default constructor.
	}

	/** {@inheritDoc} */
	@Override
	public Long getId() {
		return this.id;
	}

	/** {@inheritDoc} */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/** {@inheritDoc} */
	@Override
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/** {@inheritDoc} */
	@Override
	public Organization getOrganization() {
		return this.organization;
	}

	/** {@inheritDoc} */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return this.name;
	}

	/** {@inheritDoc} */
	@Override
	public void setActive(Boolean active) {
		this.active = active;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getActive() {
		return this.active;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof OrganizationDivision)) {
			return false;
		}
		
		OrganizationDivision that = (OrganizationDivision) o;
		
		if (this.getOrganization() == null) {
			throw new IllegalStateException("Organization required.");
		}
		if (!this.getOrganization().equals(that.getOrganization())) {
			return false;
		}
		if (!this.getName().equals(that.getName())) {
			return false;
		}
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		if (this.getOrganization() == null) {
			throw new IllegalStateException("Organization required.");
		}
		int hashCode = 14;
		
		hashCode = 29 * hashCode + this.organization.hashCode();
		hashCode += 29 * hashCode + this.name.hashCode();
		return hashCode;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		String organizationName;
		if (this.getOrganization() != null) {
			organizationName = this.getOrganization().getName();
		} else {
			organizationName = null;
		}
		return String.format("#%d: %s - %s",
				this.getId(), organizationName, this.getName());
	}
}