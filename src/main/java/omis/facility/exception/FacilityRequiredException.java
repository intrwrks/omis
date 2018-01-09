package omis.facility.exception;

import omis.exception.BusinessException;

/**
 * Thrown if a facility is required.
 *
 * @author Stephen Abson
 * @version 0.0.1 (Feb 17, 2015)
 * @since OMIS 3.0
 */
public class FacilityRequiredException
		extends BusinessException {
	
	private static final long serialVersionUID = 1L;

	/** Instantiates default exception. */
	public FacilityRequiredException() {
		// Default constructor
	}

	/**
	 * Instantiates with message and cause.
	 * 
	 * @param message message
	 * @param cause cause
	 */
	public FacilityRequiredException(
			final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates with message.
	 * 
	 * @param message message
	 */
	public FacilityRequiredException(final String message) {
		super(message);
	}

	/**
	 * Instantiates with cause.
	 * 
	 * @param cause cause
	 */
	public FacilityRequiredException(final Throwable cause) {
		super(cause);
	}
}