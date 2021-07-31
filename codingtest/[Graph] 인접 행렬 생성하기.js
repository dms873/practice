/**
 * 문제
방향이 있는 간선과 방향이 없는 간선들의 목록들을 받아 2차원 배열의 인접행렬을 반환하는 함수를 작성하세요.

조건
각 간선은 3가지 정보를 담고 있습니다.

0번째: 간선의 시작 정점 (0 이상의 정수)
1번째: 간선의 도착 정점 (0 이상의 정수)
2번째: 방향성 ('undirected' 일시 무향, 'directed' 일시 방향)

입력
인자 1: edges
Number 타입의 방향/무향인 간선들의 목록이 담긴 배열

출력
Array 타입을 리턴해야 합니다.
2차원 배열의 인접 행렬

주의사항
정점 0에서 정점4로 이어주는 간선이 존재할 경우 정점 1, 2, 3도 존재합니다.
반환하는 인접행렬은 2차원 배열이며, 행(row)는 바깥 배열, 열(column)은 안쪽 배열입니다.

let matrix = [[0, 0], [0, 0]]
matrix[0] === 0번째 행
matrix[0][0] === 0번째 행의 0번째 열
두 정점간의 간선의 유무는 0과 1로 표시합니다.

0: 두 정점간에 간선이 존재하지 않을 경우
1: 두 정점간에 간선이 존재할 경우
아래의 2차원 배열에서 세로축은 시작 정점, 가로축은 도착 정점입니다.
const matrix = [
	[0, 0, 0],
	[0, 0, 0],
	[0, 0, 0],
];

입출력 예시
let output1 = createMatrix([
	[0, 3, "directed"],
	[0, 2, "directed"],
	[1, 3, "directed"],
	[2, 1, "directed"],
]);

console.log(output1);

 * [
 *  [0, 0, 1, 1],
 *  [0, 0, 0, 1],
 *  [0, 1, 0, 0],
 *  [0, 0, 0, 0]
 * ]

let output2 = createMatrix([
	[0, 2, "directed"],
	[2, 4, "undirected"],
	[1, 3, "undirected"],
	[2, 1, "directed"],
]);

console.log(output2);
 * [
 *  [0, 0, 1, 0, 0],
 *  [0, 0, 0, 1, 0],
 *  [0, 1, 0, 0, 1],
 *  [0, 1, 0, 0, 0],
 *  [0, 0, 1, 0, 0],
 * ]
 */

function createMatrix(edges) {
    // TODO: 여기에 코드를 작성합니다.
    // directed는 한방향 / undirected 양방향
    // 첫번째로, 모든 배열 다 탐색을하고, 제일 큰숫자를 찾는다.
    // 제일 큰숫자가 5라면 5x5 행렬을 만든다.
    // 그 후 방향에 따라 데이터를 [숫자] 를 기입한다.

    let result = [];
    let maxNumber = 0;

    for (let i = 0; i < edges.length; i++) {
        if (edges[i][0] > maxNumber) {
            maxNumber = edges[i][0];
        }
    }
    for (let i = 0; i < edges.length; i++) {
        if (edges[i][1] > maxNumber) {
            maxNumber = edges[i][1];
        }
    }
    // let tmp = new Array(maxNumber+1).fill(0) // [0,0,0,0]
    // result = new Array(maxNumber+1).fill(tmp) // [[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
    result = new Array(maxNumber + 1)
        .fill(0)
        .map((i) => new Array(maxNumber + 1).fill(0));

    // for문돌려서 [2]인덱스가 directed 이면 / undirected 면;
    for (let i = 0; i < edges.length; i++) {
        if (edges[i][2] === "directed") {
            result[edges[i][0]][edges[i][1]] = 1;
        } else if (edges[i][2] === "undirected") {
            result[edges[i][0]][edges[i][1]] = 1;
            result[edges[i][1]][edges[i][0]] = 1;
        }
    }
    return result;
}
