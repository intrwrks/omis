package omis.paroleeligibility.service.impl;

import java.util.Date;
import java.util.List;

import omis.exception.DuplicateEntityFoundException;
import omis.offender.domain.Offender;
import omis.paroleeligibility.domain.AppearanceCategory;
import omis.paroleeligibility.domain.EligibilityStatusCategory;
import omis.paroleeligibility.domain.EligibilityStatusReason;
import omis.paroleeligibility.domain.ParoleEligibility;
import omis.paroleeligibility.domain.ParoleEligibilityNote;
import omis.paroleeligibility.domain.component.ParoleEligibilityStatus;
import omis.paroleeligibility.service.ParoleEligibilityService;
import omis.paroleeligibility.service.delegate.AppearanceCategoryDelegate;
import omis.paroleeligibility.service.delegate.EligibilityStatusReasonDelegate;
import omis.paroleeligibility.service.delegate.ParoleEligibilityDelegate;
import omis.paroleeligibility.service.delegate.ParoleEligibilityNoteDelegate;

/**
 * Implementation of service for parole eligibility service.
 *
 * @author Trevor Isles
 * @version 0.1.0 (Nov 9, 2017)
 * @since OMIS 3.0
 */
public class ParoleEligibilityServiceImpl implements ParoleEligibilityService {
	
	private final ParoleEligibilityDelegate paroleEligibilityDelegate;
	
	private final EligibilityStatusReasonDelegate 
		eligibilityStatusReasonDelegate;
	
	private final AppearanceCategoryDelegate appearanceCategoryDelegate;
	
	private final ParoleEligibilityNoteDelegate paroleEligibilityNoteDelegate;
	
	
	public ParoleEligibilityServiceImpl(
			final ParoleEligibilityDelegate paroleEligibilityDelegate,
			final EligibilityStatusReasonDelegate 
				eligibilityStatusReasonDelegate,
			final AppearanceCategoryDelegate appearanceCategoryDelegate,
			final ParoleEligibilityNoteDelegate paroleEligibilityNoteDelegate) {
		this.paroleEligibilityDelegate = paroleEligibilityDelegate;
		this.eligibilityStatusReasonDelegate = eligibilityStatusReasonDelegate;
		this.appearanceCategoryDelegate = appearanceCategoryDelegate;
		this.paroleEligibilityNoteDelegate = paroleEligibilityNoteDelegate;
	}

	/** {@inheritDoc} */
	@Override
	public ParoleEligibility create(final Offender offender,
			final Date hearingEligibilityDate, 
			final AppearanceCategory appearanceCategory,
			final EligibilityStatusCategory statusCategory, 
			final Date statusDate, 
			final EligibilityStatusReason statusReason,
			final String statusComment, 
			final Date reviewDate) 
					throws DuplicateEntityFoundException {
		return this.paroleEligibilityDelegate.create(offender,
				hearingEligibilityDate, reviewDate, new ParoleEligibilityStatus(
				statusDate,	statusComment, statusCategory, statusReason), 
				appearanceCategory); 
	}

	/** {@inheritDoc} */
	@Override
	public ParoleEligibility update(
			final ParoleEligibility paroleEligibility,
			final Date hearingEligibilityDate,
			final AppearanceCategory appearanceCategory, 
			final EligibilityStatusCategory statusCategory, 
			final Date statusDate,
			final EligibilityStatusReason statusReason, 
			final String statusComment, 
			final Date reviewDate)
					throws DuplicateEntityFoundException {
		return this.paroleEligibilityDelegate.update(paroleEligibility, 
				paroleEligibility.getOffender(), hearingEligibilityDate,
				reviewDate, new ParoleEligibilityStatus(statusDate, 
				statusComment, statusCategory, statusReason), 
				appearanceCategory); 
	}

	/** {@inheritDoc} */
	@Override
	public void remove(ParoleEligibility paroleEligibility) {
		this.paroleEligibilityDelegate.remove(paroleEligibility); 
	}
	

	/** {@inheritDoc} */
	@Override
	public ParoleEligibilityNote createParoleEligibilityNote(
			final ParoleEligibility paroleEligibility, 
			final Date date,
			final String description) 
					throws DuplicateEntityFoundException {
		return this.paroleEligibilityNoteDelegate.create(paroleEligibility,
				description, date);
	}

	/** {@inheritDoc} */
	@Override
	public ParoleEligibilityNote updateParoleEligibilityNote(
			final ParoleEligibilityNote paroleEligibilityNote,
			final Date date,
			final String description) 
					throws DuplicateEntityFoundException {
		return this.paroleEligibilityNoteDelegate.update(
				paroleEligibilityNote, description, date);
	}

	/** {@inheritDoc} */
	@Override
	public void removeParoleEligiblityNote(
			final ParoleEligibilityNote paroleEligibilityNote) {
		this.paroleEligibilityNoteDelegate.remove(paroleEligibilityNote);
	}
	

	/** {@inheritDoc} */
	@Override
	public List<ParoleEligibilityNote> 
		findParoleEligibilityNotesByParoleEligibility(
			ParoleEligibility paroleEligibility) {
		return this.paroleEligibilityNoteDelegate
			.findParoleEligibilityNotesByParoleEligibility(paroleEligibility);
	}
	
	/** {@inheritDoc} */
	@Override
	public List<EligibilityStatusReason> findEligibilityStatusReasons() {
		return this.eligibilityStatusReasonDelegate
				.findEligibilityStatusReasons();
	}
	
	/** {@inheritDoc} */
	@Override
	public List<AppearanceCategory> findAppearanceCategories() {
		return this.appearanceCategoryDelegate.findAppearanceCategories();
	}

}
