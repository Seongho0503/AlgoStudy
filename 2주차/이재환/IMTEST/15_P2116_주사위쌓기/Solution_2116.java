package P2116_주사위쌓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2116 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//주사위 갯수 입력
		int N = Integer.parseInt(br.readLine());
		int[][] dice = new int[N][6];
		
		//주사위 면 입력
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++)
				dice[i][j]=Integer.parseInt(st.nextToken());
		}
		
		
		int max=0;
		//첫번째 주사위(top << 1~6 모든 케이스 넣기)
		for(int i=0;i<6;i++) {
			int top=dice[0][i];
			int bottom=bottom(dice[0],i);
			int sum = sideSum(bottom, top, 0);
			
			//2번째 주사위~마지막 주사위
			for(int j=1;j<N;j++) {
				for(int k=0;k<6;k++) {
					if(dice[j][k]==bottom){
						top=dice[j][k];
						bottom=bottom(dice[j],k);
						break;
					}	
				}
				sum=sideSum(bottom, top, sum);
			}
			
			// 옆면 최대합 구하기
			max=Math.max(sum, max);
		}
		System.out.println(max);
	}
	
	// 밑면(bottom) 구하는 method
	public static int bottom(int[] arr,int i) {
		int bottom=0;
		if(i==0) 	    bottom=arr[i+5];
		else if(i==1||i==2) bottom=arr[i+2];
		else if(i==3||i==4) bottom=arr[i-2];
		else if(i==5) 	    bottom=arr[i-5]; 
		return bottom;
	}
	
	//옆면 최댓값 구하는 method
	public static int sideSum(int bottom,int top,int sum) {
		if(bottom+top==11)	   sum+=4; //두 면 6,5 -> 옆면 최댓값 4
		else if(bottom==6||top==6) sum+=5; //한 면 6 -> 옆면 최댓값 5
		else	                   sum+=6;	//6이 옆면에 있을때 -> 옆면 최댓값 6
		return sum;
	}
}
