package IMTEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10157 {
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int ROW;
	static int COL;
	static int num;
	static boolean map[][];

	// 접근법 : 달팽이 문제랑 비슷함 (바같 부터 숫자를 채우면 된다)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," "); 
		
		COL = Integer.parseInt(st.nextToken());
		ROW = Integer.parseInt(st.nextToken());
		map = new boolean[ROW][COL];
		num = Integer.parseInt(br.readLine());
		//  총 좌석 수 계산하여 초과한 수가 입력되면 0 반환
		if(num > ROW*COL)
		{
		 System.out.println(0); 
		 return;  //똑같은 코드 (프로그램 강제종료) System.exit(0);
		}
		search(0,0);
	} 
	static void search(int x, int y) {
		int cnt = 0;
		int cx = x;
		int cy = y;
		
		// (x,y)를 (0,0)으로 잡음
		int nx = 0 , ny = 0; 
		int dir = 0;
		map[x][y] = true;
		//4방탐색 (상 ->우 -> 하 ->좌) 회전
		while(true) {
			//cnt 세면서 입력 받은 num에 도달하면 강제 종료
			if(cnt == num) {
				System.out.println((cy - dy[dir] + 1) + " " +(cx - dx[dir] + 1));
				return;
			}
			
			nx = cx + dx[dir];
			ny = cy + dy[dir];
			//(nx,ny)가 맵 밖(범위를 벗어나거나/경계값 체크)으로 나가거나 이미 방문한 곳에서는 방향을 바꿔준다 
			if(nx < 0 || nx >= ROW || ny < 0 || ny >= COL || map[nx][ny]) {
				dir = (dir+1) % 4;
				nx = cx + dx[dir];
				ny = cy + dy[dir];
			}
			
			map[nx][ny] = true;
			cx = nx; 
			cy = ny;
			cnt++;
		}
	}
}