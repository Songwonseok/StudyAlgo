function solution(m, n, board) {
  var answer = 0;
  let removed = 0;
  board = board.map(v => [...v]);

  do {
    const visit = new Array(m).fill(0).map(v => new Array(n).fill(false));
    removed = 0;

    for (let i = 0; i <= m - 2; i++) {
      for (let j = 0; j <= n - 2; j++) {
        if (board[i][j]) {
          findSquare(board, visit, i, j);
        }
      }
    }
    removed = removeFriends(board, visit);
    downFriends(board);
    answer += removed;
  } while (removed > 0)

  return answer;
}

function findSquare(board, visit, x, y) {
  if (x + 1 >= board.length || y + 1 >= board[0].length)
    return false;

  const kakaoFriend = board[x][y];

  for (let i = x; i <= x + 1; i++) {
    for (let j = y; j <= y + 1; j++) {
      if (kakaoFriend != board[i][j])
        return false;
    }
  }

  for (let i = x; i <= x + 1; i++) {
    for (let j = y; j <= y + 1; j++) {
      visit[i][j] = true;
    }
  }

  return true;
}

function downFriends(board) {
  const bottom = board.length - 1;
  const width = board[0].length - 1;

  for (let y = 0; y <= width; y++) {
    for (let x = bottom - 1; x >= 0; x--) {
      if (board[x][y]) {
        let prev = x;
        let next = x + 1;

        while (next <= bottom && board[next][y] === null) {
          let temp = board[prev][y];
          board[prev][y] = board[next][y];
          board[next][y] = temp;
          prev++;
          next++;
        }
      }
    }
  }
}

function removeFriends(board, visit) {
  let count = 0;
  for (let i = 0; i < visit.length; i++) {
    for (let j = 0; j < visit[i].length; j++) {
      if (visit[i][j]) {
        board[i][j] = null;
        count++;
      }
    }
  }
  return count;
}

const m = 4;
const n = 4;
const board = ["ABCD", "BACE", "BCDD", "BCDD"];

console.log(solution(m, n, board));
