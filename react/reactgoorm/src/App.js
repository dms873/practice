import logo from "./logo.svg";
import "./App.css";
import Comment from "./Comment";

const comments = [
    { name: "은지니", content: "너무 이쁜 은지니!" },
    { name: "재워니", content: "너무 못생긴 재워니!" },
    { name: "Jung", content: "왜 자기 혼자함?" },
];

function App() {
    return (
        <div
            className="App"
            style={{ padding: 16, backgroundColor: "#282c34" }}
        >
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <p>
                    Edit <code>src/App.js</code> and save to reload.
                </p>
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Learn React
                </a>
            </header>
            <div>
                {comments.map((comment, index) => {
                    return (
                        <Comment
                            name={comment.name}
                            content={comment.content}
                        />
                    );
                })}
            </div>
        </div>
    );
}

export default App;
