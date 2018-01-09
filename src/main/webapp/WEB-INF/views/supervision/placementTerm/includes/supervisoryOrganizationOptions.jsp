<%--
 - OMIS - Offender Management Information System
 - Copyright (C) 2011 - 2017 State of Montana
 -
 - This program is free software: you can redistribute it and/or modify
 - it under the terms of the GNU General Public License as published by
 - the Free Software Foundation, either version 3 of the License, or
 - (at your option) any later version.
 -
 - This program is distributed in the hope that it will be useful,
 - but WITHOUT ANY WARRANTY; without even the implied warranty of
 - MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 - GNU General Public License for more details.
 -
 - You should have received a copy of the GNU General Public License
 - along with this program.  If not, see <http://www.gnu.org/licenses/>.
 --%>

<%--
 - Supervisory orgnaization options.
 -
 - Author: Stephen Abson
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setBundle basename="omis.msgs.common" var="commonBundle"/>
	<option value=""><fmt:message key="nullLabel" bundle="${commonBundle}"/></option>
<c:forEach var="supervisoryOrganization" items="${allowedSupervisoryOrganizations}">
	<c:choose>
	<c:when test="${not empty defaultSupervisoryOrganization and defaultSupervisoryOrganization eq supervisoryOrganization}">
		<option value="${supervisoryOrganization.id}" selected="selected"><c:out value="${supervisoryOrganization.name}"/></option>
	</c:when>
	<c:otherwise>
		<option value="${supervisoryOrganization.id}"><c:out value="${supervisoryOrganization.name}"/></option>
	</c:otherwise>
	</c:choose>
</c:forEach>