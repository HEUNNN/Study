//1. 동기적 처리와 비동기적 처리
/*
Synchronous: 요청을 보낸 후, 해당 요청의 응답을 받아야 다음 동작을 실행(코드 한줄 실행 완료 후, 다음 줄 실행)
Asynchronous: 요청을 보낸 후, 응답과 관계 없이 다음 동작을 실행(코드 한줄 실행 후, 완료와 상관없이 다음 줄 실행)
Javascript는 다른 언어와 마찬가지로 동기적 처리가 기본이지만, 일부 기능은 비동기적으로 처리가 가능하도록 관련 기능을 추가로 제공
*/
//2. 주요 비동기적 처리
/*
Rest API 요청
파일/데이터베이스 처리
타이머, 암호화/복호화 등
*/

//2.1 setTimeout() 함수
console.log('꼼꼼하고, 선명하고, 바로 활용하는 잔재미 코딩');
setTimeout(() => {
    console.log('나도 할 수 있다.');
}, 3000); //3000ms = 3s
console.log('Dave lee');
/*
비동기 처리의 문제점
예를 들어, Rest API를 호출해서 결과값을 받아서, 이를 기반으로 코드를 실행하는 경우에
해당 함수 호출 후, 결과값을 받지 않은 채로, 다음 코드가 실행되면, 전체 코드 실행에 문제가 됨
*/

//3. Callback Function: 비동기 처리의 문제점을 해결할 수 있는 콜백함수
/*
- 자바스크립트에서 함수는 first-class function
- first-class function: 함수 자체를 변수에 저장 가능하고,
                        함수의 인자에 다른 함수를 인수로 전달이 가능하며,
                        return 값으로 함수 전달이 가능
*/
function func1(callbackFunc) { //여기서 callback은 함수 -> first-class function은 인수를 다른 함수로 받을 수 있음 
    setTimeout(() => {
        console.log('Func1');
        callbackFunc();
    }, 1000);
}
function func2() {
    console.log('Func2');
}
func1(func2);
