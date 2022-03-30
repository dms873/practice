<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>실습문제3-회원가입</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <style>
        input {
            margin-bottom: 20px;
        }

        #check_id, #check_pwd {
            border: 0;
            font-size: 15px;
            width: 300px;
        }

        #check_id:focus, #check_pwd:focus {
            outline: 0;
        }
    </style>
</head>

<body>

    <script>
        var user_id = 'user01';
        $(function() {
            $("#insert_id").on("keydown", function(key) {
                if($("#insert_id").val() == "") {
                    $("#check_id").val("");
                }
                if(key.keyCode == 13) {
                    if($("#insert_id").val() != user_id) {
                        $("#check_id").val("사용가능한 아이디입니다.");
                        $("#check_id").css("color", "green");
                    } else {
                        $("#check_id").val("이미 존재하는 아이디입니다.");
                        $("#check_id").css("color", "red");
                    }
                }
            })

            $("#insert_check_pwd").on("focusout", function() {
                if($("#insert_pwd").val() == $("#insert_check_pwd").val()) {
                    $("#check_pwd").val("비밀번호가 일치합니다.");
                    $("#check_pwd").css("color", "green");
                } else if($("#insert_pwd").val() == "" || $("#insert_check_pwd").val() == "") {
                    $("#check_pwd").val("");
                } else {
                    $("#check_pwd").val("비밀번호가 일치하지 않습니다.");
                    $("#check_pwd").css("color", "red");
                }
            })

            $("#join_btn").on("click", function() {
                if($("#insert_name").val() == "" && $("#insert_pwd").val() == "" && $("#insert_check_pwd").val() == "" && $("#insert_name").val() == "") {
                    alert("입력창을 확인해주세요");
                    $("#insert_id").focus();
                } else if($("#insert_name").val() == "") {
                    alert("이름을 입력해주세요.");
                    $("#insert_name").focus();
                } else if($("#check_id").val() == "사용가능한 아이디입니다." && $("#check_pwd").val() == "비밀번호가 일치합니다.") {
                    alert($("#insert_name").val() + "님, 회원가입이 성공적으로 완료되었습니다^^");
                    $("#insert_id").val("");
                    $("#check_id").val("");
                    $("#insert_pwd").val("");
                    $("#insert_check_pwd").val("");
                    $("#check_pwd").val("");
                    $("#insert_name").val("");
                } else if($("#check_id").val() == "이미 존재하는 아이디입니다.") {
                    alert("아이디를 다시 입력해주세요.");
                    $("#insert_id").focus();
                } else if($("#check_pwd").val() == "비밀번호가 일치하지 않습니다.") {
                    alert("비밀번호를 다시 입력해주세요.");
                    $("#insert_pwd").focus();
                }
            })
        })

    </script>

    <h1>Practice3</h1>
    <fieldset>
        <legend>회원가입</legend>
            아이디 : <input type="text" id="insert_id">
            <input type="text" id="check_id" readonly></input>
            <br>
            비밀번호 : <input type="password" id="insert_pwd">
            <br>
            비밀번호 확인 : <input type="password" id="insert_check_pwd">
            <input type="text" id="check_pwd" readonly></input>
            <br>
            이름 : <input type="text" id="insert_name">
            <br>
            <button id="join_btn">회원가입</button>
    </fieldset>
</body>
</html>
