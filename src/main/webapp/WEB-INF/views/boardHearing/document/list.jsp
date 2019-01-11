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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<fmt:bundle basename="omis.boardhearing.msgs.boardHearingDocument">
<head>
	<jsp:include page="/WEB-INF/views/common/includes/headerOffenderListResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/headerListResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/toolsResources.jsp"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/boardHearing/scripts/boardHearings.js?VERSION=1"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/boardHearing/style/boardHearing.css" />
	<title>
		<fmt:message key="boardHearingListHeader"/>
	</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/offender/includes/offenderHeader.jsp"/>
	<jsp:include page="/WEB-INF/views/boardHearing/includes/boardHearingHeader.jsp"/>
	<h1 style="margin-top:20px;">
		<a class="actionMenuItem" id="actionMenuLink" href="${pageContext.request.contextPath}/boardHearing/document/boardHearingDocumentsActionMenu.html?boardHearing=${boardHearing.id}"></a>
		<fmt:message key="boardHearingDocumentListHeader"/>
	</h1>
	<jsp:include page="includes/documentListTable.jsp"/>
</body>
</fmt:bundle>
</html>