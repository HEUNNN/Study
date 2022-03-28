"use strict";

//1. Variable: 변경될 수 있는 값(변수)
//let keyword 사용 (var은 잘 사용하지 않음)
let myName = "hyeeun";
console.log(myName);
myName = "soon_gob";
console.log(myName);

/* Block Scope 에러 발생
{
  let fruit = "apple";
  console.log(fruit);
}

console.log(fruit);
*/
//var를 사용하면 안되는 이유 -> Hoisting, Block Scope 무시
console.log(age); //undefined
age = 4;
console.log(age); //4
var age;

/* let은 Hoisting 허용하지 않고 오류가 발생함  
color = "red";
let color;
*/
//let 변수는 color을 선언하기 전에 값을 할당하면 에러가 발생 -> 당연한 현상
/*
{
	var fruit = 'apple';
{
console.log(fruit); //apple -> block scope 적용이 안됨
*/

//premitive 변수 타입 중 Symbol 특징 예시
const symbol1 = Symbol("id");
const symbol2 = Symbol("id");
console.log(symbol1 === symbol2); //false

const gSymbol1 = Symbol.for("a");
const gSymbol2 = Symbol.for("a");
console.log(gSymbol1 === gSymbol2); //true
//symbol 값 출력 방법
console.log(`value: ${symbol1.description}, type: ${typeof symbol1}`);
//value: id, type: symbol

//Dynamic Typing -> JS의 특징(TypeScript 탄생의 원인)
/*
선언시 어떤 타입인지 선언하지 않고,
프로그램이 동작할때 할당된 값에 따라서 타입이 변경될 수 있다는 것을 의미한다.
(java나 C등의 언어는 해당되지 않음)
-> 혼란을 일으킬 수 있다.
*/
let text = "hello";
console.log(`value: ${text}, type: ${typeof text}`);
//value: hello, type: string
text = 1;
console.log(`value: ${text}, type: ${typeof text}`);
//value: 1, type: number
text = "7" + 5;
console.log(`value: ${text}, type: ${typeof text}`);
//value: 75, type: string
text = "8" / "2";
console.log(`value: ${text}, type: ${typeof text}`);
//value: 4, type: number
