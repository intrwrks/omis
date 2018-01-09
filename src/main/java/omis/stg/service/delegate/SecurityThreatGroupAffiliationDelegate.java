package omis.stg.service.delegate;

import java.util.Date;
import java.util.List;

import omis.audit.AuditComponentRetriever;
import omis.audit.domain.CreationSignature;
import omis.audit.domain.UpdateSignature;
import omis.audit.domain.VerificationSignature;
import omis.datatype.DateRange;
import omis.exception.DuplicateEntityFoundException;
import omis.instance.factory.InstanceFactory;
import omis.offender.domain.Offender;
import omis.region.domain.City;
import omis.region.domain.State;
import omis.stg.dao.SecurityThreatGroupAffiliationDao;
import omis.stg.domain.SecurityThreatGroup;
import omis.stg.domain.SecurityThreatGroupActivityLevel;
import omis.stg.domain.SecurityThreatGroupAffiliation;
import omis.stg.domain.SecurityThreatGroupChapter;
import omis.stg.domain.SecurityThreatGroupRank;

/**
 * Delegate for security threat group affiliations.
 * 
 * @author Josh Divine
 * @version 0.1.0 (Dec 07, 2016)
 * @since OMIS 3.0
 */
public class SecurityThreatGroupAffiliationDelegate {

	private final InstanceFactory<SecurityThreatGroupAffiliation>
	securityThreatGroupAffiliationInstanceFactory;
	
	private final SecurityThreatGroupAffiliationDao
		securityThreatGroupAffiliationDao;
	
	private final AuditComponentRetriever auditComponentRetriever;
	
	/**
	 * Instantiates an implementation of service for security threat group
	 * affiliations.
	 * @param securityThreatGroupAffiliationInstanceFactory
	 * @param securityThreatGroupAffiliationDao data access object for
	 * security threat group affiliations
	 * @param auditComponentRetriever audit component retriever
	 */
	public SecurityThreatGroupAffiliationDelegate(
			final InstanceFactory<SecurityThreatGroupAffiliation>
				securityThreatGroupAffiliationInstanceFactory,
			final SecurityThreatGroupAffiliationDao
				securityThreatGroupAffiliationDao,
			final AuditComponentRetriever auditComponentRetriever) {
		this.securityThreatGroupAffiliationInstanceFactory
			= securityThreatGroupAffiliationInstanceFactory;
		this.securityThreatGroupAffiliationDao
			= securityThreatGroupAffiliationDao;
		this.auditComponentRetriever = auditComponentRetriever;
	}
	
	/**
	 * Returns security threat group affiliations for offender.
	 * 
	 * @param offender offender
	 * @return security threat group affiliations for offender
	 */
	public List<SecurityThreatGroupAffiliation> findByOffender(
			final Offender offender) {
		return this.securityThreatGroupAffiliationDao.findByOffender(offender);
	}

	/**
	 * Creates a security threat group affiliation.
	 * 
	 * @param offender offender
	 * @param dateRange date range
	 * @param group group
	 * @param activityLevel activity level
	 * @param chapter chapter
	 * @param rank rank
	 * @param state State
	 * @param city city
	 * @param moniker moniker
	 * @param comment comment
	 * @param verificationSignature verification signature
	 * @return security threat group affiliation
	 * @throws DuplicateEntityFoundException if the affiliation exists
	 */
	public SecurityThreatGroupAffiliation create(
			final Offender offender, final DateRange dateRange,
			final SecurityThreatGroup group,
			final SecurityThreatGroupActivityLevel activityLevel,
			final SecurityThreatGroupChapter chapter,
			final SecurityThreatGroupRank rank,
			final State state, final City city, final String moniker,
			final String comment,
			final VerificationSignature verificationSignature)
			throws DuplicateEntityFoundException {
		Date startDate;
		Date endDate;
		if (dateRange != null) {
			startDate = dateRange.getStartDate();
			endDate = dateRange.getEndDate();
		} else {
			startDate = null;
			endDate = null;
		}
		if (this.securityThreatGroupAffiliationDao.find(
				offender, group, startDate, endDate) != null) {
			throw new DuplicateEntityFoundException("Affiliation exists");
		}
		SecurityThreatGroupAffiliation affiliation
			= this.securityThreatGroupAffiliationInstanceFactory
				.createInstance();
		affiliation.setOffender(offender);
		affiliation.setCreationSignature(new CreationSignature(
				this.auditComponentRetriever.retrieveUserAccount(),
				this.auditComponentRetriever.retrieveDate()));
		affiliation.setUpdateSignature(new UpdateSignature(
				this.auditComponentRetriever.retrieveUserAccount(),
				this.auditComponentRetriever.retrieveDate()));
		affiliation.setDateRange(dateRange);
		affiliation.setGroup(group);
		affiliation.setActivityLevel(activityLevel);
		affiliation.setChapter(chapter);
		affiliation.setRank(rank);
		affiliation.setState(state);
		affiliation.setCity(city);
		affiliation.setMoniker(moniker);
		affiliation.setComment(comment);
		affiliation.setVerificationSignature(verificationSignature);
		return this.securityThreatGroupAffiliationDao
				.makePersistent(affiliation);
	}

	/**
	 * Updates a security threat group affiliation.
	 * 
	 * @param affiliation affiliation
	 * @param dateRange date range
	 * @param group group
	 * @param activityLevel activity lever
	 * @param chapter chapter
	 * @param rank rank
	 * @param state State
	 * @param city city
	 * @param moniker moniker
	 * @param comment comment
	 * @param verificationSignature verification signature
	 * @return security threat group affiliation
	 * @throws DuplicateEntityFoundException if the affiliation exists
	 */
	public SecurityThreatGroupAffiliation update(
			final SecurityThreatGroupAffiliation affiliation,
			final DateRange dateRange, final SecurityThreatGroup group,
			final SecurityThreatGroupActivityLevel activityLevel,
			final SecurityThreatGroupChapter chapter,
			final SecurityThreatGroupRank rank,
			final State state, final City city, final String moniker,
			final String comment,
			final VerificationSignature verificationSignature)
			throws DuplicateEntityFoundException {
		Date startDate;
		Date endDate;
		if (dateRange != null) {
			startDate = dateRange.getStartDate();
			endDate = dateRange.getEndDate();
		} else {
			startDate = null;
			endDate = null;
		}
		if (this.securityThreatGroupAffiliationDao.findExcluding(
				affiliation.getOffender(), group, startDate, endDate,
				affiliation) != null) {
			throw new DuplicateEntityFoundException("Affiliation exists");
		}
		affiliation.setUpdateSignature(new UpdateSignature(
				this.auditComponentRetriever.retrieveUserAccount(),
				this.auditComponentRetriever.retrieveDate()));
		affiliation.setDateRange(dateRange);
		affiliation.setGroup(group);
		affiliation.setActivityLevel(activityLevel);
		affiliation.setChapter(chapter);
		affiliation.setRank(rank);
		affiliation.setState(state);
		affiliation.setCity(city);
		affiliation.setMoniker(moniker);
		affiliation.setComment(comment);
		affiliation.setVerificationSignature(verificationSignature);
		return this.securityThreatGroupAffiliationDao
				.makePersistent(affiliation);
	}

	/**
	 * Removes a security threat group affiliation.
	 * 
	 * @param affiliation security threat group affiliation to remove
	 */
	public void remove(final SecurityThreatGroupAffiliation affiliation) {
		this.securityThreatGroupAffiliationDao.makeTransient(affiliation);
	}
}