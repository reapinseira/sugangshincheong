<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<title>공지사항</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
	<style type="text/css">
		#select{
			color:red;
		}
	</style>
</head>
<body>
	<div class="container">
		<%-- <c:if test="${!empty noticeList}"> --%>
			<br/><br/>
			<!-- memos가 비어있지 않다면 if문을 실행하라 -->
			<table class="table table-bordered text-center">
				<thead>
					<tr style="height:20px">
						<td style="width:100px">번호</td>
						<td style="width:300px">제목</td>
						<td style="width:100px">작성자</td>
						<td style="width:100px">작성일</td>
						<td style="width:50px">조회수</td>
					</tr>
				</thead>
				<tbody>
					<!-- var : 변수명 items : 가져올 것 -->
					<c:forEach var="notice" items = "${noticeList}">
						<tr>
							<td>${notice.nno}</td>
							<td class="text-left"><a href="notice_detail?nno=${notice.nno}">${notice.ntitle}</a></td>
							<td>${notice.aname}</td>
							<td>${notice.ndate}</td>
							<td>${notice.nclick}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		<%-- </c:if> --%>
	</div>
</body>
</html>