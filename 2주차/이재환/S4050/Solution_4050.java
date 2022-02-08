package P4050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4050__재관이의대량할인 {
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
			
			// 큰 값에서부터 3번째 되는 값마다 0을 만든다.
			for(int j=N-3; j>=0; j=j-3)
				price[j]=0;
			
			//배열의 합 구하기
			int sum=0;
			for(int i=0;i<N;i++)
				sum+=price[i];
			
			System.out.println("#" + t + " "+sum);
		}

		br.close();
	}
}
