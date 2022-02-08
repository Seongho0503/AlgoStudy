package sw_8934;



	

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw8934 {
    
	// 테이스 케이스 횟수
	static int T;
	//읽어들인 문자열
	static String str;
    
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            T = Integer.parseInt(br.readLine());
            for (int tc = 1; tc <= T; tc++) {
            	String str = br.readLine();
                System.out.println("#" + tc + " " + isPalin(str));
            }
            br.close();
        }
    	// 알파벳은 a, b, c 3개, 서로 다른 값을 넣어 구별
    	//착한 재현이는, 문자열에 있는 문자들을 섞어서 길이 2 이상의 팰린드롬이 등장하지 않게 하려 한다. 
        // 길이 2 이상의 팰린드롬이 나오지 않으려면 a, b, c 모두 사용해야하기 때문에
        // aab, aba, baa, acc , abb  등  불가
    
        public static String isPalin(String str){
            int[] num = new int[3];
            int a = 0, b = 1, c = 2;

            //문자를 int로 변환해야함 num int 배열 이기 때문에
            for(int i=0; i<str.length(); i++)
                num[str.charAt(i)-'a'] += 1;

            //팰린드롬인 것을 확인하기 위해 같은 알파벳의 중복 확인
            int min = Math.min(Math.min(num[a], num[b]), num[c]);
            int max = Math.max(Math.max(num[a], num[b]), num[c]);
            
            //똑같은 알파벳이 2번이상이면 팰린드롬이기 때문에 no
            // max 값이 2보다 크면 무조건 같은 알파벳이 중복된 것 이기 때문에 팰린드롬이다.
            return max-min > 1 ? "NO" : "YES";
        }
} 
