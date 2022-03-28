//JavaScript  Function
//1. 함수 선언식 형태의 함수 -> Hoisting 발생
function printHello(userName) {
  //userName의 type이 따로 정해져있지는 않다.
  //TypeScript에서는 parameter의 type을 지정해주어야 한다.
  console.log(`Hello ${userName}.`);
}

printHello("hyeeun");

//2. 함수 표현식 형태의 함수 -> Hoisting 발생 X
//1)
const func = function funcName() {
  //named function => 디버깅할때 좋다.
  console.log("This is function.");
};
func(); //This is function.
const func2 = func; //func함수를 func2 변수의 값으로 할당
func2(); //This is function.

//2) Arrow Function
const func3 = () => {
  console.log("This is Arrow Function!!");
};
func3();
//This is Arrow Function!!
/*
Arrow Function의 경우 {} 생략이 가능하다. 그러나 코드가 길 경우 {}를 사용해야하며,
{}를 사용할때는 값을 return 해주어야 한다.({}사용하지 않을때는 return 안해도 됨)
*/

//3. callback
function randomQuiz(answer, printYes, printNo) {
  if (answer === "love you") {
    printYes();
  } else {
    printNo();
  }
}

const printYes = function yes() {
  //named function -> 디버깅시 좋다
  console.log("Yes!");
};

const printNo = function () {
  //anonymous function
  console.log("No!");
};

randomQuiz("wrong", printYes, printNo); //printYes(), printNo()를 넘겨줌
randomQuiz("love you", printYes, printNo);

//4. IIFE ->  함수 선언과 동시에 함수를 호출하기
(function hello() {
  console.log("IIFE");
})();
