<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<fmt:setBundle basename="omis.msgs.common" var="commonBundle" />
<fmt:bundle basename="omis.education.msgs.educationDocument">
	<ul>
		<sec:authorize access="hasRole('EDUCATION_CREATE') or hasRole('ADMIN')">
			<li>
				<a class="createLink" href="${pageContext.request.contextPath}/education/document/create.html?offender=${offender.id}"><span class="visibleLinkLabel"><fmt:message key="createEducationDocumentLink"/></span></a>
			</li>
		</sec:authorize>
	</ul>
</fmt:bundle>