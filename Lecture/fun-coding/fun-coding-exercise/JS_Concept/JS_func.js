//함수
//1. 일반 함수
function func(name) {
    console.log("Hello " + name);
}
func("LeeHyeEun");

//2. 화살표 함수(ES6) -> 익명 함수, 일반 함수보다 더 간단하게 정의 가능
let arrowFunc = (name) => {
    console.log('Hello ' + name);
}
arrowFunc("LeeHyeEun");

let f1 = userAge => userAge * 2;
console.log(f1(12)); //24

let f2 = (item1, item2) => item1 + item2;
console.log(f2(1, 5)); //6