"use strict";
//크레인 인형 뽑ㅣ
//바구니에 같은 인형이 2개 연속으로 있으면 터트려짐, 터트려져 사라진 인형의 개수 return
function solution(board, moves) {
  const n = board.length;
  let answer = 0;
  let basket = [];
  for (let i = 0; i < moves.length; i++) {
    let idx = moves[i] - 1;
    for (let j = 0; j < n; j++) {
      if (board[j][idx] === 0) continue;
      if (basket[basket.length - 1] === board[j][idx]) {
        answer += 2;
        basket.pop();
      } else {
        basket.push(board[j][idx]);
      }
      board[j][idx] = 0;
      break;
    }
  }
  return answer;
}
console.log(
  solution(
    [
      [0, 0, 0, 0, 0],
      [0, 0, 1, 0, 3],
      [0, 2, 5, 0, 1],
      [4, 2, 4, 4, 2],
      [3, 5, 1, 3, 1],
    ],
    [1, 5, 3, 5, 1, 2, 1, 4]
  )
);
