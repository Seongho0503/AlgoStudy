package SWEA.D3.오목판정_11315;

/*
 * 저번에 재환이가 중첩 loof break로 탈출 못하는 거
 * break loof로 탈출 시켰음 
 * 
 * 
 */
import java.io.*;

public class 오목판점_11315_ver2_내가디버깅용 {
	
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	// 8방 접근 :  상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
	static int a;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		// 테케 시작
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); 
			char[][] map = new char[N][N];

			// .입력
			for (int i = 0; i < N; i++) {
				// 한줄 읽기. ..o..
				String line = br.readLine(); 
				// 2차원 배열에 요소마다 값 할당
				map[i] = line.toCharArray(); 			
				} 

			// 오목여부체크
			boolean bingo = false;

			// 한칸씩 탐색
			loof: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (map[i][j] == 'o') {// 돌발견 ->8방 체크해야 함
						for (int k = 0; k < 8; k++) {
							// 8방 체크. 추가로 4개 오목알이 더 발견되면 성공
							for (int cnt = 1; cnt <= 4; cnt++) {
								int nx = i + dx[k] * cnt;
								int ny = j + dy[k] * cnt;

								// map 경계값 체크, 밖으로 나가면 종료시킴
								if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
									break;
								// 동그라미가 아니면 종료시킴 
								} else if (map[nx][ny] != 'o') {
									break;
								}

								if (cnt == 4) {
									// 한방향 빙고
									bingo = true;
									break loof; 
									// 이증 루프 빠져 나감 
								} 
							} 
						} 
					} 
				} 
			} 
			sb.append("#" + tc + " " + (bingo ? "YES" : "NO") + "\n");
		}

		System.out.println(sb);

	}

}