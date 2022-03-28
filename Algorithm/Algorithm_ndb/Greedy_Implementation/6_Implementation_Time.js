//Implementation algorithm
//시각
/*
정수 N이 입력되면 00시 00분 00초 부터 N시 59분 59초까지의 모든 시각 중에서
3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하세요.

예를 들어 다음은 3이 하나라도 포함되어 있으므로 세어야하는 시각입니다.

- 00시 00분 03초

3이 하나라도 포함되어 있지 않으므로 세면 안되는 시각입니다.

- 00시 02분 55초
*/
function solution(n) {
  let answer = 0;
  let includeThree = 0;
  for (let i = 0; i <= 59; i++) {
    if (String(i).includes("3")) {
      includeThree++;
    }
  }
  let notIncludeThree = 60 - includeThree;
  console.log(includeThree);
  for (let i = 0; i <= n; i++) {
    if (String(i).includes("3")) {
      answer += 60 * 60; //0부터 59까지는 60개
    } else if (!String(i).includes("3")) {
      answer += includeThree * notIncludeThree;
      answer += includeThree * notIncludeThree;
      answer += includeThree * includeThree;
    }
  }
  return answer;
}
console.log(solution(5));
