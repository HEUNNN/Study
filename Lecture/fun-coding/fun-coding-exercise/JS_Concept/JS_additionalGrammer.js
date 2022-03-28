//자주 나올 수 있는 javascript 추가 문법
//javascript는 코드를 더 간단하게 작성하기 위한 문법들이 존재한다.
//1. 삼항 연산자
//비교 해보기 => 같은 결과가 나온다.
const data1 = [1, 2];
if (data1.length === 0) {
    console.log('빈 배열입니다.');
} else {
    console.log('빈 배열이 아닙니다.')
}

data1.length === 0 ? console.log('빈 배열입니다.') : console.log('빈 배열이 아닙니다.');

//2. 함수의 기본 인자(parameter) 값 설정
// ES6 에서 나온 문법으로, 인자 값을 넣지 않을 시 디폴트로 인자에 넣어지는 값을 설정할 수 있음
//default 인자값을 설정하지 않았을때
function printName(name) {
    console.log(name);
}
printName(); //undefined
//default 인자값을 설정 하였을때
function printName2(item, name = 'hyeeun') {
    console.log('item: ', item, ',name: ', name);
}
printName2();
printName2('dave'); //제일 처음 인자부터 대입됨
printName2('item 1', 'dave');

//3. 구조 분해 할당(비구조화 할당) 문법
//구조 분해 할당은 배열이나 객체의 속성을 해체해서, 값을 개별 변수에 대입할 수 있게 하는 문법
let data2 = {
    userName: 'hyeeun',
    age: 25,
};
let { age, userName } = data2; //동일한 프로퍼티명을 써줘야, 해당 프로퍼티에 맞는 값이 대입됨
console.log(userName, age);

//property가 다른 변수명을 사용하고자 할 경우, 대입할 '프로퍼티명: 다른 변수명'의 형태로 써줘야 함
let { userName: myName, age: myAge } = data2;
console.log(myName, myAge);

//꼭 객체의 모든 프로퍼티를 가져올 필요는 없고, 객체의 프로퍼티 중 가져오고 싶은 데이터만 가져올 수 있음
let { userName: myName2 } = data2;
console.log(myName2);

let data3 = {
    fruit: 'apple',
    color: 'red',
};
//가져올 프로퍼티가 정의되어 있지 않을 경우에는 디폴트 값으로 대입하게끔 할 수 있음
let { fruit, whereIsIt = 'mart' } = data3;
console.log(fruit, whereIsIt);

//가져올 프로퍼티명을 다른 변수에 저장하되, 해당 프로퍼티명이 객체 안에 없을 경우, 다른 변수에 디폴트 값을 대입하기
let data4 = {
    grade: '4th',
    age: 24,
};
let { grade, age: studentAge = 25, studentHobby = 'Youtube' } = data4;
console.log(grade, studentAge, studentHobby);
//console.log(grade, age, stdudentAge, studentHobby); 출력시 에러남, age라는 프로퍼티는 myAge로 변수를 선언하기 때문

//4. 배열 분해 할당: 배열의 각 아이템을 별도 변수에 할당하는 문법
let arr1 = [1, 2, 3, 4];
let [first, second, third, fourth] = arr1;
console.log(second, third, first, fourth);
//배열의 일부만 추출 가능, 첫번째 아이템부터 대입하며 대입할 변수가 없을 경우는 대입하지 않음
let [element1, element2] = arr1;
console.log(element1, element2);
//대입할 아이템이 없을 경우, undefined로 대입
let arr2 = [1, 2];
let [item1, item2, item3, item4] = arr2;
console.log(item1, item2, item3, item4);
//특정 item만 갖고 오고 싶을 경우 -> 콤마 사용
let arr3 = [1, 2, 3, 'a', 5];
let [, , thirdItem, fourthItem, fifthItem] = arr3;
console.log(thirdItem, fourthItem, fifthItem);
//특정 원소는 배열로 반환하고 싶을때 ...  사용 -> '...'은 맨 마지막의 변수에만 사용해야 함
let arr4 = [1, 2, 3];
let [x1, ...x2] = arr4;
console.log(x1, x2);
//대입할 아이템이 없는 경우에, undefined 출력되는것이 아닌 내가 지정한 defaul값이 나오도록 함
let arr5 = [1, 2, 3, 4];
let [y1, y2, y3, y4, y5 = "default value"] = arr5;
console.log(y1, y2, y3, y4, y5);

//5. 유용한 구조 분해 할당 문법 활용 팁
//5.1 변수값 교환하기
let a = 1;
let b = 2;
[a, b] = [b, a];
console.log(a, b);
//5.2 함수 리턴시 여러 데이터 넘겨주기
function getData() {
    return [10, 100];
}
let [c, d] = getData();
console.log(c, d);
//5.2 문자열 분리해서, 각각의 변수에 대입하기 -> split('구분자')
//배열 분해 할당과 응용하기
let str = "Dave lee, fun-coding, coding";
let [teacherName, brand, subject] = str.split(',');
console.log(teacherName, subject);

//6. Rest 파라미터: 함수 인자 선언 앞에 '...'을 붙여서 정의하는 방법
//해당 함수에 전달된 인자 리스트는 하나의 배열로 해당 변수에 넣어짐
function sayHello(...rest) {
    console.log(rest);
    //typeof rest 실행시 object로 출력되므로, Array.isArray()의 경우
    //인자값이 배열이면 true를 return 하므로, 이를 사용해서 해당 변수가 배열임을 확인
    console.log(Array.isArray(rest));
}

sayHello("hello", "everyone");

//7. spread 파라미터: iterable 한 변수 앞에 붙여서, 해당 변수의 데이터를 개별 아이템으로 분리함
//iterable: 반복 가능한 객체를 의미 -> 배열 or 문자열
let arr6 = [1, 2, 3];
console.log(arr6);
console.log("spread test: ", ...arr6); //console.log(arr6[0], arr6[1], zrr6[2]);와 같은 결과
//spread 파라미터 사용이 유용한 경우
function printStr(s, s1, s2) {
    console.log(s);
    console.log(s1);
    console.log(s2);
}
const hello = ["hello", "hi", 'bye'];
printStr(...hello);