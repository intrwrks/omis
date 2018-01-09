package omis.specialneed.domain;

import omis.audit.domain.Creatable;
import omis.audit.domain.Updatable;

/**
 * Special need associable document category.
 *
 * @author Josh Divine
 * @version 0.1.0 (Nov 1, 2017)
 * @since OMIS 3.0
 */
public interface SpecialNeedAssociableDocumentCategory 
	extends Creatable, Updatable {
	
	/**
	 * Sets the ID of the special need associable document category.
	 *
	 * @param id ID
	 */
	void setId(Long id);
	
	/**
	 * Return the ID of the special need associable document category.
	 *
	 * @return ID
	 */
	Long getId();
	
	/**
	 * Sets the name of the special need associable document category.
	 *
	 * @param name name
	 */
	void setName(String name);
	
	/**
	 * Return the name of the special need associable document category.
	 *
	 * @return name
	 */
	String getName();
	
	/**
	 * Sets whether the special need associable document category is valid.
	 *
	 * @param date date
	 */
	void setValid(Boolean valid);
	
	/**
	 * Returns whether the special need associable document category is valid.
	 *
	 * @return valid
	 */
	Boolean getValid();
	
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