package Programmers.kakao.blind2020;

public class solution1 {
    public static String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");
        new_id = new_id.replaceAll("[.]+",".");
        new_id = new_id.replaceAll("^.|.$","");
        if(new_id == "") new_id = "a";
        if(new_id.length() >=16) {
        	new_id = new_id.substring(0,15);
        	new_id = new_id.replaceAll(".$","");
        }
        
        if(new_id.length() <=2) {
        	char lastCharacter = new_id.charAt(new_id.length()-1);
        	for(int i=0;i<3-new_id.length(); i++) {
        		new_id += lastCharacter;
            }
        }
        
		return new_id;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
