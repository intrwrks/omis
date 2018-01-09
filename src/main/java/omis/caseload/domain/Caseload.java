package omis.caseload.domain;

import omis.audit.domain.Creatable;
import omis.audit.domain.Updatable;

/**
 * Caseload.
 *
 * @author Sheronda Vaughn
 * @author Ryan Johns
 * @version 0.1.0 (May 18, 2017)
 * @since OMIS 3.0
 */
public interface Caseload extends Creatable, Updatable {
	
	
	/**
	 * Sets the ID for the caseload.
	 *
	 * @param id id
	 */
	void setId(Long id);
	
	
	/**
	 * Returns the ID for the caseload.
	 *
	 * @return ID
	 */
	Long getId();
	
	/**
	 * Sets the case work category for the caseload.
	 *
	 * @param category category
	 */
	void setCategory(CaseworkCategory category);
	
	/**
	 * Returns the case work category for the caseload.
	 *
	 * @return category
	 */
	CaseworkCategory getCategory();
	
	
	/**
	 * Sets the name for the caseload.
	 *
	 * @param name name
	 */
	void setName(String name);
	
	/**
	 * Returns the name for the caseload.
	 * @return name.
	 */
	String getName();
	
	/**
	 * Sets the case for the caseload.
	 *
	 * @param caseload caseload
	 */
	void setCaseload(Caseload caseload);
	
	/**
	 * Returns the case for the caseload.
	 *
	 * @return caseload.
	 */
	Caseload getCaseload();
	
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