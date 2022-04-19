
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][][] arr;
	static int n;
	static int m;
	static int max_time = Integer.MAX_VALUE;
	static List<int[]> virus = new ArrayList<int[]>();
	static List<Integer> selected;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String s[] = rd.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		arr = new int[n][n][11];
		selected = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			s = rd.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j][0] = Integer.parseInt(s[j]);
				if (Integer.parseInt(s[j]) == 2) {
					int[] tmp = { i, j };
					virus.add(tmp);
				}
			}
		}
		for (int i = 0; i < virus.size(); i++) {
			int[] tmp = { virus.get(i)[0], virus.get(i)[1], 0 };
			check(tmp, i + 1);
		}
		//pr();
		select();
		if(max_time!=Integer.MAX_VALUE&&max_time!=0)
		System.out.println(max_time-1);
		else if(max_time==0){
			System.out.println(0);
		}else {
			System.out.println(-1);
		}

	}

	// virus중에서 m개 선택
	static void select() {
		if (selected.size() >= m) {
			// System.out.println(selected.toString());
			count();
			return;
		}
		for (int i = 0; i < virus.size(); i++) {
			if(selected.size()>0)
			if (selected.get(selected.size()-1)>i)
				continue;
			selected.add(i);
			select();
			selected.remove(selected.size() - 1);
		}
		return;
	}

	// 바이러스 퍼지는 시간 계산
	static void count() {
		int selected_max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j][0] == 0) {
					int min = Integer.MAX_VALUE;
					for (int k = 0; k < m; k++) {
						if (min > arr[i][j][selected.get(k) + 1]&& arr[i][j][selected.get(k) + 1]!=0) {
							min = arr[i][j][selected.get(k) + 1];
						}
					}
					// 각 칸을 검사할 때 현재까지의 최대 시간보다 크거나 같으면 종료
					if (min >= max_time)
						return;

					// 최소시간이 MAX_VALUE일 경우 도달하지 못한 곳이므로 종료
					if (min == Integer.MAX_VALUE) {
						return;
					}
					selected_max = Math.max(min, selected_max);
				}
			}
		}
		max_time = selected_max;
	}

	

	static void check(int[] ij, int num) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(ij);
		int time;
		ij[2] = 1;
		while (!q.isEmpty()) {
			ij = q.poll();
			time = ij[2];
			if(arr[ij[0]][ij[1]][num]!=0)
				continue;
			arr[ij[0]][ij[1]][num] = time;
			for (int k = 0; k < 4; k++) {
				int i = ij[0] + dx[k];
				int j = ij[1] + dy[k];
				if (i < 0 || i >= n || j < 0 || j >= n || arr[i][j][0] == 1 || arr[i][j][num] != 0)
					continue;
				int[] tmp = { i, j, time + 1 };
				q.add(tmp);

			}

		}

	}
	
	//출력 확인용
	static void pr() {
		for (int i = 0; i < virus.size() + 1; i++) {
			System.out.println("-----------");
			for (int j = 0; j < n; j++) {
				for (int l = 0; l < n; l++) {
					System.out.print(arr[j][l][i] + " ");
				}
				System.out.println();
			}
		}
	}

}
