<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<title>메인</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
			
	<script type = "text/javascript">
		$(function(){
		
			var student = '${student}';
			var message = '${message}';
			var account = '${account}';
			var authority = '${authority}';
			
		});
	</script>
</head>
<body>
	<c:if test="${account == null}">
		<a href = "login_page">로그인</a>
	</c:if>
	
	<c:if test="${account != null}">
		<form action="logout">
			<p>${account.sname}, 로그인되었습니다.</p>
			<input type="submit" value="로그아웃"/>
		</form>
	</c:if>
	<br/>
	<ul>
		<li><a href="notice">공지사항</a></li>
		<li><a href="faq">FAQ</a></li>
		<li><a href="lecture_regist.do">수강신청</a></li>
		<li><a href="timetable.do">시간표 보기</a></li>
		<li><a href="lecture_info">강의정보</a></li>
	</ul>
	<br/>
	<a href="lectureList_move">강의리스트</a>
</body>
</html>