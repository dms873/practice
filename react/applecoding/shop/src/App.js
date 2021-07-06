import React from "react";
import { Navbar, Container, Nav, Jumbotron, Button } from "react-bootstrap";
import "./App.css";

function App() {
    return (
        <div className="App">
            <>
                <Navbar bg="light" variant="light">
                    <Container>
                        <Navbar.Brand href="#home">ShoeShop</Navbar.Brand>
                        <Nav className="me-auto">
                            <Nav.Link href="#home">Home</Nav.Link>
                            <Nav.Link href="#features">Features</Nav.Link>
                            <Nav.Link href="#pricing">Pricing</Nav.Link>
                        </Nav>
                    </Container>
                </Navbar>

                <Jumbotron className="background">
                    <Container>
                        <h1>20% Season Off</h1>
                        <p>
                            This is a modified jumbotron that occupies the
                            entire horizontal space of its parent.
                        </p>
                    </Container>
                    <Button variant="danger">Learn more</Button>
                </Jumbotron>

                <div className="container">
                    <div className="row">
                        <div className="col-md-4">
                            <img
                                src="https://codingapple1.github.io/shop/shoes1.jpg"
                                width="100%"
                            />
                            <h4>상품명</h4>
                            <p>상품설명 & 가격</p>
                        </div>
                        <div className="col-md-4">
                            <img
                                src="https://codingapple1.github.io/shop/shoes2.jpg"
                                width="100%"
                            />
                            <h4>상품명</h4>
                            <p>상품설명 & 가격</p>
                        </div>
                        <div className="col-md-4">
                            <img
                                src="https://codingapple1.github.io/shop/shoes3.jpg"
                                width="100%"
                            />
                            <h4>상품명</h4>
                            <p>상품설명 & 가격</p>
                        </div>
                    </div>
                </div>
            </>
        </div>
    );
}

export default App;
