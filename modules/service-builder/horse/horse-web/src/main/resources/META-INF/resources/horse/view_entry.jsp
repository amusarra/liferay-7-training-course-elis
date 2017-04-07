<%@ include file="init.jsp" %>

<%
	String backURL = (String)request.getAttribute("backURL");
%>
<div class="container-fluid-1280 main-content-body">
	<liferay-ui:header title="to-back" backURL="<%=backURL%>" backLabel="to-back"></liferay-ui:header>
	<liferay-ui:message key="to-be-implements"></liferay-ui:message>
</div>