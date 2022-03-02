package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//메모리 : 11528KB
//시간 : 80ms
public class BOJ_1003_피보나치함수 {
	static int count[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			//count[0]==> 0의 갯수/count[1] ==> 1의 갯수
			count = new int[2]; 
			fibonacci(N);
			sb.append(count[0]).append(" ").append(count[1]);
			System.out.println(sb);
		}
	}

	static void fibonacci(int n) {
		int temp=0;
		int t0=0; //0
		int t1=1; //1
		if (n == 0) {
			count[0]++;
			return;
		} else if (n == 1) {
			count[1]++;
			return;
		} else if(n<0){
			return;
		}else {
			//메모이제이션 기법으로 재귀함수를 for문으로 바꿔주니 시간초과가 안났음
			//Dynamaic Programming공부의 필요성 느낌
			for(int i=1;i<n;i++) {
				temp= t0+t1;
				t0=t1;
				t1=temp;
			}
			count[0]=t0;
			count[1]=t1;
		}
			
	}

}
