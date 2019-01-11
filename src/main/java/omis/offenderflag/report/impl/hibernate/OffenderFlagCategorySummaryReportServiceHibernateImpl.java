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
package omis.offenderflag.report.impl.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;

import omis.offenderflag.report.OffenderFlagCategorySummary;
import omis.offenderflag.report.OffenderFlagCategorySummaryReportService;

/**
 * Offender flag category summary report service hibernate implementation.
 *
 * @author Sheronda Vaughn
 * @author Josh Divine
 * @version 0.1.1 (Feb 14, 2018)
 * @since OMIS 3.0
 */
public class OffenderFlagCategorySummaryReportServiceHibernateImpl 
	implements OffenderFlagCategorySummaryReportService {
	
	private static final String FIND_OFFENDER_FLAG_CATEGORY_SUMMARIES 
		= "findOffenderFlagCategorySummaries";
	
	private final SessionFactory sessionFactory;	

	/** Instantiates an implementation of offender flag category summary report
	 * service hibernate impl */
	public OffenderFlagCategorySummaryReportServiceHibernateImpl(
			final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** {@inheritDoc} */
	@Override
	public List<OffenderFlagCategorySummary> 
		findAllOffenderFlagCategorySummaries() {
		@SuppressWarnings("unchecked")
		List<OffenderFlagCategorySummary> summaries = this.sessionFactory
				.getCurrentSession().getNamedQuery(
						FIND_OFFENDER_FLAG_CATEGORY_SUMMARIES)
				.setReadOnly(true)
				.list();
		
		return summaries;
	}
}