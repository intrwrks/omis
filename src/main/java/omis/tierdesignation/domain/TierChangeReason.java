package omis.tierdesignation.domain;

import java.io.Serializable;

/**
 * Tier change reason.
 * 
 * @author Stephen Abson
 * @author Jason Nelson
 * @version 0.1.0 (Dec 12, 2013)
 * @since OMIS 3.0
 */
public interface TierChangeReason
		extends Serializable {

	/**
	 * Sets the ID.
	 * 
	 * @param id ID
	 */
	void setId(Long id);
	
	/**
	 * Returns the ID.
	 * 
	 * @return ID
	 */
	Long getId();
	
	/**
	 * Sets the name.
	 * 
	 * @param name name
	 */
	void setName(String name);
	
	/**
	 * Returns the name.
	 * 
	 * @return name
	 */
	String getName();
	
	/**
	 * Sets the sort order.
	 * 
	 * @param sortOrder sort order.
	 */
	void setSortOrder(Short sortOrder);
	
	/**
	 * Returns the sort order.
	 * 
	 * @return sort order
	 */
	Short getSortOrder();
	
	/**
	 * Sets whether the change reason is valid.
	 * 
	 * @param valid whether change reason is valid
	 */
	void setValid(Boolean valid);
	
	/**
	 * Returns whether the change reason is valid.
	 * 
	 * @return whether change reason is valid
	 */
	Boolean getValid();
	
	/**
	 * Compares {@code this} and {@code obj} for equality.
	 * 
	 * <p>Any mandatory property may be used in the comparison. If a  mandatory
	 * property of {@code this} that is used in the comparison is {@code null}
	 * an {@code IllegalStateException} will be thrown.
	 * 
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
	 * 
	 * <p>Any mandatory property of {@code this} may be used in the hash code.
	 * If a mandatory property that is used in the hash code is {@code null} an
	 * {@code IllegalStateException} will be thrown.
	 * 
	 * @return hash code
	 * @throws IllegalStateException if a mandatory property of {@code this}
	 * that is used in the hash code is {@code null}
	 */
	@Override
	int hashCode();
}