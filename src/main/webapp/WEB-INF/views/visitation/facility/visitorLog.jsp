<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<fmt:bundle basename="omis.visitation.msgs.visitation">
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/common/style/general.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/common/style/colors.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/common/style/fonts.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/common/style/list.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/common/style/links.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/common/style/toolbar.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/common/style/form.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/common/style/jquery/ui/jquery-ui.custom.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/common/scripts/ServerConfig.js"> </script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/3rdparty/JQuery/jquery.min.js"> </script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/3rdparty/JQuery/ui/jquery-ui-custom.min.js"> </script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/visitation/scripts/visitorLog.js"> </script>
	<title>
		<fmt:message key="facilityVisitationLogHeader">
			<fmt:param value="${facility.name}"/>
		</fmt:message>
	</title>
</head>
<body>
	<h1>
		<fmt:message key="facilityVisitationLogHeader">
			<fmt:param value="${facility.name}"/>
		</fmt:message>
	</h1>
	<ul id="visitationToolbar" class="toolbar">
		<c:choose>
			<c:when test="${not empty offender}">
				<input type="hidden" id="offender" value="${offender.id}"/>
			</c:when>
			<c:otherwise>
				<%--This should be a link to the previous pertinent navigation screen--%>
				<input type="hidden" id="faciltiy" value="${facility.id}"/>
			</c:otherwise>
		</c:choose>
	</ul>
	<jsp:include page="../includes/changeVisitorLogDatesForm.jsp"/>
	<h2><fmt:message key="visitationLogHeadingLabel"/></h2>
	<jsp:include page="../includes/logListTable.jsp"/>
</body>
</fmt:bundle>
</html>