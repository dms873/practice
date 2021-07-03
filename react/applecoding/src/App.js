/* eslint-disable */

import React, { useState } from "react";
import logo from "./logo.svg";
import "./App.css";

function App() {
    let [글제목, 글제목변경] = useState([
        "강남맛집소개",
        "여자바지추천",
        "남자코트추천",
    ]);

    let [따봉, 따봉변경] = useState(0);
    let [modal, modal변경] = useState(false);
    let [누른제목, 누른제목변경] = useState(0);
    let [입력값, 입력값변경] = useState("");

    let posts = "강남 맛집";

    function 제목바꾸기() {
        var newArray = [...글제목];
        newArray[1] = "빨간맛";
        글제목변경(newArray);
    }

    return (
        <div className="App">
            <div className="black-nav">
                <div>개발 Blog</div>
            </div>
            {/* <button onClick={제목바꾸기}> 코트변경버튼임 </button> */}

            {글제목.map((글, i) => {
                return (
                    <div className="list" key={i}>
                        <h3
                            onClick={() => {
                                누른제목변경(i);
                            }}
                        >
                            {글}
                            <span
                                onClick={() => {
                                    따봉변경(따봉 + 1);
                                }}
                            >
                                👍🏻
                            </span>{" "}
                            {따봉}{" "}
                        </h3>
                        <p>2월 18일 발행</p>
                        <hr />
                    </div>
                );
            })}

            <div className="publish">
                <input
                    onChange={() => {
                        입력값변경();
                    }}
                />
                <button
                    onClick={() => {
                        글제목;
                    }}
                >
                    저장
                </button>
            </div>

            <button
                onClick={() => {
                    modal변경(!modal);
                }}
            >
                열고 닫기
            </button>
            {modal === true ? (
                <Modal 글제목={글제목} 누른제목={누른제목} />
            ) : null}
        </div>
    );
}

function Modal(props) {
    return (
        <div className="modal">
            <h2>{props.글제목[props.누른제목]}</h2>
            <p>날짜</p>
            <p>상세내용</p>
        </div>
    );
}

export default App;
