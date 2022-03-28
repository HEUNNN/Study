"use strict";
//팩토리얼 구하기
//Recursive Function
function solution(n) {
  let answer;
  function DFS(n) {
    if (n === 1) {
      return 1;
    } else {
      return n * DFS(n - 1);
    }
  }
  return (answer = DFS(n));
}
console.log(solution(6));
