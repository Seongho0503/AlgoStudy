package D4.sw4050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SunghoComment {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
		
			int N = Integer.parseInt(br.readLine());
			int[] price = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) 
				price[i]=Integer.parseInt(st.nextToken());	
			
			// 입력값 정렬
			Arrays.sort(price);
			
			// 수정해본 코드 : 재환이 코드에서 for(int j=N-3; j>=0; j=j-3)은 3번쨰 자리수를 0으로 만들어 계산결과 sum에 영향을 주지 않음
			// 재환이 : 3번째 0으로 만들어서 sum에 영향 없음! 성호 : 3번째 어차피 계산 안 하고 sum 구할 때 if조건문으로 점프시키고 계산함.
			// sum을 구할 때 3번쨰 자리수에 조건문을 줘서 3번째 자리가 오면 continue하게 만들었음 (5줄 -> 4줄, j지역변수 안써도 됨)
			// 재환이 코드 진짜 깔끔하다. 필요한 부분만 딱 있네. 간결 그자체
			int sum=0;
			for(int i=0;i<N;i++) {
				  if(i==N-3) continue;
				sum+=price[i];
			}
			
			/* 원래 재환이 코드 :  큰 값에서부터 3번째 되는 값마다 0을 만든다.
			for(int j=N-3; j>=0; j=j-3)
				price[j]=0;
			
			//배열의 합 구하기
			int sum=0;
			for(int i=0;i<N;i++)
				sum+=price[i];
			 */
			
			System.out.println("#" + t + " "+sum);
		}

		br.close();
	}
}