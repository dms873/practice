/**
 * 문제
 * 문자열을 요소로 갖는 배열을 입력받아 가장 짧은 문자열과 가장 긴 문자열을 제거한 배열을 리턴해야 합니다.
 *
 * 입력
 * string 타입을 요소로 갖는 배열
 * arr[i].length는 20 이하
 *
 * 출력
 * 배열을 리턴해야 합니다.
 */

function removeExtremes(arr) {
    let long = arr[0];
    let short = arr[0];
    let longindex = 0;
    let shortindex = 0;

    for (let i = 0; i < arr.length; i++) {
        if (arr[i].length >= long.length) {
            long = arr[i];
            longindex = i;
        }

        if (arr[i].length <= short.length) {
            short = arr[i];
            shortindex = i;
        }
    }

    let result = [];
    for (let i = 0; i < arr.length; i++) {
        if (i !== longindex && i !== shortindex) {
            result.push(arr[i]);
        }
    }
    return result;
}
