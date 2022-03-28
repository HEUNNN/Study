//1. for문
for (let i = 0; i < 5; i++) {
    console.log(i);
}

//2. 배열과 for 문
const data = ['hyeeun', 'dong', 'jayden'];
for (let i = 0; i < data.length; i++) {
    console.log(i + 1, '번째 data:', data[i]);
}

for (let item of data) {
    console.log(item);
}

//3. 객체와 for 문
// for ... in 문으로 객체의 키를 반복할 때마다 가져올 수 있음
/*
tip
Object.entries(objectName): 프로퍼티 키와 값으로 이루어진 각 프로퍼티 셋의 리스트 배열 반환
                -> [[key1, value1], [key2, value2], [key3, value3] ... ]
Object.keys(objectName): 프로퍼티 키 리스트 배열 반환
             -> [key1, key2, key3 ... ]
Object.values(objectName): 프로퍼티 값 리스트 배열 반환
               -> [value1, value2, value3 ... ]
*/
const Me = {
    name: 'hyeeun',
    age: 25,
    hobby: 'Youtube',
    get_message: function () {
        return "Hello World!";
    }
}

console.log(Object.entries(Me));
console.log(Object.keys(Me));
console.log(Object.values(Me));

for (let property in Me) {
    console.log('property key: ', property, ', value: ', Me[property]);
}

//4. while 문
let i = 0;
while (i < 5) {
    console.log(i);
    i++;
}

//5. break 와 continue
// break: 반복문 안에서, 더 이상 반복문을 수행하지 않고, 반복문 밖으로 빠져나오기(반복문 종료)
// continue: 현재 반복 횟수에서, continue 다음의 반복 코드를 수행하지 않고, 다음 반복 횟수로 넘어가기
for (let i = 0; i < 5; i++) {
    if (i === 3) {
        break;
    }
    console.log('break test', i);
}
for (let j = 0; j < 5; j++) {
    if (j === 3) {
        continue;
    }
    console.log('continue test', j);
}