package Programmers.coding.second;

import java.util.*;

/* 택배 라이더 
 * int n, int[][] walls, int[][] riders, int[][] s, int[][] e
 * n * n 크기의 지도 위에서 택배를 배달하는 문제
 * 1) 지도는 0과 1로 이루어져 있고 1은 벽으로 이동할 수 없다. 벽의 위치는 walls 배열에 담겨있다
 * 2) riders에는 riders[라이더의 수][라이더의 x,y좌표] 로 되어있다.
 * 3) s, e 는 택배를 받는 곳과 배달하는 곳의 위치가 담겨있다. s,e 는 순서대로 짝지어져 있다. 즉, s[0][x,y], e[0][x,y]은 한쌍이다.
 * 4) 라이더의 수, s,e의 수는 같다.
 * 5) 각 라이더는 1,2,3,..., s.length 택배 중에 하나를 정해서 배달 한다.
 * 6) 배달은 라이더의 처음 위치에서 s를 들렸다가 e로 가야한다.
 * 
 */

class Solution3 {
    static int[][] map;
    static int min;
    static boolean[] check; // 중복순열 방지
    static int[] permResult; // 순열 결과
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1}; //상하좌우
    static Rider[] riderArr;

    public class Rider {
        public int x;
        public int y;
        public int target;

        HashMap<Integer,Integer> caching;
        public Rider(int x,int y){
            this.x = x;
            this.y = y;
            this.caching = new HashMap<>();
        }

    }

    public void countMove(int[][] s, int[][] e){
        boolean[][] visit;
        int total = 0;
        int N = map.length;
        for(int i=0;i<riderArr.length;i++){
            int target = riderArr[i].target;        
            if(riderArr[i].caching.containsKey(target)){
                total += riderArr[i].caching.get(target);
            }else{
                visit = new boolean[N][N];
                Queue<int[]> queue = new LinkedList();
                boolean getItem = false;

                queue.add(new int[] {riderArr[i].x, riderArr[i].y, 0});

                while(!queue.isEmpty()){
                    int x = queue.peek()[0];
                    int y = queue.peek()[1];
                    int cnt = queue.poll()[2];

                    // 라이더가 물품 보관소에 도착했다면 queue 초기화, 택배를 상차 true
                    if(!getItem && s[target][0] == x && s[target][1] == y){
                        getItem = true;
                        queue.clear();
                        queue.add(new int[] {x,y,cnt});
                        visit = new boolean[N][N];
                        continue;
                    }
                    // 택배를 가졌고, 배송지로 도착했다면 캐시에 저장
                    else if(getItem && e[target][0] == x && e[target][1] == y){
                        riderArr[i].caching.put(target, cnt);
                        total+= cnt;
                        break;
                    }
                    for(int dir=0;dir<dx.length;dir++){
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if(nx <0 || nx >= N || ny <0 || ny >=N ||map[nx][ny] == 1 || visit[nx][ny])
                            continue;
                        visit[nx][ny] = true;
                        queue.add(new int[] {nx,ny,cnt+1});
                    }
                }
            }
        }
        min = Math.min(min,total);
    }

    public void perm(int depth, int cnt, int[][] s, int[][] e){ // 깊이, 배송지 수
        if(depth == cnt){
            for(int i=0;i<cnt;i++){
                riderArr[i].target = permResult[i];
            }
            countMove(s,e);
            return;
        }
        for(int i=0;i<cnt;i++){
            if(!check[i]){
                permResult[depth] = i;
                check[i] = true;
                perm(depth+1, cnt, s, e);
                check[i] = false;
            }
        }
    }

    public int solution(int n, int[][] walls, int[][] riders, int[][] s, int[][] e) {
        int answer = 0;
        int size = s.length;
        map = new int[n][n];
        check = new boolean[size];
        permResult = new int[size];
        min = Integer.MAX_VALUE;
        riderArr = new Rider[size];

        for(int i=0;i<walls.length;i++){
            map[walls[i][0]][walls[i][1]] = 1;
        }

        for(int i=0;i<size;i++){
            riderArr[i] = new Rider(riders[i][0], riders[i][1]);
        }

        perm(0, size, s, e);

        answer = min;
        return answer;
    }
}