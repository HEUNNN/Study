"use strict";
//Array APIs
// Q1. make a string out of an array
{
  const fruits = ["apple", "banana", "orange"];
  console.log(fruits.join());
}

// Q2. make an array out of a string
{
  const fruits = "🍎, 🥝, 🍌, 🍒";
  console.log(fruits.split(","));
}

// Q3. make this array look like this: [5, 4, 3, 2, 1]
{
  const array = [1, 2, 3, 4, 5];
  console.log(array.reverse());
  console.log(array);
}

// Q4. make new array without the first two elements
{
  const array = [1, 2, 3, 4, 5];
  const newArr = array.slice(2, 5);
  console.log(newArr);
  console.log(array); //원본 array는 변화 없음
}

class Student {
  constructor(name, age, enrolled, score) {
    this.name = name;
    this.age = age;
    this.enrolled = enrolled;
    this.score = score;
  }
}
const students = [
  new Student("A", 29, true, 45),
  new Student("B", 28, false, 80),
  new Student("C", 30, true, 90),
  new Student("D", 40, false, 66),
  new Student("E", 18, true, 88),
];

// Q5. find a student with the score 90
{
  const gradeA = students.find((v) => {
    return v.score === 90;
  });
  console.log(gradeA);
}

// Q6. make an array of enrolled students -> ??
{
  console.log(students.filter((e) => e.enrolled === true));
}

// Q7. make an array containing only the students' scores
// result should be: [45, 80, 90, 66, 88]
{
  const scores = [];
  students.map((e) => scores.push(e.score));
  console.log(scores);
}

// Q8. check if there is a student with the score lower than 50
{
  const res = students.some((student) => student.score <= 50);
  console.log(res); //true
  /*
  const res = students.every((student) => student.score < 50);
  console.log(res);
  //false 반환
  */
}

// Q9. compute students' average score
{
  const avg =
    students.reduce((acc, curr) => {
      return acc + curr.score;
    }, 0) / students.length;
  console.log(avg);
  /* 
  let sum = 0;
  students.map((e) => (sum += e.score));
  console.log(sum / students.length);
  */
}

// Q10. make a string containing all the scores
// result should be: '45, 80, 90, 66, 88'
{
  const result = students
    .map((student) => student.score)
    .filter((score) => score >= 50)
    .join();
  console.log(result); // 45, 80, 90, 66, 88
}

// Bonus! do Q10 sorted in ascending order
// result should be: '45, 66, 80, 88, 90'
{
  const res = students.map((e) => e.score).reverse();
  console.log(res);
}
