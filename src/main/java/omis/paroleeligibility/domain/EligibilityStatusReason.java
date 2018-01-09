package omis.paroleeligibility.domain;

import java.io.Serializable;

/**
 * Eligibility status reason
 *
 * @author Trevor Isles
 * @version 0.1.0 (Nov 3, 2017)
 * @since OMIS 3.0
 */
public interface EligibilityStatusReason extends Serializable {
	
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
	 * Returns the name of the eligibility status reason.
	 * 
	 * @return
	 */
	String getName();
	
	/**
	 * Sets the name of the eligibility status reason.
	 * 
	 * @param name
	 */
	void setName(String name);

	/**
	 * Returns whether the eligibility status reason is valid or not.
	 * @return
	 */
	Boolean getValid();
	
	/**
	 * Sets whether the eligibility status reason is valid or not.
	 * @param valid
	 */
	void setValid(Boolean valid);
	
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
