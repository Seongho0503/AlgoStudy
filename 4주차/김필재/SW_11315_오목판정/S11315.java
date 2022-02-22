
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S11315 {
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상 하 좌 우 상좌 상우 하좌 하우
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int n = 0;
	static char[][] arr;
	static boolean check;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(rd.readLine());
		for (int t = 0; t < test; t++) {

			n = Integer.parseInt(rd.readLine());
			arr = new char[n][n];
			for (int i = 0; i < n; i++) {
				String input = rd.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = input.charAt(j);
				}
			}
			// 테스트 케이스마다 초기화
			check = false;

			// 모든 위치에 대하여 체크 실행
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 8방향에 대해서 실행
					for (int k = 0; k < 8; k++) {
						if (arr[i][j] == 'o')
							check(k, i, j, 1);
					}
				}
			}
			System.out.print("#" + (t + 1));
			if (check) {
				System.out.println(" YES");
			} else {
				System.out.println(" NO");
			}

		}
	}

	static void check(int direction, int i, int j, int num) {
		// System.out.println(i+" "+j+" "+num+" "+direction);
		if (num >= 5) {
			check = true;
			return;
		}
		// 다음 값이 배열 범위 안에 있는지
		if (i + dx[direction] >= 0 && i + dx[direction] < n && j + dy[direction] >= 0 && j + dy[direction] < n) {
			// 다음 값이 o일때 체크
			if (arr[i + dx[direction]][j + dy[direction]] == 'o')
				check(direction, i + dx[direction], j + dy[direction], num + 1);
			else
				return;
		}

	}
}
