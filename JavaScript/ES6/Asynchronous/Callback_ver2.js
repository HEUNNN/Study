"use strict";

//JavaScript is synchronous.
//Execute the code block by orger after hoisting. -> hoisting이 된 이후부터 작성 순서에 맞추어 하나씩 동기적으로 실행된다.
//Hoisting: var 변수, function declaration 들이 자동적으로 코드의 제일 위로 올라가 실행되는것

/*
Synchronous: 정해진 순서에 맞게 코드가 실행됨 -> '동기'
Asynchronous: 언제 코드가 실행될지 예측할 수 없음 -> '비동기'
*/

console.log("1");
const callback = () => {
  console.log("hello");
};
callback();
setTimeout(callback, 1000);
console.log("2");
console.log("3");

//callback은 항상 비동기로 실행될까? No

//Synchronous callback
function printImmediately(print) {
  //print라는 callback 함수를 전달 받음
  print();
}
printImmediately(() => {
  //callback을 동기적으로 실행
  console.log("hi");
});

/* (동기) Hoisting이 적용된 실제로 실행된 코드 -> 함수 선언이 가장 위로 올라감(Hoisting)

function printImmediately(print) {
  print();
}

console.log("1");

setTimeout(() => {
  console.log("hello");
}, 1000);

console.log("2");
console.log("3");

printImmediately(() => {
  console.log("hi");
});

result
1
2
3
hi
hello
*/

//Asynchronous callback
function printWithDelay(print, timeout) {
  //setTimout()을 wrapping
  setTimeout(print, timeout);
}
const print = () => {
  //callback을 비동기적으로 실행
  console.log("Async callback");
};
printWithDelay(print, 2000);

/* (비동기) Hoisting이 적용된 실제로 실행된 코드 -> 함수 선언이 가장 위로 올라감(Hoisting)

function printImmediately(print) {
  print();
}

function printWithDelay(print, timeout) {
  setTimeout(print, timeout);
}

console.log("1");

setTimeout(() => {
  console.log("hello");
}, 1000);

console.log("2");
console.log("3");

printImmediately(() => {
  console.log("hi"); //callback을 동기적으로 실행
});

printWithDelay(() => { //callback을 비동기적으로 실행
  console.log("Async callback"); 
}, 2000);

result
1
2
3
hi
hello
world!
*/

//callback 지옥
class UserStorage {
  loginUser(id, password, onSuccess, onError) {
    setTimeout(() => {
      if (
        (id === "ellie" && password === "dream") ||
        (id === "coder" && password === "academy")
      ) {
        onSuccess(id);
      } else {
        onError(new Error("Not Found"));
      }
    }, 2000);
  }
  getRoles(user, onSuccess, onError) {
    setTimeout(() => {
      if (user === "ellie") {
        onSuccess({ name: "ellie", role: "admin" });
      } else {
        onError(new Error("No Access"));
      }
    }, 1000);
  }
}

const userStorage = new UserStorage();
const id = prompt("enter your id");
const password = prompt("enter your password");
userStorage.loginUser(
  id,
  password,
  (user) => {
    userStorage.getRoles(
      user,
      (userWithRole) => {
        alert(`Hello ${userWithRole.name},  you have a ${user.role} role `);
      },
      (error) => {
        console.log("Error");
      }
    );
  },
  (error) => {
    console.log("Error");
  }
);
/* callback 지옥의 단점
 1. 가독성이 떨어진다.
 2. 에러 분석, 디버깅, 유지보수를 해야하는 경우에 어렵다.
*/
//콜백 지옥
let list = [];
setTimeout(
  (name) => {
    list.push(name);
    console.log(list);

    setTimeout(
      (name) => {
        list.push(name);
        console.log(list);

        setTimeout(
          (name) => {
            list.push(name);
            console.log(list);

            setTimeout(
              (name) => {
                list.push(name);
                console.log(list);
              },
              500,
              "카페모카"
            );
          },
          500,
          "카페라떼"
        );
      },
      500,
      "아메리카노"
    );
  },
  500,
  "에스프레소"
);
//[ '에스프레소', '아메리카노', '카페라떼', '카페모카' ]
