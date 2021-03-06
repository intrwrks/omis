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
 - Author: Josh Divine
 - Version: 0.1.0 (Dec 20, 2017)
 - Since: OMIS 3.0
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<fmt:bundle basename="omis.hearinganalysis.msgs.hearingAnalysis">
<head>
	<title>
		<c:choose>
			<c:when test="${not empty hearingAnalysis}">
				<fmt:message key="editHearingAnalysisTitle"/>
			</c:when>
			<c:otherwise>
				<fmt:message key="createHearingAnalysisTitle"/>
			</c:otherwise>
		</c:choose>
	</title>
	<jsp:include page="/WEB-INF/views/common/includes/headerOffenderFormResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/jQueryResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/serverConfigResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/messageResolverResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/toolsResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/searchResources.jsp"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/common/scripts/SessionConfig.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/hearingAnalysis/scripts/JQuery/jquery.omis.hearingAnalysis.js?VERSION=1"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/hearingAnalysis/scripts/hearingAnalysis.js?VERSION=2"></script>
	<script type="text/javascript">
		//Track current indexes
		var currentHearingAnalysisNoteIndex = ${hearingAnalysisNoteIndex};
    </script>
</head>

<body>
	<jsp:include page="/WEB-INF/views/offender/includes/offenderHeader.jsp"/>
	<h1>
		<a class="actionMenuItem" id="actionMenuLink" href="${pageContext.request.contextPath}/hearingAnalysis/hearingAnalysisActionMenu.html?paroleEligibility=${eligibility.id}"></a>
		<c:choose>
			<c:when test="${not empty hearingAnalysis}">
				<fmt:message key="editHearingAnalysisTitle"/>
			</c:when>
			<c:otherwise>
				<fmt:message key="createHearingAnalysisTitle"/>
			</c:otherwise>
		</c:choose>
	</h1>
	<jsp:include page="includes/editForm.jsp"/>
</body>
</fmt:bundle>
</html>