package omis.custody.report.impl.hibernate;

import java.util.Date;

import org.hibernate.SessionFactory;

import omis.custody.report.CustodyReviewSummaryItemService;
import omis.custody.report.CustodySummary;
import omis.offender.domain.Offender;

/**
 * 
 *
 * @author Sheronda Vaughn
 * @version 0.1.0 (Jun 8, 2017)
 * @since OMIS 3.0
 */
public class CustodyReviewSummaryItemServiceHibernateImpl 
				implements CustodyReviewSummaryItemService {

	private static final String FIND_CUSTODY_REVIEW_BY_OFFENDER_AND_DATE_QUERY 
					= "findCustodyReviewByOffenderAndDate";
	
	private final SessionFactory sessionFactory;
	
	/* Parameters.*/ 
	private static final String OFFENDER_PARAMETER_NAME = "offender";
	
	private static final String EFFECTIVE_PARAMETER_NAME = "effectiveDate";
	
	/** Instantiates an implementation of CustodyReviewSummaryItemServiceHibernateImpl */
	public CustodyReviewSummaryItemServiceHibernateImpl(
			final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** {@inheritDoc} */
	@Override
	public CustodySummary findCustodyReviewSummaryByOffenderAndDate(
			final Offender offender, final Date effectiveDate) {
		CustodySummary summary = (CustodySummary) this.sessionFactory
				.getCurrentSession()
				.getNamedQuery(FIND_CUSTODY_REVIEW_BY_OFFENDER_AND_DATE_QUERY)
				.setParameter(OFFENDER_PARAMETER_NAME, offender)
				.setTimestamp(EFFECTIVE_PARAMETER_NAME, effectiveDate)
				.setMaxResults(1).uniqueResult();
		return summary;
	}
}