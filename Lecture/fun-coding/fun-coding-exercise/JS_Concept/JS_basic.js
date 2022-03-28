/*
Vanilla JS: javascript 기반의 다양한 라이브러리(예: jquery) 보다, javascript 자체의 기능만 쓰는 JS
jquery를 javascript와 함께 사용하면 다양한 추가 기능과 간단한 사용이 가능하지만,
이런 라이브러리들은 사이즈가 커서 실행 속도가 느리고 다운로드 시간이 오래 걸리며
디버깅시 라이브러리 내부 코드까지 들어가야 하는 경우가 있으므로, 디버깅이 매우 어려운 단점이 존재
-> 최근에는 라이브러리를 최소로 사용하고, javascript 자체만을 사용하고자 노력 중
-> javscript만으로는 코드가 매우 길어지기에 react or vuejs 등을 사용하여 속도도 개선하고,
   코드의 간결성도 챙기는 frame work을 별도로 사용한다.
*/

//변수
//1. 변수만 선언 (let)
let testValue;
testValue = 1;
console.log('let value test:', testValue); //answer: 1
testValue = "apple";
console.log('let value test:', testValue); //answer: apple

//2. 상수 선언 (const)
const testValue2 = 1;
console.log('const value test:', testValue2);

//Javsscript data type
//1. Number: 정수, 부동소숫점을 통째로 Number 데이터 타입으로 처리
const testValue3 = 1;
const testValue4 = 1.254; //부동소숫점
console.log("data type test:", typeof testValue3); //answer: number
console.log("data type test:", typeof testValue4); //answer: number

//2. Boolean
const testValue5 = 1 > 2; //false
console.log(typeof testValue5);
console.log(testValue5);
const testValue6 = Boolean('a') //보통 text는 true
const testValue7 = Boolean('') //empty is false
const testValue8 = Boolean(0) //zero is false
console.log('a', testValue6, 'empty', testValue7, 'zero', testValue8);

//3. null and undefined
//null은 값이 없음을 나타내고, undefined는 값이 할당되지 않았음을 나타냄
//undefined: 변수를 위한 공간은 있지만 값을 아직 설정하지 않아 할당되지 않음
let testValue9; //undefined -> 값은 설정하지 않고 선언만 한 상태
console.log('typeof:', typeof testValue9, "value", testValue9);
let testValue10 = null; //type은 object, value는 null
console.log('typeof', typeof testValue10, 'value', testValue10);

//4. object
//객체 타입을 나타냄 -> 별도 문법으로 한번에 다룰것임

//5. symbol -> ES6에서 추가된 타임
//Symbol은 unique한 값을 만든다.
// -> symbol([description])description은 문자열, 숫자 등의 데이터가 될 수 있으며,
//    해당 심볼을 설명하기 위한 목적 이외에는 심볼 생성, 접근등과 관련 없음
let testSymbol1 = Symbol(1);
let testSymbol2 = Symbol(1);
console.log('testSymbol1', testSymbol1, "typeof testSymbol1", typeof testSymbol1);
console.log('testSymbol2', testSymbol2, "typeof testSymbol2", typeof testSymbol2);
console.log('==', testSymbol1 == testSymbol2);
console.log("===", testSymbol1 === testSymbol2);
console.log(testSymbol2); //null이 출력 됨

//데이터 타입 변환
//1. Number()
console.log('type', typeof Number('a'), "transform a -> ?", Number('a'));
console.log('type', typeof Number('1'), "transform '1' -> ?", Number('1'));

//2. parseInt() or parseFloat()
let floatNum = 1.234;
console.log('original value', floatNum, 'type', typeof parseInt(floatNum), 'value print', parseInt(floatNum));

//3. Boolean()
let str = "apple";
console.log('original value', str, 'original type', typeof str, 'transform type', typeof Boolean(str), 'transform value', Boolean(str));

//4. String()
let num = 12;
console.log('original value', num, 'original type', typeof num, 'transform type', typeof String(num), 'transform value', String(num));

//동등 연산자와 일치 연산자
// ==, !=(동등 연산자): 관대한 연산자로 기본적으로 값만 같은지 확인, ===, !==(일치 연산자): 엄격한 연산자로 기본적으로 값과 데이터 타입 둘 다 같은지를 확인
let a = "12";
let b = 12;
console.log("==", a == b); //true
console.log("===", a === b); //false

//++ 연산자
//변수++: 변수에서 먼저 값을 꺼내고, 그 다음에 1을 더함
//++변수: 변수 값에 1을 더한 값을 꺼냄
let val = 1;
console.log(val++ === 2); //false, 초기의 val 값 1을 꺼내서 2와 비교(===)하여 false를 return하고 val + 1
console.log(val); //2  
console.log(++val === 3); //true, val에 1을 더해서 3과 비교(===)
console.log(val);

//대입 연산자
let val2 = 1;
val2 += 1; //val2 = 2
console.log(val2);
val2 -= 1; //val2 = 1
console.log(val2);
val2 *= 5; //val2 = 5
console.log(val2);
val2 /= 5; //val2 = 1
console.log(val2);

//논리 연산자
let val3 = false;
console.log(!val3);
let val4 = true && true; //&&: and 
let val5 = false && true;
console.log(val4, val5);
let val6 = true || true;
let val7 = true || false;
console.log(val6, val7);

//문자열 연산 : +로 문자열을 합칠 수 있음
let string1 = "Hello";
console.log(string1 + " World!"); //Hello World!

//조건문
//1. if 문
let age = "21";
if (age > 20) {
    console.log("성인입니다.");
} else if (age > 15) {
    console.log("청소년입니다.");
} else {
    console.log("어린이입니다.");
}
//2. switch/case 구문
let age1 = 15;
switch (age1) {
    case 12: //조건이 맞으면 아래 조건도 실행하기 때문에 break가 필요
        console.log("12살입니다.");
        break;
    case 13:
        console.log("13살입니다.");
        break;
    default: //조건이 다 안맞았을때 실행 => else문과 유사
        console.log("매칭되는 나이가 없습니다.");
}