<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>views/member/list.jsp</h1>
	<h2>회원목록을 확인 (관리자) (spring)</h2>
	
    <table border="1">
      <tr>
        <td>아이디</td>
        <td>이름</td>
        <td>비밀번호</td>
        <td>나이</td>
        <td>성별</td>
        <td>이메일</td>
        <td>가입일</td>
      </tr>
      
	  <c:forEach var="vo" items="${memberList }">      
	      <tr>
	        <td>${vo.userid }</td>
	        <td>${vo.username }</td>
	        <td>${vo.userpw }</td>
	        <td>${vo.useremail }</td>
	        <td>${vo.regdate }</td>
	      </tr>
      </c:forEach>
      
    </table>
    
    <h2><a href="./main">메인페이지로...</a></h2>
    


</body>
</html>