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

package omis.vehicle.service.testng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

import omis.testng.AbstractHibernateTransactionalTestNGSpringContextTests;
import omis.vehicle.exception.VehicleMakeExistsException;
import omis.vehicle.service.OffenderVehicleManager;
import omis.vehicle.service.delegate.VehicleMakeDelegate;

/**.
 * Test finding vehicle makers
 *
 * @author Yidong Li
 * @version 0.0.1 (Dec. 26, 2018)
 * @since OMIS 3.0
 */
@Test(groups = {"vehicle", "service"})
public class OffenderVehicleManagerFindVehicleMakeTests 
	extends AbstractHibernateTransactionalTestNGSpringContextTests {
	/* Instance factory */
	
	/* Delegates. */
	@Autowired
	@Qualifier("vehicleMakeDelegate")
	private VehicleMakeDelegate vehicleMakeDelegate;
	
	/* Service to test. */
	@Autowired
	@Qualifier("offenderVehicleManager")
	private OffenderVehicleManager offenderVehicleManager;
	
	/* Test methods. */
	
	/**
	 * Test finding all vehicle makes
	 * @throws VehicleMakeExistsException 
	 */
	@Test
	public void testFindingColors() throws VehicleMakeExistsException {
		// Arrangements
		this.vehicleMakeDelegate.create("ColorOne", true);
		this.vehicleMakeDelegate.create("ColorTwo", true);
		
		// Action
		Integer count = this.offenderVehicleManager.findVehicleMake().size();
		
		// Assertion
		assert 2 == count
		: String.format("Wrong vehicle color number: #%d found; #%d expected",
		count, 2);
	}
}