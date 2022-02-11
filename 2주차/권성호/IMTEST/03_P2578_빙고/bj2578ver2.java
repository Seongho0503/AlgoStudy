package IMTEST;


/*11 12 2 24 10
16 1 13 3 25
6 20 5 21 17
19 4 8 14 9
22 15 7 23 18
5 10 7 16 2
4 22 8 17 13
3 18 1 6 25
12 19 23 14 21
11 24 9 20 15*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2578ver2 {
	static int cnt = 0;
	static int index;
	static int[][] map = new int [5][5]; 
	static int [] arr = new int[5]; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		//map에 요소 값을 하나씩 초기화 시킴
		for(int i=0; i<5; i++) {
			 st= new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		 for(int tc =0; tc<5; tc++) {
			 st= new StringTokenizer(br.readLine(), " "); 
			   for(int idx =0; idx <5; idx++)   {               //while (st.hasMoreTokens()){ 
				 arr[idx] = Integer.parseInt(st.nextToken()); // 배열에 한 토큰씩 담기 idx++; }
			 }
			//System.out.println("0번째"+arr[0]+"1번쨰"+arr[1]+"2번째"+arr[2]+"3번째"+arr[3]+arr[4]); 디버깅용
			 for(int i=0; i<5; i++) {				 
				 for(int j=0; j<5; j++) {
					 if(map[i][j]==arr[j]) {
						 index+=1;      //빙고가 되었을 때 몇 번째 순서인지 판단하기 위해서
						 map[i][j] = 0; // 찾은 값들을 0으로 모두 바꾸기
					 }
					 // 빙고 한판 완성 
					 if(map[i][0]+map[i][1]+ map[i][2]+map[i][3]+map[i][4]==0) {
						 cnt += 1;
					 } // 빙고 세판 완성
 					 if(cnt>=3) {
						 System.out.println(index);
						 return;
					 }
				    
				 }	
				
			  }
		}
	}
}
