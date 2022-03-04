package BJ.Siver.파보나치수열_1003;

//메모리: 11556 kb  시간	: 84 ms 코드 길이 : 1150 B
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파보나치수열_1003_ver3 {
	
	//0이 출려되는 횟수 , 문제에서 n이 40까지
	static int[] cnt0 = new int[41];
	//1이 출력되는 횟수
	static int[] cnt1 = new int[41];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 피보나치 수열
		/*int fibonacci(int n) {
		    if (n == 0) {  // n이 0일때-------------------(1)
		        printf("0");
		        return 0;
		    } else if (n == 1) { // n이 1일때  -------------------(2)
		        printf("1");
		        return 1;
		    } else {              // n이 2이상일때 ----------------(3)
		        return fibonacci(n‐1) + fibonacci(n‐2);
		    }
		}
		*/
		//n이 0일 때 피보나치 함수에 넣으면 0의 갯수가 1개  -------------------(1)
		cnt0[0] = 1;
		cnt1[0] = 0;
		
		//n이 1일 때 피보나치 함수에 넣으면 1의 갯수가 1개  -------------------(2)
		cnt0[1] = 0;
		cnt1[1] = 1;
		//N은 40보다 작거나 같은 자연수 또는 0이다. (문제 조건)
		// 피보나치 수열은 피보나치함수(N)에서 N이 2이상일 때부터
		for(int i=2;i<=40;i++) {  //--------------------------(3)
			// fibonacci(N)의 0의 개수는 fibonacci(N-1)의 0의 개수 + fibonacci(N-2)의 0의 개수와 동일하며
	        //1의 경우에도 마찬가지이다. ( 피보나치 수열 원리)
			cnt0[i] = cnt0[i-1] + cnt0[i-2];
			cnt1[i] = cnt1[i-1] + cnt1[i-2];
		}
		//테케 수
		int T = Integer.parseInt(in.readLine());
			
		// 테케 돌리기
		while(T>0) {
			int n = Integer.parseInt(in.readLine());
			System.out.println(cnt0[n]+" "+cnt1[n]);
			T--;
		}
	}
}