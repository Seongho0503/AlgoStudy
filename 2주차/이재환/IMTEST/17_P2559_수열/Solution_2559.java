package P2559_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



//성공은 뜨지만 시간이 1016ms 제한시간은 1초 -> 시간 줄이는거 고민해봐야할 문제
public class Solution_2559 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		int[] temp = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		//온도 입력 
		for(int i=0;i<N;i++)
			temp[i]=Integer.parseInt(st.nextToken());
		int sum;
		int max=Integer.MIN_VALUE;
		//K개씩 더하기
		for(int i=0;i<=N-K;i++){
			sum=0;
			for(int j=i;j<i+K;j++) {
				sum+=temp[j];
			}
			//최댓값 찾기
			if(max<sum) max=sum;
		}
			
		System.out.println(max);

	}
}
