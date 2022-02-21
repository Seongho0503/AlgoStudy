package P2304_창고다각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_2304 {

	//기둥 클래스
	public static class Column implements Comparable<Column> {
		int l;
		int h;

		public Column(int l, int h) {
			super();
			this.l = l;
			this.h = h;
		}

		@Override
		public int compareTo(Column o) {
			return this.l - o.l;
		}

		@Override
		public String toString() {
			return "Column [l:" + l + " h:" + h + " ]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 기둥 갯수
		ArrayList<Column> list = new ArrayList<>();
		
		int max_h = 0;
		int max_idx = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			list.add(new Column(l, h));
			max_h = Math.max(max_h, h);
		}
		//오름 차순 정렬
		Collections.sort(list);

		//가장 높은 기둥 찾기
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).h == max_h) {
				max_idx = i;
				break;
			}
		}

		//최대 기둥 왼쪽에서부터 더하기
		int ans = 0;
		for (int i = 0; i < max_idx; i++) {
			for (int j = i + 1; j <= max_idx; j++) {
				if (list.get(i).h <= list.get(j).h) {
					ans += (list.get(j).l - list.get(i).l) * list.get(i).h;
					i = j;
				}
			}
		}
		
		//최대 기둥 오른쪽에서 더하기

		for (int i = N - 1; i > max_idx; i--) {
			for (int j = i - 1; j >= max_idx; j--) {
				if (list.get(i).h <= list.get(j).h) {
					ans += (list.get(i).l - list.get(j).l) * list.get(i).h;
					i = j;
				}
			}
		}

		//최대 기둥 더해주기
		ans += max_h * 1;

		System.out.println(ans);

	}
}
