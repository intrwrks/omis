<!-- 
 - Author: Josh Divine
 - Version: 0.1.0 (Dec 8, 2016)
 - Since: OMIS 3.0
 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="/WEB-INF/tld/omis.tld" prefix="omis" %>
<fmt:setBundle basename="omis.nocr.msgs.nocr" var="nocr"/>
<fmt:bundle basename="omis.nocr.msgs.basicInformation">
	<ul>
		<li>
			<span><fmt:message key="facilityLabel" bundle="${nocr}"/></span>
			<ul>
				<li><span><fmt:message key="noneAtThisTimeLabel" bundle="${nocr}"/></span></li>
				<%--<li><omis:report reportPath="" decorate="no" title="" className="newTab reportLink"><fmt:message key="facilityAlphaAliasReportLinkLabel"/></omis:report></li>--%>
			</ul>
		</li>
		<li>
			<span><fmt:message key="communityLabel" bundle="${nocr}"/></span>
			<ul>
				<li><span><fmt:message key="noneAtThisTimeLabel" bundle="${nocr}"/></span></li>
				<%--<li><omis:report reportPath="" decorate="no" title="" className="newTab reportLink"><fmt:message key="communityAlphaAliasReportLinkLabel"/></omis:report></li>--%>
			</ul>
		</li>
	    <li>
			<span><fmt:message key="combinedLabel" bundle="${nocr}"/></span>
			<ul>
				<li><omis:reportPro reportPath="/BasicInformation/AlternativeNames/Name_Search" decorate="no" title="" className="newTab reportLink"><fmt:message key="combinedNameSearchReportLinkLabel"/></omis:reportPro></li>
				<%--<li><omis:report reportPath="" decorate="no" title="" className="newTab reportLink"><fmt:message key="combinedIdentificationNumbersReportLinkLabel"/></omis:report></li>--%>
			</ul>
		</li>
	</ul>
</fmt:bundle>