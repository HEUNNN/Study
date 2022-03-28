"use strict";
//1. class와 object 만들어보기
/*
class: template
object: instance of a class
*/
//1) class 정의 하기
class Person {
  //constructor(생성자)
  constructor(name, age) {
    //fields
    this.name = name;
    this.age = age;
  }
  //method
  speak() {
    console.log(`${this.name}: Hello!`);
  }
}
//2) object 만들어 보기
const me = new Person("hyeeun", 25); //객체 생성 완료
console.log(me.name);
console.log(me.age);
me.speak();

//2. Getter & Setter
class User {
  constructor(firstName, lastName, age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age; //get이 정의되는 순간 this.age는 단순 변수가 아니라 getter를 호출한다.
  }

  get age() {
    //값을 return
    return this._age;
  }

  set age(value) {
    //값을 조건에 맞게 설정(보정)
    if (value < 0) {
      throw Error("Age can not be negative.");
    }
    this._age = value;
  }
}

//const user1 = new User("Lee", "hyeeun", -1);
const user2 = new User("Lee", "DM", 28);
//age에 음수를 지정하는 실수가 생겼다! -> 이런 사용자의 실수를 보완하는 것이 Getter와 Setter이다.

//3. Fields(Public, Private)
class Experiment {
  publicField = 2;
  #privateField = 0; //클래스 내부에서만 조회, 변경 등이 가능
}
const experiment = new Experiment();
console.log(experiment.publicField); //2
console.log(experiment.privateField); //undefined

//4. 상속(Inheritance)과 다양성
class Shape {
  constructor(width, height, color) {
    this.width = width;
    this.height = height;
    this.color = color;
  }

  draw() {
    console.log(`drawing ${this.color} color of`);
  }

  getArea() {
    return this.width * this.height;
  }
}

class Rectangle extends Shape {
  //새로 추가할 fields나 method 등을 추가하기
}
class Triangle extends Shape {
  draw() {
    super.draw(); //오버라이딩 하되, 부모의 메서드의 기능도 살리기 위해 super 사용
    console.log("▲");
  }
  getArea() {
    //오버라이딩
    return (this.width * this.height) / 2;
  }
}

const rectangle = new Rectangle(20, 20, "blue");
rectangle.draw();
console.log("Rectangle area is ", rectangle.getArea()); //400

const triangle = new Triangle(20, 20, "red");
triangle.draw();
console.log("Triangle area is", triangle.getArea()); //200

//5. Class Checking: instanceOf
console.log(rectangle instanceof Rectangle); //true
console.log(triangle instanceof Rectangle); //false
console.log(triangle instanceof Triangle); //true
console.log(triangle instanceof Shape); //true
console.log(triangle instanceof Object); //true
