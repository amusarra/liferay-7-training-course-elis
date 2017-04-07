<%@ include file="init.jsp" %>
<%
	String imageURL = (String) request.getAttribute(HorseWebKeys.HORSE_PHOTO_URL);
%>

<img src="<%=imageURL%>" alt=""/>