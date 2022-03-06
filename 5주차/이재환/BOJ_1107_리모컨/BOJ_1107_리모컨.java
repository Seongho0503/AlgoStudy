package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//brute force문제 
//이런 유형을 많이 안 풀어봐서 처음에 접근하는게 힘들었음

//메모리 : 69592KB 시간:332ms
public class BOJ_1107_리모컨 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] remote = new int[10];
		int channel = 100;
		// 변수 입력
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		//M=0인 경우를 고려 안해주니 런타임 오류가 났었음(백준 채점 85퍼쯤에?)
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				remote[Integer.parseInt(st.nextToken())]++;
			}
		}
		int ans = Math.abs(N - channel); // u,d로만 이동할경우 (최악의 상황)

		// 최대 채널 500000, 최악의 경우 0->500000, 999999->500000
		// 0~999999까지 다 체크해서 최솟값 구하기
		for (int i = 0; i <= 999999; i++) {
			boolean break_check = false;
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				if (remote[str.charAt(j) - '0'] == 1) {
					break_check = true;
					break;
				}
			}

			// 부서진 버튼을 누르는 경우는 pass
			if (break_check)
				continue;

			int min = Math.abs(N - i) + str.length(); // 눌러야하는 u,d 버튼 수 + 채널 수
			ans = Math.min(min, ans);

		}
		System.out.println(ans);

	}

}
