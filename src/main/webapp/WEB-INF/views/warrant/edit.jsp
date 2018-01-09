<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<fmt:bundle basename="omis.warrant.msgs.warrant">
<head>
	<jsp:include page="/WEB-INF/views/common/includes/headerOffenderFormResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/toolsResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/searchResources.jsp"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/warrant/scripts/includes/jquery.omis.warrant.js?VERSION=1"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/warrant/scripts/warrant.js?VERSION=1"></script>
	<script type="text/javascript">
		var currentWarrantNoteItemIndex = ${warrantNoteItemIndex};
		var currentWarrantCauseViolationItemIndex = ${warrantCauseViolationItemIndex};
	</script>
	<title>
		<c:if test="${empty warrant}">
			<fmt:message key="create${warrantReasonCategory}Header"/>
		</c:if>
		<c:if test="${not empty warrant}">
			<fmt:message key="edit${warrantReasonCategory}Header" />
		</c:if>
		<jsp:include page="/WEB-INF/views/offender/includes/offenderNameSummary.jsp"/>
	</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/offender/includes/offenderHeader.jsp"/>
	<h1>
		<a class="actionMenuItem" id="actionMenuLink" href="${pageContext.request.contextPath}/warrant/warrantActionMenu.html?offender=${offender.id}"></a>
		<c:if test="${empty warrant}">
			<fmt:message key="create${warrantReasonCategory}Header"/>
		</c:if>
		<c:if test="${not empty warrant}">
			<fmt:message key="edit${warrantReasonCategory}Header" />
		</c:if>
	</h1>
	<jsp:include page="includes/editForm.jsp"/>
</body>
</fmt:bundle>
</html>