"use Strict";
//Operator: 연산
//1. string comcatenation(문자 병합)
console.log("my" + "cat");
console.log("3" + 4);
console.log(`string literals: 1 + 2 = ${1 + 2}`);
//2. Numeric operators
console.log(1 + 1); //add
console.log(1 - 1); //substract
console.log(1 / 1); //divide
console.log(1 * 1); //multiply
console.log(5 % 2); //remainder
console.log(2 ** 3); //exponentiation

//3. Increment and decrement operators
//1)Increment
let counter = 2;
const preIncrement = ++counter;
console.log(`preIncrement: ${preIncrement}, counter: ${counter}`);
/* preIncrement와 아래의 코드는 같은 의미
counter = counter + 1;
preIncrement = counter;
*/
const postIncrement = counter++;
console.log(`postIncrement: ${postIncrement}, counter: ${counter}`);
/* postIncrement와 아래의 코드는 같은 의미
postIncrement = counter;
counter = counter + 1;
*/

//2) Decrement
const preDecrement = --counter;
console.log(`preDecrement: ${preDecrement}, counter: ${counter}`);
/* preDecrement와 아래의 코드는 같은 의미
counter = counter - 1;
preDecrement = counter;
*/
const postDecrement = counter--;
console.log(`postDecrement: ${postDecrement}, counter: ${counter}`);
/* postDecrement와 아래의 코드는 같은 의미
postDecrement = counter;
counter = counter - 1;
*/

//4.Assignment operators(할당 연산자) -> +=, -=, *=, /=
let x = 3;
let y = 6;
x += y; //x = x + y
x -= y; //x = x - y
x *= y; //x = x * y
x /= y; //x = x / y

//5. Comparison operators(비교 연산자)
console.log(10 < 6); //less than
console.log(10 <= 6); //less than or equal
console.log(10 > 6); //greater than
console.log(10 >= 6); //greater than or equal

//6. Logical operators(논리 연산자) -> $$ || !(not)
const value1 = false;
const value2 = 4 < 2; //false
const value3 = true;
const check = () => {
  for (let i = 0; i < 10; i++) {
    //waisting time ...
    console.log("wait");
  }
  return true; //결국 true를 반환하는 함수
};
//1) &&(and): 비교 대상 모두가 true 값이여야 true를 반환
const andOperator1 = value1 && value3; //false
const andOperator2 = value3 && check(); //true
console.log(`And operators => res1: ${andOperator1}, res2: ${andOperator2}`);

//2) ||(or): 비교 대상 중 하나라도 true 값이면 true를 반환
const orOperator = value1 || value2 || check();
console.log(`Or operators => res: ${orOperator}`);

//3) !(not): 값을 반대로 바꾸어 줌
const value = 4 < 3; //false
console.log(value); //false
console.log(!value); //true

//7. Equality operators
const stringFive = "5";
const numberFive = 5;
//1) '==' loose equality, with type conversion
console.log(stringFive == numberFive); //true
//2) '===' strict equality, no type conversion
console.log(stringFive === numberFive);
//3) object equality by refernece
const ellie1 = { name: "ellie" };
const ellie2 = { name: "ellie" };
const ellie3 = ellie1;
console.log(ellie1 == ellie2);
console.log(ellie1 === ellie2);
console.log(ellie1 === ellie3);

//tip
console.log(0 == false); //true
console.log(0 === false); //false
console.log("" == false); //true
console.log("" === false); //false
console.log(null == undefined); //true
console.log(null === undefined); //false

//8. Conditional operators -> if, else if, else
const userName = "hyeeun";

if (userName === "hyeeun") {
  console.log("Hello, hyeeun!");
} else if (userName === "coder") {
  console.log("Hello, coder!");
} else {
  console.log("Hello, unknown!");
}

//9. Ternary operator
//condition ? trueValue : falseValue
const fruit = "apple";
console.log(fruit === "apple" ? `I like ${fruit}.` : `I don\'t like this.`);

//10. switch operator
const browser = "IE";
switch (browser) {
  case "IE":
    console.log("go away");
    break;
  case "Chrome": //같은 내용을 출력하기 때문에 반복해서 case를 선언
  case "Firefox":
    console.log("good");
    break;
  default:
    console.log("same all");
    break;
}

//11. while loop -> 조건의 상태가 false가 될때까지 반복
let i = 3;
while (i < 6) {
  console.log(`while: ${i}`);
  i++;
}
// 3, 4, 5

//12. do-while
//do block의 코드는 일단 처음 실행하고,
//while문 실행하여 조건이 true 일때만 { } 반복해서 실행
let j = 5;
do {
  console.log(`do while: ${j}`);
  j--;
} while (j > 5);
//do while: 5

//13. for loop
for (let k = 0; k < 4; k++) {
  console.log(`for: ${k}`);
}
//14. break, continue
//continue:  해당 코드만 멈추고 다음 step(i++)로 넘어감
//짝수만 출력
for (let n = 0; n <= 10; n++) {
  if (n % 2 === 0) {
    console.log(n);
  } else {
    continue;
  }
}
//break: Loop가 완전히 끝남
//0-10까지 도는 루프에서 8이되면 출력이 끝내기
for (let m = 0; m <= 10; m++) {
  if (m > 8) {
    break;
  }
  console.log(m);
}
