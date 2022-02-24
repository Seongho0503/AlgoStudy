package SWEA.D3.영준이의카드카운팅_4047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영준이의카드카운팅_4047_ver2_완성용 {
	static BufferedReader br ;
	 
	//'1' '2' -> "1" "2" ->  "12" ->  12
	//char -> string -> + 연산 -> int 
	// 쓸데없이 복잡하게 했네
	static int whereIndex(char num1, char num2) {
		
	   String s1 = String.valueOf(num1);
	   String s2 = String.valueOf(num2);
	   
	   int index = Integer.parseInt(s1+s2);
		return index;	
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			//중복 체크 
			boolean flag = false;
			
			//카드 배열 
			int S[] = new int[14];
			int D[] = new int[14];
			int H[] = new int[14];
			int C[] = new int[14];
			
			String line = br.readLine();
			for(int i=0; i<line.length(); i+=3) {
				char alp = line.charAt(i);
				char num1 = line.charAt(i+1);
				char num2 = line.charAt(i+2);
				int index =whereIndex(num1, num2);
				
				switch(alp) {
				case 'S': S[index] +=1; break;
				case 'D': D[index] +=1; break;
				case 'H': H[index] +=1; break;
				case 'C': C[index] +=1; break;
				}		  
			}
			for(int i=1; i<14; i++) {
				//  2개 이상이면 에러
				if (S[i]>1 || D[i]>1 ||H[i]>1 ||C[i]>1 ) {
					flag = true;
					break;
				}
				// 인덱스 0은 비워놔서 거기다 모든 합을 다 더함
					S[0] +=S[i];
					D[0] +=D[i];
					H[0] +=H[i];
					C[0] +=C[i];					
			}
			if(flag==true) System.out.println("#"+(tc+1)+" "+"ERROR");
			else System.out.println("#"+ (tc+1)+" "+(13-S[0]) +" " +(13-D[0]) +" "+(13-H[0]) +" "+ (13-C[0]));
		}   //13개에서 남아있는 개수 구함
	}
}
