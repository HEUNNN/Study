//비동기 처리를 위한 Promise
//1. Promise : ES6에서 공식적으로 추가된 문법으로, 비동기 처리를 위한 콜백함수의 단점을 극복하기 위해 제안
/*
new로 Promise 객체를 생성한다. Promise 객체에서는 executor라는 함수가 자동으로 실행되며,
executor라는 함수는 resolve와 rect라는 두 개의 함수를 인자로 받아서 비동기 처리 함수를 실행한다.
executor를 통해 비동기 처리 함수를 실행 완료 후, 해당 작업이 성공이면 resolve 실패면 reject 함수를 호출한다.

then method: 작업 성공 또는 실패시 수행할 작업을 정의하고, promise 코드를 실행해주는 메서드
*/
const runCode = new Promise(
    (resolve, reject) => {
        setTimeout(() => { //비동기로 동작하는 코드 입력
            let num = 10;
            if (num > 9) {
                resolve(num);
            } else {
                reject('error');
            }
        }, 1000);
    }
);

runCode.then((item) => { //promise 객체 호출하기
    console.log('success', item);
}, (err) => {
    console.log(err);
});

console.log('test');

//console.log('test'); 부분도 동기적으로 처리 하고 싶을때
const runCode2 = new Promise(
    (resolve, reject) => {
        setTimeout(() => {
            let number = 100;
            if (number > 10) {
                resolve(number);
            } else {
                reject('error1');
            }
        }, 1000);
    }
);

runCode2.then((item1) => {
    console.log(item1);
}, (error) => {
    console.log(error);
}).then(() => { //then 메서드에 하나의 함수만 넣어주면 success callback 함수만 있다고 가정함
    console.log('hyeeun');
});

//2. Promise의 3가지 상태
// 1) Pending(대기): 비동기 처리가 아직 실행되지 않은 초기 상태
// 2) Fulfilled(이행): 비동기 처리가 성공적으로 완료된 상태
// 3) Rejected(실패): 비동기 처리가 실패한 상태

// ** 여러개의 then으로 엮여있을 때, success case function(인자가 하나)만 존재하는 경우
//    한번이라도 중간에 reject 되면 실행이 안됨

//3. catch 메서드: 실행 중, 예외상황을 처리함
//   failureCallback이 정의되어 있지 않을 경우, reject 시 catch 메서드를 호출

runCode2.then((item2) => {
    console.log('catch method test', item2);
}).catch((errorMessage) => {  //chaining 형태
    console.log(errorMessage);
});


//4. chaining: then method와 연결해서, 순차적으로 실행되야할 코드를 연결할 수 있음
// -> then과 catch 메서드도 함께 연결해서 실행 가능
// -> 일반적으로 catch는 chaining 맨 마지막에 추가해서, 전체 코드의 에러 케이스를 다룸
//5. throw: 사용자 정의 예외를 던질 때 사용
//  -> catch 블록이 있으면 catch 블록으로 전달되고, 그렇지 않으면 프로그램을 종료

//6. chaining과 return
runCode2.then((item2) => {
    console.log('success');
    return item2;
}, (errorMessage2) => {
    console.log(errorMessage2);
}).then((returnValue) => {
    console.log('첫번째 chain에서 success and return 받은 값: ', returnValue);
}).catch(() => {
    console.log('error!!');
});

//7. finally(): Promise가 resolve 되든 reject 되든 마지막에 해당 함수를 실행함
let runCode3 = new Promise(
    (resolve, reject) => {
        setTimeout(() => {
            let num2 = 10;
            if (num2 > 9) {
                resolve(num2);
            } else {
                reject('this is an error');
            }
        }, 500);
    }
);

runCode3.then((element) => {
    console.log('success!');
    throw new Error('throw error'); //throw가 나와서 강제로 에러를 생성하고 catch로 넘어갈것이라 예상했다.
    return element;                 //throw라는 예외 상황이 발생하면 결과적으로는 전체 코드가 종료인 상태이다.
}, (message) => {                   //그래서 finally()가 먼저 호출되고 catch가 호출됨
    console.log(message);
}).then((n) => {
    console.log('succes number:', n);
}).finally(() => {
    console.log('finally');
}).catch((err) => {
    console.log('Catch error');
});

//8. Promise.all: 동기화 처리할 Promise를 묶어서 한번에 실행 -> 여러 함수가 다 실행이 완료된 후에, then 실행
const promise1 = new Promise((resolve, reject) => {
    setTimeout(() => resolve("100ms"), 100);
});
const promise2 = new Promise((resolve, reject) => {
    setTimeout(() => resolve("500ms"), 500);
});
const promise3 = new Promise((resolve, reject) => {
    setTimeout(() => resolve("3000ms"), 3000);
});
Promise.all([promise1, promise2, promise3]).then((data) => {
    console.log(data); //promise1, promise2, promise3 가 모두 실행 된 후 출력
});

//9. Promise.race: 여러 함수 중, 가장 빠르게 실행 완료된 함수만 then 구문을 실행 함
const promise4 = new Promise((resolve, reject) => {
    setTimeout(() => {
        console.log('500ms');
        resolve('500ms');
    }, 500);
});
const promise5 = new Promise((resolve, reject) => {
    setTimeout(() => {
        console.log('100ms');
        resolve('100ms');
    }, 100);
});
const promise6 = new Promise((resolve, reject) => {
    setTimeout(() => {
        console.log('1500ms');
        resolve('1500ms')
    }, 1500);
});

Promise.race([promise4, promise5, promise6]).then((data) => {
    console.log('race: ', data);
});