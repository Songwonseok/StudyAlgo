//package REST;
//
//import java.io.*;
//import java.net.*;
//import java.util.*;
//
//
//
//public class RestAPI {
//	static File file = new File("answer.txt");
//    static FileWriter writer = null;
//    static void restFunction(String nexturl, String answer) {
//    	HttpURLConnection conn = null;
//		JavaFileObject responseJson = null;
//		 try {
//		        //URL 설정
//		        URL url = new URL("http://13.125.222.176" + "/quiz/" + nexturl);
//		        conn = (HttpURLConnection) url.openConnection();
//		        //Request 형식 설정
//		        conn.setRequestMethod("POST");
//		        conn.setRequestProperty("Content-Type", "application/json");
//		        //request에 JSON data 준비
//		        conn.setDoOutput(true);
//		        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
//		        //commands라는 JSONArray를 담을 JSONObject 생성
//		        JSONObject commands = new JSONObject();
//		        commands.put("nickname", "서울_1반_송원석");
//		        commands.put("yourAnswer", answer);
//		        //request에 쓰기
//		        bw.write(commands.toString());
//		        bw.flush();
//		        bw.close();
//		        
//		        //보내고 결과값 받기
//		        int responseCode = conn.getResponseCode();
//		        if (responseCode == 400) {
//		            System.out.println("400:: 해당 명령을 실행할 수 없음 (실행할 수 없는 상태일 때, 엘리베이터 수와 Command 수가 일치하지 않을 때, 엘리베이터 정원을 초과하여 태울 때)");
//		        } else if (responseCode == 401) {
//		            System.out.println("401:: X-Auth-Token Header가 잘못됨");
//		        } else if (responseCode == 500) {
//		            System.out.println("500:: 서버 에러, 문의 필요");
//		        } else { // 성공 후 응답 JSON 데이터받기
//		            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		            StringBuilder sb = new StringBuilder();
//		            String line = "";
//		            while ((line = br.readLine()) != null) {
//		                sb.append(line);
//		            }
//		            
//		            //responseJson = new JSONObject(sb.toString());
//		            responseJson = (JSONObject) JSONValue.parse(sb.toString());
//		        }
//		    } catch (MalformedURLException e) {
//		        e.printStackTrace();
//		    } catch (IOException e) {
//		        e.printStackTrace();
//		    } 
//		 
//		 try {
//	            // 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
//	            writer = new FileWriter(file, true);
//	            writer.write(responseJson.toJSONString());
//	            writer.flush();
//	            
//	            System.out.println("DONE");
//	        } catch(IOException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                if(writer != null) writer.close();
//	            } catch(IOException e) {
//	                e.printStackTrace();
//	            }
//	        }
////		 catch (JSONExcesption e) {
////		        System.out.println("not JSON Format response");
////		        e.printStackTrace();
////		    }
//	
//		   System.out.println(responseJson);
//		// parser.JSONtoData(responseJson);
//    }
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		while(true) {
//			String nexturl = br.readLine();
//			if(nexturl.equals("끝"))
//				break;
//			String answer = br.readLine();
//			restFunction(nexturl, answer);
//		}
//		
//	}
//}