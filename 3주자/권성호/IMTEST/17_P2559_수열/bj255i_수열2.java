package bj255i_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj255i_수열2 {
	//매회 최대 값 온도 임시 저장
	static int swapsum=0;
	//실제 최대 값 온도 저장
	static int temsum=0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());
		int date = Integer.parseInt(st.nextToken());
		// 온도를 담을 배열
		int[] dates = new int[num];
		
		//배열에 온도를 담음
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		for(int k=0; k<num; k++) {
			dates[k] = Integer.parseInt(st1.nextToken());
		}
		
		// 검사 조건은 밑에 주석 참고 (일수가 num - date(연속된 날짜) = 묶는횟수)
		// 10일에서 3일 연속 최대 값 체크하는 횟수는 7번
		for(int i=0; i<=num-date;i++) {
			// 임시 저장 최대값 매번 초기화
			swapsum=0;
			// 횟수별 최대 온도합 구하는 로직
			for(int j=i;j<i+date;j++) {
				swapsum += dates[j];
				
		  }// 합을 다 구하면 for문 밖에서 최대값을 비교 및 음수 온도가 입력 값으로 들어올 수 있는데 
			// swapsum이 초기화 값이 0이므로 처음 i=0일 때 최대값을 일부러 포함시키기 위해 무조건 최대 온도합에 넣는다.
			if(swapsum > temsum || i==0) temsum= swapsum;
		}
		System.out.println(temsum);
	}
}

// 2일간 검사 횟수 = n-1
// 3일간 검사 횟수 = n-2
// 5일간 검사 횟수 = n-4 
