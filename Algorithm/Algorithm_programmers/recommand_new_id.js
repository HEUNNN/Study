/*
신규 회원 id 추천 문제

id 조건
- 길이: 3 - 15
- 소문자, 숫자, 빼기 _, . 만 사용가능
- . 은 시작과 끝에는 사용할 수 없고, 연속으로도 사용 불가

조건에 맞지 않을 때 7단계의 순차적인 처리 과정을 통해 규칙에 맞는지 검사하고, 맞지 않으면 새로운 id 추천
1. 대문자 -> 소문자 => toLowerCase(), toUpperCase()
2. 소문자, 숫자, 빼기(-), 밑줄(_), 마침표를 제외한 모든 문자 제거
3. 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
4. 마침표가 처음이나 끝에 위치한다면, 제거
5. 빈 문자열이라면 'a' 대입
6. 길이가 16자 이상이면, 처음 15개의 문자를 제외한 나머지 문자들을 모두 제거
    -> 제거 후 마침표가 끝에 위치한다면 마침표 문자를 제거
7. 2자 이하라면 마지막 문자를 길이가 3이 될때까지 반복해서 끝에 붙임
*/
/*
function solution(newId) {
  let answer = "";
  for (let i = 0; i < newId.length; i++) {
    let elem = newId[i].toLowerCase();
    if ("0123456789abcdefghijklmnopqrstuvwxyz.-_".indexOf(elem) === -1)
      continue;
    //continue 현재 반복에서 명령문의 실행을 종료하고 반복문의 처음으로 돌아가서 루프문의 다음 코드를 실행
    if (elem === "." && answer[answer.length - 1] === "." && newId[i - 1])
      continue; //'.'이 연속으로 오면 answer에 더하지 않음
    answer += elem;
  }

  if (answer[0] === ".") answer = answer.slice(1);
  answer = answer.slice(0, 15);
  if (answer[answer.length - 1] === ".")
    answer = answer.slice(0, answer.length - 1);
  if (!answer) {
    answer = "a";
  }
  while (answer.length < 3) {
    answer += answer[answer.length - 1];
  }
  return answer;
}
*/
function solution(newId) {
  let answer = "";
  for (let i = 0; i < newId.length; i++) {
    let v = newId[i].toLowerCase(); //1: 소문자 치환
    if ("0123456789abcdefghijklmnopqrstuvwxyz.-_".indexOf(v) === -1) continue;
    //2: 알파벳 소문자, 숫자, .-_ 아닌 특수문자를 제외하기
    if (v === "." && answer[answer.length - 1] === ".") continue;
    //3: '.' 연속되면 하나로 합치기
    answer += v; //2, 3 단계 통과한 v 만 answer에 들어감
    //여기까지 answer = ".bat.y.abcdefghijklm"
  }
  if (answer[0] === ".") answer = answer.slice(1);
  //4: 앞에 " . "이 있을때, 제거하기

  answer = answer.slice(0, 15); //6: 길이가 15보다 클 때, 자르기

  if (answer[answer.length - 1] === ".") {
    answer = answer.slice(0, answer.length - 1);
    //4: 뒤에 " . "이 있을때, 제거하기
  }
  //5: 빈 배열이라면 "a" 대입하기
  if (!answer) answer = "a";

  //7: answer 길이가 3 이하라면 answer의 마지막 문자를 덧붙이기
  while (answer.length < 3) {
    answer += answer[answer.length - 1];
  }

  return answer;
}

console.log(solution("...!@BaT#*..y.abcdefghijklm"));
