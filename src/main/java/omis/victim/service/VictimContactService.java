package omis.victim.service;

import java.util.List;

import omis.address.domain.Address;
import omis.address.domain.AddressUnitDesignator;
import omis.address.domain.BuildingCategory;
import omis.address.domain.StreetSuffix;
import omis.address.domain.ZipCode;
import omis.contact.domain.Contact;
import omis.contact.domain.OnlineAccount;
import omis.contact.domain.OnlineAccountHost;
import omis.contact.domain.TelephoneNumber;
import omis.contact.domain.TelephoneNumberCategory;
import omis.contact.domain.component.PoBox;
import omis.country.domain.Country;
import omis.exception.DuplicateEntityFoundException;
import omis.person.domain.Person;
import omis.region.domain.City;
import omis.region.domain.State;
import omis.residence.domain.ResidenceTerm;

/**
 * Service for victim contacts.
 *
 * @author Stephen Abson
 * @author Yidong Li
 * @version 0.0.1 (Jan 5, 2016)
 * @since OMIS 3.0
 */
public interface VictimContactService {
	
	/**
	 * Creates address.
	 * 
	 * @param houseNumber house number
	 * @param buildingCategory building category
	 * @param zipCode ZIP code
	 * @return created address
	 * @throws DuplicateEntityFoundException if address exists
	 */
	Address createAddress(String houseNumber, BuildingCategory buildingCategory,
			ZipCode zipCode)
				throws DuplicateEntityFoundException;
	
	/**
	 * Returns contact for victim.
	 * 
	 * @param victim victim
	 * @return contact for victim
	 */
	Contact findContact(Person victim);
	
	/**
	 * Updates victim contact.
	 * 
	 * <p>If victim does not have a contact, create one.
	 * 
	 * @param victim victim the contact of whom to update
	 * @param mailingAddress mailing address
	 * @param poBox PO box
	 * @return  updated - or newly created - victim contact
	 */
	Contact updateContact(Person victim, Address mailingAddress, PoBox poBox);
	
	/**
	 * Updates victim residence term.
	 * 
	 * <p>If victim does not have a residence term, create one.
	 * 
	 * @param victim victim the contact of whom to update
	 * @param address address
	 * @return updated - or newly created - victim contact
	 */
	ResidenceTerm updateResidenceTerm(Person victim, Address address);
	
	/**
	 * Adds telephone number.
	 * 
	 * @param contact contact to which to add telephone number
	 * @param value value
	 * @param extension extension
	 * @param primary whether primary
	 * @param category category
	 * @return added telephone number
	 * @throws DuplicateEntityFoundException if telephone number exists
	 */
	TelephoneNumber addTelephoneNumber(Contact contact, Long value,
			Integer extension, Boolean primary,
			TelephoneNumberCategory category)
				throws DuplicateEntityFoundException;
	
	/**
	 * Adds online account.
	 * 
	 * @param contact contact to which to add online account
	 * @param name name
	 * @param primary whether primary
	 * @param host host
	 * @return added online account
	 * @throws DuplicateEntityFoundException if online account exists
	 */
	OnlineAccount addOnlineAccount(Contact contact, String name,
			Boolean primary, OnlineAccountHost host)
				throws DuplicateEntityFoundException;
	
	/**
	 * Updates telephone number.
	 * 
	 * @param telephoneNumber telephone number to update
	 * @param value value
	 * @param extension extension
	 * @param primary whether primary
	 * @param category category
	 * @return updated telephone number
	 * @throws DuplicateEntityFoundException if telephone number exists
	 */
	TelephoneNumber updateTelephoneNumber(TelephoneNumber telephoneNumber,
			Long value, Integer extension, Boolean primary,
			TelephoneNumberCategory category)
				throws DuplicateEntityFoundException;
	
	/**
	 * Updates online account.
	 * 
	 * @param onlineAccount online account
	 * @param name name
	 * @param primary whether primary
	 * @param host host
	 * @return updated online account
	 * @throws DuplicateEntityFoundException if online account exists
	 */
	OnlineAccount updateOnlineAccount(OnlineAccount onlineAccount,
			String name, Boolean primary, OnlineAccountHost host)
				throws DuplicateEntityFoundException;
	
	/**
	 * Removes telephone number.
	 * 
	 * @param telephoneNumber telephone number to remove
	 */
	void removeTelephoneNumber(TelephoneNumber telephoneNumber);
	
	/**
	 * Removes online account.
	 * 
	 * @param onlineAccount online account to remove
	 */
	void removeOnlineAccount(OnlineAccount onlineAccount);
	
	/**
	 * Returns telephone numbers for victim contact.
	 * 
	 * @param victimContact victim contact
	 * @return telephone numbers for victim contact
	 */
	List<TelephoneNumber> findTelephoneNumbers(Contact victimContact);

	/**
	 * Returns online accounts for victim contact.
	 * 
	 * @param contact victim contact
	 * @return online accounts for victim contact
	 */
	List<OnlineAccount> findOnlineAccounts(Contact contact);
	
	/**
	 * Returns online account hosts.
	 * 
	 * @return online account hosts
	 */
	List<OnlineAccountHost> findOnlineAccountHosts();
	
	/**
	 * Returns countries.
	 * 
	 * @return countries
	 */
	List<Country> findCountries();

	/**
	 * Returns States by country.
	 * 
	 * @param country country
	 * @return States by country
	 */
	List<State> findStatesByCountry(Country country);

	/**
	 * Returns whether country has States.
	 * 
	 * @param country country
	 * @return whether country has States
	 */
	boolean hasStates(Country country);

	/**
	 * Returns cities by country.
	 * 
	 * @param country country
	 * @return cities by country
	 */
	List<City> findCitiesByCountry(Country country);

	/**
	 * Returns cities by State.
	 * 
	 * @param state State
	 * @return cities by State
	 */
	List<City> findCitiesByState(State state);

	/**
	 * Returns address unit designators.
	 * 
	 * @return address unit designators
	 */
	List<AddressUnitDesignator> findAddressUnitDesignators();

	/**
	 * Returns street suffixes.
	 * 
	 * @return street suffixes
	 */
	List<StreetSuffix> findStreetSuffix();

	/**
	 * Returns ZIP codes by city.
	 * 
	 * @param city city
	 * @return ZIP codes by city
	 */
	List<ZipCode> findZipCodesByCity(City city);

	/**
	 * Creates city.
	 * 
	 * @param name name
	 * @param state State
	 * @param country country
	 * @return city
	 * @throws DuplicateEntityFoundException if city exists
	 */
	City createCity(String name, State state, Country country)
			throws DuplicateEntityFoundException;

	/**
	 * Creates ZIP code.
	 * 
	 * @param value value
	 * @param extension extension
	 * @param city city
	 * @return ZIP code
	 * @throws DuplicateEntityFoundException if ZIP code exists
	 */
	ZipCode createZipCode(String value, String extension, City city)
				throws DuplicateEntityFoundException;
}