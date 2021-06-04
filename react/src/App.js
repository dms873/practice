/* eslint-disable */

import React, { useState } from "react";
import logo from "./logo.svg";
import "./App.css";

function App() {
    let [글제목, 글제목변경] = useState([
        "남자코트 추천",
        "바지 추천",
        "티 추천",
    ]);
    let [좋아요, 좋아요변경] = useState(0);

    function 제목변경() {
        let newArray = [...글제목];
        newArray[0] = "여자코트 추천";
        글제목변경(newArray);
    }

    let posts = "리액트는 어려워😱";

    return (
        <div className="App">
            <div className="black-nav">
                <div style={{ color: "pink", fontSize: "30px" }}>개발 Blog</div>
            </div>
            <button onClick={제목변경}>Button</button>

            <div className="list">
                <h3> {posts}</h3>
                <p>6월 4일 발행</p>
                <hr />
            </div>
            <div className="list">
                <h3>
                    {글제목[0]}
                    <span
                        onClick={() => {
                            좋아요변경(좋아요 + 1);
                        }}
                    >
                        👍🏻
                    </span>
                    {좋아요}
                </h3>
                <p>6월 5일 발행</p>
                <hr />
            </div>
            <div className="list">
                <h3> {글제목[1]} </h3>
                <p>6월 6일 발행</p>
                <hr />
            </div>
            <div className="list">
                <h3> {글제목[2]} </h3>
                <p>6월 7일 발행</p>
                <hr />
            </div>

            <Modal />
            <Modal />
        </div>
    );
}

function Modal() {
    return (
        <div className="modal">
            <h2>제목</h2>
            <p>날짜</p>
            <p>상세내용</p>
        </div>
    );
}

export default App;
