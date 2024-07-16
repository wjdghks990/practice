<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <!-- 태그 라이브러리 -->   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>
	Java + HTML
<hr>
<%
	for(int i=0; i<5; i++) {
%>
 나 d.jsp얌!<br>
<%
	}
%> 

<hr>
	Tag 언어(TagLibrary)
<hr>
<c:forEach begin="1" end="5">
	나 d.jsp얌!<br>
</c:forEach>
	
</body>
</html>