package P10163_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10163 {
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] MAP = new int[1002][1002];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			// 번호대로 숫자로 채워넣기 1번 색종이 ->1, 2번색종이->2
			for (int i = x; i < x + l; i++)
				for (int j = y; j < y + h; j++) {
					if (i >= 0 && j >= 0 && i <= 1000 && j <= 1000)
						MAP[i][j] = n;
				}

		}

		//덮힌 색종이 구역은 덮은 색종이에 의해 덮어쓰기됨
		//색종이 갯수 구하기 (해당 숫자와 일치하는 것 갯수 찾기)
		int[] sum = new int[N + 1];
		for (int n = 1; n <= N; n++)
			for (int i = 0; i <= 1000; i++)
				for (int j = 0; j <= 1000; j++)
					if (MAP[i][j] == n)
						sum[n]++;

		for (int n = 1; n <= N; n++)
			System.out.println(sum[n]);

	}
}
