package omis.offenderflag.report.impl.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import omis.offender.domain.Offender;
import omis.offenderflag.report.OffenderFlagProfileItemReportService;

/** Hibernate implementation of offender flag profile item report service.
 * @author Ryan Johns
 * @version 0.1.0 (Mar 15, 2016)
 * @since OMIS 3.0 */
public class OffenderFlagProfileItemReportServiceHibernateImpl 
	implements OffenderFlagProfileItemReportService {
	private final static String FIND_COUNT_BY_OFFENDER_QUERY_NAME 
		= "findOffenderFlagCountByOffender";
	
	private final static String OFFENDER_PARAM_NAME = "offender";
	
	private final SessionFactory sessionFactory;
	
	/** Constructor.
	 * @param sessionFactory - session factory. */
	public OffenderFlagProfileItemReportServiceHibernateImpl(
			final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** {@inheritDoc} */
	@Override
	public Integer findOffenderFlagCountByOffender(
			final Offender offender) {
		Query q = this.sessionFactory.getCurrentSession().getNamedQuery(
				FIND_COUNT_BY_OFFENDER_QUERY_NAME);
		q.setEntity(OFFENDER_PARAM_NAME, offender);
		return ((Long) q.uniqueResult()).intValue();
	}
}
