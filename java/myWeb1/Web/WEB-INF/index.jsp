<%@page import="kh.test.first.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!-- 최적해상도 1250 결정 -->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 이 jsp파일을 dispatcher한 서블릿url을 기준으로 경로 지정해야됨 !!
         jsp파일 위치가 기준이 아님! (../../Web/resources/css/reset.css 적용 안됨!!) -->
    <link rel="stylesheet" href="./resources/css/reset.css">
    <style>
    	a {
    		text-decoration: none;
    	}
    
        .wrap {
            width: 100%;
        }
        .wrap.header {
            background: bisque;
            border: 1px solid black;
            box-sizing: border-box;
        }
        .wrap.content {
            background: beige;
            border: 1px solid black;
            box-sizing: border-box;
        }
        .wrap.footer {
            background: bisque;
            border: 1px solid black;
            box-sizing: border-box;
        }
        /* header */
        header{ 
            /* 1. 중앙정렬 */
            width: 80%; margin: 0 auto;
        }
        /* #content */
        #content{
            /* 1. 중앙정렬 */
            width: 80%; margin: 0 auto;
            position: relative;
            /* 2. float 배치- 한것으로 height 계산 못하므로 overflow hidden 설정 */
            overflow: hidden;
        }
        /* section */
        section{
            /* 2. float 배치 */
            width: 80%; 
            float: left;
        }
        article {
            /* 5. 테두리 !! 중요 부모요소의 크기를 최대로 가지면서 나의 content 크기가 줄어듬 */
            border: 1px solid black;
            padding: 30px 20px;
            
            margin-bottom: 10px;
        }
        /* aside */
        aside{
            /* 2. float 배치 */
            width: 18%; float: right;
            border: 1px solid black;
        }
        /* footer */
        footer{
            /* 1. 중앙정렬 */
            width: 80%; margin: 0 auto;
            /* 2. float 배치-해제하고 정확한 위치잡기*/
            clear: both;

            margin-bottom: 10px;
        }


        /* 1500 보다 클때 */
        @media (min-width:1500px) {
            body{
                font-size: 1.2rem;
            }
        }

        /* 800 보다 작을 때 */
        @media (max-width:799px) {
            body{
                font-size: 0.8rem;
            }
            /* header */
            header{ 
                /* 1. 중앙정렬 */
                width: 90%; 
            }
            /* #content */
            #content{
                /* 1. 중앙정렬 */
                width: 90%;
                position: relative;
                /* 2. float 배치- 한것으로 height 계산 못하므로 overflow hidden 설정 */
                overflow: hidden;
            }
            /* section */
            section{
                /* 2. float 배치 */
                width: 100%; 
                float: none;
            }
            article {
                /* 5. 테두리 !! 중요 부모요소의 크기를 최대로 가지면서 나의 content 크기가 줄어듬 */
                padding: 30px 20px;
            }
            /* aside */
            aside{
                /* 2. float 배치 */
                width: 80%; margin: 0 auto; 
                float: none;
            }
            /* footer */
            footer{
                /* 1. 중앙정렬 */
                width: 90%; margin: 0 auto;
                /* 2. float 배치-해제하고 정확한 위치잡기*/
                /* clear: both; */

                margin-bottom: 10px;
            }
        }
    </style>
    <style>
        /* 각자 파트 */
        /* block size 수업용 */
        .content .flex4content{
            display: flex;
            /* overflow: hidden; */
        }
        .content .flex4content > div{
            border: 1px solid black;
            margin: 10px 5px;
            /* margin-right: 10px; */
            /* padding: 10px; */
            /* float:left; width: 25%; */
            /* width: 23%;
            display: inline-flex; */
        }

        .modal {
            display: none;
            width: 100%;
            height: 100%;
            z-index: 1;
            position: fixed;
            top:0;
            left: 0;
            background-color: rgba(0, 0, 128, 0.3);
        }
        .modal>.modal_content{
            position: relative;
            top: 50px;
            left: 30px;
            width: 50%;
            background-color: white;
        }
    </style>
    <!-- accordion menu -->
    <style>
        .accordion {
            width: 90%;
            margin: 10px auto;
        }

        .btn_accordion {
            width: 100%;
            padding: 20px;
            transition: 1s;
            border: 0;
        }

        .btn_accordion:hover {
            background-color: greenyellow;
        }

        .panel {
            display: none;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
        window.onload = pageLoadedHandler;
        // function pageLoadedHandler(){
        //     $(".btn_modal").on("click", openModalHandler);
        //     $(".close").on("click", closeModalHandler);
        //     $(".modal").on("click",closeModalWindowHandler);
        // }
        // function openModalHandler(){
        //     $(".modal").slideDown(1000);
        // }
        // function closeModalHandler(){
        //     $(".modal").slideUp();
        // }
        // function closeModalWindowHandler(){
        //     if(event.target == $(".modal").get(0) 
        //         || event.target == $(".close").get(0)){
        //         $(".modal").slideUp(300);
        //     }
        // }

        // var - function scope
        // let, const - block-scope
        // let : 재선언 안됨. immutable 됨
        // const : 재선언, 재할당 안됨. immutable 안됨
        var modalClass = document.getElementsByClassName("modal");
        // modal box
        function pageLoadedHandler() { 
            // accordion
            { 
                // let eleBtns = document.getElementsByClassName("btn_accordion");
                // for(var i = 0; i < eleBtns.length; i++) {
                //     eleBtns[i].onclick = function() {
                //         console.log(this.nextElementSibling);
                //         var eleNextNode = this.nextElementSibling;
                //         var isDisplay = eleNextNode.style.display;
                //         if(isDisplay == "" || isDisplay == 'none') {
                //             eleNextNode.style.display = 'block';
                //             // 절대 안됨 ! 자료형때문에 isDisplay = 'block'; 
                //         } else {
                //             eleNextNode.style.display = 'none';
                //         }
                //     }
                // }
            }

            // accordion - jquery
            {
                // $(".btn_accordion").click(function(e) {
                //     $(this).next().toggle();
                // })
            }

            // accordion - jquery - html 배치를 다르게(이상함)
            {
                // $(".btn_accordion").click(function(e) {
                //     var idx = $(this).index();
                //     console.log(idx);
                //     console.log(this);
                //     $(".panel").each(function(index, elem) {
                //         console.log(this);
                //         console.log(index);
                //     })
                // })
            }

            // js DOM - 1개 open - other 접힘
            {
                let eleBtns = document.getElementsByClassName("btn_accordion");
                for(var i = 0; i < eleBtns.length; i++) {
                    eleBtns[i].onclick = function() {
                        console.log(this);
                        console.log(this.nextElementSibling);
                        // show 된 것을 닫아줘야 함
                        let elePanels = document.getElementsByClassName(".panel");
                        for(var j = 0; j < elePanels.length; j++) {
                            var isDisplay = elePanels[j].style.display;
                            if(isDisplay != "" && isDisplay != "none") { // show 상태
                                elePanels[j].style.display = "none";
                                break;
                            }
                        }
                        // this를 show
                        var eleNext = this.nextElementSibling;
                        var isDisplay = eleNext.style.display;
                        console.log(isDisplay);
                        if(isDisplay == "" || isDisplay == "none") {
                            eleNext.style.display = "block"; // 1
                            // 절대 안됨 자료형 중요! isDisplay = "block"; // 2
                        } else {
                            eleNext.style.display = "none";
                        }
                    }
                }
            }

            // jquery - 1개 open - other 접힘
            {
                window.onload = pageLoadedHandler;
                function pageLoadedHandler() {
                    $(".btn_accordion").on("click", function() {
                        var nowDisplay = $(this).next();
                        console.log($(this).next().css("display"));
                        if(nowDisplay.css("display") == "none" || nowDisplay.css("display") == "") {
                            $(".panel").each(function() {
                                $(this).hide();
                            })
                            nowDisplay.show();
                        } else {
                            nowDisplay.hide();
                        }
                    });
                };
            };

            document.getElementsByClassName("btn_modal")[0].addEventListener("click", openModalHandler);
            document.getElementsByClassName("close")[0].onclick = closeModalHandler;
            modalClass[0].onclick = closeModalWindowHandler;
        }

        function openModalHandler() {
            modalClass[0].style.display = "block";
        }

        function closeModalHandler() {
            modalClass[0].style.display = "none";
        }

        function closeModalWindowHandler() {
            console.log("closeModcloseModalWindowHandleral");
            if(event.target == document.getElementsByClassName("modal")[0]) {
                modalClass[0].style.display = "none";
            }
        }
    </script>
</head>

<body>
    <div id="main_wrap">
        <div class="wrap header">
            <header>
            <%
	MemberVo ssmvo = (MemberVo)session.getAttribute("ssMemberVo");
	if(ssmvo == null) {

%>
	<button id="login">로그인</button>
<%
	} else {
%>
	<button id="logout">로그아웃</button>
	<button id="mypage">마이페이지</button>
<%
	}
%>

	
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                    voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem
                    ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                    voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </header>
            <script>
		// $("#login").click(function(){
			// location.href = "login";  // a href와 동일 get 방식으로 이동
		// });
		
		
		$("#login").click(function() {
			// 페이지 이동
			// get방식으로 링크가 걸리는 것과 동일함
			// 방법 1)
			// location.assign("login");
			// 방법 2) 주로 이거로 씀
			location.href = "login"; // a태그의 href와 동일 : get방식
			
		});
		
		$("#logout").click(function() {
			// 페이지 이동
			// get방식으로 링크가 걸리는 것과 동일함
			location.href = "logout"; // a태그의 href와 동일 : get방식
			
		});
		
		$("#mypage").click(function() {
			// 페이지 이동
			// get방식으로 링크가 걸리는 것과 동일함
			location.href = "mypage"; // a태그의 href와 동일 : get방식
			
		});
	</script>
        </div>
        <div class="wrap content">
            <div id="content">
                <section>
                    <article id="art_1">
                        <h2>Main Article</h2>
                        <div class="flex4content">
                            <div >
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            </div>
                            <div>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            </div>
                            <div>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            </div>
                            <div>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            </div>
                        </div>
                    </article>
                    <article id="art_2">
                        <h2>Main Article</h2>
                        <button class="btn_modal">동의하기ModalBox열기</button>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                            voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                            cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem
                            ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                            voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                            cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                        </p>
                        <div class="modal">
                            <!-- 여기에는 아무 내용 적지 않음. - 대체로 -->
                            <div class="modal_content">
                                <!-- 여기에 내용 작성 -->
                                <div class="close">&#9932;</div>
                                <div class="flex4content">
                                    <div >
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                                    </div>
                                    <div>
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                                    </div>
                                    <div>
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                                    </div>
                                    <div>
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                                    </div>
                                </div>
                            </div>
                        </div>
                    </article>
                    <article id="art-3">
                        <h2>Main Article</h2>
                        <div class="accordion">
                            <button class="btn_accordion">Section 1</button>
                            <div class="panel">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                                    voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem
                                    ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                                    voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                            </div>
                            <button class="btn_accordion">Section 2</button>
                            <div class="panel">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                                    voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem
                                    ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                                    voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                            </div>
                            <button class="btn_accordion">Section 3</button>
                            <div class="panel">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                                    voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem
                                    ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                                    voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                            </div>
                        </div>
                    </article>
                    <article id="art-4">
                        <h2>Main Article</h2>
                        <!-- 버튼이면 자바스크립트로 등록해서 주로 사용하니까 a태그로 묶지 않는다! -->
                        <!-- <a href=""><button id="btn_boardList">게시판목록</button></a> -->
                        <button id="btn_boardList">게시판목록</button>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                            voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                            cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem
                            ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                            voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                            cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                            <script>
                            	$("#btn_boardList").click(function() {
                            		console.log("게시판버튼 눌림!");
                            		location.href="boardList";
                            	});
                            </script>
                    </article>
                    <article id="art-5">
                        <h2>Main Article</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                            voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                            cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem
                            ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                            voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                            cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    </article>
                    <article id="art-6">
                        <h2>Main Article</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                            voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                            cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem
                            ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                            voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                            cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    </article>
                </section>
                <aside>
                    <input type="radio" name="tab" id="first" checked>
                    <input type="radio" name="tab" id="second">
                    <div class="buttons">
                        <label for="first">First</label>
                        <label for="second">Second</label>
                    </div>
                    <div class="items">
                        <div class="tab_item">
                            <ul>
                                <li class="item">
                                    <a href="#art-4">
                                        <div class="thumbnail"><img src="https://dummyimage.com/45/ff0"></div>
                                        <div class="description">
                                            <strong>HTML5 Canvas</strong>
                                            <p>2020-03-08</p>
                                        </div>
                                    </a>
                                </li>
                                <li class="item">
                                    <a href="#art-4">
                                        <div class="thumbnail"><img src="https://dummyimage.com/45/ff0"></div>
                                        <div class="description"><strong>HTML5 Semantics Web</strong>
                                            <p>2020-03-08</p>
                                        </div>
                                    </a>
                                </li>
                                <li class="item">
                                    <a href="#art-4">
                                        <div class="thumbnail"><img src="https://dummyimage.com/45/ff0"></div>
                                        <div class="description"><strong>HTML5 Video</strong>
                                            <p>2020-03-08</p>
                                        </div>
                                    </a>
                                </li>
                                <li class="item">
                                    <a href="#art-4">
                                        <div class="thumbnail"><img src="https://dummyimage.com/45/ff0"></div>
                                        <div class="description"><strong>HTML5 Semantics Web</strong>
                                            <p>2020-03-08</p>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab_item">
                            <ul>
                                <li class="item"><a href="#">
                                        <div class="thumbnail"><img src="https://dummyimage.com/45/ff0"></div>
                                        <div class="description"><strong>CSS3 Transition</strong>
                                            <p>2020-03-08</p>
                                        </div>
                                    </a></li>
                                <li class="item"><a href="#">
                                        <div class="thumbnail"><img src="https://dummyimage.com/45/ff0"></div>
                                        <div class="description"><strong>CSS3 Animation</strong>
                                            <p>2020-03-08</p>
                                        </div>
                                    </a></li>
                                <li class="item"><a href="#">
                                        <div class="thumbnail"><img src="https://dummyimage.com/45/ff0"></div>
                                        <div class="description"><strong>CSS3 Border</strong>
                                            <p>2020-03-08</p>
                                        </div>
                                    </a></li>
                                <li class="item"><a href="#">
                                        <div class="thumbnail"><img src="https://dummyimage.com/45/ff0"></div>
                                        <div class="description"><strong>CSS3 Box</strong>
                                            <p>2020-03-08</p>
                                        </div>
                                    </a></li>
                            </ul>
                        </div>
                    </div>
                </aside>
            </div>
        </div>
        <div class="wrap footer">
            <footer>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                    voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem
                    ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                    voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </footer>
        </div>
    </div>
</body>

</html>