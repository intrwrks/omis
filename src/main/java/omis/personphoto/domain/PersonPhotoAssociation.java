package omis.personphoto.domain;

import omis.audit.domain.Creatable;
import omis.audit.domain.Updatable;
import omis.media.domain.Photo;
import omis.person.domain.Person;

/**
 * Person photo association.
 * 
 * @author Stephen Abson
 * @version 0.1.0 (Feb 8, 2013)
 * @since OMIS 3.0
 */
public interface PersonPhotoAssociation
		extends Creatable, Updatable {
	
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
	 * Sets the person.
	 * 
	 * @param person person
	 */
	void setPerson(Person person);
	
	/**
	 * Returns the person.
	 * 
	 * @return person
	 */
	Person getPerson();
	
	/**
	 * Sets the photo.
	 * 
	 * @param photo photo
	 */
	void setPhoto(Photo photo);
	
	/**
	 * Returns the photo.
	 * 
	 * @return photo
	 */
	Photo getPhoto();

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