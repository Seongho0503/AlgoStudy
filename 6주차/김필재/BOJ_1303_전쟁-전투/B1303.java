
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//메모리 12496kb 시간 84ms
public class B1303 {
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int a;
	static int b;
	static char[] co = { 'W', 'B' };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String[] s = rd.readLine().split(" ");
		a = Integer.parseInt(s[0]);
		b = Integer.parseInt(s[1]);
		arr = new char[b][a];
		visited = new boolean[b][a];
		for (int i = 0; i < b; i++) {
			String s2 = rd.readLine();
			for (int j = 0; j < a; j++) {
				arr[i][j] = s2.charAt(j);
			}
		}
		int[] power = new int[2];
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				if (!visited[i][j]) {
					int[] result = check(i, j, 0, -1);
					//System.out.println(Arrays.toString(result));
					power[result[0]] += Math.pow(result[1], 2);
				}
			}
		}
		System.out.println(power[0]+" "+power[1]);
	}

	// 흰색:0 파란색:1
	// co= {'W','B'}
	static int[] check(int i, int j, int sum, int color) {
		sum++;
		if (color == -1) {
			if (arr[i][j] == 'W')
				color = 0;
			else
				color = 1;
		}
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int ii = i + dx[k];
			int jj = j + dy[k];
			if (ii < 0 || ii >= b || jj < 0 || jj >= a || visited[ii][jj] || arr[ii][jj] != co[color])
				continue;
			sum = check(ii, jj, sum, color)[1];
		}
		int[] result = { color, sum };
		return result;
	}

}
