import logo from "./logo.svg";
import "./App.css";

function App() {
    const proverbs = ["정재원", "또라이", "멍청이"];

    const getRandomIndex = (length) => {
        return parseInt(Math.random() * length);
    };

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <p>
                    <code>src/App.js</code> 파일은 새로 고치면 되는데 정재원은
                    못고침
                </p>
                {proverbs[getRandomIndex(proverbs.length)]}
            </header>
        </div>
    );
}

export default App;
