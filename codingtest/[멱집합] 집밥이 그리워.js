/**
 * 문제
김코딩은 몇 년의 해외 출장 끝에 본가에 내려왔습니다. 오랜만에 보는 김코딩의 얼굴에 반가웠던 부모님은 상다리가 부러질 정도로 음식을 만들었습니다. 감동의 재회도 잠시, 의자에 앉아 식사를 하려던 김코딩은 무엇부터 먹어야 될지 깊은 생각에 빠졌습니다. 정성스럽게 차려 주신 만큼, 최대한 많은 방법으로 다양하게 먹고 싶었기 때문입니다.

밥은 한 가지이며 반찬은 다수일 때, 밥과 함께 먹을 수 있는 반찬의 모든 경우의 수를 배열에 담아 리턴하세요.

입력
인자 1: sideDishes
String 타입의 영문으로 된 반찬이 나열되어 있는 배열

출력
Array 타입을 리턴해야 합니다.
밥과 함께 먹을 수 있는 반찬의 모든 경우의 수가 담긴 배열

주의사항
반찬은 영문으로 작성이 되어 있습니다.
반찬은 중복되지 않습니다.
반찬을 먹지 않는 것도 포함됩니다. (출력되는 2차원 배열은 빈 배열을 포함합니다.)
반찬은 3개 이상 99개 이하입니다.
출력되는 배열은 전부 사전식 순서(lexical order)로 정렬되어야 합니다.

ex)
입출력 예시
let output = missHouseMeal(["eggroll", "kimchi", "fishSoup"]);
console.log(output);

[ [], 
  [ 'eggroll' ], 
  [ 'eggroll', 'fishSoup' ], 
  [ 'eggroll', 'fishSoup', 'kimchi' ], 
  [ 'eggroll', 'kimchi' ], 
  [ 'fishSoup' ], 
  [ 'fishSoup', 'kimchi' ], 
  [ 'kimchi' ]
] 
*/

function missHouseMeal(sideDishes) {
    // TODO: 여기에 코드를 작성합니다.
    let sorted = sideDishes.sort();
    let result = [[]];

    let makePowerSetArr = (target, result) => {
        let copy = result.slice();
        for (let i = 0; i < copy.length; i++) {
            let el = copy[i];
            let concatEl = [target];
            let concatArr = el.concat(concatEl);
            result.push(concatArr);
        }
        return result;
    };

    for (let j = 0; j < sorted.length; j++) {
        let sortedEl = [sorted[j]];
        let filtered = result.filter((el) => el === sortedEl);
        if (filtered.length === 0) {
            makePowerSetArr(sorted[j], result);
        }
    }
    return result.sort();
}

// function missHouseMeal(sideDishes) {

// 결과를 담을 배열을 선언합니다.
//   let result = [];
// sideDishes를 사전식 순서로 정렬합니다.
//   sideDishes.sort();

// 모든 조합을 검사하는 재귀 함수를 작성합니다.
//   const sidePowerSet = (idx, sideDish) => {

// 재귀 함수이기 때문에 탈출 조건을 만듭니다.
//     if (idx === sideDishes.length) {
// 만약, idx와 sideDishes의 길이가 같다면(마지막까지 검토한 경우) result에 sideDish를 삽입하고 push합니다.
//       result.push(sideDish);
//       return;
//     }

// idx번째 요소가 포함되지 않는 경우
//     sidePowerSet(idx + 1, sideDish);

// idx번째 요소가 포함되는 경우
//     sidePowerSet(idx + 1, [...sideDish, sideDishes[idx]]);
//   };

// 0 번째 인덱스와 빈 배열을 인자로 받는 재귀 함수를 실행합니다.
//   sidePowerSet(0, []);

// 결과를 사전식 순서로 정렬합니다.
//   return result.sort();
// }
