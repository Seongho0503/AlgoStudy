package P8934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//순열 배운걸로 완전검색해서 해봤는데 이클립스에서 결과 나오는데 
//3번째 케이스 문자수가 많다보니 시간 초과 나오네
//시간되면 다른방법으로도 풀어볼게

public class Solution_8934{
	static char[] c,numbers;
	static boolean[] isSelected;
	static String ans;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String str = br.readLine();
			
			c=str.toCharArray();
			numbers= new char[c.length];
			isSelected = new boolean[c.length];
			ans="NO";
			permutation(0);
			System.out.println("#" + t + " " + ans);
		}
		br.close();
	}
	
	//순열
	public static void permutation(int cnt) {
		// 기저 파트
		if(cnt== c.length) {
			for(int i=0;i<c.length-1;i++) 
				if(numbers[i]==numbers[i+1]) return;//(@+aa,bb,cc+@) 옆 체크 같으면 리턴		
			for(int i=0;i<c.length-2;i++)
				if(numbers[i]==numbers[i+2]) return;//(@+bab,bcb,cac,cbc,aba,aca+@)
													// 왼,오 체크 후 같으면 리턴			
			ans="YES";//옆체크, 왼오체크에서 return 되지 않은게 있으면 yes					
		}		
		// 유도 파트(모든 문자 배열 구하기)
		for (int i = 0; i < c.length; i++) {
			if(isSelected[i]) continue;
			numbers[cnt]=c[i];
			isSelected[i]=true;
			permutation(cnt+1);
			isSelected[i]=false;
		}		
	}
}
