package Algorizm.s2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
		
			int n = Integer.parseInt(br.readLine());
			int[][] field = new int[n][n];
			
			//숫자 담기
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++)
					field[i][j] = str.charAt(j)-'0';
			}
			
			int sum = 0;
			
			//반틈 더하기
			for (int i = 0; i <= n / 2; i++) {
				for (int j = n / 2 - i; j <= n / 2 + i; j++) 
					sum += field[i][j];
			}
			
			//나머지 반틈 더하기
			for (int i = n / 2 + 1; i < n; i++) {
				for (int j = i - n / 2; j <= 3 * (n / 2) - i; j++)
					sum += field[i][j];
			}

			System.out.println("#" + t + " " + sum);
		}

		br.close();
	}
}
