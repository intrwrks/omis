package omis.hearing.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import omis.communitysupervision.dao.CommunitySupervisionOfficeDao;
import omis.communitysupervision.domain.CommunitySupervisionOffice;
import omis.exception.DuplicateEntityFoundException;
import omis.facility.domain.Facility;
import omis.facility.service.delegate.FacilityDelegate;
import omis.hearing.domain.Hearing;
import omis.hearing.domain.HearingCategory;
import omis.hearing.domain.HearingNote;
import omis.hearing.domain.HearingStatus;
import omis.hearing.domain.HearingStatusCategory;
import omis.hearing.domain.ImposedSanction;
import omis.hearing.domain.Infraction;
import omis.hearing.domain.StaffAttendance;
import omis.hearing.domain.component.Resolution;
import omis.hearing.service.HearingService;
import omis.hearing.service.delegate.HearingDelegate;
import omis.hearing.service.delegate.HearingNoteDelegate;
import omis.hearing.service.delegate.HearingStatusDelegate;
import omis.hearing.service.delegate.ImposedSanctionDelegate;
import omis.hearing.service.delegate.InfractionDelegate;
import omis.hearing.service.delegate.StaffAttendanceDelegate;
import omis.jail.domain.Jail;
import omis.jail.service.delegate.JailDelegate;
import omis.location.domain.Location;
import omis.location.service.delegate.LocationDelegate;
import omis.offender.domain.Offender;
import omis.prerelease.dao.PreReleaseCenterDao;
import omis.prerelease.domain.PreReleaseCenter;
import omis.staff.domain.StaffAssignment;
import omis.supervision.dao.SupervisoryOrganizationDao;
import omis.supervision.domain.SupervisoryOrganization;
import omis.treatment.dao.TreatmentCenterDao;
import omis.treatment.domain.TreatmentCenter;
import omis.violationevent.domain.ConditionViolation;
import omis.violationevent.domain.DisciplinaryCodeViolation;
import omis.violationevent.domain.ViolationEvent;
import omis.violationevent.service.delegate.ConditionViolationDelegate;
import omis.violationevent.service.delegate.DisciplinaryCodeViolationDelegate;
import omis.violationevent.service.delegate.ViolationEventDelegate;

/**
 * HearingServiceImpl.java
 * 
 *@author Annie Jacques 
 *@version 0.1.1 (Apr 18, 2017)
 *@since OMIS 3.0
 *
 */
public class HearingServiceImpl implements HearingService {
	
	private final HearingDelegate hearingDelegate;
	
	private final HearingNoteDelegate hearingNoteDelegate;
	
	private final StaffAttendanceDelegate staffAttendanceDelegate;
	
	private final HearingStatusDelegate hearingStatusDelegate;
	
	private final InfractionDelegate infractionDelegate;
	
	private final ImposedSanctionDelegate imposedSanctionDelegate;
	
	private final ViolationEventDelegate violationEventDelegate;
	
	private final ConditionViolationDelegate conditionViolationDelegate;
	
	private final DisciplinaryCodeViolationDelegate
		disciplinaryCodeViolationDelegate;
	
	private final JailDelegate jailDelegate;
	
	private final FacilityDelegate facilityDelegate;

	private final LocationDelegate locationDelegate;
	
	private final TreatmentCenterDao treatmentCenterDao;
	
	private final PreReleaseCenterDao preReleaseCenterDao;
	
	private final CommunitySupervisionOfficeDao communitySupervisionOfficeDao;

