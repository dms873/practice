function solution(s) {
    var answer = true;

    answer =
        s.toLowerCase().split("p").length === s.toLowerCase().split("y").length;

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    console.log("Hello Javascript");

    return answer;
}
