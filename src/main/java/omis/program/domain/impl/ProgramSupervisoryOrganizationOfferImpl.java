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
package omis.program.domain.impl;

import omis.program.domain.Program;
import omis.program.domain.ProgramSupervisoryOrganizationOffer;
import omis.supervision.domain.SupervisoryOrganization;

/**
 * Implementation offering program at supervisory organization.
 *
 * @author Stephen Abson
 * @version 0.0.1 (Apr 12, 2016)
 * @since OMIS 3.0
 */
public class ProgramSupervisoryOrganizationOfferImpl
		implements ProgramSupervisoryOrganizationOffer {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Program program;

	private SupervisoryOrganization supervisoryOrganization;
	
	/**
	 * Instantiation of default implementation offering program at supervisory
	 * organization.
	 */
	public ProgramSupervisoryOrganizationOfferImpl() {
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
	public void setProgram(final Program program) {
		this.program = program;
	}

	/** {@inheritDoc} */
	@Override
	public Program getProgram() {
		return this.program;
	}

	/** {@inheritDoc} */
	@Override
	public void setSupervisoryOrganization(
			final SupervisoryOrganization supervisoryOrganization) {
		this.supervisoryOrganization = supervisoryOrganization;
	}

	/** {@inheritDoc} */
	@Override
	public SupervisoryOrganization getSupervisoryOrganization() {
		return this.supervisoryOrganization;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof ProgramSupervisoryOrganizationOffer)) {
			return false;
		}
		ProgramSupervisoryOrganizationOffer that
			= (ProgramSupervisoryOrganizationOffer) obj;
		if (this.getProgram() == null) {
			throw new IllegalStateException("Program required");
		}
		if (!this.getProgram().equals(that.getProgram())) {
			return false;
		}
		if (this.getSupervisoryOrganization() == null) {
			throw new IllegalStateException(
					"Supervisory organization required");
		}
		if (!this.getSupervisoryOrganization()
				.equals(that.getSupervisoryOrganization())) {
			return false;
		}
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		if (this.getProgram() == null) {
			throw new IllegalStateException("Program required");
		}
		if (this.getSupervisoryOrganization() == null) {
			throw new IllegalStateException(
					"Supervisory organization required");
		}
		int hashCode = 14;
		hashCode = 29 * hashCode + this.getProgram().hashCode();
		hashCode = 29 * hashCode + this.getSupervisoryOrganization()
				.hashCode();
		return hashCode;
	}
}