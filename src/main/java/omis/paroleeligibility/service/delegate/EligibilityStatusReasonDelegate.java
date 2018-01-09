package omis.paroleeligibility.service.delegate;

import java.util.List;

import omis.exception.DuplicateEntityFoundException;
import omis.instance.factory.InstanceFactory;
import omis.paroleeligibility.dao.EligibilityStatusReasonDao;
import omis.paroleeligibility.domain.EligibilityStatusReason;

/**
 * Delegate for the eligibility status reason.
 *
 * @author Trevor Isles
 * @version 0.1.0 (Nov 9, 2017)
 * @since OMIS 3.0
 */
public class EligibilityStatusReasonDelegate {
	
	/* Instance factories. */
	
	private final InstanceFactory<EligibilityStatusReason> 
		eligibilityStatusReasonInstanceFactory;
	
	/* DAOs. */
	
	private final EligibilityStatusReasonDao eligibilityStatusReasonDao;
	
	/* Constructor. */
	
	public EligibilityStatusReasonDelegate(
			final InstanceFactory<EligibilityStatusReason> 
				eligibilityStatusReasonInstanceFactory,
			final EligibilityStatusReasonDao eligibilityStatusReasonDao) {
		this.eligibilityStatusReasonInstanceFactory 
			= eligibilityStatusReasonInstanceFactory;
		this.eligibilityStatusReasonDao = eligibilityStatusReasonDao;
	}
	
	/**
	 * Creates a new eligibility status reason
	 * 
	 * @param name eligibility status reason name
	 * @param valid whether an eligibility status reason is valid
	 * @return eligibility status reason
	 * @throws DuplicateEntityFoundException
	 */
	public EligibilityStatusReason create(
			final String name, 
			final Boolean valid)
		throws DuplicateEntityFoundException {
		if (this.eligibilityStatusReasonDao.findEligibilityStatusReason(
				name) != null) {
			throw new DuplicateEntityFoundException(
					"Duplicate eligibility status reason found.");
		}
		
		EligibilityStatusReason statusReason = 
				this.eligibilityStatusReasonInstanceFactory.createInstance();
				this.populateEligibilityStatusReason(statusReason, name, valid);
		return this.eligibilityStatusReasonDao.makePersistent(statusReason);
	}
	
	/**
	 * Updates an eligibility status reason
	 * 
	 * @param eligibilityStatusReason eligibility status reason
	 * @param name name of the eligibility status reason
	 * @param valid whether an eligibility status reason is valid
	 * @return updated eligibilty status reason
	 * @throws DuplicateEntityFoundException
	 */
	public EligibilityStatusReason update(
			final EligibilityStatusReason eligibilityStatusReason,
			final String name,
			final Boolean valid)
		throws DuplicateEntityFoundException {
		if (this.eligibilityStatusReasonDao
				.findEligibilityStatusReasonExcluding(eligibilityStatusReason, 
						name) != null) {
			throw new DuplicateEntityFoundException(
					"Duplicate eligibility status reason found.");
		}
		this.populateEligibilityStatusReason(
				eligibilityStatusReason, name, valid);
		return this.eligibilityStatusReasonDao.makePersistent(
				eligibilityStatusReason);
	}
	
	/**
	 * Removes an eligibility status reason
	 * 
	 * @param eligibilityStatusReason
	 */
	public void remove(final EligibilityStatusReason eligibilityStatusReason) {
		this.eligibilityStatusReasonDao.makeTransient(eligibilityStatusReason);
	}
	
	/**
	 * Returns eligibility status reasons
	 * 
	 * @param eligibilityStatusReason
	 * @return eligibility status reasons
	 */
	public List<EligibilityStatusReason> findEligibilityStatusReasons() {
		return this.eligibilityStatusReasonDao
				.findEligibilityStatusReasons();
	}
	
	/**
	 * Populates the specified eligibility status reason.
	 * 
	 * @param eligibilityStatusReason
	 * @param name
	 * @param valid
	 */
	private void populateEligibilityStatusReason(
			final EligibilityStatusReason eligibilityStatusReason,
			final String name,
			final Boolean valid) {
		eligibilityStatusReason.setName(name);
		eligibilityStatusReason.setValid(valid);
	}

}
