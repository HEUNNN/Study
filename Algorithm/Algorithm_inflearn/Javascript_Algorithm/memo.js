const recursive = (numA, numB) => {
  if (numA % numB === 0) {
    return numB;
  } else {
    return recursive(numB, numA % numB);
  }
};
let answer = recursive(3, 2);
console.log(answer);
