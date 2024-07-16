<%@page import="vo.Personvo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Personvo p = new Personvo("홍길동", 30, "서울 관악 남부순환로");
	
	pageContext.setAttribute("p", p);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	p's info
<hr>
<!-- 객체 내의 속성표현방법 : .(dot)표현법 -->
이름: ${ pageScope.p.name } <br> <!-- p.getName() call -->
나이: ${ p.age } <br>
<!-- square bracket [] -->
주소: ${ p['addr'] } <br>
</body>
</html>