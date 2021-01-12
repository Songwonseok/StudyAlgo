const fs = require('fs');
const inputs = fs.readFileSync('./dev/stdin').toString().split('\n');
// const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');

const Main = () => {
  const N = parseInt(input[0]);
  const schedule = [];

  for (let i = 1; i <= N; i++) {
    const meet = input[i].split(" ");
    schedule.push([parseInt(meet[0]), parseInt(meet[1])]);
  }

  schedule.sort((a, b) => {
    if (a[1] === b[1])
      return a[0] - b[0];
    return a[1] - b[1];
  })

  let count = 0;
  let prev = 0;
  schedule.forEach(meet => {
    if (meet[0] >= prev) {
      count++;
      prev = meet[1];
    }
  })

  console.log(count);
}

Main();