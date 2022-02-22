package P2563_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2563 {
	static int [][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N= Integer.parseInt(br.readLine());
		int[][] MAP = new int[100][100];
		int check_cnt=0;
	
		for(int n=0; n<N;n++) {
			st = new StringTokenizer(br.readLine()," ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
	
			for(int i=y;i<y+10;i++) {
				for(int j=x;j<x+10;j++) {
					if(MAP[i][j]==0) {
						MAP[i][j]=1;
						check_cnt++;
					}
				}
			}
		}
		System.out.println(check_cnt);		
	}
}
