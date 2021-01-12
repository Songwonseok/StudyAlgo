const fs = require('fs');
const inputs = fs.readFileSync('./dev/stdin').toString().split("\n");
// const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');

const Main = () => {
  const N = parseInt(inputs[0]);
  let count = N;

  for (let i = 1; i <= N; i++) {
    const word = inputs[i];
    const set = new Set();
    let prev = word[0];

    for (let i = 1; i < word.length; i++) {

      if (set.has(word[i])) {
        count--;
        break;
      }
      if (prev !== word[i]) {
        set.add(prev);
        prev = word[i];
      }
    }
  }
  console.log(count);
}

Main();