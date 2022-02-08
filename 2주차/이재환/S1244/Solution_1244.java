package P1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
10
123 1
2737 1
757148 1
78466 2
32888 2
777770 5
436659 2
431159 7
112233 3
456789 10
 */
public class Solution_1244_최대상금 {
	static int N;
	static int[] price;
	static int res;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();

			N = Integer.parseInt(st.nextToken());
			price = new int[str.length()];

			for (int i = 0; i < str.length(); i++)
				price[i] = str.charAt(i) - '0';
			
			max=0;
			ans = find_swap(0, 0);

			System.out.println("#" + t + " " + ans);
		}
		br.close();
	}

	public static int find_swap(int cnt, int start) {
		int temp;
		// 기본 파트
		if (cnt == N) {			
			res=0;		
			// 숫자 구하기
			for (int i = 0; i < price.length; i++)
				res += price[i] * Math.pow(10, price.length - 1 - i);
			// 최대값 구하기
			max = Math.max(res, max);
			return max;
		}

		// 유도 파트 (모든 경우의수 구하기 = 완전탐색?)
		for (int i = start; i < price.length; i++) 
			for (int j = i + 1; j < price.length; j++) {
				if (price[j] >= price[i]) {
					// 자리 바꾸기
					temp = price[i];
					price[i] = price[j];
					price[j] = temp;
					// 재귀 호출
					find_swap(cnt + 1,i);
					// 자리 돌려놓기
					temp = price[i];
					price[i] = price[j];
					price[j] = temp;
				}
			}	
		return max;
	}
}
