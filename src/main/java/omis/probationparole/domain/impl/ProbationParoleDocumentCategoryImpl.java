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
package omis.probationparole.domain.impl;

import omis.probationparole.domain.ProbationParoleDocumentCategory;

/**
 * Probation Parole Document Categlory Implementation.
 * 
 *@author Annie Wahl 
 *@version 0.1.0 (Dec 6, 2018)
 *@since OMIS 3.0
 *
 */
public class ProbationParoleDocumentCategoryImpl
		implements ProbationParoleDocumentCategory {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private Boolean valid;

	/** {@inheritDoc} */
	@Override
	public Long getId() {
		return this.id;
	}

	/** {@inheritDoc} */
	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return this.name;
	}

	/** {@inheritDoc} */
	@Override
	public void setName(final String name) {
		this.name = name;
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getValid() {
		return this.valid;
	}

	/** {@inheritDoc} */
	@Override
	public void setValid(final Boolean valid) {
		this.valid = valid;
	}
	
	/**{@inheritDoc}*/
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ProbationParoleDocumentCategory)) {
			return false;
		}
		
		ProbationParoleDocumentCategory that =
				(ProbationParoleDocumentCategory) obj;
		
		if (this.getName() == null) {
			throw new IllegalStateException("Name required.");
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
			throw new IllegalStateException("Name required.");
		}
		
		int hashCode = 14;
		hashCode = 29 * hashCode + this.getName().hashCode();
		
		return hashCode;
	}
}
