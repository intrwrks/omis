package omis.health.domain;

import java.io.Serializable;

/**
 * Provider specialty association.
 * 
 * @author Sheronda Vaugn
 * @version 0.1.0 (Apr 25, 2014)
 * @since OMIS 3.0
 */
public interface ProviderSpecialtyAssociation extends Serializable {
	
	/**
	 * Returns the ID.
	 * 
	 * @return id
	 */
	Long getId();
	
	/**
	 * Sets the ID.
	 * 
	 * @param id id
	 */
	void setId(Long id);
	
	/**
	 * 
	 * Returns the provider assignment.
	 * 
	 * @return provider assignment
	 */
	ProviderAssignment getProviderAssignment();
	
	/** 
	 * Set the provider assignment.
	 * 
	 * @param providerAssignment provider assignment
	 */
	void setProviderAssignment(ProviderAssignment providerAssignment);
	
	/**
	 * Returns the specialty.
	 * 
	 * @return provider specialty
	 */
	ProviderSpecialty getSpecialty();
	
	/**
	 * Set the specialty.
	 * 
	 * @param specialty provider specialty
	 */
	void setSpecialty(ProviderSpecialty specialty);

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
