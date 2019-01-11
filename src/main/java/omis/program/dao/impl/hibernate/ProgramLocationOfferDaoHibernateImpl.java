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
package omis.program.dao.impl.hibernate;

import org.hibernate.SessionFactory;

import omis.dao.impl.hibernate.GenericHibernateDaoImpl;
import omis.location.domain.Location;
import omis.program.dao.ProgramLocationOfferDao;
import omis.program.domain.Program;
import omis.program.domain.ProgramLocationOffer;

/**
 * Hibernate implementation offering program at location.
 *
 * @author Stephen Abson
 * @version 0.0.1 (Apr 13, 2016)
 * @since OMIS 3.0
 */
public class ProgramLocationOfferDaoHibernateImpl
		extends GenericHibernateDaoImpl<ProgramLocationOffer>
		implements ProgramLocationOfferDao {

	/* Query names. */
	
	private static final String FIND_QUERY_NAME = "findProgramLocationOffer";

	/* Parameter names. */
	
	private static final String PROGRAM_PARAM_NAME = "program";
	
	private static final String LOCATION_PARAM_NAME = "location";

	/* Constructors. */
	
	/**
	 * Instantiates Hibernate implementation offering program at location.
	 * 
	 * @param sessionFactory session factory
	 * @param entityName entity name
	 */
	public ProgramLocationOfferDaoHibernateImpl(
			final SessionFactory sessionFactory, final String entityName) {
		super(sessionFactory, entityName);
	}
	
	/* Method implementations. */

	/** {@inheritDoc} */
	@Override
	public ProgramLocationOffer find(
			final Program program, final Location location) {
		ProgramLocationOffer offer = (ProgramLocationOffer)
				this.getSessionFactory().getCurrentSession()
					.getNamedQuery(FIND_QUERY_NAME)
					.setParameter(PROGRAM_PARAM_NAME, program)
					.setParameter(LOCATION_PARAM_NAME, location)
					.uniqueResult();
		return offer;
	}
}