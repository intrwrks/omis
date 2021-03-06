package omis.commitstatus.domain.impl;

import omis.commitstatus.domain.CommitStatus;

/** Implementation of Commit Status.
 * @author Yidong Li
 * @version 0.1.0 (May 31, 2017)
 * @since OMIS 3.0 */
public class CommitStatusImpl implements CommitStatus {
	private Long id;
	private static final long serialVersionUID = 1L;
	private String name;
	private Boolean valid;

	/** Constructor. */
	public CommitStatusImpl() {
		
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CommitStatus)) {
			return false;
		}
		CommitStatus that = (CommitStatus) obj;
		if (this.getName() == null) {
			throw new IllegalStateException("Name required");
		}
		if (this.getValid() == null) {
			throw new IllegalStateException("Valid required");
		}
		if(this.getName().equals(that.getName())){
			return true;
		} else {
			return false;
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		int hashCode = 7;
		if (this.name == null) {
			throw new IllegalStateException("Name required");
		}
		if (this.getValid()==null) {
			throw new IllegalStateException("Valid required");
		}		
		hashCode += 29 * this.getName().hashCode();
		hashCode += 29 * this.getValid().hashCode();
		return hashCode;
	}
}
