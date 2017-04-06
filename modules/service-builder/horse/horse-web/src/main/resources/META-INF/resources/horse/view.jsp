<%@ page import="it.dontesta.labs.liferay.elis.portlet.horse.configuration.util.HorseConfigurationValues" %>
<%@ include file="init.jsp" %>

<%
 PortletURL viewIteratorURL = renderResponse.createRenderURL();
 viewIteratorURL.setParameter("mvcPath", "/horse/view.jsp");

 /* Sorting */
 String orderByCol = ParamUtil.getString(request, "orderByCol");
 String orderByType = ParamUtil.getString(request, "orderByType");

 if (orderByCol == null || orderByCol.equals(StringPool.BLANK)) {
  orderByCol = "name";
 }

 if (orderByType == null || orderByType.equals(StringPool.BLANK)) {
  orderByType = "asc";
 }

 String displayStyle = "list";
%>

<portlet:renderURL var="addHorse">
 <portlet:param name="mvcRenderCommandName" value="/horse/add"/>
</portlet:renderURL>

<portlet:renderURL var="addHorseWithPhoto">
 <portlet:param name="photo" value="true"/>
 <portlet:param name="mvcRenderCommandName" value="/horse/photo"/>
</portlet:renderURL>


<div class="container-fluid-1280 main-content-body">

 <liferay-ui:search-container delta="<%=HorseConfigurationValues.HORSE_SEARCH_CONTAINER_PAGE_DEFAULT_DELTA%>" deltaConfigurable="true"
                              orderByCol="<%= orderByCol %>" orderByType="<%= orderByType %>" total="<%=HorseLocalServiceUtil.getHorsesCount()%>"
                              emptyResultsMessage="no-horse-found"
                              iteratorURL="<%=viewIteratorURL %>" >
  <liferay-ui:search-container-results results="<%= HorseLocalServiceUtil.getHorses(searchContainer.getStart(), searchContainer.getEnd()) %>" />

  <liferay-ui:search-container-row className="it.dontesta.labs.liferay.elis.servicebuilder.model.Horse" modelVar="horse" keyProperty="horseId" >
   <portlet:renderURL var="rowURL">
    <portlet:param name="backURL" value="<%=currentURL %>" />
    <portlet:param name="horseId" value="${horse.horseId}" />
    <portlet:param name="mvcRenderCommandName" value="/horse/view_entry"/>
   </portlet:renderURL>
   <liferay-ui:search-container-column-text property="name" name="horse-name" orderable="true" orderableProperty="name" href="${rowURL}"/>
   <liferay-ui:search-container-column-text property="kind" name="horse-kind" orderable="true" orderableProperty="kind"/>
   <liferay-ui:search-container-column-text property="age" name="horse-age" />
   <liferay-ui:search-container-column-text property="mantle" name="horse-mantle"/>
   <liferay-ui:search-container-column-text property="gender" name="horse-gender"/>
   <liferay-ui:search-container-column-date property="dateOfBirth" name="date-of-birth"/>
   <liferay-ui:search-container-column-jsp align="right"
           path="/horse/entry_action.jsp"
   />
  </liferay-ui:search-container-row>
  <liferay-ui:search-iterator/>
 </liferay-ui:search-container>

 <liferay-frontend:add-menu >
  <liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add-horse") %>' url="<%=addHorse%>"/>
  <liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add-horse-with-photo") %>' url="<%=addHorseWithPhoto%>"/>
</liferay-frontend:add-menu>

</div>