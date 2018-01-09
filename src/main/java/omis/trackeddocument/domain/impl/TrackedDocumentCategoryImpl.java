package omis.trackeddocument.domain.impl;

import omis.trackeddocument.domain.TrackedDocumentCategory;

/** Implementation of tracked document category.
 * @author Yidong Li
 * @version 0.1.0 (Dec 11, 2017)
 * @since OMIS 3.0 */
public class TrackedDocumentCategoryImpl implements TrackedDocumentCategory {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Boolean valid;
	
	/** Constructor. */
	public TrackedDocumentCategoryImpl() {
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
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TrackedDocumentCategory)) {
			return false;
		}
		TrackedDocumentCategory that = (TrackedDocumentCategory) obj;
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
		final int number = 7;
		int hashCode = number;
		
		if (this.getName() == null) {
			throw new IllegalStateException("Name required");
		}
		hashCode += 29 * this.getName().hashCode();
		return hashCode;
	}
}
