package P10157_자리배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10157 {
	//우,하,좌,상
	static int[] dx= {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][] map=new int[C+1][R+1];
		
		// 대기번호가 좌석수를 넘어가면 0 출력 후 return
		if(K>R*C) {
			System.out.println(0);
			return;
		}
		
		//1,1 -> R,C 모든 좌석 0(빈 좌석)으로 초기화
		for(int i=1;i<=C;i++)
			for(int j=1;j<=R;j++)
				map[i][j]=0;
		
		//시작점
		int x=0;
		int y=1;
		
		int dir=0; // 배열 순회 방향
		int cnt=0; //현재 좌석 배정 수
		
		while(cnt<R*C){
			if(cnt==K) break; 
		
			int nx = x + dx[dir%4];
			int ny = y + dy[dir%4];

			//범위 벗어나거나, 해당좌석이 0(빈 좌석)이 아니면 방향 바꾸기	
			if (nx > R || ny > C || nx <1 || ny < 1 ||map[ny][nx]!=0) {
				dir++;
				continue;
			}		
			map[ny][nx]=++cnt;
			x=nx;
			y=ny;		
		}
		//출력
		System.out.print(y+" "+x);
			
	}
}