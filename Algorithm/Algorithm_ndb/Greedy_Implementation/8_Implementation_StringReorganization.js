"use strict";
//Implementation algorithm
//문자열 재정렬
/*
알파벳 대문자와 숫자(0 ~ 9)로만 구성된 문자열이 입력으로 주어진다.
이때 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤에,
그 뒤에 모든 숫자를 더한 값을 이어서 출력합니다.

- 예를 들어 K1KA5CB7 이라는 값이 들어오면 ABCKK13을 출력합니다
*/
function solution(str) {
  let answer;
  let stringToArr = str.split("");
  let alphabet = [];
  for (let i = 0; i < str.length; i++) {
    if (str.charCodeAt(i) >= 65) {
      alphabet.push(str.charCodeAt(i));
    }
  }
  alphabet = alphabet.sort((a, b) => a - b).map((s) => String.fromCharCode(s));

  const num = stringToArr
    .filter((n) => n <= 9)
    .reduce((acc, curr) => {
      return Number(acc) + Number(curr);
    }, 0);
  return (answer = alphabet.concat(num).join(""));
}
//console.log(solution("AJKDLSI412K4JSJ9D")); //ADDIJJJKKLSS20
console.log(solution("K1KA5CB7")); //ABCKK13
