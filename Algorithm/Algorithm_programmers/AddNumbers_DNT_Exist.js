"use strict";
//없는 숫자 더하기
/*
0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어진다.
numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 하는 프로그램을 작성하세요.

제한사항

- 1 ≤ number.length ≤ 9
    - 0 ≤ numbers의 모든 원소 ≤9
    - numbers의 모든 원소는 서로 다름
*/
function solution(numbers) {
  let answer = 0;
  const totalNum = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  const totalSum = totalNum.reduce((a, b) => a + b);
  const numbersSum = numbers.reduce((a, b) => a + b);
  return (answer = totalSum - numbersSum);
}
//console.log(solution([1, 2, 3, 4, 6, 7, 8, 0])); //14
console.log(solution([5, 8, 4, 0, 6, 7, 9])); //6
