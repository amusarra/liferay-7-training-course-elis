<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Horse horseEntry = null;
	if (row != null) {
		horseEntry = (Horse)row.getObject();
	}
	else {
		horseEntry = (Horse)request.getAttribute(HorseWebKeys.HORSE_ENTRY);
	}
%>

<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">

	<portlet:renderURL var="editEntryURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="horseEntryId" value="<%= String.valueOf(horseEntry.getHorseId()) %>" />
		<portlet:param name="mvcRenderCommandName" value="/horse/edit"/>
	</portlet:renderURL>

	<portlet:renderURL var="photoEntryURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="horseEntryId" value="<%= String.valueOf(horseEntry.getHorseId()) %>" />
		<portlet:param name="mvcRenderCommandName" value="/horse/photo"/>
	</portlet:renderURL>

	<portlet:actionURL name="/horse/delete" var="deleteEntryURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="horseEntryId" value="<%= String.valueOf(horseEntry.getHorseId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon
			alt="alt-edit-entry-action"
			label="<%=true%>"
			message="message-edit-entry-action"
			toolTip="tool-tip-edit-entry-action"
			iconCssClass="icon-edit"
			markupView="lexicon"
			url="<%= editEntryURL %>"
	/>
	<liferay-ui:icon
			alt="alt-delete-entry-action"
			label="<%=true%>"
			message="message-delete-entry-action"
			toolTip="tool-tip-delete-entry-action"
			iconCssClass="icon-remove"
			markupView="lexicon"
			url="<%= deleteEntryURL %>"
	/>
	<liferay-ui:icon
			alt="alt-photo-entry-action"
			label="<%=true%>"
			message="message-photo-entry-action"
			toolTip="tool-tip-photo-entry-action"
			iconCssClass="icon-camera"
			markupView="lexicon"
			url="<%= photoEntryURL %>"
	        useDialog="<%=true%>"
	/>
</liferay-ui:icon-menu>