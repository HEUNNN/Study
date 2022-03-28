"use strict";
//Array
//Array: 자료구조의 종류 중 하나
//1. 배열 선언
const arr1 = new Array();
const arr2 = [];
//2.index를 사용하여 배열에 접근하기
const fruits = ["apple", "banana"];
console.log(fruits); //['apple', 'banana']
console.log(fruits.length); //2
console.log(fruits[0]); // apple
console.log(fruits[fruits.length - 1]);
console.log(fruits[3]); // undefined

for (let elem of fruits) {
  console.log(elem);
}

fruits.forEach((elem, idx, totalArr) =>
  console.log(`Element: ${elem}, Index: ${idx}, Total Array: ${totalArr}`)
);
/*
.forEach(callback func, thisArg);
callback (value, index, array) =>  void 로 구성
array는 전체적인 배열을 의미
*/

//2. 배열에 요소를 추가/삭제 하기
//추가 ->  push , unshift(맨 앞에 추가)
fruits.push("strawberry", "watermelon");
console.log(fruits);
fruits.unshift("grape");
console.log(fruits);
//삭제 -> pop, shift(맨 뒤의 item 삭제)
fruits.pop();
console.log(fruits);
fruits.shift();
console.log(fruits);

//splice ->  인덱스를 사용하여 특정 위치의 item 삭제
fruits.push("lemmon", "peach", "watermelon");
console.log(fruits);
//[ 'apple', 'banana', 'strawberry', 'lemmon', 'peach', 'watermelon']
const d = fruits.splice(2, 2);
console.log(d);
console.log(fruits);
fruits.splice(1, 1, "grape", "orange");
console.log(fruits);
//concat -> 2개의 배열을 합치는 배열의 API
const fruits2 = ["coconut", "pear"];
const newFruits = fruits.concat(fruits2);
console.log(newFruits);
//indexOf : 요소의 index 칮기
console.log("origin fruits: ", fruits, "origin fruits2: ", fruits2);
console.log(`apple \'s index: ${fruits.indexOf("apple")}`);
//includex: 배열에 해당 요소가 존재하는지에 대해 boolean 값 반환
console.log(`apple is exist? ${fruits.includes("apple")}.`);
//lastIndexOf: 찾고자하는 요소가 여러개있을떼, 그들 중 마지막 요소의 인덱스를 반환
fruits.push("orange");
console.log(fruits);
console.log(fruits.lastIndexOf("orange"));
