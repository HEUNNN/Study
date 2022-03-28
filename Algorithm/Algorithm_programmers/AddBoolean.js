"use strict";
function solution(ab, sign) {
  const n = ab.length;
  let answer = 0;
  for (let i = 0; i < n; i++) {
    if (sign[i]) answer += ab[i];
    else {
      answer -= ab[i];
    }
  }
  return answer;
}
console.log(solution([4, 7, 12], [true, false, true]));
