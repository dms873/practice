/**
 * 문제
주어진 인접행렬에서 한 정점으로부터 다른 정점으로 이어지는 길이 존재하는지 반환해야 합니다.

입력
인자 1: matrix
Array 타입을 요소로 갖는 인접 행렬이 담긴 2차원 배열
인자 2: from
Number 타입의 시작 정점
인자 3: to
Number 타입의 도착 정점

출력
boolean 타입을 리턴해야 합니다.

입출력 예시
const result = getDirections(
	[
		[0, 1, 0, 0],
		[0, 0, 1, 0],
		[0, 0, 0, 1],
		[0, 1, 0, 0],
	],
	0,
	2
);
console.log(result); // true
정점 0에서 2로 가는 길이 존재하는지 확인합니다.
0 --> 1 로 가는 간선이 존재하고, 1 --> 2 로 가는 간선이 존재하기 때문에 true를 반환합니다.
 */

function getDirections(matrix, from, to) {
    let passed = [from];
    let checkDirection = function (matrix, from, to) {
        if (matrix[from][to] === 1) {
            return true;
        }
        for (let i = 0; i < matrix[from].length; i++) {
            if (matrix[from][i] === 1 && !passed.includes(i)) {
                passed.push(i);
                if (checkDirection(matrix, i, to)) {
                    return true;
                }
            }
        }
        return false;
    };
    return checkDirection(matrix, from, to);
}
//1. 요소의 값이 1인지 확인
// 1.true from,to 를 갔었던 길인지 확인
//  1.true.true 1.true 단계로 돌아가기
//  1.true.false
//
// 0 -> 3
// 0 1 0 1
// 0 0 0 1
// 0 1 0 0
// 1 0 0 0
