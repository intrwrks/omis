<?xml version="1.0" encoding="UTF-8"?>
<%--
 - Author: Yidong Li
 - Version: 0.1.0 (Feb 9, 2014)
 - Since: OMIS 3.0
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<fmt:setBundle basename="omis.employment.msgs.employment" var="employment"/>
	<fmt:bundle basename="omis.employment.msgs.form">
	<head>
		<title>
			<fmt:message key="employmentLabel" bundle="${employment}"/>
			<jsp:include page="/WEB-INF/views/offender/includes/offenderNameSummary.jsp"/>
		</title>
		<jsp:include page="/WEB-INF/views/common/includes/headerOffenderListResources.jsp"/>
		<jsp:include page="/WEB-INF/views/common/includes/toolsResources.jsp"/>
		<jsp:include page="/WEB-INF/views/common/includes/linksResources.jsp"/>
		<jsp:include page="/WEB-INF/views/common/includes/messageResolverResources.jsp"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/employment/scripts/employments.js"> </script>
	</head>
	<body>
		<c:if test="${not empty offenderSummary}">
			<jsp:include page="/WEB-INF/views/offender/includes/offenderHeader.jsp"/>
		</c:if>
			<h1>
				<a class="actionMenuItem" id="actionMenuLink" href="${pageContext.request.contextPath}/employment/employmentsActionMenu.html?offender=${offender.id}"></a><span class="visibleLinkLabel"/>
				<fmt:message key="employmentHistoryTitle" bundle="${employment}"/>
			</h1>
		<jsp:include page="includes/listTable.jsp"/>	
	</body>
	</fmt:bundle>
</html>