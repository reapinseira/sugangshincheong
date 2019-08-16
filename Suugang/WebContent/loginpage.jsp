<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<title>로그인 페이지</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type = "text/javascript">
		$(function(){
			//alert("Test");
			
			//멤버 데이터가 null이면 출력
			var message = '${message}';
			
			var admin = '${admin}';
			var student = '${student}';
			var account = '${account}';
			
			var authority = '${authority}';
			
			if( !student ){
				if( message ){
					//멤버 없음, 메세지 있음 : 로그인 실패
					alert('실패');
					alert(message);
				} //else : 멤버, 메세지 모두 없음 : 첫 진입
				
			} else {
				//멤버 있음 : 로그인 성공. index창에서 처리
			}
		
		});
	</script>
</head>
<body>
	<form action="login" method="post">
		<input type="text" name="no" id="no" placeholder="학번을 입력하세요."/><br/>
		<input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요"/><br/>
		<button type="submit">로그인</button>
	</form>
</body>
</html>