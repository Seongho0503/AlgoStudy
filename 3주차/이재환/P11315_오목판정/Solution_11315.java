package P11315_오목판정;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_11315 {
	static int N, ans, cnt;
	static char[][] map;
	static int[] dx= { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
		
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			ans = 0;
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			//입력
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++)
					map[i][j] = str.charAt(j);
			}
			
			//돌 찾으면 5줄 이상인지 check
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < N; j++) 
					if (map[i][j] == 'o') 
						check(i, j);
		
			if(ans == 1)
				sb.append("YES");
			else
				sb.append("NO");
			
			System.out.println(sb);
		}
	}

	//8방 탐색 이용
	private static void check(int y, int x) {
		for (int d = 0; d < 8; d++) {
			cnt = 1;
			while(true) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				
				if(ny<0||nx<0||ny>=N||nx>=N||map[ny][nx]!='o') break;	
				
				cnt++;
				x=nx;
				y=ny;
				if(cnt==5) ans=1;
			}
		}
	}
}
