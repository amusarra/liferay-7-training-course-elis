<%@ include file="/horse/init.jsp" %>
<div class="container-fluid-1280 main-content-body">



<liferay-frontend:add-menu >
 <liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request,
 "add-leave") %>' url="<%=addLeaveJSP%>" />
</liferay-frontend:add-menu>

</div>