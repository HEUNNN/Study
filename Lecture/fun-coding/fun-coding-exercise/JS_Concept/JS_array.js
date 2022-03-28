//배열
//1. 배열을 객체처럼 생성하기
const myArray = new Array();
console.log(myArray); //empty array
myArray[0] = 1;
myArray[1] = 2;
myArray[2] = "apple";
myArray[3] = "orange";
console.log('original array', myArray);
// 특정 item 수정하기
myArray[2] = "banana";
console.log('update array', myArray);
//배열 삭제
myArray.splice(2, 2); //splice(삭제를 시작할 인덱스 번호, 삭제를 시작할 인덱스 부터 몇개를 삭제할 지의 갯수)
console.log('delete item', myArray);
//해당 배열을 저장하고 있는 주소를 바꿀일이 거의 없기 때문에, 수정/삭제 등의 변화가 일어나도 const array는 영향을 받지 않음
//배열을 덮어 씌우는것은 const일때 불가능

//2. 객체도 배열의 item으로 선언 가능
const data = [
    { name: 'hyeeun', age: 25 },
    { name: 'Jayden', age: 28 }
];
console.log('object in array', data);
console.log(data[0].name);
//3. 배열 내부에 배열도 가능
const data2 = [
    [1, 2, 3],
    ['a', 'b', 'c'],
    [10, 20, 30]
];
console.log('array in array', data2);

//4. 다양한 배열 관련 기능(함수)
//4.1 push: 배열의 긑에 아이템 추가
const data3 = [1, 2, 'apple', 'orange', 10];
console.log('original array', data3, ', original array lenght', data3.length);
data3.push('pused item');
console.log('push test array', data3, ', push test array length', data3.length);
//4.2 pop: 배열의 끝에 있는 아이템을 리턴해주고, 해당 아이템은 배열에서 삭제
const data4 = [1, 2, 'apple', 'orange', 10];
console.log('original array', data4);
console.log('pop test return value: ', data4.pop(), ', pop test array', data4);
//4.3 shift: 배열의 첫 번째 아이템을 삭제 후 반환하고, 뒤에 있는 아이템을 한칸씩 앞으로 당김
//    unshift: 배열의 제일 앞에 아이템을 추가하고, 뒤로 한칸씩 아이템을 밈
const data5 = [1, 2, 3, 4];
console.log('original array', data5);
console.log('shift test value: ', data5.shift(), ', shift test array', data5);
data5.unshift('unshifted item');
console.log('unshift test array', data5);
//4.4 concat: 두 배열 합치기
const data6 = [1, 2, 3];
const data7 = [4, 5, 6];
let concatArr = data6.concat(data7);
console.log('concat test array', concatArr);
//4.5 reverse: 배열을 역순으로 배치
console.log('original array: ', concatArr, ',reverse array: ', concatArr.reverse());
console.log(concatArr.reverse()); // 다시 뒤집어 주어야 original로 돌아옴
//4.6 slice(a,b): a 아이템 인덱스부터 시작해서, b-1 아이템 인덱스까지 추출 하여 return
//               -> slice한 결과만 출력하고, 원래 array는 변화하지 않음 *slice와 차이
console.log('slice test array', concatArr.slice(2, 4));
//4.7 forEach: for 문을 대체해서, 간단히 배열의 각 아이템을 가져올 수 있는 함수
const data8 = [1, 2, 10, 20];
data8.forEach(item => {
    console.log(item);
});
//4.8 map: 배열의 각 아이템에 정의한 함수를 적용해서, 새로운 배열을 리턴하는 함수
const mapArr = data8.map(item => item * 10);
console.log(mapArr);
console.log(data8);
//4.9 indexOf('item'): 배열에서 지정한 데이터가 위치한 인덱스 번호를 return
let idx = data8.indexOf(10);
console.log(idx); //2
//4.10 findIndex: 배열의 아이템이 객체일 경우, 해당 객체에서 지정한 데이터 위치를 찾을 수 있는 방법
const data9 = [
    {
        id: 1,
        name: 'lee hyeeun',
    },
    {
        id: 2,
        name: 'lee dongmyeong',
    }
];
console.log(data9.indexOf('lee dongmyeong')); //찾을 수 없음
console.log(data9.findIndex(item => item.name === 'lee hyeeun'));
//4.11 find: findIndex와 유사하지만, 지정한 데이터 위치를 리턴하는 것이 아니라 지정한 데이터가 있는 객체를 리턴
console.log(data9.find(item => item.name === 'lee hyeeun'));
//4.12 filter: 배열에서 특정 조건에 맞는 아이템만 추출할 때 사용
const data10 = ['a', 10, 23, 'c'];
let even = data10.filter(item => item % 2 === 0);
console.log(even);
//4.13 join: 아이템 사이에 특정 문자열을 넣어서, 모든 아이템을 합쳐서 하나의 문자열로 만들어줌
let data11 = ['a', 'p', 'p', 'l', 'e', 1, 2];
data11 = data11.join('');
console.log(data11, typeof data11);