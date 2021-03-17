function solution(s) {
  const answer = [];
  const line = s.substring(1, s.length - 1);

  const comb = [];
  let sub = '';
  for (let i = 0; i < line.length; i++) {
    if (line[i] == '{') {
      sub = ''
    } else if (line[i] == '}') {
      comb.push(sub);
      i++;
    } else {
      sub += line[i];
    }
  }

  const tuple = comb.map(s => s.split(","));
  const set = new Set();
  tuple.sort((a, b) => a.length - b.length);


  for (let i = 0; i < tuple.length; i++) {
    for (let j = 0; j < tuple[i].length; j++) {
      if (!set.has(tuple[i][j])) {
        set.add(tuple[i][j]);
        answer.push(Number(tuple[i][j]));
      }
    }
  }

  return answer;
}