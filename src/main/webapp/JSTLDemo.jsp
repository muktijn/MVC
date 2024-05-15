<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	List<String> names = new ArrayList<String>();
names.add("ram");
names.add("sham");
%>

<%
	String url="/signout.jsp";
%>
	<c:out value="${1+2}"></c:out>
	<c:set var="temp" value="${100}"></c:set><br>
	<c:out value="${temp}"></c:out><br>
	<c:out value="${variable}"></c:out>
	<h1> IF </h1>
	<c:if test="${temp>100}">
		<h1>Temp is less then 100</h1>
	 </c:if>
	 
	 <h1> Choose </h1>
	 <c:choose>
	 	<c:when test="${ temp >100 }"> <h1>Temp is greater then 100</h1></c:when>
	 	<c:when test="${ temp <100 }"><h1>Temp is less then 100</h1></c:when>
	 	<c:otherwise> Temp is 100 </c:otherwise>
	 </c:choose>
	 <h1> URL </h1>
	 <a href="<c:url value="${url}"> </c:url>">This is link</a>
	 <h1> For Loop </h1>
	 <c:forEach var="i" begin="1" end="10">
	 	i value <c:out value="${i}"></c:out> <br>
	 </c:forEach>
	  <h1> For Loop for List </h1>
	 <c:forEach var="name" items="${names}" varStatus="java.util.List">
	 		<c:out value="${name}"></c:out>
	 </c:forEach>
</body>
</html>