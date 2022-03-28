"use strict";
/*
두 개의 자연수에 대한 최대 공약수를 구하는 대표적인 알고리즘으로는 유클리드 호제법이 있다. 

**유클리드 호제법**

- 두 자연수 A, B에 대하여 (A > B) A를 B로 나눈 나머지를 R이라고 한다.
- 이때 A와 B의 최대공약수는 B와 R의 최대공약수와 같다.
*/
function solution(a, b) {
  let answer;
  function DFS(numA, numB) {
    if (numA % numB === 0) {
      return (answer = numB);
    } else {
      DFS(numB, numA % numB);
    }
  }
  DFS(a, b);
  return answer;
}
console.log(solution(192, 162));
