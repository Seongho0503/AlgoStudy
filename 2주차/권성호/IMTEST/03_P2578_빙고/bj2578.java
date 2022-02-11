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

public class bj2578 {
	static int cnt = 0;
	static int sol;
	static int index;
	static int[][] map = new int [5][5]; 
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
		
		
		 while(true) {
			 st= new StringTokenizer(br.readLine(), " ");
			 int num1 = Integer.parseInt(st.nextToken());
			 int num2 = Integer.parseInt(st.nextToken());
			 int num3 = Integer.parseInt(st.nextToken());
			 int num4 = Integer.parseInt(st.nextToken());
			 int num5 = Integer.parseInt(st.nextToken());
			 for(int i=0; i<5; i++) {				 
				 for(int j=0; j<5; j++) {
					 if(map[i][j] == num1 ||map[i][j] == num2 || map[i][j] == num3 || map[i][j] == num4 || map[i][j] == num5) {
						 index +=1;
						 System.out.println(sol=map[i][j]);
						 map[i][j] = 0;
					  }	
					 
					 if(map[i][0]+map[i][1]+ map[i][2]+map[i][3]+map[i][4]==0) {
						 cnt += 1;
					}
					 if(cnt>=3) {
						 System.out.println(index);
						 return;
					 }
				    
				 }	
				
			  }
		}
		
	}
}
