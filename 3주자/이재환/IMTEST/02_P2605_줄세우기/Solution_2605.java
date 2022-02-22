package P2605_줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2605 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		int N=Integer.parseInt(br.readLine());
		
		//입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			int input=Integer.parseInt(st.nextToken());
			if(input==0)
				list.add(i);
			else
				list.add(i-1-input,i);
		} 	
		//출력
		for(int x: list)
			System.out.print(x+" ");
	}
}
