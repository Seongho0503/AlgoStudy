// 메모리 : 192512 kb  시간 : 392 ms
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
	static int[][] arr;
	static int[][] arr2;
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
		arr = new int[n][n];
		selected = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			s = rd.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
				if (Integer.parseInt(s[j]) == 2) {
					int[] tmp = { i, j };
					virus.add(tmp);
				}
			}
		}
		
		select();
		if (max_time != Integer.MAX_VALUE && max_time != 0)
			System.out.println(max_time - 1);
		else if (max_time == 0) {
			System.out.println(0);
		} else {
			System.out.println(-1);
		}

	}

	// virus중에서 m개 선택
	static void select() {
		if (selected.size() >= m) {
			//System.out.println(selected.toString());
			check();
			return;
		}
		for (int i = 0; i < virus.size(); i++) {
			if (selected.size() > 0)
				if (selected.get(selected.size() - 1) >= i)
					continue;
			selected.add(i);
			select();
			selected.remove(selected.size() - 1);
		}
		return;
	}

	static void check() {
		arr2=new int[n][n];
		for (int l = 0; l < m; l++) {
			
			Queue<int[]> q = new LinkedList<int[]>();
			int[] tmp = { virus.get(selected.get(l))[0],virus.get(selected.get(l))[1], 1 };
			q.add(tmp);
			int time;
			while (!q.isEmpty()) {
				int[] ij = q.poll();
				time = ij[2];
				
				if (arr[ij[0]][ij[1]] == 1)
					continue;
				if (arr2[ij[0]][ij[1]] <= time&&arr2[ij[0]][ij[1]]!=0)
					continue;
				//if(arr2[ij[0]][ij[1]]>time)
				arr2[ij[0]][ij[1]] = time;
				for (int k = 0; k < 4; k++) {
					int i = ij[0] + dx[k];
					int j = ij[1] + dy[k];
					if (i < 0 || i >= n || j < 0 || j >= n || arr[i][j] == 1 || (arr2[i][j] <time+1)&&arr2[i][j]!=0)
						continue;
					int[] tmp2 = { i, j, time + 1 };
					q.add(tmp2);

				}

			}
		}
		int max=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]==0&&arr2[i][j]==0) {
					return;
				}
				if(arr[i][j]==2)
					continue;
				if(max<arr2[i][j])
					max=arr2[i][j];
			}
		}
		
		if(max<max_time) {
			max_time=max;
			//System.out.println(selected.toString());
			//pr();
		}

	}

	// 출력 확인용
	static void pr() {
			System.out.println("-----------");
			for (int j = 0; j < n; j++) {
				for (int l = 0; l < n; l++) {
					System.out.print(arr2[j][l] + " ");
				}
				System.out.println();
			}
		
	}

}
