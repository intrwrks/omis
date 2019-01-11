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
package omis.hearing.report.impl.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;

import omis.hearing.domain.Hearing;
import omis.hearing.report.HearingSummary;
import omis.hearing.report.HearingSummaryReportService;
import omis.offender.domain.Offender;

/**
 * HearingSummaryReportServiceHibernateImpl.java
 * 
 * @author Annie Wahl
 * @author Josh Divine 
 * @version 0.1.2 (Feb 14, 2018)
 * @since OMIS 3.0
 *
 */
public class HearingSummaryReportServiceHibernateImpl
	implements HearingSummaryReportService {
	
	private static final String FIND_HEARING_SUMMARIES_BY_OFFENDER_QUERY_NAME =
			"findHearingSummariesByOffender";
	
	private static final String SUMMARIZE_HEARING_QUERY_NAME = "summarizeHearing";
	
	private static final String OFFENDER_PARAMETER_NAME = "offender";
	
	private static final String HEARING_PARAMETER_NAME = "hearing";
	
	private final SessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory
	 */
	public HearingSummaryReportServiceHibernateImpl(
			final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**{@inheritDoc} */
	@Override
	public List<HearingSummary> findByOffender(final Offender offender) {
		@SuppressWarnings("unchecked")
		List<HearingSummary> summaries = this.sessionFactory.getCurrentSession()
				.getNamedQuery(FIND_HEARING_SUMMARIES_BY_OFFENDER_QUERY_NAME)
				.setParameter(OFFENDER_PARAMETER_NAME, offender)
				.setReadOnly(true)
				.list();
		return summaries;
	}

	/**{@inheritDoc} */
	@Override
	public HearingSummary summarize(final Hearing hearing) {
		HearingSummary summary = (HearingSummary) this.sessionFactory
				.getCurrentSession()
				.getNamedQuery(SUMMARIZE_HEARING_QUERY_NAME)
				.setParameter(HEARING_PARAMETER_NAME, hearing)
				.setReadOnly(true)
				.uniqueResult();
		
		return summary;
	}
}