"use strict";
//Promise로 콜백지옥 탈출하기
//callback 함수를 사용하지 않고, promise 객체를 사용하여 비동기 처리를 깔끔하게 수행
//Promise는 JS에 포함되어 있는 객체이다. 비동기 처리에 콜백함수 대신 유용하게 사용할 수 있는 객체이다.
//state: 기능 수행 중인지(pending), 기능을 수행하고 성공(fulfilled)했는지, 실패(reject)했는지에 대한 상태
//producer: 원하는 데이터를 제공 -> Promise Obj
//consumer: 제공된 데이터를 사용하는 consumer

//1. Producer
//우리가 원하는 기능을 비동기적으로 실행하는 Promise
//when new Promise is created, the executor runs automatically.
const promise = new Promise((resolve, reject) => {
  //executor
  //doing some heavy work -> network, read files ..
  console.log("doing something...");
  setTimeout(() => {
    //resolve("hyeeun"); // 성공
    reject(new Error("no network"));
  }, 2000);
});

//2. Consumer
// Consumer는 then, catch, finally 사용하여 값을 받아올 수 있다.
promise
  .then((value) => {
    //promise가 잘 수행되어서 resolve의 인자로 넘겨준 'hyeeun'이 value 값이 된다.
    console.log(value);
  })
  .catch((error) => {
    console.log(error);
  })
  .finally(() => {
    // 성공 실패와 상관없이 무조건 마지막에 호출되어진다.
    console.log("finally");
  });

//3. Promise Chaining
const fetchNumber = new Promise((resolve, reject) => {
  setTimeout(() => resolve(1), 1000); //1초 후에 숫자 1을 전달
});
fetchNumber
  .then((num) => num * 2)
  .then((num) => num * 3)
  .then((num) => {
    return new Promise((resolve, reject) => {
      setTimeout(() => resolve(num - 1), 1000);
    });
  })
  .then((num) => console.log(num));

//4. 오류 처리(Error Handling)
const getHen = () => {
  //promise를 반환하는 함수
  // {}를 사용하려면 return 해줘야 한다.
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve("🐓"), 1000);
  });
};
const getEgg = (hen) =>
  //promise를 반환하는 함수
  new Promise((resolve, reject) => {
    setTimeout(() => reject(`error! ${hen} => 🥚`), 1000);
  });

const cook = (egg) =>
  //promise를 반환하는 함수
  new Promise((resolve, reject) => {
    setTimeout(() => resolve(`${egg} => 🍳`), 1000);
  });

getHen()
  .then(getEgg) //then에서 받아오는 value를 getEgg 함수의 인자로 전달됨
  .catch((error) => {
    //전달된 error를 잘 처리해서 getEgg에서 에러가 생겨도 lemon 이모티콘으로 대체하여 반환하도록 함
    return "🍋";
  })
  .then((egg) => cook(egg))
  .then((meal) => {
    return console.log(meal);
  })
  .catch(console.log);
