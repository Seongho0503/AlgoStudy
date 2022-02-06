package Sungho_S1215;

	import java.util.*;
	import java.io.*;;
	 
	public class Solution {
	 
	    static int mapSize = 8;
	    static char map[][];
	    static int wordLength;
	    static List<Character> list;
	    static List<Character> reverseList;
	    static int answer;
	 
	    public static void Palindrome() {
	 
	        // 가로 먼저 검사
	        for (int h = 0; h < mapSize; h++) {  // 맵 길이
	            for (int i = 0; i <= (mapSize - wordLength); i++) { // 실제 돌아야하는 횟수
	                for (int j = i; j < (i + wordLength); j++) { // 하나씩 값 뽑아내서 
	                    list.add(map[h][j]);
	                    reverseList.add(map[h][j]);
	                }
	                Collections.reverse(reverseList);
	 
	                if (isAccord())
	                    answer++;
	                list.clear();  // 판별 후 새로운 값을 받기 위해서
	                reverseList.clear();
	            }
	        }
	 
	        // 세로 검사
	        for (int w = 0; w < mapSize; w++) { // 맵 길이
	            for (int i = 0; i <= (mapSize - wordLength); i++) { // 실제 돌아야하는 횟수
	                for (int j = i; j < (i + wordLength); j++) {  // 하나씩 값 뽑아내서 
	                    list.add(map[j][w]);
	                    reverseList.add(map[j][w]);
	                }
	                Collections.reverse(reverseList);
	 
	                if (isAccord())
	                    answer++;
	                list.clear(); // 판별 후 새로운 값을 받기 위해서
	                reverseList.clear();
	            }
	        }
	    }
	 
	    public static boolean isAccord() {
	 
	        int len = list.size();
	        int count = 0;
	 
	        for (int i = 0; i < len; i++) {
	            if (list.get(i) == reverseList.get(i)) // 둘이 값 비교
	                count++;
	        }
	 
	        return count == len ? true : false;
	    }
	 
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	        int T = 10;  // 테케 횟수
	 
	        for (int testcase = 1; testcase <= T; testcase++) { 
	 
	            list = new ArrayList<>();
	            reverseList = new ArrayList<>();
	            answer = 0;
	 
	            wordLength = Integer.parseInt(br.readLine());  // 묶는 횟수 
	            map = new char[mapSize][mapSize]; //여기서는 8x8
	 
	            for (int i = 0; i < mapSize; i++) {
	                String str = br.readLine();
	                for (int j = 0; j < mapSize; j++) {
	                    map[i][j] = str.charAt(j);
	                }
	            } // input for
	 
	            Palindrome();  // 회문 함수 호출
	 
	            System.out.println("#" + testcase + " " + answer);
	 
	        } // testcase end
	    } // main
	} // main class

