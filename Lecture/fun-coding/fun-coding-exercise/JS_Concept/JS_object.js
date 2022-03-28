//객체, object
/*
Javascript 객체: property(일종의 변수)외, method(일종의 함수)로 이루어지며, Javascript의 property는 보통 key와 value로 이루어져 있음
tip) CSS의 객체는 property로 이루어져 있고, 각 property에 대응하는 property value로 이루어져 있음
tip) HTML의 객체는 attribute(속성)과 attribute value로 이루어져 있음
*/
//1. Javascript 객체 property와 method

// property는 보통 문자열 혹은 심볼값으로 구성, property value는 해당 키에 저장하고자하는 데이터가 들어 있음
//method는 일반 함수와 구분하여, 객체가 가지고 있는 함수를 일컬음

//1.1 javascript 객체 생성 방법: 객체 리터럴 (const를 주로 사용)
const user = {
    name: "hyeeun",
    age: 25,
    get_data: function () {
        return 1 + 2;
    },
};
console.log(user);
console.log('type', typeof user);
console.log(user.name); //hyeeun
console.log(user.age); //25
user.age = 20;
console.log(user.age);
console.log(user.get_data());

const emptyObject = {};
console.log(emptyObject);
emptyObject.name = 'leehyeeun';
console.log(emptyObject.name);

const me = { //객체안에 객체를 생성하기
    age: 25,
    name: "leehyeeun",
    details: {
        hobby: "youtube",
        major: "ICE",
        get_details: function (item) {
            return item * 2;
        },
    },
}
console.log(me.name);
console.log(me.details.hobby); //youtube
console.log(me.details.major); //ICE
console.log(me.details.get_details(3)); //6

//1.2 객체 리터럴과 this 키워드
// this 키워드는 자신의 객체를 가리킴

const aboutMe = {
    age: 25,
    name: 'hyeeun',
    details: {
        hobby: "Youtube",
        major: "ICE",
        get_hobby: function () {
            return this.hobby; //나의 객체 안의 hobby 값을 받아오려면 this가 필요
        },
        get_tall: (tall) => { //arrow function에서는 this를 사용할 수 없음
            return tall;
        }
    }
}
console.log(aboutMe.details.get_hobby('aa')); //Youtube
console.log(aboutMe.details.get_hobby()); //Youtube
console.log(aboutMe.details.get_tall(158));

//1.3 getter와 setter
/*
클래스 기반 객체 지향 문법에서는 클래스 내부 변수를 외부에서 어느 범위까지 접근할 수 있을지를 지정하는 문법을 제공한다. (private, public 등)
javascript 객체 리터럴에서는 이와 유사한 기능으로 getter(획득자), setter(설정자) 기능을 제공
메서드를 포함해서, 전체를 프로퍼티라고 할 때 프로퍼티를 데이터 프로퍼티(일반적 프로퍼티), 접근자 프로퍼티(getter or setter)로 나누기도 함
getter는 프로퍼티 값을 읽을 때 호출되는 메서드, setter는 프로퍼티 값을 수정할 때(설정할 때) 호출되는 메서드
**getter는 선언시 인자가 없어야 하고, setter는 선언시 인자가 반드시 하나 있어야 함
*/

const hyeeun = {
    firstName: 'Lee',
    age: 25,
    get getter_age() {
        return this.age;
    },
    set setter_age(value) {
        this.age = value;
    },
};
console.log(hyeeun.getter_age); //25
hyeeun.setter_age = 20; //수정
console.log(hyeeun.getter_age); //20

//2. new Object()
const userInf = new Object();
console.log(userInf); //{}, empty
userInf.name = "leehyeeun";
userInf.age = "25";
userInf.get_data = function () {
    return 3 * 4;
};
console.log(userInf.name, userInf.age, userInf.get_data()); //'leehyeeun' 25 12

//3. 생성자 함수로 생성하는 방식
function User(age, name) {
    this.age = 25; //this를 사용해주어야 함
    this.name = "hyeeun";
}
const leehyeeun = new User(25, "hyeeun");
console.log(typeof leehyeeun);
console.log(leehyeeun.age, leehyeeun.name);

//3.1 prototype(프로토타입)
/*
생성자 함수에 프로퍼티 또는 메서드 정의 가능
'객체이름.property.propertyname = code'와 같이 사용
*/
function userInformation(age, name) {
    this.age = age;
    this.name = name;
}

userInformation.prototype.message = function () {
    return 'Hello';
}
userInformation.prototype.hobby = 'youtube';

const lili = new userInformation(25, "hyeeun");
console.log(lili.age, lili.name, lili.hobby); //25 hyeeun youtube
console.log(lili.message()); //Hello

//4. javascript ES6와 클래스
/*
ES6에서 다른 언어의 객체 지향 문법과 유사한 class 키워드 기반 객체 생성 문법이 표준화 됨  
*/
//constructor(): 클래스 생성자 함수
//클래스 내부에 constructor()라는 이름으로 하나의 생성자 함수를 작성할 수 있음 -> function 키워드 사용X

class User1 {
    constructor() {
        this.name = "dave";
        this.age = 20;
    }

    get_message() {
        return "Hello!!";
    }
}
const dave = new User1();
console.log(typeof dave, dave.name, dave.age, dave.get_message());

class User2 {
    constructor(age, name) {
        this.age = age;
        this.name = name;
    }
}
const myInf = new User2(25, 'Hyeeun');
console.log(myInf.age, myInf.name);

//4.1 상속
//extends를 사용해서, 상속할 클래스를 선언할 수 있음
//자식 클래스에서는 super()(부모 클래스의 constructor()를 호출함)를 constructor() 안에서 호출해야 함

class Animal {
    constructor(name) {
        this.name = "Here is " + name;
    }

    get_message() {
        return "bye";
    }
}

class Zoo extends Animal {
    constructor(name, brand) {
        super(name);
        this.brand = brand;
    }
    get_message() { //부모 클래스를 상속받을지라도 부모 클래스의 특정 메서드를 자식 메서드가 덮어 씌움 
        return "Hello";
    }
}

const zooClub = new Zoo('everland', 'samsung');
console.log(zooClub.name, zooClub.brand);

//4.2 hasOwnProperty()
//클래스명.prototype.property name = property value; 클래스 외부에서 프로퍼티 추가 가능
//클래스 내부에서 선언한 프로퍼티임을 확인하기 위해 hasOwnProperty(perperty name);을 사용할 수 있음
//property만 사용가능하기 때문에 메서드는 사용이 불가능
class Fruit {
    constructor(name, color) {
        this.name = name;
        this.color = color;
    }
    get_message() {
        return "Delicious!";
    }
}
Fruit.prototype.size = 'small';

const myFavFruit = new Fruit('strawberry', 'red');
console.log(myFavFruit);
console.log('size: ', myFavFruit.size);
console.log(myFavFruit.hasOwnProperty('size')); //false
console.log(myFavFruit.hasOwnProperty('name')); //true