"use strict";
//Press the keypad
/*
맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

- 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
- 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
- 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
- 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
* 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.

순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가
매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를
나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
*/
/* 나의 코드
function solution(num, hand) {
  let answer = [];
  let left = [0, 3];
  let right = [2, 3];
  const key = [
    [1, 4, 7, "*"],
    [2, 5, 8, 0],
    [3, 6, 9, "#"],
  ];
  hand = hand[0].toUpperCase();
  const calDistance = (centerNum) => {
    let centerP = [1, key[1].indexOf(centerNum)];
    let rightD = Math.abs(right[0] - 1) + Math.abs(right[1] - centerP[1]); //distance
    let leftD = Math.abs(left[0] - 1) + Math.abs(left[1] - centerP[1]);

    if (rightD === leftD) {
      if (hand === "R") right = centerP;
      else left = centerP;
      answer.push(hand);
    } else if (rightD < leftD) {
      answer.push("R");
      right = centerP;
    } else {
      answer.push("L");
      left = centerP;
    }
  };
  for (let i = 0; i < num.length; i++) {
    if (key[0].includes(num[i])) {
      answer.push("L");
      left = [0, key[0].indexOf(num[i])];
    } else if (key[2].includes(num[i])) {
      answer.push("R");
      right = [2, key[2].indexOf(num[i])];
    } else {
      calDistance(num[i]);
    }
  }
  return String(answer.join(""));
}
*/

//다른 사람이 key 정의한 것을 참고하여 다시 코드 작성 해봄
function solution(num, hand) {
  let answer = [];
  let left = "*";
  let right = "#";
  const key = {
    1: [0, 0],
    2: [0, 1],
    3: [0, 2],
    4: [1, 0],
    5: [1, 1],
    6: [1, 2],
    7: [2, 0],
    8: [2, 1],
    9: [2, 2],
    "*": [3, 0],
    0: [3, 1],
    "#": [3, 2],
  };
  hand = hand[0].toUpperCase();
  const calDistance = (centerNum) => {
    let centerP = key[centerNum];
    let rightP = key[right];
    let leftP = key[left];
    let rightD =
      Math.abs(rightP[0] - centerP[0]) + Math.abs(rightP[1] - centerP[1]);
    let leftD =
      Math.abs(leftP[0] - centerP[0]) + Math.abs(leftP[1] - centerP[1]);
    if (rightD === leftD) {
      answer.push(hand);
      if (hand === "R") right = centerNum;
      if (hand === "L") left = centerNum;
    } else if (rightD < leftD) {
      answer.push("R");
      right = centerNum;
    } else if (rightD > leftD) {
      answer.push("L");
      left = centerNum;
    }
  };
  for (let i = 0; i < num.length; i++) {
    if ([1, 4, 7, "*"].includes(num[i])) {
      answer.push("L");
      left = num[i];
    } else if ([3, 6, 9, "#"].includes(num[i])) {
      answer.push("R");
      right = num[i];
    } else {
      calDistance(num[i]);
    }
  }
  return answer.join("");
}

console.log(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"));
