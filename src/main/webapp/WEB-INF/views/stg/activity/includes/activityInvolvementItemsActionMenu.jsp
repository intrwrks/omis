<%-- Author: Trevor Isles --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<fmt:bundle basename="omis.stg.msgs.stg">
<ul>
	<sec:authorize access="hasRole('STG_ACTIVITY_LIST') or hasRole('ADMIN')">
		<li>
			<a id="createActivityInvolvementItemLink" class="createLink" href="${pageContext.request.contextPath}/stg/activity/createActivityInvolvementItem.html?activityInvolvementItemIndex=${activityInvolvementsItemIndex}">
			<span class="visibleLinkLabel"><fmt:message key="createActivityInvolvementLabel"/></span></a>
		</li>
	</sec:authorize>
</ul>
</fmt:bundle>