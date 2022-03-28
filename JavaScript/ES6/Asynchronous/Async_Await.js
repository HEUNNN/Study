"use strict";
//Async & Await: Promise를 좀 더 간편하고, 동기적으로 실행되는 것 처럼 보이게 해준다.
//Promise 체이닝을 하게 되면 코드가 난잡해질 수 있다.
//Async, Await은 새로운 것이 아니라 Promise 위에 더 간편한 API를 제공한다.
// = syntatic sugar

//1. Async
//1) Promise로 비동기 처리
function fetchUser() {
  //do network request in 10 sec..
  return new Promise((resolve, reject) => {
    resolve("hyeeun");
  });
}
const user = fetchUser();
user.then((userName) => {
  console.log(userName);
});
console.log("hi");
console.log(user);

//2) Promise를 사용하지 않고 비동기를 작성하기 -> Async
async function User() {
  //async를 함수 앞에 붙여주면, 자동적으로 함수안의 코드 블럭들이 Promise로 변환된다.
  return "hyeeun";
}
const info = User();
info.then((userName) => console.log(userName));
console.log("hi");
console.log(info);

//3) Await
function delay(ms) {
  return new Promise((resolve, reject) => {
    setTimeout(resolve, ms); //정해진 시간이 지나면 resolve를 호출
  });
}
async function getLemon() {
  //async는 Promise를 생성하여 반환
  await delay(3000);
  return "🍋";
}
async function getStar() {
  //async는 Promise를 생성하여 반환
  await delay(3000);
  return "🌟";
}
getLemon().then((lemon) => console.log(lemon)); //🍋
getStar().then(console.log); //🌟, 위 코드를 간단하게 작성한 것 -> 그냥 console.log만 해도 출력이 됨
/* 위 코드를 promise로 표현
function getStar() {
  //delay(3000)은 promise
  return delay(3000).then(() => {
    return "🌟";
  });
}
*/
/* Promise 체이닝을 중첩적으로 사용하면 콜백 지옥이 발생 -> async로 해결
function pickEmoticon() {
  return getLemon().then((lemon) => {
    return getStar().then((star) => `${lemon} + ${star}`);
  });
}
*/
async function pickEmoticon() {
  const lemon = await getLemon();
  const star = await getStar();
  return `${lemon} + ${star}`;
}
pickEmoticon().then(console.log); // pickEmoticon() 모두 성공시 console.log, 총 6초 소요

//4) await의 병렬처리 -> use Promise APIS(유용한 Promise)
function delayTime(ms) {
  return new Promise((resolve, reject) => {
    setTimeout(resolve, ms); //정해진 시간이 지나면 resolve를 호출
  });
}
async function getApple() {
  //async는 Promise를 생성하여 반환
  await delayTime(1000);
  return "🍎";
}
async function getBanana() {
  //async는 Promise를 생성하여 반환
  await delayTime(2000);
  return "🍌";
}
function pickAllFruits() {
  //프로미스의 배열을 전달하고, 그 배열 내부의 모든 프로미스들이 병렬적으로 받아질때까지 모아준다.
  return Promise.all([getApple(), getBanana()]).then((fruitsArr) =>
    console.log(fruitsArr)
  );
}
pickAllFruits();

function pickOnly() {
  return Promise.race([getApple(), getBanana()]);
}
pickOnly().then((f) => console.log(`The first is ${f}`));

//Home Work
/*
callback 지옥 예제인 userStorage 부분을 async와 await을 사용하여 지옥을 탈출해보기
*/
