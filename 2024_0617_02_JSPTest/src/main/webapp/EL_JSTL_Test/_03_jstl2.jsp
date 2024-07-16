<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!-- JSTL Core -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="i" begin="1" end="5" step="1">
	<c:if test="${ i%2==1 }">
	<font color="red">${ i } : 안녕</font><br>
	</c:if>
	<c:if test="${ i%2==0 }">
	<font color="blue">${ i } : 안녕</font><br>
	</c:if>
</c:forEach>


</body>
</html>