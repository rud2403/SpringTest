<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF/views/productDetail.jsp</h1>
	
	컨트롤러에서 전달된 객체 정보
	<h2>${test }</h2>
	
	<hr>
	<h2>상품 객체</h2>
	<h2>${vo.name }</h2>

	<h4>상품명 : ${vo.name }</h4>	
	<h4>상품가격 : ${vo.price }</h4>	
	
	<hr>
	
	<h1> 전달되는 속성의 key값이 없을 경우 클래스명의 첫글자만 소문자로 변경</h1>
	
	<h2>${productVO }</h2>
	<h4>상품명 : ${productVO.name }</h4>
	<h4>가격 : ${productVO.price }</h4>
</body>
</html>