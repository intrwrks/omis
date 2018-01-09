<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<fmt:bundle basename="omis.presentenceinvestigation.msgs.educationSectionSummary">
	<ul>
		<sec:authorize access="hasRole('EDUCATION_SECTION_SUMMARY_CREATE') or hasRole('EDUCATION_SECTION_SUMMARY_EDIT') or hasRole('ADMIN')">
			<li>
				<a id="createEducationSectionSummaryNoteItemLink" class="createLink" 
					href="${pageContext.request.contextPath}/presentenceInvestigation/educationSummary/createEducationSectionSummaryNoteItem.html?educationSectionSummaryNoteItemIndex=${educationSectionSummaryNoteItemIndex}"><span class="visibleLinkLabel"><fmt:message key="addEducationSectionSummaryNoteLink"/></span></a>
			</li>
		</sec:authorize>
	</ul>
</fmt:bundle>