	private final SupervisoryOrganizationDao supervisoryOrganizationDao;
	
	
	/**
	 * @param hearingDelegate
	 * @param hearingNoteDelegate
	 * @param staffAttendanceDelegate
	 * @param hearingStatusDelegate
	 * @param infractionDelegate
	 * @param violationEventDelegate
	 * @param jailDelegate
	 * @param facilityDelegate
	 * @param treatmentCenterDao
	 * @param preReleaseCenterDao
	 * @param communitySupervisionOfficeDao
	 * @param supervisoryOrganizationDao
	 */
	public HearingServiceImpl(final HearingDelegate hearingDelegate,
			final HearingNoteDelegate hearingNoteDelegate,
			final StaffAttendanceDelegate staffAttendanceDelegate,
			final HearingStatusDelegate hearingStatusDelegate,
			final InfractionDelegate infractionDelegate,
			final ImposedSanctionDelegate imposedSanctionDelegate,
			final ViolationEventDelegate violationEventDelegate,
			final ConditionViolationDelegate conditionViolationDelegate,
			final DisciplinaryCodeViolationDelegate
				disciplinaryCodeViolationDelegate,
			final JailDelegate jailDelegate,
			final FacilityDelegate facilityDelegate,
			final LocationDelegate locationDelegate,
			final TreatmentCenterDao treatmentCenterDao,
			final PreReleaseCenterDao preReleaseCenterDao,
			final CommunitySupervisionOfficeDao communitySupervisionOfficeDao,
			final SupervisoryOrganizationDao supervisoryOrganizationDao) {
		this.hearingDelegate = hearingDelegate;
		this.hearingNoteDelegate = hearingNoteDelegate;
		this.staffAttendanceDelegate = staffAttendanceDelegate;
		this.hearingStatusDelegate = hearingStatusDelegate;
		this.infractionDelegate = infractionDelegate;
		this.imposedSanctionDelegate = imposedSanctionDelegate;
		this.violationEventDelegate = violationEventDelegate;
		this.conditionViolationDelegate = conditionViolationDelegate;
		this.disciplinaryCodeViolationDelegate =
				disciplinaryCodeViolationDelegate;
		this.jailDelegate = jailDelegate;
		this.facilityDelegate = facilityDelegate;
		this.locationDelegate = locationDelegate;
		this.treatmentCenterDao = treatmentCenterDao;
		this.preReleaseCenterDao = preReleaseCenterDao;
		this.communitySupervisionOfficeDao = communitySupervisionOfficeDao;
		this.supervisoryOrganizationDao = supervisoryOrganizationDao;
	}

	/**{@inheritDoc} */
	@Override
	public Hearing createHearing(final Location location,
			final Offender offender, final Boolean inAttendance, final Date date,
			final HearingCategory category, final StaffAssignment officer)
			throws DuplicateEntityFoundException {
		return this.hearingDelegate.create(location, offender, inAttendance,
				date, category, officer);
	}

	/**{@inheritDoc} */
	@Override
	public Hearing updateHearing(final Hearing hearing, final Location location,
			final Boolean inAttendance, final Date date,
			final HearingCategory category, final StaffAssignment officer)
			throws DuplicateEntityFoundException {
		return this.hearingDelegate.update(hearing, location, inAttendance,
				date, category, officer);
	}

	/**{@inheritDoc} */
	@Override
	public void removeHearing(final Hearing hearing) {
		this.hearingDelegate.remove(hearing);
	}

	/**{@inheritDoc} */
	@Override
	public HearingNote createHearingNote(final Hearing hearing,
			final String description, final Date date)
			throws DuplicateEntityFoundException {
		return this.hearingNoteDelegate.create(hearing, description, date);
	}

	/**{@inheritDoc} */
	@Override
	public HearingNote updateHearingNote(final HearingNote hearingNote,
			final String description, final Date date)
			throws DuplicateEntityFoundException {
		return this.hearingNoteDelegate.update(
				hearingNote, description, date);
	}

	/**{@inheritDoc} */
	@Override
	public void removeHearingNote(final HearingNote hearingNote) {
		this.hearingNoteDelegate.remove(hearingNote);
	}

	/**{@inheritDoc} */
	@Override
	public List<HearingNote> findHearingNotesByHearing(final Hearing hearing) {
		return this.hearingNoteDelegate.findAllByHearing(hearing);
	}

	/**{@inheritDoc} */
	@Override
	public StaffAttendance createStaffAttendance(final Hearing hearing,
			final StaffAssignment staff)
			throws DuplicateEntityFoundException {
		return this.staffAttendanceDelegate.create(hearing, staff);
	}

	/**{@inheritDoc} */
	@Override
	public StaffAttendance updateStaffAttendance(
			final StaffAttendance staffAttendance, final StaffAssignment staff)
					throws DuplicateEntityFoundException {
		return this.staffAttendanceDelegate.update(
				staffAttendance, staff);
	}

	/**{@inheritDoc} */
	@Override
	public void removeStaffAttendance(final StaffAttendance staffAttendance) {
		this.staffAttendanceDelegate.remove(staffAttendance);
	}

	/**{@inheritDoc} */
	@Override
	public List<StaffAttendance> findStaffAttendedByHearing(
			final Hearing hearing) {
		return this.staffAttendanceDelegate.findAllByHearing(hearing);
	}

	/**{@inheritDoc} */
	@Override
	public List<Location> findFacilityLocations() {
		List<Facility> facilities = this.facilityDelegate.findAll();
		List<Location> locations = new ArrayList<Location>();
		for(Facility facility : facilities){
			locations.add(facility.getLocation());
		}
		return locations;
	}

