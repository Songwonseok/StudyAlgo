package Programmers.kakao;

import java.util.*;

public class KAKAO_2021_순위검색 {

	public static int getLanguage(String language){
        if(language.equals("cpp")){
            return 0;   
        }else if(language.equals("java")){
            return 1;
        }else if(language.equals("python")){
            return 2;
        }else{
            return -1;
        }
    }
    public static int getOccupation(String ocuupation){
        if(ocuupation.equals("backend")){
            return 0;   
        }else if(ocuupation.equals("frontend")){
            return 1;
        }else{
            return -1;
        }
    }

    public static int getCareer(String career){
        if(career.equals("junior")){
            return 0;   
        }else if(career.equals("senior")){
            return 1;
        }else{
            return -1;
        }
    }

    public static int getSoulFood(String food){
        if(food.equals("chicken")){
            return 0;   
        }else if(food.equals("pizza")){
            return 1;
        }else{
            return -1;
        }
    }

    public static void addInfo(ArrayList<Integer>[][][][] applicants, int lang, int occup, int career, int food, int score){
        if(applicants[lang][occup][career][food] == null){
                applicants[lang][occup][career][food] = new ArrayList<Integer>();
            }
            applicants[lang][occup][career][food].add(score);
    }

    public static void sort(ArrayList<Integer>[][][][] applicants){
        for(int i=0;i<=3;i++){
            for(int j=0;j<=2;j++){
                for(int k=0;k<=2;k++){
                    for(int z=0;z<=2;z++){
                        if(applicants[i][j][k][z] != null){
                            Collections.sort(applicants[i][j][k][z]);
                        }   
                    }
                }
            }
        }
    }

    public static int binarySearch(ArrayList<Integer> list, int score){
        if(list == null) {
            return -1;
        }

        int index = -1;
        int left = 0;
        int right = list.size() - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (list.get(mid) >= score) {
                index = mid;
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }
        return index;
    }

    public static int getCount(ArrayList<Integer>[][][][] applicants, int lang, int occup, int career, int food, int score, int depth){
        if(depth == 4){
            int index = binarySearch(applicants[lang][occup][career][food], score);
            if (index < 0) {
                return 0;
            }
            return applicants[lang][occup][career][food].size() - index;
        }
        int count = 0;
        if(depth == 0 && lang < 0){
            for(int i=0;i<3;i++){
                count += getCount(applicants, i, occup, career, food, score, depth+1);
            }
        }else if(depth == 1 && occup < 0){
            for(int i=0;i<2;i++){
                count += getCount(applicants, lang, i, career, food, score, depth+1);
            }
        }else if(depth == 2 && career < 0){
            for(int i=0;i<2;i++){
                count += getCount(applicants, lang, occup, i, food, score, depth+1);
            }
        }else if(depth == 3 && food < 0){
            for(int i=0;i<2;i++){
                count += getCount(applicants, lang, occup, career, i, score, depth+1);
            }
        }else{
            count += getCount(applicants, lang, occup, career, food, score, depth+1);
        }

        return count;
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        ArrayList<Integer>[][][][] applicants = new ArrayList[4][3][3][3];

        for (int i = 0; i < info.length; i++) {
            String[] applicantInfo = info[i].split(" ");
            int lang = getLanguage(applicantInfo[0]);
            int occup = getOccupation(applicantInfo[1]);
            int career = getCareer(applicantInfo[2]);
            int food = getSoulFood(applicantInfo[3]);
            int score = Integer.parseInt(applicantInfo[4]);
            addInfo(applicants, lang, occup, career, food, score);

        }
        sort(applicants);

        for (int i = 0; i < query.length; i++) {
            String[] options = query[i].split(" and ");
            int lang = getLanguage(options[0]);
            int occup = getOccupation(options[1]);
            int career = getCareer(options[2]);

            String[] foodAndScore = options[3].split(" ");
            int food = getSoulFood(foodAndScore[0]);
            int score = Integer.parseInt(foodAndScore[1]);

            answer[i] = getCount(applicants, lang, occup, career, food, score, 0);
        }

        return answer;
    }

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		solution(info, query);
		System.out.println();

	}

}
