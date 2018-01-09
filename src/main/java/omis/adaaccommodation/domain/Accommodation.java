package omis.adaaccommodation.domain;
import omis.audit.domain.Creatable;
import omis.audit.domain.Updatable;

/**
 * Accommodation.
 *
 * @author Sheronda Vaughn
 * @version 0.1.0 (Jul 14, 2015)
 * @since OMIS 3.0
 */
public interface Accommodation 
	extends Creatable, Updatable {

	/**
	 * Sets the ID of the ADA accommodation.
	 * 
	 * @param id ID
	 */
	void setId(Long id);
	
	/**
	 * Returns the ID of the ADA accommodation.
	 * 
	 * @return ID
	 */
	Long getId();
	
	/**
	 * Sets the description of the ADA accommodation.
	 * 
	 * @param description description
	 */
	void setDescription(String description);
	
	/**
	 * Returns the description of the ADA accommodation.
	 * 
	 * @return description
	 */
	String getDescription();
	
	/**
	 * Sets the disability of the ADA accommodation.
	 * 
	 * @param disability disability
	 */
	void setDisability(Disability disability);
	
	/**
	 * Returns the disability of the ADA accommodation.
	 * 
	 * @return disability
	 */
	Disability getDisability();
	
	/**
	 * Sets the accommodation category of the ADA accommodation.
	 * 
	 * @param accommodationCategory accommodation category
	 */
	void setAccommodationCategory(AccommodationCategory accommodationCategory);
	
	/**
	 * Returns the accommodation category of the ADA accommodation.
	 * 
	 * @return accommodation category
	 */
	AccommodationCategory getAccommodationCategory();
	
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