	/**{@inheritDoc} */
	@Override
	public List<Location> findJailLocations() {
		List<Jail> jails = this.jailDelegate.findAll();
		List<Location> locations = new ArrayList<Location>();
		for(Jail jail : jails){
			locations.add(jail.getLocation());
		}
		return locations;
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
	public void removeImposedSanction(final ImposedSanction imposedSanction) {
		this.imposedSanctionDelegate.remove(imposedSanction);
	}

	/**{@inheritDoc} */
	@Override
	public List<Infraction> findInfractionsByHearing(final Hearing hearing) {
		return this.infractionDelegate.findByHearing(hearing);
	}
	
	/**{@inheritDoc} */
	@Override
	public ImposedSanction findImposedSanctionByInfraction(
			final Infraction infraction) {
		return this.imposedSanctionDelegate.findByInfraction(infraction);
	}

	/**{@inheritDoc} */
	@Override
	public List<Location> findTreatmentCenterLocations() {
		List<Location> treatmentCenterLocations =
				new ArrayList<Location>();
		
		List<TreatmentCenter> treatmentCenters =
				this.treatmentCenterDao.findAll();
		List<Location> locations =
				this.locationDelegate.findAll();
		
		for(Location location : locations){
			for(TreatmentCenter treatmentCenter : treatmentCenters){
				if(treatmentCenter.getLocation()
						.equals(location)){
					treatmentCenterLocations
						.add(location);
				}
			}
		}
		
		return treatmentCenterLocations;
	}

	/**{@inheritDoc} */
	@Override
	public List<Location> findPreReleaseCenterLocations() {
		List<Location> preReleaseCenterLocations =
				new ArrayList<Location>();
		
		List<PreReleaseCenter> preReleaseCenters =
				this.preReleaseCenterDao.findAll();
		List<Location> locations =
				this.locationDelegate.findAll();
		
		for(Location location : locations){
			for(PreReleaseCenter preReleaseCenter : preReleaseCenters){
				if(preReleaseCenter.getLocation()
						.equals(location)){
					preReleaseCenterLocations
						.add(location);
				}
			}
		}
		
		return preReleaseCenterLocations;
	}

	/**{@inheritDoc} */
	@Override
	public List<Location> findCommunitySupervisionOfficeLocations() {
		List<Location> communitySupervisionOfficeLocations =
				new ArrayList<Location>();
		
		List<CommunitySupervisionOffice> communitySupervisionOffices =
				this.communitySupervisionOfficeDao.findAll();
		List<Location> locations =
				this.locationDelegate.findAll();
		
		for(Location location : locations){
			for(CommunitySupervisionOffice communitySupervisionOffice :
					communitySupervisionOffices){
				if(communitySupervisionOffice.getLocation()
						.equals(location)){
					communitySupervisionOfficeLocations
						.add(location);
				}
			}
		}
		
		return communitySupervisionOfficeLocations;
	}

	/**{@inheritDoc} */
	@Override
	public List<SupervisoryOrganization> findSupervisoryOrganization() {
		return this.supervisoryOrganizationDao.findAll();
	}

	/**{@inheritDoc} */
	@Override
	public HearingStatus findLatestHearingStatus(final Hearing hearing) {
		return this.hearingStatusDelegate.findLatestByHearing(hearing);
	}

	/**{@inheritDoc} */
	@Override
	public List<ViolationEvent> findUnresolvedViolationEventsByOffender(
			final Offender offender) {
		return this.violationEventDelegate.findUnresolvedByOffender(offender);
	}

	/**{@inheritDoc} */
	@Override
	public List<ConditionViolation>
		findUnresolvedConditionViolationsByViolationEvent(
				final ViolationEvent violationEvent) {
		return this.conditionViolationDelegate.findUnresolvedByViolationEvent(
				violationEvent);
	}

	/**{@inheritDoc} */
	@Override
	public List<DisciplinaryCodeViolation>
		findUnresolvedDisciplinaryCodeViolationsByViolationEvent(
				final ViolationEvent violationEvent) {
		return this.disciplinaryCodeViolationDelegate
				.findUnresolvedByViolationEvent(violationEvent);
	}

	/**{@inheritDoc} */
	@Override
	public List<HearingStatus> findHearingStatusesByHearing(Hearing hearing) {
		return this.hearingStatusDelegate.findByHearing(hearing);
	}
}
