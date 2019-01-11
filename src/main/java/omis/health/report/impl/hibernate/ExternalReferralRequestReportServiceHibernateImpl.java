/*
 * OMIS - Offender Management Information System
 * Copyright (C) 2011 - 2017 State of Montana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package omis.health.report.impl.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;

import omis.facility.domain.Facility;
import omis.health.report.ExternalReferralRequestReportService;
import omis.health.report.ExternalReferralRequestSummary;
import omis.offender.domain.Offender;

/**
 * Hibernate implementation of report service for external referral requests. 
 *
 * @author Stephen Abson
 * @author Josh Divine
 * @author Yidong Li
 * @version 0.0.2 (Oct 22, 2018)
 * @since OMIS 3.0
 */
public class ExternalReferralRequestReportServiceHibernateImpl
		implements ExternalReferralRequestReportService {

	/* Queries. */
	
	private static final String FIND_BY_FACILITY_QUERY_NAME = 
			"findExternalReferralRequestSummariesByFacility";
	
	private static final String FIND_BY_OFFENDER_QUERY_NAME = 
			"findExternalReferralRequestSummariesByOffender";
	
	private static final String COUNT_BY_FACILITY_QUERY_NAME = 
		"countExternalReferralRequestSummariesByFacility";
	
	private static final String COUNT_BY_OFFENDER_QUERY_NAME = 
		"countExternalReferralRequestSummariesByOffender";
	
	/* Parameter names. */
	
	private static final String FACILITY_PARAM_NAME = "facility";
	
	private static final String OFFENDER_PARAM_NAME = "offender";
	
	/* Resources. */
	
	private final SessionFactory sessionFactory;

	/* Constructors. */
	
	/**
	 * Hibernate implementation of report service for external referral
	 * requests.
	 * 
	 * @param sessionFactory session factory
	 */
	public ExternalReferralRequestReportServiceHibernateImpl(
			final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* Method implementations. */
	
	/** {@inheritDoc} */
	@Override
	public List<ExternalReferralRequestSummary> findByFacility(
			final Facility facility) {
		@SuppressWarnings("unchecked")
		List<ExternalReferralRequestSummary> summaries = this.sessionFactory
				.getCurrentSession()
				.getNamedQuery(FIND_BY_FACILITY_QUERY_NAME)
				.setParameter(FACILITY_PARAM_NAME, facility)
				.setReadOnly(true)
				.list();
		return summaries;
	}

	/** {@inheritDoc} */
	@Override
	public List<ExternalReferralRequestSummary> findByOffender(
			final Offender offender) {
		@SuppressWarnings("unchecked")
		List<ExternalReferralRequestSummary> summaries = this.sessionFactory
				.getCurrentSession()
				.getNamedQuery(FIND_BY_OFFENDER_QUERY_NAME)
				.setParameter(OFFENDER_PARAM_NAME, offender)
				.setReadOnly(true)
				.list();
		return summaries;
	}
	
	/** {@inheritDoc} */
	@Override
	public long countByFacility(final Facility facility) {
		long count = (long) this.sessionFactory
			.getCurrentSession()
			.getNamedQuery(COUNT_BY_FACILITY_QUERY_NAME)
			.setParameter(FACILITY_PARAM_NAME, facility)
			.setReadOnly(true)
			.uniqueResult();
		return count;
	}
	
	/** {@inheritDoc} */
	@Override
	public long countByOffender(
			final Offender offender) {
		long count = (long) this.sessionFactory
			.getCurrentSession()
			.getNamedQuery(COUNT_BY_OFFENDER_QUERY_NAME)
			.setParameter(OFFENDER_PARAM_NAME, offender)
			.setReadOnly(true)
			.uniqueResult();
		return count;
	}
}