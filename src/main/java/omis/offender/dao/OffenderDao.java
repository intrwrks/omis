package omis.offender.dao;

import java.util.List;

import omis.dao.GenericDao;
import omis.offender.domain.Offender;
import omis.person.domain.Person;
import omis.person.domain.PersonIdentity;
import omis.person.domain.PersonName;

/**
 * Data access object for offenders.
 * 
 * @author Stephen Abson
 * @author Joel Norris
 * @version 0.1.4 (Sept 16, 2014)
 * @since OMIS 3.0
 */
public interface OffenderDao
		extends GenericDao<Offender> {
	
	/**
	 * Checks whether an offender exists with the given offender number.
	 * 
	 * @param offenderNumber offender number of which to determine the validity
	 * @return whether an offender exists with given number
	 */
	boolean isOffenderNumberValid(Integer offenderNumber);
	
	/**
	 * Returns person as offender; {@code null} if person is not an offender.
	 * 
	 * @param person person
	 * @return person as offender; {@code null} if person is not an offender
	 */
	Offender findAsOffender(Person person);
	
	/**
	 * Returns offenders with the specified last name first name.
	 * 
	 * @param firstName first name
	 * @param lastName last name
	 * @return offenders with specified last and first name
	 */
	List<Offender> findOffenderByName(String firstName, String lastName);
	
	/**
	 * Returns the offender with the specified offender number.
	 * 
	 * @param offenderNumber offender number
	 * @return offender with specified offender number
	 */
	Offender findByOffenderNumber(Integer offenderNumber);
	
	/**
	 * Returns the next offender number.
	 * 
	 * @return next offender number
	 */
	Integer findNextOffenderNumber();
	
	/**
	 * Expunges offender.
	 * 
	 * @param offender offender to expunge
	 * @throws UnsupportedOperationException if expunging of offenders is not
	 * supported
	 */
	void expunge(Offender offender);

	/**
	 * Returns any and all offender who have the specified identity and name.
	 * 
	 * @param identity person identity
	 * @param name person name
	 * @return list of matching offenders
	 */
	List<Offender> findOffenderByIdentityAndName(PersonIdentity identity,
			PersonName name);
	
	/**
	 * Converts person to an offender.
	 * 
	 * @param person person
	 * @param offenderNumber offender number
	 * @param newly created offender
	 */
	Offender convertPerson(Person person, Integer offenderNumber);
}