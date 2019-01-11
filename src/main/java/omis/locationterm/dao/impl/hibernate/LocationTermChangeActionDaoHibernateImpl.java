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
package omis.locationterm.dao.impl.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;

import omis.dao.impl.hibernate.GenericHibernateDaoImpl;
import omis.locationterm.dao.LocationTermChangeActionDao;
import omis.locationterm.domain.LocationTermChangeAction;
import omis.supervision.domain.CorrectionalStatus;

/**
 * Hibernate implementation of data access object for location term change
 * action.
 *
 * @author Stephen Abson
 * @version 0.0.1 (Mar 6, 2015)
 * @since OMIS 3.0
 */
public class LocationTermChangeActionDaoHibernateImpl
		extends GenericHibernateDaoImpl<LocationTermChangeAction>
		implements LocationTermChangeActionDao {

	/* Query names. */
	
	private static final String FIND_QUERY_NAME
		= "findLocationTermChangeAction";
	
	private static final String FIND_ALL_QUERY_NAME
		= "findLocationTermChangeActions";
	
	private static final String FIND_ALLOWED_FOR_CORRECTIONAL_STATUS_QUERY_NAME
		= "findLocationTermChangeActionsAllowedForCorrectionalStatus";
	
	/* Parameter names. */
	
	private static final String NAME_PARAM_NAME = "name";
	
	private static final String CORRECTIONAL_STATUS_PARAM_NAME
		= "correctionalStatus";

	/* Constructors. */
	
	/**
	 * Instantiates Hibernate implementation of data access object for location
	 * term change action.
	 * 
	 * @param sessionFactory session factory
	 * @param entityName entity name
	 */
	public LocationTermChangeActionDaoHibernateImpl(
			final SessionFactory sessionFactory, final String entityName) {
		super(sessionFactory, entityName);
	}

	/* Method implementations. */
	
	/** {@inheritDoc} */
	@Override
	public LocationTermChangeAction find(final String name) {
		LocationTermChangeAction changeAction
				= (LocationTermChangeAction) this.getSessionFactory()
					.getCurrentSession().getNamedQuery(FIND_QUERY_NAME)
						.setParameter(NAME_PARAM_NAME, name)
						.uniqueResult();
		return changeAction;
	}
	
	/** {@inheritDoc} */
	@Override
	public List<LocationTermChangeAction> findAll() {
		@SuppressWarnings("unchecked")
		List<LocationTermChangeAction> changeActions
			= this.getSessionFactory().getCurrentSession()
				.getNamedQuery(FIND_ALL_QUERY_NAME)
				.list();
		return changeActions;
	}
	
	/** {@inheritDoc} */
	@Override
	public List<LocationTermChangeAction> findAllowedForCorrectionalStatus(
			final CorrectionalStatus correctionalStatus) {
		@SuppressWarnings("unchecked")
		List<LocationTermChangeAction> changeActions
			= this.getSessionFactory().getCurrentSession()
				.getNamedQuery(FIND_ALLOWED_FOR_CORRECTIONAL_STATUS_QUERY_NAME)
				.setParameter(CORRECTIONAL_STATUS_PARAM_NAME,
						correctionalStatus)
				.list();
		return changeActions;
	}
}