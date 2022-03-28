"use strict";
//1. Asynchronous & Synchronous
//동기: 작성된 코드 순서대로 실행
//비동기: 언제 코드가 실행될 지 예측이 불가능 -> 코드 작성 순서대로 실행 X
//  Hoisting 이 된 이후부터 코드가 작성한 순서에 맞춰서 하나씩 동기적으로 실행
//  Hoisting? var , function declaration 들이 자동적으로 코드의 최상단으로 이동되는 현상
console.log("1");
setTimeout(() => console.log("2"), 1000);
console.log("3");
console.log("4");

//Synchronous callback
console.log("1");
function printImmediately(printCb) {
  printCb();
}
printImmediately(() => console.log("2"));
console.log("3");
//Asynchronous callback
console.log("1");
function printWithDelay(printCb, timeout) {
  setTimeout(printCb, timeout);
}
printWithDelay(() => console.log("2"), 1000);
console.log("3");
/*
1 
3
2
*/

//2. Callback Hell
//1) callback hell example
class UserStorage {
  loginUser(id, password, onSuccess, onError) {
    setTimeout(() => {
      if (
        (id === "ellie" && password === "dream") ||
        (id === "coder" && password === "academy")
      ) {
        onSuccess(id);
      } else {
        onError(new Error("not Found")); // Error 객체를 생성한다. ->  new Error
      }
    }, 2000);
  }
  getRoles(userId, onSuccess, onError) {
    // 사용자가 역할을 받아온다.
    setTimeout(() => {
      if (userId === "ellie") {
        onSuccess({ userName: "hyeeun", userRole: "admin" });
      } else {
        onError(new Error("no access!"));
      }
    }, 1000);
  }
}

const userStorage = new UserStorage();
const id = "ellie";
const password = "dream";
userStorage.loginUser(
  id,
  password,
  (userId) => {
    userStorage.getRoles(
      userId,
      (userWithRole) => {
        console.log(
          `Hello ${userWithRole.userName}, you have a ${userWithRole.userRole}. `
        );
      },
      (error) => {
        console.log(error);
      }
    );
  },
  (error) => {
    console.log(error);
  }
);
