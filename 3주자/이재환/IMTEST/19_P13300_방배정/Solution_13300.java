package P13300_방배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_13300 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] list = new int[2][7];

		//배열을 만들어서 입력과 동시에 인원 체크하기
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			list[s][grade]++;
		}


		//각 배열 방마다 K로 나누고
		//나머지가 0일때와 0이 아닐때 나눠서 방 정해주기
		int ans=0;
		for(int s=0;s<=1;s++) {
			for(int grade=1;grade<=6;grade++) {
				if(list[s][grade]%K==0)
					ans+=list[s][grade]/K;
				else
					ans+=(list[s][grade]/K+1);
			}
		}
		System.out.println(ans);

	}
}
