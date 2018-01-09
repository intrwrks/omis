package omis.incident.domain;

import java.io.Serializable;

import omis.person.domain.Person;

/**
 * Jurisdiction association.
 *  
 * @author Joel Norris
 * @version 0.1.0 (Nov 9, 2015)
 * @since OMIS 3.0
 */
public interface JurisdictionAssociation extends Serializable {

	/**
	 * Returns the id.
	 * 
	 * @return id
	 */
	Long getId();
	
	/**
	 * Sets the id.
	 * 
	 * @param id id
	 */
	void setId(Long id);
	
	/**
	 * Returns the jurisdiction.
	 * 
	 * @return jurisdiction
	 */
	Jurisdiction getJurisdiction();
	
	/**
	 * Sets the jurisdiction.
	 * 
	 * @param jurisdiction jurisdiction.
	 */
	void setJurisdiction(Jurisdiction jurisdiction);
	
	/**
	 * Returns the person.
	 * 
	 * @return person
	 */
	Person getPerson();
	
	/**
	 * Sets the person.
	 * 
	 * @param person person
	 */
	void setPerson(Person person);
	
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