package omis.visitation.domain;

import java.util.Date;

import omis.audit.domain.Creatable;
import omis.audit.domain.Updatable;

/**
 * Visitation association note.
 * 
 * @author Joel Norris
 * @version: 0.1.0 (Feb 9, 2017)
 * @since OMIS 3.0
 */
public interface VisitationAssociationNote extends Updatable, Creatable {

	Long getId();
	
	void setId(Long id);
	
	String getValue();
	
	void setValue(String value);
	
	Date getDate();
	
	void setDate(Date date);
	
	VisitationAssociation getAssociation();
	
	void setAssociation(VisitationAssociation association);
	
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
	
	/**
	 * Returns a string representation for {@code this}.
	 * <p>
	 * All properties of {@code this} should be represented.
	 * 
	 * @return string representation of {@code this}
	 */
	@Override
	String toString();
}