package omis.hearing.service.impl;

import java.util.Date;
import java.util.List;

import omis.exception.DuplicateEntityFoundException;
import omis.hearing.domain.Hearing;
import omis.hearing.domain.HearingStatus;
import omis.hearing.domain.HearingStatusCategory;
import omis.hearing.domain.ImposedSanction;
import omis.hearing.domain.Infraction;
import omis.hearing.domain.component.Resolution;
import omis.hearing.service.ResolutionService;
import omis.hearing.service.delegate.HearingStatusDelegate;
import omis.hearing.service.delegate.ImposedSanctionDelegate;
import omis.hearing.service.delegate.InfractionDelegate;
import omis.offender.domain.Offender;
import omis.violationevent.domain.ConditionViolation;
import omis.violationevent.domain.DisciplinaryCodeViolation;
import omis.violationevent.service.delegate.ConditionViolationDelegate;
import omis.violationevent.service.delegate.DisciplinaryCodeViolationDelegate;

/**
 * ResolutionServiceImpl.java
 * 
 *@author Annie Jacques 
 *@version 0.1.0 (Apr 18, 2017)
 *@since OMIS 3.0
 *
 */
public class ResolutionServiceImpl implements ResolutionService {
	
	private final HearingStatusDelegate hearingStatusDelegate;
	
	private final InfractionDelegate infractionDelegate;
	
	private final ImposedSanctionDelegate imposedSanctionDelegate;
	
	private final ConditionViolationDelegate conditionViolationDelegate;
	
	private final DisciplinaryCodeViolationDelegate
			disciplinaryCodeViolationDelegate;
	
	/**
	 * @param hearingStatusDelegate
	 * @param infractionDelegate
	 * @param imposedSanctionDelegate
	 */
	public ResolutionServiceImpl(
			final HearingStatusDelegate hearingStatusDelegate,
			final InfractionDelegate infractionDelegate,
			final ImposedSanctionDelegate imposedSanctionDelegate,
			final ConditionViolationDelegate conditionViolationDelegate,
			final DisciplinaryCodeViolationDelegate
			disciplinaryCodeViolationDelegate) {
		this.hearingStatusDelegate = hearingStatusDelegate;
		this.infractionDelegate = infractionDelegate;
		this.imposedSanctionDelegate = imposedSanctionDelegate;
		this.conditionViolationDelegate = conditionViolationDelegate;
		this.disciplinaryCodeViolationDelegate =
				disciplinaryCodeViolationDelegate;
	}

	/**{@inheritDoc} */
	@Override
	public HearingStatus createHearingStatus(final Hearing hearing,
			final String description, final Date date,
			final HearingStatusCategory category)
					throws DuplicateEntityFoundException {
		return this.hearingStatusDelegate.create(hearing, description, date,
				category);
	}

	/**{@inheritDoc} */
	@Override
	public HearingStatus updateHearingStatus(final HearingStatus hearingStatus,
			final String description, final Date date,
			final HearingStatusCategory category)
					throws DuplicateEntityFoundException {
		return this.hearingStatusDelegate.update(hearingStatus, description,
				date, category);
	}

	/**{@inheritDoc} */
	@Override
	public void removeHearingStatus(final HearingStatus hearingStatus) {
		this.hearingStatusDelegate.remove(hearingStatus);
	}

	/**{@inheritDoc} */
	@Override
	public Infraction createInfraction(final Hearing hearing,
			final ConditionViolation conditionViolation,
			final DisciplinaryCodeViolation disciplinaryCodeViolation,
			final Resolution resolution)
					throws DuplicateEntityFoundException {
		return this.infractionDelegate.create(hearing, conditionViolation,
				disciplinaryCodeViolation, resolution);
	}

	/**{@inheritDoc} */
	@Override
	public Infraction updateInfraction(final Infraction infraction,
			final ConditionViolation conditionViolation,
			final DisciplinaryCodeViolation disciplinaryCodeViolation,
			final Resolution resolution)
					throws DuplicateEntityFoundException {
		return this.infractionDelegate.update(infraction, conditionViolation,
				disciplinaryCodeViolation, resolution);
	}

	/**{@inheritDoc} */
	@Override
	public void removeInfraction(final Infraction infraction) {
		this.infractionDelegate.remove(infraction);
	}

	/**{@inheritDoc} */
	@Override
	public List<Infraction> findInfractionsByHearing(final Hearing hearing) {
		return this.infractionDelegate.findByHearing(hearing);
	}

	/**{@inheritDoc} */
	@Override
	public ImposedSanction createImposedSanction(final Infraction infraction,
			final Offender offender, final String description)
			throws DuplicateEntityFoundException {
		return this.imposedSanctionDelegate.create(infraction, offender,
				description);
	}

	/**{@inheritDoc} */
	@Override
	public ImposedSanction updateImposedSanction(
			final ImposedSanction imposedSanction, final Offender offender,
			final String description)
			throws DuplicateEntityFoundException {
		return this.imposedSanctionDelegate.update(imposedSanction, offender,
				description);
	}

	/**{@inheritDoc} */
	@Override
	public void removeImposedSanction(final ImposedSanction imposedSanction) {
		this.imposedSanctionDelegate.remove(imposedSanction);
	}

	/**{@inheritDoc} */
	@Override
	public ImposedSanction findImposedSanctionByInfraction(
			final Infraction infraction) {
		return this.imposedSanctionDelegate.findByInfraction(infraction);
	}

	/**{@inheritDoc} */
	@Override
	public ConditionViolation findConditionViolationById(final Long id) {
		return this.conditionViolationDelegate.findById(id);
	}

	/**{@inheritDoc} */
	@Override
	public DisciplinaryCodeViolation findDisciplinaryCodeViolationById(
			final Long id) {
		return this.disciplinaryCodeViolationDelegate.findById(id);
	}

}
