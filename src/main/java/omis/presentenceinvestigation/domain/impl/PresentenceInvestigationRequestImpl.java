package omis.presentenceinvestigation.domain.impl;

import java.util.Date;


import omis.audit.domain.CreationSignature;
import omis.audit.domain.UpdateSignature;
import omis.docket.domain.Docket;
import omis.presentenceinvestigation.domain.PresentenceInvestigationCategory;
import omis.presentenceinvestigation.domain.PresentenceInvestigationRequest;
import omis.user.domain.UserAccount;

/** Implementation of the presentence investigation request.
 * @author Ryan Johns
 * @author Joel Norris
 * @author Annie Jacques
 * @version 0.1.2 (Jun 23, 2017)
 * since OMIS 3.0 */
public class PresentenceInvestigationRequestImpl 
	implements PresentenceInvestigationRequest {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date requestDate;
	private Date expectedCompletionDate;
	private Date sentenceDate;
	private UserAccount assignedUser;
	private Docket docket;
	private Date completionDate;
	private PresentenceInvestigationCategory category;
	private UpdateSignature updateSignature;
	private CreationSignature creationSignature;

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
	public void setUpdateSignature(
			final UpdateSignature updateSignature) {
		this.updateSignature = updateSignature;
		
	}

	/** {@inheritDoc} */
	@Override
	public UpdateSignature getUpdateSignature() {
		return this.updateSignature;
	}

	
	/** {@inheritDoc} */
	@Override
	public Long getId() {
		return this.id;
	}

	/** {@inheritDoc} */
	@Override
	public Date getRequestDate() {
		return this.requestDate;
	}

	/** {@inheritDoc} */
	@Override
	public Date getExpectedCompletionDate() {
		return this.expectedCompletionDate;
	}

	/** {@inhertiDoc} */
	@Override
	public Date getCompletionDate() {
		return this.completionDate;
	}

	/** {@inheritDoc} */
	@Override
	public UserAccount getAssignedUser() {
		return this.assignedUser;
	}

	/** {@inheritDoc} */
	@Override
	public Docket getDocket() {
		return this.docket;
	}

	/** {@inheritDoc} */
	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	/** {@inheritDoc} */
	@Override
	public void setRequestDate(final Date requestDate) {
		this.requestDate = requestDate;
	}

	/** {@inheritDoc} */
	@Override
	public void setCompletionDate(final Date completionDate) {
		this.completionDate = completionDate;
	}

	/** {@inheritDoc} */
	@Override
	public void setExpectedCompletionDate(final Date expectedCompletionDate) {
		this.expectedCompletionDate = expectedCompletionDate;
	}

	/** {@inheritDoc} */
	@Override
	public void setAssignedUser(final UserAccount assignedUser) {
		this.assignedUser = assignedUser;
	}

	/** {@inheritDoc} */
	@Override
	public void setDocket(final Docket docket) {
		this.docket = docket;
	}
	
	/**{@inheritDoc} */
	@Override
	public Date getSentenceDate() {
		return this.sentenceDate;
	}
	
	/**{@inheritDoc} */
	@Override
	public void setSentenceDate(final Date sentenceDate) {
		this.sentenceDate = sentenceDate;
	}
	
	/**{@inheritDoc} */
	@Override
	public PresentenceInvestigationCategory getCategory() {
		return this.category;
	}
	
	/**{@inheritDoc} */
	@Override
	public void setCategory(PresentenceInvestigationCategory category) {
		this.category = category;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		boolean result = false;
		
		if (this == obj) {
			result = true;
		} else {
			if (obj instanceof PresentenceInvestigationRequest) {
				this.checkState();
				PresentenceInvestigationRequest that 
					= (PresentenceInvestigationRequest) obj;
				if (this.getDocket().equals(that.getDocket())) {
					result = true;
				}
			}
		}
		
		return result;
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		this.checkState();
		int hashCode = 14;
		
		hashCode = 29 * hashCode + this.getDocket().hashCode();
		
		return hashCode;
	}
	
	/* Checks state. */
	private void checkState() {
		if (this.getDocket() == null) {
			throw new IllegalStateException("Docket Required.");
		}
		if (this.getRequestDate() == null) {
			throw new IllegalStateException("Request Date Required.");
		}
		if (this.getExpectedCompletionDate() == null) {
			throw new IllegalStateException("Expected Completion Date Required.");
		}
		if (this.getAssignedUser() == null) {
			throw new IllegalStateException("Assigned User Required.");
		}
		if (this.getCategory() == null) {
			throw new IllegalStateException("Category Required.");
		}
	}
}
