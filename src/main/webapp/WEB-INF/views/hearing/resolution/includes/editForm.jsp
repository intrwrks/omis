<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<sec:authorize var="editResolution" access="hasRole('VIOLATION_EDIT') or hasRole('ADMIN') or hasRole('VIOLATION_CREATE')"/>
<fmt:setBundle basename="omis.msgs.common" var="commonBundle"/>
<fmt:bundle basename="omis.hearing.msgs.hearing">
<form:form commandName="resolutionForm" class="editForm">
	<form:input type="hidden" path="resolutionCategory" />
	<c:choose>
		<c:when test="${resolutionCategory eq 'FORMAL'}">
			<fieldset>
				<span class="fieldGroup">
					<form:label path="date" class="fieldLabel">
						<fmt:message key="hearingDateLabel"/>
					</form:label>
					<form:input path="date" class="date"/>
					<form:errors path="date" cssClass="error"/>
				</span>
			</fieldset>
			
			<fieldset>
				<legend>
					<fmt:message key="hearingStatusLabel" />
				</legend>
				<span class="fieldGroup">
					<form:label path="category" class="fieldLabel">
						<fmt:message key="categoryLabel"/>
					</form:label>
					<form:select path="category" readonly="true">
						<jsp:include page="../../../includes/nullOption.jsp"/>
						<c:forEach items="${hearingStatusCategories}" var="cat">
							<option value="${cat}" ${cat == resolutionForm.category ? 'selected="selected"' : ''}>
								<fmt:message key="${cat.name}StatusLabel"/>
							</option>
						</c:forEach>
					</form:select>
					<form:errors path="category" cssClass="error"/>
				</span>
				<span class="fieldGroup">
					<form:label path="statusDescription" class="fieldLabel">
						<fmt:message key="statusDescriptionLabel"/>
					</form:label>
					<form:textarea path="statusDescription"/>
					<form:errors path="statusDescription" cssClass="error"/>
				</span>
			</fieldset>
		</c:when>
	</c:choose>
	<fieldset>
	<legend>
		<fmt:message key="violationsLabel" />
	</legend>
	<c:choose>
		<c:when test="${fn:length(resolutionForm.violationItems) gt 1}">
			<span class="fieldGroup">
				<label for="groupEdit.false" class="fieldLabel">
					<fmt:message key="groupEditFalseLabel"/>
				</label>
				<form:radiobutton path="groupEdit" value="false" class="fieldValue"/>
				<label for="groupEdit.true" class="fieldLabel">
					<fmt:message key="groupEditTrueLabel"/>
				</label>
				<form:radiobutton path="groupEdit" value="true" class="fieldValue"/>
			</span>
			<span id="groupViolationDescription" class="violationDescription" style="display:none;"></span>
			<span id="groupViolations" style="display:none;"></span>
		</c:when>
		<c:otherwise>
			<form:input type="hidden" path="groupEdit" />
		</c:otherwise>
	</c:choose>
	<c:forEach var="violationItem" items="${resolutionForm.violationItems}" varStatus="status">
		<c:set var="i" value="${status.index}" />
		<div class="violationItem" >
		<form:input type="hidden" path="violationItems[${i}].infraction" />
		<form:input type="hidden" path="violationItems[${i}].disciplinaryCodeViolation" />
		<form:input type="hidden" path="violationItems[${i}].conditionViolation" />
		
		<div id="violationDescription${i}" class="violationDescription" >
			<span class="fieldGroup">
				<label class="fieldLabel">
					<fmt:message key="violationDescriptionLabel"/>
				</label>
				<span class="violationDescriptionNoOverflow">
					<c:out value="${violationItem.summary.violationEventDetails}" />
					<span class="hideOverflow"></span>
				</span>
				<span class="showOverflow"></span>
			</span>
		</div>
		<div id="violation${i}" class="violation">
			<span class="fieldGroup">
				<label class="fieldLabel">
					<fmt:message key="violationLabel"/>
				</label>
				<c:out value="${not empty violationItem.summary.conditionClause
					? violationItem.summary.conditionClause
					: violationItem.summary.disciplinaryCodeDescription}" />
			</span>
		</div>
		
		<span class="fieldGroup">
			<form:label path="violationItems[${i}].date" class="fieldLabel">
				<fmt:message key="dateLabel"/>
			</form:label>
			<form:input path="violationItems[${i}].date" class="date"/>
			<form:errors path="violationItems[${i}].date" cssClass="error"/>
		</span>
		<span class="fieldGroup">
			<form:label path="violationItems[${i}].authority" class="fieldLabel">
				<fmt:message key="authorityLabel"/>
			</form:label>
			<input id="authorityInput${i}"/>
				<form:hidden id="violationItems[${i}].authority" path="violationItems[${i}].authority"/>
				<a id="clearAuthority${i}" class="clearLink"></a>
			<span id="authorityDisplay${i}">
				<c:if test="${not empty violationItem.authority}" >
					<c:out value="${violationItem.authority.name.lastName}, ${violationItem.authority.name.firstName}"/>
				</c:if>
			</span>
			<form:errors path="violationItems[${i}].authority" cssClass="error"/>
		</span>
		<c:choose>
			<c:when test="${resolutionCategory eq 'INFORMAL'
							or resolutionCategory eq 'DISMISSED'}">
				<span class="fieldGroup">
					<form:label path="violationItems[${i}].decision" class="fieldLabel">
						<fmt:message key="decisionLabel"/>
					</form:label>
					<form:textarea path="violationItems[${i}].decision"/>
					<form:errors path="violationItems[${i}].decision" cssClass="error"/>
				</span>
			</c:when>
		</c:choose>
		<span class="fieldGroup">
			<form:label path="violationItems[${i}].reason" class="fieldLabel">
				<fmt:message key="reasonLabel"/>
			</form:label>
			<form:textarea path="violationItems[${i}].reason"/>
			<form:errors path="violationItems[${i}].reason" cssClass="error"/>
		</span>
		<c:choose>
			<c:when test="${resolutionCategory eq 'INFORMAL'
							or resolutionCategory eq 'FORMAL'}">
				<c:choose>
					<c:when test="${resolutionCategory eq 'FORMAL'}">
						<span class="fieldGroup">
							<form:label path="violationItems[${i}].disposition" class="fieldLabel">
								<fmt:message key="dispositionLabel"/>
							</form:label>
							<form:select path="violationItems[${i}].disposition" class="disposition">
								<jsp:include page="../../../includes/nullOption.jsp"/>
								<c:forEach items="${dispositionCategories}" var="disposition">
									<option value="${disposition}" ${disposition == resolutionForm.violationItems[i].disposition ? 'selected="selected"' : ''}>
										<fmt:message key="${disposition.name}DispositionLabel"/>
									</option>
								</c:forEach>
							</form:select>
							<form:errors path="violationItems[${i}].disposition" cssClass="error"/>
						</span>
					</c:when>
				</c:choose>
				<span class="fieldGroup">
					<c:if test="${resolutionCategory eq 'FORMAL'}">
						<fmt:message key='sanctionOnGuiltyLabel' var="placeholder"/>
					</c:if>
					<form:label path="violationItem.sanction" class="fieldLabel">
						<fmt:message key="sanctionLabel"/>
					</form:label>
					<c:choose>
						<c:when test="${(not (violationItem.disposition eq 'GUILTY')) and resolutionCategory eq 'FORMAL'}">
							<form:textarea path="violationItems[${i}].sanction" readOnly="true" placeholder="${placeholder}"/>
						</c:when>
						<c:otherwise>
							<form:textarea path="violationItems[${i}].sanction" placeholder="${placeholder}" />
						</c:otherwise>
					</c:choose>
					<form:errors path="violationItems[${i}].sanction" cssClass="error"/>
				</span>
			</c:when>
		</c:choose>
		<c:if test="${not empty violationItem.infraction.resolution.date}">
			<span class="fieldGroup">
				<form:label path="violationItems[${i}].appealDate" class="fieldLabel">
					<fmt:message key="appealDateLabel"/>
				</form:label>
				<form:input path="violationItems[${i}].appealDate" class="date"/>
				<form:errors path="violationItems[${i}].appealDate" cssClass="error"/>
			</span>
		</c:if>
		</div>
	</c:forEach>
	</fieldset>
	
<c:if test="${editResolution}">
	<p class="buttons">
		<input type="submit" value="<fmt:message key='saveLabel' bundle='${commonBundle}'/>"/>
	</p>
</c:if>
</form:form>
</fmt:bundle>