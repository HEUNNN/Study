"use strict";
//Implementation algorithm
/*
A 왕국의 왕실 정원은 8 x 8 좌표 평면입니다. 왕실 정원의 특정한 한 칸에 나이트가 서 있습니다.
나이트는 매우 충성스러운 신하로 매일 무술을 연마합니다. 나이트는 말을 타고 있기 때문에
이동을 할 때는 L자 형태로만 이동할 수 있으며, 정원 밖으로는 나갈 수 없습니다.

나이트가 이동할 수 있는 2가지 경우

- 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
- 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기

8 x 8 좌표 평면상에서 나이트의 위치가 주어졌을 때,나
이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하세요.
왕실의 정원에서 행 위치를 표현할 때는 1부터 8로 표현하며,
열 위치를 표현할 때는 a 부터 h로 표현한다.
*/
function solution(p) {
  const steps = [
    [-2, -1],
    [-2, 1],
    [2, -1],
    [2, 1],
    [-1, -2],
    [1, -2],
    [-1, 2],
    [1, 2],
  ];
  let answer = 0;
  let firstCell = "a".charCodeAt(); //97
  let lastCell = "h".charCodeAt(); //104
  p[0] = p[0].charCodeAt();
  let tmp = p.slice(); //깊은 복사
  for (let i = 0; i < steps.length; i++) {
    tmp[0] = tmp[0] + steps[i][0];
    tmp[1] = tmp[1] + steps[i][1];
    if (
      firstCell <= tmp[0] &&
      tmp[0] <= lastCell &&
      1 <= tmp[1] &&
      tmp[1] <= 8
    ) {
      answer++;
    }
    tmp = p.slice();
  }
  return answer;
}
console.log(solution(["a", 1])); //2
//console.log(solution("c", 2)); //6
