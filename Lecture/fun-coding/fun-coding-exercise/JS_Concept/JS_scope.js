//스코프
//scope: 변수, 함수 선언시 해당 변수 또는 함수가 유효한 범위를 의미
/*
Global(전역) scope: 코드 전체 범위
Function(함수) scope: 함수 내에서의 범위
Block(블록) scope: {}괄호로 이루어진 블록 내에서의 범위
*/

//1. Global scope: 블록 또는 함수 안에서 선언되지 않고,
//                외부에서 선언된 변수/함수로 함수 또는 블록 포함 모든 코드에서 사용 가능
//2. Block scope: let과 const로 선언된 변수는 블록 안에서 선언이 되었다면, 블록 밖에서는 유효하지 않음
{
    const name = "hyeeun";
    console.log(name);
}
//console.log(name); //undefined or error
//block 밖에서 선언한 let , const는 블록 안에서도 유효하다. *if or while or for문도 block
const tName = 'dave';
{
    console.log(tName);
}
console.log(tName);
//block 안에 또 다른 block
{
    let age = 25;
    {
        console.log(age);
    }
}
//console.log(age); //오류

//3. var 키워드와 함수 scope: var 키워드는 함수 scope를 가짐
/* 함수 scope란?
함수 안에서 var 키워드로 선언된 변수는 함수 외부에서는 유효하지 않지만, 블록 안에서 var 키워드로 선언된
변수는 블록 외부에서도 유효함
*/
{
    var d1 = 'data1';
}
console.log(d1);

function testFunc() {
    var d2 = 'data2';
    console.log('함수 내부', d2);
}
//console.log('함수 외부', d2); 오류

//4. 전역변수와 지역변수
//지역 변수: 함수에서 선언된 변수, 전역 변수: 전역 scope를 가진 변수
//-> 동일한 이름을 가진 전역 변수와 지역 변수가 있으면, 함수 안에서는 지역 변수를 우선해서 사용
let middleName = 'hyeeun';
function get_Name() {
    let middleName = 'dong';
    console.log('지역 변수: ', middleName);
}
get_Name();
console.log('전역 변수: ', middleName);
//원래 let으로 같은 변수명을 선언하면 오류가 나는데 한개는 전역변수 한개는 지역변수라 오류가 나지 않음
