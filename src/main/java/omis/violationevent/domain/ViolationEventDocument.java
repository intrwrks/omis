package omis.violationevent.domain;

import omis.audit.domain.Creatable;
import omis.audit.domain.Updatable;
import omis.document.domain.Document;

/**
 * ViolationEventDocument.java
 * 
 *@author Annie Jacques 
 *@version 0.1.0 (Jan 17, 2017)
 *@since OMIS 3.0
 *
 */
public interface ViolationEventDocument extends Creatable, Updatable{
	
	/**
	 * Returns the ID of the ViolationEventDocument
	 * @return ID
	 */
	public Long getId();
	
	/**
	 * Sets the ID of the ViolationEventDocument
	 * @param id - Long
	 */
	public void setId(Long id);
	
	/**
	 * Returns the document of the ViolationEventDocument
	 * @return document - document
	 */
	public Document getDocument();
	
	/**
	 * Sets the document of the ViolationEventDocument
	 * @param document - document
	 */
	public void setDocument(Document document);
	
	/**
	 * Returns the ViolationEvent for the ViolationEventDocument
	 * @return ViolationEvent - ViolationEvent
	 */
	public ViolationEvent getViolationEvent();
	
	/**
	 * Sets the ViolationEvent for the ViolationEventDocument
	 * @param ViolationEvent - ViolationEvent
	 */
	public void setViolationEvent(ViolationEvent violationEvent);
	
	/** Compares {@code this} and {@code obj} for equality.
	 * <p>
	 * Any mandatory property may be used in the comparison. If a  mandatory
	 * property of {@code this} that is used in the comparison is {@code null}
	 * an {@code IllegalStateException} will be thrown.
	 * @param obj reference object with which to compare {@code this}
	 * @return {@code true} if {@code this} and {@code obj} are equal;
	 * {@code false} otherwise
	 * @throws IllegalStateException if a mandatory property of {@code this}
	 * that is used in the comparison is {@code null} */
	@Override
	boolean equals(Object obj);
	
	/** Returns a hash code for {@code this}.
	 * <p>
	 * Any mandatory property of {@code this} may be used in the hash code. If
	 * a mandatory property that is used in the hash code is {@code null} an
	 * {@code IllegalStateException} will be thrown.
	 * @return hash code
	 * @throws IllegalStateException if a mandatory property of {@code this}
	 * that is used in the hash code is {@code null} */
	@Override
	int hashCode();
}
