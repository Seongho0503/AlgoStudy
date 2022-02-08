import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_8934 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(rd.readLine());
		for (int t = 0; t < testcase; t++) {
			String input = rd.readLine();
			int count[]=new int[3]; //0:a 1:b 2:c 의 개수
			
			//각각의 알파벳 개수 구함
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='a') {
					count[0]++;
				}
				else if(input.charAt(i)=='b') {
					count[1]++;
				}
				else {
					count[2]++;
				}
			}
			
			//알파벳 개수 많은 순으로 comp에 인덱스 저장
			int comp[] = new int[3];
			if(count[0]>count[1]) {
				if(count[1]>count[2]) {
					comp[0]= 0;
					comp[1]= 1;
					comp[2]= 2;
				}
				else if(count[2]>count[1]) {
					comp[0]= 2;
					comp[1]= 0;
					comp[2]= 1;
				}
				else {
					comp[0]= 0;
					comp[1]= 2;
					comp[2]= 1;
				}
			}
			else {
				if(count[0]>count[2]) {
					comp[0]= 1;
					comp[1]= 0;
					comp[2]= 2;
				}
				else if(count[2]>count[1]) {
					comp[0]= 2;
					comp[1]= 1;
					comp[2]= 0;
				}
				else {
					comp[0]= 1;
					comp[1]= 2;
					comp[2]= 0;
				}
				
			}
			
			//(제일 많은 알파벳 수 - 가장 적은 알파벳 수) , (두번째 많은 알파벳 수 - 가장 적은 알파벳 수)가 각각 1이하 
			if(count[comp[0]]-count[comp[2]]<=1&&count[comp[1]]-count[comp[2]]<=1)	
				System.out.println("#"+(t+1)+" YES");
			else
				System.out.println("#"+(t+1)+" NO");
			//System.out.println("a: "+count[0]+" b: "+count[1]+" c: "+count[2]);
			//System.out.println("comp: "+comp[0]+comp[1]+comp[2]);
		}
	}
}
