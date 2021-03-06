package omis.incident.domain.impl;

import omis.incident.domain.IncidentStatementCategory;

/**
 * Incident statement category implementation.
 * 
 * @author Joel Norris
 * @version 0.1.0 (Sept 9, 2016)
 * @since OMIS 3.0
 */
public class IncidentStatementCategoryImpl
	implements IncidentStatementCategory {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private Boolean valid;
	
	private Short sortOrder;
	
	/**
	 * Instantiates a default instance of incident statement category.
	 */
	public IncidentStatementCategoryImpl() {
		//Default constructor.
	}

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

	/** {@inheritDoc} */
	@Override
	public Short getSortOrder() {
		return this.sortOrder;
	}

	/** {@inheritDoc} */
	@Override
	public void setSortOrder(final Short sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}	
		if (!(o instanceof IncidentStatementCategory)) {
			return false;
		}
		
		IncidentStatementCategory that = (IncidentStatementCategory) o;
		
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