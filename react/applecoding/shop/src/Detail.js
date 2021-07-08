import React from "react";
import { useHistory } from "react-router";

const Detail = (props) => {
    let history = useHistory();

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6">
                    <img
                        src="https://image.nbkorea.com/NBRB_Product/20200521/NB20200521091531658001.jpg"
                        width="100%"
                    />
                </div>
                <div className="col-md-6 mt-4">
                    <h4 className="pt-5">{props.data[0].title}</h4>
                    <p>상품설명</p>
                    <p>120,000원</p>
                    <button className="btn btn-danger">주문하기</button>
                    <button
                        className="btn btn-info"
                        onClick={() => {
                            history.goBack();
                        }}
                    >
                        뒤로가기
                    </button>
                </div>
            </div>
        </div>
    );
};

export default Detail;
