
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	static int[][] arr;

	// j 짝수일 때 = 상 하 좌 우 좌상 우상의 셀과 연결되어있음
	static int[] dx1 = { -1, 1, 0, 0, -1, -1 };
	static int[] dy1 = { 0, 0, -1, 1, -1, 1 };

	// j 홀수일 때 = 상 하 좌 우 좌하 우하의 셀과 연결되어있음
	static int[] dx2 = { -1, 1, 0, 0, 1, 1 };
	static int[] dy2 = { 0, 0, -1, 1, -1, 1 };
	static int max = 0;
	static int max_sum = 0;

	static List<int[]> cell;
	static List<int[]> selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(rd.readLine());
		for (int t = 1; t <= test; t++) {
			String[] s = rd.readLine().split(" ");
			int w = Integer.parseInt(s[0]);
			int h = Integer.parseInt(s[1]);
			cell = new ArrayList<>();
			selected = new ArrayList<>();
			arr = new int[h][w];
			for (int i = 0; i < h; i++) {
				s = rd.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					int[] tmp = { i, j, Integer.parseInt(s[j]) };
					cell.add(tmp);
				}
			}

			// 셀들을 사용자 수 큰 순으로 정렬
			Collections.sort(cell, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[2] - o1[2];
				}
			});
			check(0);
			System.out.println("#"+t+" "+max);
		}
	}

	// 두 셀이 연결되어있는지 확인
	static boolean check_connected(int[] ij1, int[] ij2) {
		for (int k = 0; k < 6; k++) {
			if (ij1[1] % 2 == 0) {
				if ((ij1[0] + dx1[k] == ij2[0]) && (ij1[1] + dy1[k] == ij2[1])) {
					return true;
				}
			} else {
				if ((ij1[0] + dx2[k] == ij2[0]) && (ij1[1] + dy2[k] == ij2[1])) {
					return true;
				}
			}
		}
		return false;
	}

	static void check(int n) {
		// 이미 max값이 있을 때에는 나머지 선택을 cell 값중 최대값으로 채워도 현재 max일 때보다 작을 경우 종료
		if (max > 0) {
			int sum = 0;
			for (int[] k : selected) {
				sum += k[2];
			}
			if (sum + cell.get(0)[2] * (4 - selected.size()) < max_sum)
				return;
		}
		// 4개 선택하였을 때
		if (n == 4) {
			int connection = 0;
			// 리스트의 셀들이 모두 연결되어있는지 확인
			Queue<int[]> q = new LinkedList<int[]>();
			List<int[]> visited = new ArrayList<>();
			q.add(selected.get(0));
			visited.add(selected.get(0));
			while (!q.isEmpty()) {
				for (int[] i : selected) {
					if (visited.contains(i))
						continue;
					if (check_connected(q.peek(), i)) {
						q.add(i);
						visited.add(i);
						connection++;
					}
				}
				q.poll();
			}
			// 모든 셀이 연결되어있으면 max와 비교하여 값을 저장하고 리턴
			if (connection == 3) {
				int sum = 0;
				for (int[] k : selected) {
					// System.out.print(k[2] + " ");
					sum += k[2];
				}
				// System.out.println();
				max = Math.max(max, (int) Math.pow(sum, 2));
				max_sum = sum;
				return;
			} else {
				return;
			}
		}

		// cell에서 하나씩 선택하여 selected 리스트에 추가
		for (int[] select : cell) {
			// 중복 방지
			if (selected.contains(select))
				continue;
			selected.add(select);
			check(n + 1);
			selected.remove(selected.size() - 1);
		}
	}
}
