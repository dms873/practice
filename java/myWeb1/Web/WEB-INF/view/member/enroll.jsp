<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enroll Page</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<!-- private String mId;
	private String nickname;
	private String email;
	private String phone;
	private String password; -->
	
	<form name="formRegister">
	<!--  action="enroll.do" method="post" -->
		아이디 : <input type="text" name="mId" id="mId" required placeholder="영문자, 숫자 사용하여 6자 이상 20자이하"> <button type="button" id="idCheck">중복체크</button><br>
		비밀번호 : <input type="password" name="password" id="password" required placeholder="영문자, 숫자, 특수문자(_!)를 사용하여 6자 이상 입력해주세요."><br>
		비밀번호 확인 : <input type="password" name="password_re" id="password_re" required placeholder="비밀번호 확인"><br>
		닉네임 : <input type="text" name="nickname" id="nickname" required><br>
		이메일 : <input type="email" name="email" id="email" required><br>
		전화번호 : <input type="tel" name="phone" id="phone" required><br>
		<button type="button" id="btn_enroll">회원가입</button>
	
	</form>
	
	<script>
		// 유효성 체크
		/* $("#mId").focusout(function() {
			
		}); */
		
		
		$("#btn_enroll").click(function() {
			var mId = $("#mId").val().trim();
			// 대소문자, 6자 이상 20자 이하
			var regExpId = /[A-Za-z0-9]{6,20}$/;
			// 대소문자로 시작, 대소문자, 숫자, 특수문자(!_), 3자이상 5자이하(시작글자때문에 1자 먹힘)
			// var regExpId = /^[A-Za-z][A-Za-z0-9!_]{2,4}$/;
			
			if(!regExpId.test(mId)) {
				alert("아이디 입력란에는 영어 대소문자, 6자 이상 20자 이하");
				$("#mId").val("");
				$("#mId").focus();
				return false;
			}
			
			var phone = $("#phone").val().trim();
			// 숫자 3자, -, 숫자 3~4, -, 숫자4
			var regExpPhone = /^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$/;
			// [0-9] 대신 \d 사용 가능.
			
			if(!regExpPhone.test(phone)) {
				alert("전화번호 입력란에는 000-0000-0000 형식");
				$("#phone").val("");
				$("#phone").focus();
				return false;
			}
			
			var password = $("#password").val().trim();
			if(!password || password != $("#password_re").val().trim()) {
				alert("비밀번호가 일치하지 않습니다.");
				$("#password").val("");
				$("#password_re").val("");
 				$("#password").focus();
				return false;
			} else {
				// 영문자, 특수문자, 숫자가 적어도 1개 이상, 8자 이상 16자 이하
				var regExpPassword = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{8,16}$/;
				
				if(!regExpPassword.test(password)) {
					alert("비밀번호는 영문자, 특수문자 숫자가 적어도 1개 이상, 8자 이상 16자 이하");
					$("#password").val("");
					$("#password_re").val("");
					$("#password").focus();
					return false;
				}
			}
			
			// ★★★★★ form action, method 작성 ★★★★★
			// form은 getElementName 안써도 됨
			var form = document.formRegister;
			form.action = "enroll.do";
			form.method = "post";
			// button타입이 submit으로 바뀌면서 전송됨.
			form.submit();
			
		});
	
	</script>
</body>
</html>