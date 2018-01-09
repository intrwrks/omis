<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="omis.msgs.common" var="commonBundle"/>
<fmt:bundle basename="omis.hearing.msgs.hearing">
<c:forEach var="summary" items="${unresolvedViolationSummaries}">
<tr class="violationItemRow">
	<td>
		<fmt:message key="${summary.violationEventCategory}CategoryLabel"/>
	</td>
	<td>
		<span class="violationDescriptionNoOverflow">
			<c:out value="${summary.violationEventDetails}" />
			<span class="hideOverflow"></span>
		</span>
		<span class="showOverflow"></span>
	</td>
	<td>
		<c:choose>
			<c:when test="${not empty summary.disciplinaryCodeDescription}">
				<c:out value="${summary.disciplinaryCodeDescription}"/>
			</c:when>
			<c:when test="${not empty summary.conditionClause}">
				<c:out value="${summary.conditionClause}"/>
			</c:when>
		</c:choose>
	</td>
</tr>
</c:forEach>
</fmt:bundle>	