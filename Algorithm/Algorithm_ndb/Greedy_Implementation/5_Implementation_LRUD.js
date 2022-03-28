//구현 Algorithm
//상하 좌우
/*
여행가 A는 N x N 크기의 정사각형 공간 위에 서 있습니다. 이 공간은 1 x 1 크기의 정사각형으로 나누어져 있습니다.
가장 왼쪽 위 좌표는 (1, 1)이며, 가장 오른쪽 아래 좌표는 (N, N)에 해당합니다.
여행가 A는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1, 1) 입니다.
여행가 A가 이동할 계획서가 주어집니다.  A가 도착하는 지점의 좌표를 구하세요.

- L: 왼쪽으로 한 칸 이동
- R: 오른쪽으로 한 칸 이동
- U: 위로 한 칸 이동
- D: 아래로 한 칸 이동

단, N x N 크기의 정사각형을 벗어나는 움직임은 무시됩니다
( (1, 1) 위치에서 L or U 등의 이동은 무시)
(N과 이동 계획 내용이 주어진다.)
*/

//나의 코드
function solution(n, arr) {
  let dx = [0, 0, -1, 1]; // L, R, U, D
  let dy = [-1, 1, 0, 0];
  let x = 1;
  let y = 1;
  for (let i = 0; i < arr.length; i++) {
    switch (arr[i]) {
      case "L":
        if (x + dx[0] >= 1 && y + dy[0] >= 1) {
          x = x + dx[0];
          y = y + dy[0];
        }
        break;
      case "R":
        if (x + dx[1] >= 1 && y + dy[1] >= 1) {
          x = x + dx[1];
          y = y + dy[1];
        }
        break;
      case "U":
        if (x + dx[2] >= 1 && y + dy[2] >= 1) {
          x = x + dx[2];
          y = y + dy[2];
        }
        break;
      case "D":
        if (x + dx[3] >= 1 && y + dy[3] >= 1) {
          x = x + dx[3];
          y = y + dy[3];
        }
        break;
    }
  }
  return [x, y];
}
console.log(solution(5, ["R", "R", "R", "U", "D", "D"]));
