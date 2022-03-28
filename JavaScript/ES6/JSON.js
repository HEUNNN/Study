//JSON
//1. Object to JSON
//stringify(obj)
{
  let json = JSON.stringify(true);
  console.log(json);

  json = JSON.stringify(["apple", "banana"]);
  console.log(json);

  const rabbit = {
    //JS obj
    itName: "tori",
    color: "white",
    size: null,
    birthDate: new Date(),
    jump: () => {
      console.log(`${itName} can jump`);
    },
  };
  //rabbit obj to JSON
  json = JSON.stringify(rabbit);
  console.log(json);

  //Callback or Array를 사용하여 좀 더 세밀하게 변환하기
  json = JSON.stringify(rabbit, ["itName"]);
  console.log(json);

  json = JSON.stringify(rabbit, (key, value) => {
    console.log(`key: ${key}, value: ${value}`);
    return key === "itName" ? "hyeeun" : value;
  });
  console.log(json);
}

//2. JSON to Object
//parse(json)
{
  const rabbit = {
    //JS obj
    itName: "tori",
    color: "white",
    size: null,
    birthDate: new Date(),
    jump: () => {
      console.log(`${itName} can jump`);
    },
  };
  const json = JSON.stringify(rabbit);
  console.log(json);
  const obj = JSON.parse(json);
  console.log(obj);
  //obj.jump(); //오류 발생
  console.log(rabbit.birthDate.getDate());
  //Date() Object 안에 존재하는 getData() API 출력하면 숫자가 나온다.
  //console.log(obj.birthDate.getDate());
  //에러가 발생 -> obj에서 birthDate는 string이기 때문
}
{
  // birthDate를 객체로 살려두기 위해 parse에 callback 사용
  const rabbit = {
    //JS obj
    itName: "tori",
    color: "white",
    size: null,
    birthDate: new Date(),
    jump: () => {
      console.log(`${itName} can jump`);
    },
  };
  const json = JSON.stringify(rabbit);
  const obj = JSON.parse(json, (key, value) => {
    return key === "birthDate" ? new Date() : value;
  });
  console.log(obj);
  console.log(obj.birthDate);
  console.log(obj.birthDate.getDate());
}
