package Goorm.NHN;
import java.util.*;

/*
 * 
 * 
 * 
 * 
 */

public class 모의평가 {
	private static void solution(int sizeOfMatrix, int[][] matrix) {
		int[] dx = {-1,1,0,0}, dy = {0,0,-1,1}; // 상하좌우
    // TODO: 이곳에 코드를 작성하세요.
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<sizeOfMatrix;i++){
			for(int j=0;j<sizeOfMatrix;j++){
				if(matrix[i][j] == 1){
					int cnt = 1;
					matrix[i][j] = 0;
					Queue<Integer> que = new LinkedList<>();
					que.add(i*sizeOfMatrix + j);
					while(!que.isEmpty()){
						int x = que.peek()/sizeOfMatrix;
						int y = que.poll()%sizeOfMatrix;
						for(int dir=0;dir<dx.length;dir++){
							int nx = x + dx[dir];
							int ny = y + dy[dir];
							if(nx < 0 || nx >= sizeOfMatrix || ny < 0 || ny >= sizeOfMatrix)
								continue;
							if(matrix[nx][ny] == 1){
								cnt++;
								matrix[nx][ny] = 0;
								que.add(nx*sizeOfMatrix + ny);
							}
						}
					}
					list.add(cnt);
				}
			}
		}
		
	if(list.size() > 0 ){
			int[] result = new int[list.size()];
		for(int i=0;i<result.length;i++)
			result[i] = list.get(i);
		
		Arrays.sort(result);
		StringBuilder answer = new StringBuilder();
		
		for(int cnt : result){
			answer.append(Integer.toString(cnt)+" ");
		}
		System.out.println(list.size());
		System.out.println(answer.substring(0,answer.length()-1));
	}
	else{
		System.out.println(list.size());
	}
		
  }
  
  private static class InputData {
    int sizeOfMatrix;
    int[][] matrix;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      
      inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
      for (int i = 0; i < inputData.sizeOfMatrix; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.sizeOfMatrix; j++) {
          inputData.matrix[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.sizeOfMatrix, inputData.matrix);
  }
}