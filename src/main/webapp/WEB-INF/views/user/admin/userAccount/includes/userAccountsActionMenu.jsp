<%--
 - Action menu for user accounts.
 -
 - Author: Stephen Abson
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<fmt:bundle basename="omis.user.msgs.userAccount">
<ul>
	<li><a class="userAdminLink" href="${pageContext.request.contextPath}/user/admin/index.html"><fmt:message key="userAdminIndexLink"/></a></li>
	<sec:authorize access="hasRole('ADMIN') or hasRole('USER_ACCOUNT_CREATE')">
		<li><a class="createLink" href="${pageContext.request.contextPath}/user/admin/userAccount/create.html?user=${user.id}"><fmt:message key="createUserAccountLink"/></a></li>
	</sec:authorize>
	<sec:authorize access="hasRole('ADMIN') or hasRole('USER_SEARCH')">
		<li><a class="searchLink" href="${pageContext.request.contextPath}/user/search.html"><fmt:message key="userSearchLink"/></a></li>
	</sec:authorize>
</ul>
</fmt:bundle>