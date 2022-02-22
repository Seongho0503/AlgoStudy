package P2669_직사각형_네개의_합집합의_면적_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1 2 4 4
2 3 5 7
3 1 6 5
7 3 8 6
*/
public class Solution_2669 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int map[][] = new int[101][101];
		int area = 0;

		for (int n = 0; n < 4; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int i = y1; i < y2; i++)
				for (int j = x1; j < x2; j++) {
					if (map[i][j] != 1) {
						map[i][j] = 1;
						area++;
					}
				} // 출력
		}
		System.out.print(area);
	}
}