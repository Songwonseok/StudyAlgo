function solution(n, t, m, p) {
  const length = t * m;
  let answer = '';
  let said = '';
  let number = 0;
  while (said.length < length) {
    said += number.toString(n);
    number++;
  }
  for (let i = p - 1; i < length; i += m) {
    answer += said[i];
  }

  return answer.toUpperCase();
}