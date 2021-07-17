import React, { useState } from "react";
import Data from "./data";
import { Navbar, Container, Nav, Jumbotron, Button } from "react-bootstrap";
import "./App.css";
import { Link, Route, Switch } from "react-router-dom";
import Detail from "./Detail";

function App() {
    let [data, setData] = useState(Data);

    return (
        <div className="App">
            <div>
                <Navbar bg="light" variant="light">
                    <Container>
                        <Navbar.Brand href="/">ShoeShop</Navbar.Brand>
                        <Nav className="me-auto">
                            <Nav.Link>
                                <Link to="/">Home</Link>
                            </Nav.Link>
                            <Nav.Link>
                                <Link to="/detail">Detail</Link>
                            </Nav.Link>
                            <Nav.Link href="#pricing">Pricing</Nav.Link>
                        </Nav>
                    </Container>
                </Navbar>

                <Switch>
                    <Route exact path="/">
                        <Jumbotron className="background">
                            <Container>
                                <h1>20% Season Off</h1>
                                <p>
                                    This is a modified jumbotron that occupies
                                    the entire horizontal space of its parent.
                                </p>
                            </Container>
                            <Button variant="danger">Learn more</Button>
                        </Jumbotron>

                        <div className="container">
                            <div className="row">
                                {data.map((a, i) => {
                                    return (
                                        <Item data={data[i]} i={i} key={i} />
                                    );
                                })}
                            </div>
                        </div>
                    </Route>

                    <Route path="/detail/:id">
                        <Detail data={data} />
                    </Route>

                    <Route path="/:id">
                        <div>안녕</div>
                    </Route>
                </Switch>
            </div>
        </div>
    );
}

const Item = (props) => {
    return (
        <div className="col-md-4">
            <img src={props.data.img} width="100%" />
            <h4>{props.data.title}</h4>
            <p>
                {props.data.content} & {props.data.price}
            </p>
        </div>
    );
};
export default App;
