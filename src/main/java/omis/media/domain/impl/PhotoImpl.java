package omis.media.domain.impl;

import java.util.Date;

import omis.audit.domain.CreationSignature;
import omis.audit.domain.UpdateSignature;
import omis.media.domain.Photo;

/**
 * Implementation of photo.
 * 
 * @author Stephen Abson
 * @version 0.1.0 (Feb 8, 2013)
 * @since OMIS 3.0
 */
public class PhotoImpl implements Photo {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String filename;

	private Long date;
	
	private CreationSignature creationSignature;

	private UpdateSignature updateSignature;
	
	/** Instantiates a default photo. */
	public PhotoImpl() {
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
	public void setFilename(final String filename) {
		this.filename = filename;
	}

	/** {@inheritDoc} */
	@Override
	public String getFilename() {
		return this.filename;
	}
	
	/** {@inheritDoc} */
	@Override
	public void setDate(final Date date) {
		if (date != null) {
			this.date = date.getTime();
		} else {
			this.date = null;
		}
	}

	/** {@inheritDoc} */
	@Override
	public Date getDate() {
		if (this.date != null) {
			return new Date(this.date);
		} else {
			return null;
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public void setCreationSignature(
			final CreationSignature creationSignature) {
		this.creationSignature = creationSignature;
	}

	/** {@inheritDoc} */
	@Override
	public CreationSignature getCreationSignature() {
		return this.creationSignature;
	}

	/** {@inheritDoc} */
	@Override
	public void setUpdateSignature(final UpdateSignature updateSignature) {
		this.updateSignature = updateSignature;
	}

	/** {@inheritDoc} */
	@Override
	public UpdateSignature getUpdateSignature() {
		return this.updateSignature;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Photo)) {
			return false;
		}
		if (this.getFilename() == null) {
			throw new IllegalStateException("Filename required");
		}
		Photo that = (Photo) obj;
		return this.getFilename().equals(that.getFilename());
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		if (this.getFilename() == null) {
			throw new IllegalStateException("Filename required");
		}
		int hashCode = 14;
		hashCode = 29 * hashCode + this.getFilename().hashCode();
		return hashCode;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return String.format("#%d - %s", this.getId(), this.getFilename());
	}
}