package omis.commitstatus.service.testng;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

import omis.commitstatus.domain.CommitStatus;
import omis.commitstatus.exception.CommitStatusTermExistsAfterException;
import omis.commitstatus.service.CommitStatusTermService;
import omis.commitstatus.service.delegate.CommitStatusDelegate;
import omis.commitstatus.service.delegate.CommitStatusTermDelegate;
import omis.datatype.DateRange;
import omis.exception.DuplicateEntityFoundException;
import omis.offender.domain.Offender;
import omis.offender.service.delegate.OffenderDelegate;
import omis.testng.AbstractHibernateTransactionalTestNGSpringContextTests;

/**
 * Tests commit status term creation with exists after exception
 *
 * @author Yidong Li
 * @version 0.0.1
 * @since OMIS 3.0
 */
@Test(groups = {"commitstatus"})
public class CommitStatusTermServiceCommitStatusTermCreationWithExistAfterExceptionTest
		extends AbstractHibernateTransactionalTestNGSpringContextTests {
	
	/* Delegates. */
	@Autowired
	@Qualifier("offenderDelegate")
	private OffenderDelegate offenderDelegate;
	
	@Autowired
	@Qualifier("commitStatusTermDelegate")
	private CommitStatusTermDelegate commitStatusTermDelegate;
	
	@Autowired
	@Qualifier("commitStatusDelegate")
	private CommitStatusDelegate commitStatusDelegate;
	
	/* Service to test. */
	@Autowired
	@Qualifier("commitStatusTermService")
	private CommitStatusTermService commitStatusTermService;
	
	/**
	 * Tests the creation of commit status term with exist after exception.
	 * @throws DuplicateEntityFoundException 
	 */
	@Test(expectedExceptions = {CommitStatusTermExistsAfterException.class})
	public void testCommitStatusTermCreationExistAfterExceptionTest() 
		throws DuplicateEntityFoundException{
		// Arrangement
		Offender offender = this.offenderDelegate.createWithoutIdentity("Obama",
			"Kevin", "Johns", "Mr.");
		CommitStatus status1 = this.commitStatusDelegate.create("Status A", true);
		DateRange dateRange1 = new DateRange();
		Date startDate1= new Date(1205120000);
		dateRange1.setStartDate(startDate1);
		this.commitStatusTermService.create(offender, 
			status1, dateRange1);
		
		CommitStatus status2 = this.commitStatusDelegate.create("Status b", true);
		DateRange dateRange2 = new DateRange();
		Date startDate2= new Date(105120000);
		dateRange2.setStartDate(startDate2);
		
		// Action
		this.commitStatusTermService.create(offender, 
			status2, dateRange2);
	}
}