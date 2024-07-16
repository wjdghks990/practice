<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	//ScriptLet : Java Code 영역
	// _jspService(request,response)안에 코딩되는 것. -> request,response활용히야 호출 가능
	
	// JSP내장객체 : JSP->Servlet변환시 내부에 존재하는 객체
	//			   request/response
	//			   session/application
	// 			   pageContext
	//			   out
	
	// /member_resgister.do?name=홍길동&id=asdf1&pwd=1234&gender=남자&
	// firend=&firend=&firend=&blood=A형&profile=3
	
	// 0. 수신인코딩 설정
	request.setCharacterEncoding("utf-8");
	
	// 1. parameter 받기
	String name 	= request.getParameter("name");
	String id 		= request.getParameter("id");
	String pwd 		= request.getParameter("pwd");
	String gender 	= request.getParameter("gender");
	String blood 	= request.getParameter("blood");
	String profile 	= request.getParameter("profile");
	
	// parameter이름이 동일한 이름으로 들어온 경우에는 배열로 받는다
	// checkbox : 체크된 목록만 넘어온다(체크항목이 없으면 null)
	String[] hobbyArr  = request.getParameterValues("hobby");	
	//						hobby=독서&hobby=영화
	//							0		1
	// String[] hobbyArr  = {"독서","영화"};
	
	//취미목록
	String hobbyList = "취미없음";
	if(hobbyArr != null) {
		
		StringBuffer sb = new StringBuffer();
		for(String hobby : hobbyArr) {
			// 메모리 낭비 줄임
			sb.append(hobby);
			sb.append(" ");
		}
		
		hobbyList = sb.toString().trim();
	}
//		-------------------------------------------------------------------------------		
	
	// input : 모든값이 넘어옴
	String[] friendArr = request.getParameterValues("friend");
	//					 friend=&friend=&friend=
	// String[] friendArr = {"", "", ""}; 	
	String friendList = "";
	
	StringBuffer sb1 = new StringBuffer(); // StringBuffer(느리다) vs StringBulider(빠르다)
	for(String friend : friendArr) {
		sb1.append(friend);
		sb1.append(" ");
	}
	
	friendList = sb1.toString().trim();
	
	if(friendList.isEmpty()) friendList = "친구없음";
%>    
    
<!-- 결과전송 -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- BootStrap 3.x -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	#box {
		width: 500px;
		margin: auto;
		margin-top: 50px;
		box-shadow: 1px 1px 2px black;
	}
	
	th {
		background: #333333;
		color: white;
	}
	
	th:hover {
		background: gray;
	}
</style>

</head>
<body>
<div id="box">
	<table class="table table-hover table-bordered" >
		<tr>
			<th>이름</th>
			<td><%= name %></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><% out.print(id); %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><% out.print(pwd); %></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%= gender %></td>
		</tr>
		<tr>
			<th>취미</th>
			<td><%= hobbyList %></td>
		</tr>
		<tr>
			<th>친구</th>
			<td><%= friendList %></td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td><%= blood %></td>
		</tr>
		<tr>
			<th>자기소개</th>
			<td><%= profile %></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<button class="btn btn-info" onclick="location.href='input.html'">다시하기</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>