package Goorm.NHN;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution1 {
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
		char[] AllPlayer = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		HashMap<Character, Integer> taggerMap = new HashMap();
		HashSet<Character> quickSet = new HashSet();
		
		char[] player = new char[numOfAllPlayers-1];
		
		taggerMap.put('A', 1);
		for(int i=0;i<numOfAllPlayers-1;i++) {
			player[i] = AllPlayer[i+1];
			taggerMap.put(player[i], 0);
		}
		for(int i=0;i<namesOfQuickPlayers.length;i++)
			quickSet.add(namesOfQuickPlayers[i]);
		
		
		char tagger = 'A';
		int index = 0;
		
		for(int i=0;i<numOfGames;i++) {
			int moveIndex = numOfMovesPerGame[i];
			index =  (index + moveIndex) % player.length;
			if(index < 0 )
				index = player.length + index;
			
			if(quickSet.contains(player[index])) {
				taggerMap.put(tagger, taggerMap.get(tagger) + 1);
				continue;
			}else {
				char temp = tagger;
				tagger = player[index];
				taggerMap.put(tagger, taggerMap.get(tagger) + 1);
				player[index] = temp;
			}
		}
		
		for(int i=0;i<player.length;i++) {
			System.out.println(player[i] +" " + taggerMap.get(player[i]));
		}
		System.out.println(tagger + " " + taggerMap.get(tagger));
		
	  }
	
	
	private static class InputData {
	    int numOfAllPlayers;
	    int numOfQuickPlayers;
	    char[] namesOfQuickPlayers;
	    int numOfGames;
	    int[] numOfMovesPerGame;
	  }

	  private static InputData processStdin() {
	    InputData inputData = new InputData();

	    try (Scanner scanner = new Scanner(System.in)) {
	      inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

	      inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
	      inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
	      System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

	      inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
	      inputData.numOfMovesPerGame = new int[inputData.numOfGames];
	      String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
	      for(int i = 0; i < inputData.numOfGames ; i++){
	        inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
	      }
	    } catch (Exception e) {
	      throw e;
	    }

	    return inputData;
	  }

	  public static void main(String[] args) throws Exception {
	    InputData inputData = processStdin();

	    solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
	  }
}
