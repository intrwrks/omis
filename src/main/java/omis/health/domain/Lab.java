package omis.health.domain;

import java.io.Serializable;

import omis.location.domain.Location;

/**
 * Lab.
 * 
 * @author Joel Norris
 * @version 0.1.0 (Apr 1, 2014)
 * @since OMIS 3.0
 */
public interface Lab extends Serializable {

	/**
	 * Returns the ID of the lab.
	 * 
	 * @return id
	 */
	Long getId();
	
	/**
	 * Sets the ID of the lab.
	 * 
	 * @param id id
	 */
	void setId(Long id);
	
	/**
	 * Returns the name of the lab.
	 * 
	 * @return name
	 */
	String getName();
	
	/**
	 * Sets the name of the lab.
	 * 
	 * @param name name
	 */
	void setName(String name);
	
	/**
	 * Returns the location of the lab.
	 * 
	 * @return location
	 */
	Location getLocation();
	
	/**
	 * Sets the location of the lab.
	 * 
	 * @param location location
	 */
	void setLocation(Location location);
	
	/**
	 * Returns the valid value.
	 * 
	 * @return valid
	 */
	Boolean getValid();
	
	/**
	 * Sets the valid value.
	 * 
	 * @param valid valid
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