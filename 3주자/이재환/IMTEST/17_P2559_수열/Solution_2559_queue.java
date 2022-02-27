package P2559_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2559 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine(), " ");

		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			queue.offer(temp);
			sum += temp;
			if (!queue.isEmpty() && queue.size() == K) {
				max = Math.max(sum, max);
				sum -= queue.poll();
			}

		}
		System.out.println(max);

	}
}
