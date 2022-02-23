package BJ.Siver.색종이2_2567;



/*
 * 
 * 둘레
 * 색종이 부분의 배열을 1로 채워줌
 * 안에 있는 내부 사각형은  둘레에 포함 안된다.
 * (1)작은 사각형의 좌,우,상,하에 0이 있어야 둘레에 포함되니다.
 * 색종이 부분을 1로 채우고 좌,우, 상, 하  0이 있나 검사 실시
 * 
 */

import java.util.*;
import java.io.*;

public class 색종이2_2568_ver3_스터디업로드 {
	static int[][] map = new int[100][100];
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= num; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			//가로
			int row = Integer.parseInt(st.nextToken());
			//세로
			int col = Integer.parseInt(st.nextToken());

			//배열 입력 start
			for (int i = row; i < row + 10; i++) {
				for (int j = col; j < col + 10; j++) {
					if (map[i][j] == 1) continue;
					map[i][j] = 1;

				}

			} // 배열 입력 end

		}// 한 테케 end

		// 둘레 체크 start
		for(int i = 1; i<map.length;i++) {
			for(int j=1; j<map[i].length; j++) {
				
				if(map[i][j]==1) {
					// 처음에 이렇게 했다가 한번씩만 체크 되서 원래 둘레보다 적게 나옴 각각 니눠서 cnt를 ++ 시켜야 함
					//if(map[i][j-1]==0 || map[i][j+1]==0 || map[i+1][j]==0 || map[i-1][j]==0) cnt++;
					// 이렇게 하면 안 되는 부분을 그림 첨부함 (꼭지점 부분은 둘레에 2번 포함 됨)
					if(map[i][j-1]==0)  cnt++;
					if(map[i][j+1]==0)  cnt++;
					if(map[i-1][j]==0)  cnt++;
					if(map[i+1][j]==0)  cnt++;
					
				}
				
			}
			
		} // 둘레 체크 end
			System.out.println(cnt);
	} // 모든 테케 종료
}
