package omis.paroleeligibility.domain;

import java.io.Serializable;
import java.util.Date;

import omis.audit.domain.CreationSignature;
import omis.audit.domain.UpdateSignature;

/**
 * Parole eligibility note
 *
 * @author Trevor Isles
 * @version 0.1.0 (Nov 3, 2017)
 * @since OMIS 3.0
 */
public interface ParoleEligibilityNote extends Serializable {
	
	/**
	 * Returns the id.
	 * 
	 * @return id
	 */
	Long getId();
	
	/**
	 * Sets the id.
	 * 
	 * @param id
	 */
	void setId(Long id);
	
	/**
	 * Returns the parole eligibility note description.
	 * 
	 * @return description
	 */
	String getDescription();
	
	/**
	 * Sets the parole eligibility note description.
	 * 
	 * @param description
	 */
	void setDescription(String description);
	
	/**
	 * Returns the parole eligibility note date.
	 * 
	 * @return date
	 */
	Date getDate();
	
	/**
	 * Sets the parole eligibility note date.
	 * 
	 * @param date
	 */
	void setDate(Date date);
	
	/**
	 * Returns parole eligibility.
	 * 
	 * @return paroleEligibility
	 */
	ParoleEligibility getParoleEligibility();
	
	/**
	 * Sets parole eligibility.
	 * 
	 * @param paroleEligibility
	 */
	void setParoleEligibility(ParoleEligibility paroleEligibility);
	
	/**
	 * Returns creationSignature.
	 * 
	 * @return creationSignature
	 */
	CreationSignature getCreationSignature();
	
	/**
	 * Sets creationSignature.
	 * 
	 * @return creationSignature
	 */
	void setCreationSignature(CreationSignature creationSignature);
	
	/**
	 * Returns updateSignature.
	 * 
	 * @return updateSignature
	 */
	UpdateSignature getUpdateSignature();
	
	/**
	 * Sets updateSignature.
	 * 
	 * @return updateSignature
	 */
	void setUpdateSignature(UpdateSignature updateSignature);
	
	/**
	 * Compares {@code this} and {@code obj} for equality.
	 * <p>
	 * Any mandatory property may be used in the comparison. If a  mandatory
	 * property of {@code this} that is used in the comparison is {@code null}
	 * an {@code IllegalStateException} will be thrown.
	 * @param obj reference object with which to compare {@code this}
	 * @return {@code true} if {@code this} and {@code obj} are equal;
	 * {@code false} otherwise
	 * @throws IllegalStateException if a mandatory property of {@code this}
	 * that is used in the comparison is {@code null} 
	 */
	@Override
	boolean equals(Object obj);
	
	/**
	 * Returns a hash code for {@code this}.
	 * <p>
	 * Any mandatory property of {@code this} may be used in the hash code. If
	 * a mandatory property that is used in the hash code is {@code null} an
	 * {@code IllegalStateException} will be thrown.
	 * @return hash code
	 * @throws IllegalStateException if a mandatory property of {@code this}
	 * that is used in the hash code is {@code null}
	 */
	@Override
	int hashCode();

}
