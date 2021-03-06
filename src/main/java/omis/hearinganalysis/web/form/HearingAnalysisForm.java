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
package omis.hearinganalysis.web.form;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import omis.hearinganalysis.domain.HearingAnalysisCategory;
import omis.paroleboardmember.domain.ParoleBoardMember;

/**
 * Hearing analysis form.
 *
 * @author Josh Divine
 * @author Annie Wahl
 * @version 0.1.3 (Dec 3, 2018)
 * @since OMIS 3.0
 */
public class HearingAnalysisForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private HearingAnalysisCategory category;
	
	private ParoleBoardMember analyst;
	
	private Date dueDate;
	
	private List<HearingAnalysisNoteItem> hearingAnalysisNoteItems;
	
	/**
	 * Instantiates a default hearing analysis form. 
	 */
	public HearingAnalysisForm() {
		// Default instantiation
	}

	/**
	 * Returns the hearing analysis category.
	 * 
	 * @return hearing analysis category
	 */
	public HearingAnalysisCategory getCategory() {
		return category;
	}

	/**
	 * Sets the hearing analysis category.
	 * 
	 * @param category hearing analysis category
	 */
	public void setCategory(HearingAnalysisCategory category) {
		this.category = category;
	}

	/**
	 * Returns the analyst.
	 * 
	 * @return analyst
	 */
	public ParoleBoardMember getAnalyst() {
		return analyst;
	}

	/**
	 * Sets the analyst.
	 * 
	 * @param analyst board attendee
	 */
	public void setAnalyst(final ParoleBoardMember analyst) {
		this.analyst = analyst;
	}
	
	/**
	 * Returns the dueDate.
	 * @return dueDate - Date
	 */
	public Date getDueDate() {
		return this.dueDate;
	}

	/**
	 * Sets the dueDate.
	 * @param dueDate - Date
	 */
	public void setDueDate(final Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Returns the list of hearing analysis note items.
	 * 
	 * @return list of hearing analysis note items
	 */
	public List<HearingAnalysisNoteItem> getHearingAnalysisNoteItems() {
		return hearingAnalysisNoteItems;
	}

	/**
	 * Sets the list of hearing analysis note items.
	 *  
	 * @param hearingAnalysisNoteItems list of hearing analysis note items
	 */
	public void setHearingAnalysisNoteItems(
			final List<HearingAnalysisNoteItem> hearingAnalysisNoteItems) {
		this.hearingAnalysisNoteItems = hearingAnalysisNoteItems;
	}
}