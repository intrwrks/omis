package omis.bedplacement.service.testng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

import omis.address.domain.Address;
import omis.address.domain.ZipCode;
import omis.address.service.delegate.AddressDelegate;
import omis.address.service.delegate.ZipCodeDelegate;
import omis.bedplacement.domain.BedPlacement;
import omis.bedplacement.domain.BedPlacementReason;
import omis.bedplacement.exception.BedOccupiedException;
import omis.bedplacement.exception.BedPlacementDateConflictException;
import omis.bedplacement.service.BedPlacementService;
import omis.bedplacement.service.delegate.BedPlacementDelegate;
import omis.bedplacement.service.delegate.BedPlacementReasonDelegate;
import omis.country.domain.Country;
import omis.country.service.delegate.CountryDelegate;
import omis.datatype.DateRange;
import omis.exception.DuplicateEntityFoundException;
import omis.facility.domain.Bed;
import omis.facility.domain.Facility;
import omis.facility.domain.Room;
import omis.facility.service.delegate.BedDelegate;
import omis.facility.service.delegate.FacilityDelegate;
import omis.facility.service.delegate.RoomDelegate;
import omis.location.domain.Location;
import omis.location.service.delegate.LocationDelegate;
import omis.offender.domain.Offender;
import omis.offender.service.delegate.OffenderDelegate;
import omis.organization.domain.Organization;
import omis.organization.service.delegate.OrganizationDelegate;
import omis.region.domain.City;
import omis.region.domain.State;
import omis.region.service.delegate.CityDelegate;
import omis.region.service.delegate.StateDelegate;
import omis.testng.AbstractHibernateTransactionalTestNGSpringContextTests;
import omis.util.PropertyValueAsserter;

/**
 * Tests method to confirm bed placements.
 *
 * @author Josh Divine
 * @author Sheronda Vaughn
 * @version 0.0.1
 * @since OMIS 3.0
 */
