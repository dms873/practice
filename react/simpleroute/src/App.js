import logo from "./logo.svg";
import "./App.css";
import "./index";
import React from "react";
import { BrowserRouter, Route, Switch, Link } from "react-router-dom";

function App() {
    return (
        <BrowserRouter>
            <div>
                <nav>
                    <ul>
                        <li>
                            <Link to="/">Home</Link>
                        </li>
                        <li>
                            <Link to="/about">MyPage</Link>
                        </li>
                        <li>
                            <Link to="/dashboard">Dashboard</Link>
                        </li>
                    </ul>
                </nav>

                <Switch>
                    <Route exact path="/">
                        <Home />
                    </Route>
                    <Route path="/about">
                        <MyPage />
                    </Route>
                    <Route path="/dashboard">
                        <Dashboard />
                    </Route>
                </Switch>
            </div>
        </BrowserRouter>
    );
}

function Home() {
    return <h1>Home</h1>;
}

function MyPage() {
    return <h1>MyPage</h1>;
}

function Dashboard() {
    return <h1>Dashboard</h1>;
}

export default App;
