<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	// 각 영역(Scope)에 데이터를 저장(binding) 위에서부터 참조 순서
	//						  key	  value
	pageContext.setAttribute("msg", "PageContext에 저장된 변수");

	request.setAttribute("msg", "request에 저장된 변수");
	
	session.setAttribute("msg", "session에 저장된 변수");
	
	application.setAttribute("msg", "application에 저장된 변수");
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--${ 영역이름.변수 }--%>
<!-- 영역이름을 생략하면 참조순서는
pageScope->< requestScope -> sessionScope -> applicationScope
 -->

pageScope : ${ pageScope.msg } <br>
requestScope : ${ requestScope.msg } <br>
sessionScope : ${ sessionScope.msg } <br>
applicationScope : ${ applicationScope.msg } <br>

</body>
</html>