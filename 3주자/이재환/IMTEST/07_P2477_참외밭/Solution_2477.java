package P2477_참외밭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] len = new int[6];
		// 동1 서2 남3 북4
		int hid = 0;
		int wid = 0;
		int h = 0;
		int w = 0;
		
		//입력 and 가장 긴 변 순서 check
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
			if (dir == 3 || dir == 4) {
				if (len[i] > h) {
					h = len[i];
					hid = i;
				}
			} else if (dir == 1 || dir == 2) {
				if (len[i] > w) {
					w = len[i];
					wid = i;
				}
			}
		}
		
		//true : [ㄱ 모양] / false : [ㄱ 대칭모양]  -->대칭이라기 보다는 가로가 기냐 세로가 기냐? 이거를 고르는 행위
		boolean order = false; 
		
		// (5,0)과 같은 순서로 긴변이 나오는 경우 모양 체크
		if (Math.abs(wid - hid) != 1) { 
			if (wid < hid)
				order = true;
		}
		// (1,2) (2,3) (3,4) (4,5) 순서대로 긴변이 나오는 경우 모양 체크
		else{
			if (wid > hid)
				order = true;
		}
		
		int ans = 0;
		
		//전체 세로*전체 가로  - 작은 사각형 넓이
		if (order)
			ans = (h * w - len[(hid + 4) % 6] * len[(wid + 2) % 6]) * K;
		else if (!order)
			ans = (h * w - len[(hid + 2) % 6] * len[(wid + 4) % 6]) * K;
		System.out.println(ans);

	}
}
