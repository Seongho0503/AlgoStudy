package P2491_수열_오류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//최장수열 한것처럼 해봤는데 테케는 다 통과하거든?
//백준 사이트를 통과하지못하네 ㅠ 반례가 있나본데.. 계속 바꿔보는중 
public class Solution_2491 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int len[] = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			len[i] = 1;
		}

		int max = 0;

		for (int i = 1; i < N; i++) {
			if (arr[i] >= arr[i - 1] && len[i - 1] + 1 > len[i])
				len[i] = len[i - 1] + 1;
			max = Math.max(max, len[i]);
		}

		for (int i = 0; i < N; i++)
			len[i] = 1;

		for (int i = 0; i < N - 1; i++) {
			if (arr[i] >= arr[i + 1] && len[i] + 1 > len[i + 1])
				len[i + 1] = len[i] + 1;
			max = Math.max(max, len[i]);
		}

		System.out.println(max);

	}
}
