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
package omis.probationparole.report.impl.hibernate;

import java.util.List;
import org.hibernate.SessionFactory;
import omis.offender.domain.Offender;
import omis.probationparole.report.ProbationParoleDocumentAssociationSummary;
import omis.probationparole.report.ProbationParoleDocumentAssociationSummaryReportService;

/**
 * Probation Parole Document Association Summary Report
 * Service Hibernate Implementation.
 * 
 *@author Annie Wahl 
 *@version 0.1.0 (Dec 7, 2018)
 *@since OMIS 3.0
 *
 */
public class ProbationParoleDocumentAssociationSummaryReportServiceHibernateImpl
		implements ProbationParoleDocumentAssociationSummaryReportService {
	
	/* Query Names */
	
	private static final String
	FIND_PROBATION_PAROLE_DOCUMENT_ASSOCIATION_SUMMARIES_BY_OFFENDER_QUERY_NAME
		= "findProbationParoleDocumentAssociationSummariesByOffender";
	
	/* Parameter names */
	
	private static final String OFFENDER_PARAM_NAME = "offender";
	
	private final SessionFactory sessionFactory;
	
	/**
	 * Constructor for
	 * ProbationParoleDocumentAssociationSummaryReportServiceHibernateImpl.
	 * 
	 * @param sessionFactory - Session Factory
	 */
	public ProbationParoleDocumentAssociationSummaryReportServiceHibernateImpl(
			final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** {@inheritDoc} */
	@Override
	public List<ProbationParoleDocumentAssociationSummary> findByOffender(
			final Offender offender) {
		@SuppressWarnings("unchecked")
		List<ProbationParoleDocumentAssociationSummary> summaries =
			this.sessionFactory.getCurrentSession().getNamedQuery(
				FIND_PROBATION_PAROLE_DOCUMENT_ASSOCIATION_SUMMARIES_BY_OFFENDER_QUERY_NAME)
			.setParameter(OFFENDER_PARAM_NAME, offender)
			.list();
		return summaries;
	}

}
