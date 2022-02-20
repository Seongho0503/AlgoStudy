
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10163 {
	static int testcase;
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

		int arr[][] = new int[1001][1001];
		testcase = Integer.parseInt(rd.readLine());
		for (int i = 0; i < testcase; i++) {
			String input[] = rd.readLine().split(" ");
			check(arr, Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]),i+1);
		}
		for(int i:sum(arr))
			System.out.println(i);;
	}
	
	//색종이 놓기
	static void check(int[][] arr, int a, int b,int c,int d, int num) {
		for (int i = b; i < b + d; i++) {
			for (int j = a; j < a + c; j++) {
				arr[i][j] = num;
			}
		}
	}
	
	//종이 번호마다 sum 계산
	static int[] sum(int[][] arr) {
		int sum[] = new int[testcase] ;
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				for(int k=0;k<testcase;k++) {
					if (arr[i][j] == k+1)
						sum[k]++;
				}
				
			}
		}
		return sum;
	}

}
