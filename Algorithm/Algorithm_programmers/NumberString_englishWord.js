/*
function solution(str) {
  let answer = [];
  let tmp = [];
  let lists = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];
  for (let i = 0; i < str.length; i++) {
    if (str.charCodeAt(i) >= 97) {
      tmp.push(str[i]);
      if (lists.includes(tmp.join(""))) {
        answer.push(String(lists.indexOf(tmp.join(""))));
        tmp = [];
      }
    } else {
      answer.push(str[i]);
    }
  }
  return Number(answer.join(""));
}
*/
function solution(s) {
  let numbers = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];
  var answer = s;

  for (let i = 0; i < numbers.length; i++) {
    let arr = answer.split(numbers[i]);
    answer = arr.join(i);
  }

  return Number(answer);
}

console.log(solution("23four5six7"));
