"use strict";
//Promise로 callback hell 없애기
class UserStorage {
  loginUser(id, password) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (
          (id === "ellie" && password === "dream") ||
          (id === "coder" && password === "academy")
        ) {
          resolve(id);
        } else {
          reject(new Error("not Found")); // Error 객체를 생성한다. ->  new Error
        }
      }, 2000);
    });
  }
  getRoles(userId) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (userId === "ellie") {
          resolve({ userName: "hyeeun", userRole: "admin" });
        } else {
          reject(new Error("no access!"));
        }
      }, 1000);
    });
  }
}
const userStorage = new UserStorage();
const id = "ellie";
const password = "dream";
userStorage
  .loginUser(id, password)
  .then((userId) => userStorage.getRoles(userId))
  .then((userInfo) => {
    console.log(
      `user-name: ${userInfo.userName}, user-roles: ${userInfo.userRole}`
    );
  })
  .catch((error) => console.log(error));
