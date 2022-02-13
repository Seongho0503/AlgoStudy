package IMTEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2669 {
	static int P, Q ,X , Y; 
	static int sum;
	static int[][] map = new int[100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=0; tc<4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			
			//색종이 문제랑 비슷하지만 
			// 기준 점에서 다른 점이 주어지는 경우 조건식에서 row < Q
			// 기준 점에서 길이가 주러지는 경우 row< row + Q
			for(int row =Y; row<Q;row++) {
				for(int col = X; col<P; col++) {
					if(map[row][col] != 1) sum += 1;
					map[row][col] = 1;
				}
			}
			//System.out.println(sum);
		}
		System.out.println(sum);
	}

}