public class BedPlacementServiceConfirmTests
	extends AbstractHibernateTransactionalTestNGSpringContextTests {

	/* Delegates. */

	@Autowired
	@Qualifier("offenderDelegate")
	private OffenderDelegate offenderDelegate;
	
	@Autowired
	@Qualifier("bedDelegate")
	private BedDelegate bedDelegate;
	
	@Autowired
	@Qualifier("bedPlacementReasonDelegate")
	private BedPlacementReasonDelegate bedPlacementReasonDelegate;
	
	@Autowired
	@Qualifier("roomDelegate")
	private RoomDelegate roomDelegate;
	
	@Autowired
	@Qualifier("facilityDelegate")
	private FacilityDelegate facilityDelegate;
	
	@Autowired
	@Qualifier("locationDelegate")
	private LocationDelegate locationDelegate;
	
	@Autowired
	@Qualifier("organizationDelegate")
	private OrganizationDelegate organizationDelegate;
	
	@Autowired
	@Qualifier("addressDelegate")
	private AddressDelegate addressDelegate;
	
	@Autowired
	@Qualifier("zipCodeDelegate")
	private ZipCodeDelegate zipCodeDelegate;
	
	@Autowired
	@Qualifier("cityDelegate")
	private CityDelegate cityDelegate;
	
	@Autowired
	@Qualifier("countryDelegate")
	private CountryDelegate countryDelegate;
	
	@Autowired
	@Qualifier("stateDelegate")
	private StateDelegate stateDelegate;
	
	@Autowired
	@Qualifier("bedPlacementDelegate")
	private BedPlacementDelegate bedPlacementDelegate;
	
	/* Services. */

	@Autowired
	@Qualifier("bedPlacementService")
	private BedPlacementService bedPlacementService;

	/* Test methods. */

	/**
	 * Test the method to confirm a bed placement.
	 * 
	 * @throws BedPlacementDateConflictException if dates conflict
	 * @throws BedOccupiedException if the bed already has an occupant
	 * @throws DuplicateEntityFoundException if the entity already exists
	 */
	@Test
	public void testConfirm() throws BedPlacementDateConflictException, 
			BedOccupiedException, DuplicateEntityFoundException {
		// Arrangements
		Offender offender = this.offenderDelegate.createWithoutIdentity("Smith", 
				"John", "Jay", null);
		Organization organization = this.organizationDelegate.create("Org", "O", 
				null);
		final Long telephoneNumber = new Long("1234567");
		DateRange locationDateRange = 
				new DateRange(this.parseDateText("01/01/2000"), null);
		Country country = this.countryDelegate.create("Country", "C", true);
		State state = this.stateDelegate.create("State", "S", country, false, 
				true);
		City city = this.cityDelegate.create("City", true, state, country);
		ZipCode zipCode = this.zipCodeDelegate.create(city, "12345", null, 
				true);
		Address address = this.addressDelegate.findOrCreate("1 Easy Street", 
				null, null, null, zipCode);
		Location location = this.locationDelegate.create(organization, 
				locationDateRange, address);
		Facility facility = this.facilityDelegate.create(location, "Facility", 
				"F", true, telephoneNumber);
		Room room = this.roomDelegate.create("Room", facility, null, null, null, 
				null, true);
		Bed bed = this.bedDelegate.create(room, 1, true);
		Boolean confirmed = false;
		DateRange dateRange = new DateRange(this.parseDateText("01/01/2017"), 
				null);
		String description = "Description";
		BedPlacementReason reason = this.bedPlacementReasonDelegate
				.create("Reason", 1, true);
		BedPlacement bedPlacement = this.bedPlacementDelegate.create(offender, 
				bed, confirmed, dateRange, description, reason);
		Date date = this.parseDateText("03/01/2017");

		// Action
		bedPlacement = this.bedPlacementService.confirm(bedPlacement, date);

		// Assertions
		PropertyValueAsserter.create()
			.addExpectedValue("offender", offender)
			.addExpectedValue("bed", bed)
			.addExpectedValue("confirmed", true)
			.addExpectedValue("dateRange", dateRange)
			.addExpectedValue("description", description)
			.addExpectedValue("bedPlacementReason", reason)
			.performAssertions(bedPlacement);
	}

	/**
	 * Test {@code BedPlacementDateConflictException} is thrown.
	 * 
	 * @throws BedPlacementDateConflictException if dates conflict
	 * @throws BedOccupiedException if the bed already has an occupant
	 * @throws DuplicateEntityFoundException if the entity already exists
	 */
	@Test(expectedExceptions = {BedPlacementDateConflictException.class})
	public void testBedPlacementDateConflictException() 
			throws BedPlacementDateConflictException, BedOccupiedException, 
			DuplicateEntityFoundException {
		// Arrangements
		Offender offender = this.offenderDelegate.createWithoutIdentity("Smith", 
				"John", "Jay", null);
		Organization organization = this.organizationDelegate.create("Org", "O", 
				null);
		final Long telephoneNumber = new Long("1234567");
		DateRange locationDateRange = 
				new DateRange(this.parseDateText("01/01/2000"), null);
		Country country = this.countryDelegate.create("Country", "C", true);
		State state = this.stateDelegate.create("State", "S", country, false, 
				true);
		City city = this.cityDelegate.create("City", true, state, country);
		ZipCode zipCode = this.zipCodeDelegate.create(city, "12345", null, 
				true);
		Address address = this.addressDelegate.findOrCreate("1 Easy Street", 
				null, null, null, zipCode);
		Location location = this.locationDelegate.create(organization, 
				locationDateRange, address);
		Facility facility = this.facilityDelegate.create(location, "Facility", 
				"F", true, telephoneNumber);
		Room room = this.roomDelegate.create("Room", facility, null, null, null, 
				null, true);
		Bed bed = this.bedDelegate.create(room, 1, true);
		Boolean confirmed = true;
		DateRange dateRange = new DateRange(this.parseDateText("01/01/2017"), 
				this.parseDateText("03/01/2017"));
		String description = "Description";
		BedPlacementReason reason = this.bedPlacementReasonDelegate
				.create("Reason", 1, true);
		this.bedPlacementDelegate.create(offender, bed, confirmed, dateRange, 
				description, reason);
		DateRange secondDateRange = new DateRange(
				this.parseDateText("03/01/2017"), null);
		BedPlacement bedPlacement = this.bedPlacementDelegate.create(offender, 
				bed, false, secondDateRange, description, reason);
		Date date = this.parseDateText("02/01/2017");

		// Action
		bedPlacement = this.bedPlacementService.confirm(bedPlacement, date);
	}

	/**
	 * Test {@code BedOccupiedException} is thrown.
	 * 
	 * @throws BedPlacementDateConflictException if dates conflict
	 * @throws BedOccupiedException if the bed already has an occupant
	 * @throws DuplicateEntityFoundException if the entity already exists
	 */
	@Test(expectedExceptions = {BedOccupiedException.class})
	public void testBedOccupiedException() 
			throws BedPlacementDateConflictException, BedOccupiedException, 
			DuplicateEntityFoundException {
		// Arrangements
		Offender offender = this.offenderDelegate.createWithoutIdentity("Smith", 
				"John", "Jay", null);
		Organization organization = this.organizationDelegate.create("Org", "O", 
				null);
		final Long telephoneNumber = new Long("1234567");
		DateRange locationDateRange = 
				new DateRange(this.parseDateText("01/01/2000"), null);
		Country country = this.countryDelegate.create("Country", "C", true);
		State state = this.stateDelegate.create("State", "S", country, false, 
				true);
		City city = this.cityDelegate.create("City", true, state, country);
		ZipCode zipCode = this.zipCodeDelegate.create(city, "12345", null, 
				true);
		Address address = this.addressDelegate.findOrCreate("1 Easy Street", 
				null, null, null, zipCode);
		Location location = this.locationDelegate.create(organization, 
				locationDateRange, address);
		Facility facility = this.facilityDelegate.create(location, "Facility", 
				"F", true, telephoneNumber);
		Room room = this.roomDelegate.create("Room", facility, null, null, null, 
				null, true);
		Bed bed = this.bedDelegate.create(room, 1, true);
		Boolean confirmed = true;
		DateRange dateRange = new DateRange(this.parseDateText("01/01/2017"), 
				null);
		String description = "Description";
		BedPlacementReason reason = this.bedPlacementReasonDelegate
				.create("Reason", 1, true);
		Offender secondOffender = this.offenderDelegate
				.createWithoutIdentity("Doe", "John", null, null);
		this.bedPlacementDelegate.create(secondOffender, bed, confirmed, 
				dateRange, description, reason);
		BedPlacement bedPlacement = this.bedPlacementService.create(offender, 
				bed, false, dateRange, description, reason);
		Date date = this.parseDateText("02/01/2017");
		
		// Action
		this.bedPlacementService.confirm(bedPlacement, date);
	}

	// Parses date text
	private Date parseDateText(final String text) {
		try {
			return new SimpleDateFormat("MM/dd/yyyy").parse(text);
		} catch (ParseException e) {
			throw new RuntimeException("Parse error", e);
		}
	}
}