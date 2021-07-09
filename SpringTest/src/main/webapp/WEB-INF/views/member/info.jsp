<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>WebContent/member/info.jsp</h1>
  
  <h2> 회원정보 조회 (spring) </h2>
  <%
    //DB에서 전달받은 정보를 저장(model 객체)
    // model.addAttribute("infoVO", infoVO); 이렇게 받아온 걸 이 jsp 에서 사용
  %>
  
  
  <table border="1">
    <tr>
      <td>아이디</td>
      <td>${infoVO.userid }</td>
    </tr>
    <tr>
      <td>비밀번호</td>
      <td>${infoVO.userpw }</td>
    </tr>
    <tr>
      <td>이름</td>
      <td>${infoVO.username }</td>
    </tr>
    <tr>
      <td>이메일</td>
      <td>${infoVO.useremail }</td>
    </tr>
   <tr>
      <td>가입일자</td>
      <td>${infoVO.regdate }</td>
    </tr>
  </table>
  
  <h3><a href="./main">메인페이지로</a></h3>  


</body>
</html>