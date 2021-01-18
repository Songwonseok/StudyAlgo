const fs = require('fs');
const inputs = fs.readFileSync('./dev/stdin').toString().split('\n');
// const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');

const Main = () => {
  const N = parseInt(inputs[0]);
  const regex = /^[A-F]?A+F+C+[A-F]?$/
  for (let i = 1; i <= N; i++) {
    const line = inputs[i];

    if (line.match(regex))
      console.log('Infected!');
    else
      console.log('Good');
  }
}

Main();