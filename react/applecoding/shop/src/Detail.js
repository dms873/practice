import React from "react";
import { useHistory, useParams } from "react-router";
import styled from "styled-components";

let 박스 = styled.div`
    padding: 20px;
`;

let 제목 = styled.h4`
    font-size: 25px;
    color: ${(props) => props.색상};
`;

const Detail = (props) => {
    let { id } = useParams();
    let history = useHistory();
    let 찾은상품 = props.data.find(function (상품) {
        return 상품.id == id;
    });

    return (
        <div className="container">
            <박스>
                <제목 색상="lightpink">Detail</제목>
            </박스>
            <div className="row">
                <div className="col-md-6">
                    <img src={찾은상품.img} width="100%" />
                </div>
                <div className="col-md-6 mt-4">
                    <h4 className="pt-5">{찾은상품.title}</h4>
                    <p>{찾은상품.content}</p>
                    <p>{찾은상품.price}</p>
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
