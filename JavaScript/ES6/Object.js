//객체
/*
JS의 데이터 타입 중 하나이며, 연관된 데이터 혹은 함수(메서드)들의 모음집이다. 
거의 모든 객체는 JS 객체의 인스턴스이다.
*/
//1. Object
const me = {
  //객체 리터럴을 사용하여 객체 생성
  myName: "hyeeun",
  age: 25,
};
console.log(me);

me.hasJob = false; //이미 객체가 생성되었더라도 추가가 가능 = 가능한 사용하지 않기
console.log(me);

delete me.hasJob;
console.log(me);

console.log(me.myName); //hyeeun -> dot 방식
console.log(me["myName"]); //hyeeun -> computed properties 방식

console.log(me.hasJob); //undefined
me["hasJob"] = false;
console.log(me.hasJob); //false

function printValue(obj, key) {
  //key는 사용자가 정해서 넘겨줌
  console.log(obj[key]);
}
printValue(me, "myName"); //hyeeun
printValue(me, "age"); //25

//JS에 클래스가 도입되기 전
//아래와 같은 규칙으로 객체 생성 함수를 정의 했었다.
function MakeMe(name, age) {
  this.name = name;
  this.age = age;
}
const me2 = new MakeMe("HE", 25);
console.log(me2); //MakeMe { name: 'HE', age: 25 }

//In operator: 객체에 해당 key가 존재하는지 확인하는 operator
console.log("name" in me2);

//for ..in  vs  for ..of
for (v in me2) {
  //me2가 가지는 key들이 블럭을 돌 때마다 v라는 지역변수에 할당이 된다.
  console.log(v);
}

const arr = [1, 2, 4, 5];
for (let x of arr) {
  console.log(x);
}
//1, 2, 4, 5

//객체 복사 하기
//old way
const user1 = { name: "soongob", age: 20 };
const user3 = {};
for (key in user1) {
  user3[key] = user1[key];
}
console.log(user3);
user3.name = "hyeeun";
console.log("user3.name: ", user3.name); //hyeeun
console.log("user1.name: ", user1.name); //soongob

//Object.assign 사용
const fruit = { name: "apple", color: "red" };
const targetFruit = {}; //target
Object.assign(targetFruit, fruit);

targetFruit.name = "banana";
console.log("assigned obj: ", targetFruit.name);
console.log(fruit.name);

//assign은 여러개의 source를 사용해도 된다.
const info = { name: "hyeeun", age: 25 };
const info2 = { name: "soongob" };
const mixed = Object.assign({}, info, info2);
console.log(mixed.name);
console.log(mixed.age);
