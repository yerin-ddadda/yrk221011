<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container pt-3">
<h4>Web MVC + Front Controller Design Pattern</h4>
<%-- hidden tag --%>
<%--
			하나의 FrontControllerServlet으로 여러 폼에서 요청이 전달될 경우 이를 구분하기위한 방법 중 하나는
			hidden tag를 이용한 방법이 있다.
			<input type="hidden" name="command" value="findcustomerById">
			or
			<input type="hidden" name="command" value="registercustomer"> 이렇게되면 구별할 수가 있다.
			프론트 컨트롤러 서블릿에서는 리퀘스트겟파라미터로 command를 하면 find냐 register냐 구별할수있다.
			전달할때 command가 명령이뭐냐 어떤 명령이냐를 알면 요청하는 폼에서 
 --%>
 <%--
 					고객 검색
 					
 					index.jsp - - - FrontControllerServlet - - MockDAO
 														|
 														| forward
 											findbyid-ok.jsp (검색 결과 id, name, address)
 											or
 											findbyid-fail.jsp (alert후 index.jsp로 보낸다)
  --%>
<form action="FrontControllerServletVer4" method="get">
	<input type="hidden" name="command" value="findCustomerById">
	<input type="text" name="customerId" placeholder="고객아이디" required="required">
	<button>검색</button>
</form>
<br><br>

<%-- 
			고객 등록
			index.jsp - - - FrontControllerServlet 									- - - MockDAO
										doDispatch() 안에서 else if 를 추가해 처리
										       	|
										       	|	redirect
										   register-result.jsp
 --%>
<form action="FrontControllerServletVer4" method="post">
	<input type="hidden" name="command" value="registerCustomer">
	<input type="text" name="customerId" placeholder="고객아이디" required="required"><br>
	<input type="text" name="customerName" placeholder="고객이름" required="required"><br>
	<input type="text" name="customerAddress" placeholder="고객주소" required="required"><br>
	<button>등록</button>
</form>
</div>
</body>
</html>