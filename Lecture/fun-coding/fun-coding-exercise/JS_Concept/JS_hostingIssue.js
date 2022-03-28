//호스팅 이슈
//1. Hosting Issue: 일반적인 언어는 함수, 변수를 선언한 후, 이후 라인에서 해당 함수와 변수를 사용할 수 있으나,
//                 Javascript에서는 함수 도는 변수 선언 전에 해당 함수 또는 변수를 사용해도 에러를 내지 않는 현상을 의미
//1.1 var: let과 같이 변수 선언에 쓰이는 키워드로, let과 달리 동일한 이름의 변수를 여러번 선언할 수 있음
//        -> hosting issue의 원인이 됨
console.log(a); //undefined
var a = 1; //let으로 선언시 오류가 남
var a = 2;
a = 3;
console.log(a); //3

//함수의 경우
getData();
function getData() {
    console.log("Hello");
}
//1.2 Hosting 문제 발생 이유
/*
Javascript는 함수와 변수 선언을 실행 전, 실행 영역의 맨 앞으로 이동해서 실행한다.
console.log(a); //undefined
a = 10;
console.log(a)
var a = 20;
  위 코드의 실제 동작
var a; //초기값은 넣지 않은채로 only 선언만 일단 한다.
console.log(a);
a = 10;
console.log(a);
a = 20;
console.log(a);
*/

//1.3 해결 방안
/*
1) 변수 선언의 경우, var 키워드는 사용하지 않고 let과 const만 사용할 것
2) 함수 선언의 경우 함수 표현식으로 사용할 것
*/
//함수 선언문
function getName(name) {
    console.log(name);
}
//함수 표현식
let func = function () {
    console.log("Hello World!");
}