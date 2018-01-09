/**
 * 
 */
package omis.classification.domain;

import omis.audit.domain.Creatable;
import omis.audit.domain.Updatable;
import omis.datatype.DateRange;
import omis.offender.domain.OffenderAssociable;

/**
 * Classification Summary.
 * 
 * @author Joel Norris (Feb, 07 2013)
 * @version 0.1.0
 * @since OMIS 3.0
 */
public interface ClassificationSummary 
	extends Creatable, Updatable, OffenderAssociable {

	/**
	 * Returns the id of the classification summary.
	 * 
	 * @return the id
	 */
	Long getId();

	/**
	 * sets the id of the classification summary.
	 * 
	 * @param id the id to set
	 */
	void setId(Long id);

	/**
	 * Returns the total score of the classification summary.
	 * 
	 * @return the totalScore
	 */
	Integer getTotalScore();

	/**
	 * Sets the total score of the classification summary.
	 * 
	 * @param totalScore the totalScore to set
	 */
	void setTotalScore(Integer totalScore);

	/**
	 * Returns the custody level of the classification summary.
	 * 
	 * @return the custodyLevel
	 */
	Integer getCustodyLevel();

	/**
	 * Sets the classification level of the classification summary.
	 * 
	 * @param custodyLevel the custodyLevel to set
	 */
	void setCustodyLevel(Integer custodyLevel);

	/**
	 * Returns the classification period of the classification summary.
	 * 
	 * @return the classificationPeriod
	 */
	DateRange getClassificationPeriod();

	/**
	 * Sets the classification period of the classification summary.
	 * 
	 * @param classificationPeriod the classificationPeriod to set
	 */
	void setClassificationPeriod(DateRange classificationPeriod);

	/**
	 * Returns the override status of the classification summary.
	 * 
	 * @return the overRide
	 */
	Boolean getOverride();

	/**
	 * Sets the override status of the classification summary.
	 * 
	 * @param override the overRide to set
	 */
	void setOverride(Boolean override);

	/**
	 * Returns the comment of the classification summary.
	 * 
	 * @return the comment
	 */
	String getComment();

	/**
	 * Sets the comment of the classification summary.
	 * 
	 * @param comment the comment to set
	 */
	void setComment(String comment);
	
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