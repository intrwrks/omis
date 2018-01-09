<%--
  - Action menu for location reason term screen.
  -
  - Author: Stephen Abson
  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<fmt:setBundle basename="omis.locationterm.msgs.profile" var="profileBundle"/>
<fmt:bundle basename="omis.locationterm.msgs.locationReasonTerm">
<ul>
	<sec:authorize access="hasRole('LOCATION_REASON_TERM_LIST') or hasRole('ADMIN')">
		<li><a class="listLink" href="${pageContext.request.contextPath}/locationTerm/locationReasonTerm/list.html?offender=${offender.id}"><span class="visibleLinkLabel"><fmt:message key="listLocationReasonTermsLink"/></span></a></li>
	</sec:authorize>
	<sec:authorize access="hasRole('LOCATION_TERM_PROFILE_VIEW') or hasRole('ADMIN')">
		<li><a class="locationTermProfileLink" href="${pageContext.request.contextPath}/locationTerm/profile.html?offender=${offender.id}"><span class="visibleLinkLabel"><fmt:message key="locationTermProfileHeader" bundle="${profileBundle}"/></span></a></li>
	</sec:authorize>
</ul>
</fmt:bundle>