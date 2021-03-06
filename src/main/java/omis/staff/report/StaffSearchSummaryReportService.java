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
package omis.staff.report;

import java.util.Date;
import java.util.List;

import omis.organization.domain.OrganizationDivision;
import omis.supervision.domain.SupervisoryOrganization;


/** Service for report related operations.
 * @author Ryan Johns
 * @author Sheronda Vaughn
 * @version 0.1.0 (Jul 16, 2014)
 * @since OMIS 3.0 */
public interface StaffSearchSummaryReportService {
	
	/** find staff search result by staff id. 
	 * @param id id.
	 * @return staff search result. */
	StaffSearchResult findById(final Long id);
	
	/** find staff search result by non specified criteria and date.
	 * @param searchCriteria search criteria.
	 * @param date date.
	 * @return list of staff search results. */
	List<StaffSearchResult> findPersonNamesByUnspecified(
	String searchCriteria, final Date date);
	
	/** find staff search result by name search.
	 * @param name1 name1.
	 * @param name2 name2.
	 * @param date date.
	 * @return list of staff search results. */
	List<StaffSearchResult> findPersonNamesByNameSearch(final String name1,
			final String name2, final Date date);
	
	/** find staff search result by name search.
	 * @param first first name.
	 * @param middle middle name.
	 * @param last last name.
	 * @param date date.
	 * @return list of staff search results. */
	List<StaffSearchResult> findPersonNamesByNameSearch(
			final String first, final String middle, final String last,
			final Date date);
	
	/** find staff search result by last name search.
	 * @param name last name.
	 * @param date date.
	 * @return list of staff search results. */
	List<StaffSearchResult> findPersonNamesByLastName(final String name,
			final Date date);
	
	/** find staff search result by user name.
	 * @param username username. 
	 * @param date date.
	 * @return staff search result if it exists else null. */
	StaffSearchResult findPersonNameByUsername(final String username, 
			final Date date);

	/**
	 * Staff search summary list.
	 * 
	 * @param firstName first name
	 * @param lastName last name
	 * @param organization organization
	 * @return summary of staff search
	 */
	List<StaffSearchSummary> search(String firstName, String lastName, 
			SupervisoryOrganization organization, OrganizationDivision division);
	
//	List<StaffSearchSummary> staffSearch(String firstName, String lastName);
	
	/**
	 * List of all supervisory organizations.
	 * 
	 * @return list of organizations
	 */
	List<SupervisoryOrganization> findAllSupervisoryOrganizations();
	
	List<OrganizationDivision> findAllOrganizationDivisions();
}