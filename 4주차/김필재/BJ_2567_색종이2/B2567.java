
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2567 {
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

		int arr[][] = new int[102][102];
		int testcase = Integer.parseInt(rd.readLine());
		for (int i = 0; i < testcase; i++) {
			String input[] = rd.readLine().split(" ");
			check(arr, Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		System.out.println(sum(arr));
	}

	static void check(int[][] arr, int a, int b) {
		for (int i = b - 1; i < b + 9; i++) {
			for (int j = a - 1; j < a + 9; j++) {
				arr[i + 1][j + 1] = 1;
			}
		}
	}

	static int sum(int[][] arr) {
		int sum = 0;
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				// System.out.print(arr[i][j]);
				// 도화지 꼭지점이면
				if (arr[i][j] == 1
						&& ((i == 99 && j == 99) || (i == 0 && j == 99) || (i == 99 && j == 0) || (i == 0 && j == 0)))
					sum += 2;
				// 색종이 꼭지점이면 //상좌 //상우 //하우 //하좌
				else if (arr[i][j] == 1 && ((arr[i - 1][j] == 0 && arr[i][j - 1] == 0)
						|| (arr[i - 1][j] == 0 && arr[i][j + 1] == 0) || (arr[i + 1][j] == 0 && arr[i][j + 1] == 0)
						|| (arr[i + 1][j] == 0 && arr[i][j - 1] == 0)))
					sum += 2;
				// 도화지 가장자리이면
				else if (arr[i][j] == 1 && (i == 0 || i == 99 || j == 0 || j == 99))
					sum++;
				// 색종이 가장자리이면
				else if (arr[i][j] == 1
						&& (arr[i][j + 1] == 0 || arr[i][j - 1] == 0 || arr[i + 1][j] == 0 || arr[i - 1][j] == 0))
					sum++;
			}
			// System.out.println();
		}
		return sum;
	}

}
