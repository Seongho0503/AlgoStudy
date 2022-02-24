package SWEA_P7964_부먹왕국의차원관문;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7964 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			int ans=0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int D=Integer.parseInt(st.nextToken());
			
			//도시 입력
			int [] city = new int[N+2];
			city[0]=city[N+1]=1;
			
			//관문 정보 입력
			st= new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				city[i] = Integer.parseInt(st.nextToken());
			
			//관문이 있으면 다음칸~다음칸+D-1까지 합 check
			//합이 0이면 마지막 칸 관문 세우고
			//세운 관문 수(ans) 증가
			for(int i=0;i<N+1-D;i++) {
				if(city[i]==1) {
					int sum=0;
					for(int d=1;d<=D;d++) 
						sum+=city[i+d];
										
					if(sum==0) {
						city[i+D]=1;
						ans++;
					}					
				}
			}
			
			sb.append(ans);
			System.out.println(sb);
		}
	}
}
