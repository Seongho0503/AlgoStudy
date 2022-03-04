package BJ.Siver.유기농배추_1012;


// 메모리: 26364 kb  시간	: 268 ms 코드 길이 : 1150 B
import java.util.Scanner;

public class Main_유기농배추 {
	static boolean [][] map; 
	//이미 방문했는지 또는 배추가 있는지 표시하기 위한 배열
	static int[] dx = {-1,0,1,0}; 
	static int[] dy = {0,1,0,-1}; 
	static int  M, N, num, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
	
		for(int t=1; t<=T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			num = sc.nextInt();
			cnt = 0;
			map = new boolean[N][M];
			
			//배추 입력
			for(int i=0; i<num; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				map[r][c] = true; 
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0;j<M; j++) {
					if(map[i][j]) { //배추 있으면   -> 지렁이 증가
						cnt++;     
						find(i, j);
					}
				}
			}
			
			System.out.println(cnt);
		}
		sc.close();
	}
	//dfs
	public static void find(int row, int col) {
			map[row][col] = false; //방문 후 false 처리
			
			for(int i=0; i<4; i++) {
				int nx = row+dx[i];
				int nc = col+dy[i];
				//배추가 있다면, 상하좌우 방문
				if(nx>=0&&nx<N&&nc>=0&&nc<M&&map[nx][nc]) {
					find(nx,nc);
				}
			}
	}
}