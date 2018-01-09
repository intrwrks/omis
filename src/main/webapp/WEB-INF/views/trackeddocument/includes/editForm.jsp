<%--
 - Author: Yidong Li
 - Version: 0.1.1 (Dec 18, 2017)
 - Since: OMIS 3.0
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:setBundle basename="omis.msgs.common" var="commonBundle"/>
<fmt:bundle basename="omis.trackeddocument.msgs.trackedDocument">
<form:form commandName="trackedDocumentForm" class="editForm">
	<form:hidden path="createUserAccount"/>
	<fieldset>
		<span class="fieldGroup">
		 <c:choose>
			<c:when test="${createFlag}">
				<form:label path="docket" class="fieldLabel">
					<fmt:message key="createDocketLabel"></fmt:message>
				</form:label>
				<form:select path="docket">
					<option value="">...</option>
					<c:forEach var="docket" items="${dockets}">
					<form:option value="${docket.id}"><c:out value="${docket.value} ${docket.court.location.address.value}"/></form:option>
					</c:forEach>
				</form:select>				
				<form:errors path="docket" cssClass="error"/>
			</c:when>
			<c:otherwise>
				<fmt:message key="existingDocketLabel"> </fmt:message><c:out value="${trackedDocumentForm.docket.value}"/><c:out value="${trackedDocumentForm.docket.court.location.address.value }"/>
			</c:otherwise>
		</c:choose>
		</span>
	</fieldset>
	<table id="trackedDocumentEditTable" class="editTable">
		<thead>
			<tr>
				<th class="operation">
					<a class="actionMenuItem" id="trackedDocumentEditTableActionMenuLink" href="${pageContext.request.contextPath}/trackedDocument/trackedDocumentEditTableActionMenu.html?offender=${offender.id}"></a>
				</th>			
				<th><fmt:message key="documentLabel"/></th>
				<th><fmt:message key="receivedDateLabel"/></th>
				<th><fmt:message key="receivedByLabel"/></th>
			</tr>
		</thead>
		<tbody id="trackedDocumentReceivalBody">
			<c:forEach var="trackedDocumentReceivalItem" items="${trackedDocumentForm.trackedDocumentReceivalItems}" varStatus="status">
				<c:set var="trackedDocumentReceivalItem" value="${trackedDocumentReceivalItem}" scope="request"/>
				<c:set var="trackedDocumentReceivalIndex" value="${status.index}" scope="request"/>
				<c:if test="${trackedDocumentReceivalItem.operation!=null}">
					<jsp:include page="/WEB-INF/views/trackeddocument/includes/createTrackedDocumentsTableRow.jsp"/>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<p class="buttons">
		<input id="saveButton" type="submit" value="<fmt:message key='saveLabel' bundle="${commonBundle}"/>"/>
	</p>
</form:form>
</fmt:bundle>