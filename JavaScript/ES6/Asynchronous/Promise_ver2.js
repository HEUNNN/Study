"use-strict";
//Promise: 비동기 동작에서 콜백함수 대신에 유용하게 사용할 수 있는 객체 -> 비동기를 간편하게 처리할 수 있음
//-> Resolve & Reject

//Promise is a JavaScript object for asynchronous operation.
/*
Promise 공부 point
1. state -> 이미 실행한 동작인지, Resolve(성공) or Reject(실패) 상태 이해
2. Producer와 Consumer의 차이점 이해
Resolve === Fulfilled
*/
/* state
pending(promise가 생성 후 operation이 진행 중..) -> Resolve(operation을 성공적으로 끝냄) or Rejected
Producer: 정보 제공자
Consumer: 정보 사용자
*/

//1. Producer(Promise 생성)
//새로운 promise 객체가 만들어질때는 excutor라는 callback 함수가 바로 실행이 된다.
const promise = new Promise((resolve, reject) => {
  //excutor callback func
  //무거운 작업들은 동기적으로 수행하지 말고, Promise를 사용하여 비동기적으로 수행하는것이 좋다.(heavy: network, read files)
  console.log("doing somthing");
  setTimeout(() => {
    resolve("ellie"); //promise가 정상적으로 수행되면 resolve 콜백 함수에서 'ellie'를 전달함
    reject(new Error("no network")); //reject는 Error라는 객체를 통해서 보통 값을 전달한다.
  }, 2000);
});
//Promise 객체를 생성하는 순간 전달한 excutor라는 콜백 함수가 바로 실행됨
//즉 Promise 안에 네트워크 통신과 관련된 코드를 작성했다면 promise 객체가 생성되자마자 네트워크 통신이 시작됨
//if 사용자가 원할때만 네트워크 통신을 수행해야 한다면? 위의 코드는 promise 객체 생성과 동시에 통신이 수행되니 낭비됨, 주의 하기

//2. Consumer(Promise 사용): then, catch, finally를 통해 값을 받아올 수 있다.
promise
  .then((value) => {
    //value = 'ellie'
    //값이 정상적으로 수행이 된다면(then) 값(value)을 받아와서 원하는 기능을 수행하는 callback 함수를 전달
    console.log(value);
  })
  .catch((error) => {
    console.log(error);
  })
  .finally(() => {
    //성공, 실패 여부에 상관없이 마지막에 호출됨
    console.log("finally");
  });

//3. Promise Chaining
