<!-- 
 - Author: Joel Norris
 - Version: 0.1.0 (May  18, 2015)
 - Since: OMIS 3.0
 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<fmt:bundle basename="omis.incident.msgs.incident">
	<ul>
		<li>
			<a id="createIncidentStatementNoteItemLink" class="createLink" href="${pageContext.request.contextPath}/incident/statement/createIncidentStatementNoteItem.html?incidentStatementNoteIndex=${incidentStatementNoteIndex}"><span class="visibleLinkLabel"><fmt:message key="createIncidentStatementNoteLabel"/></span></a>
		</li>
	</ul>
</fmt:bundle>