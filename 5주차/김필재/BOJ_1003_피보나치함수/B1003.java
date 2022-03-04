import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1003 {
	//fibonacci(n)의 0,1 개수 저장 배열
	static int[][] result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(rd.readLine());
		for(int t=0;t<test;t++) {
			//테스트케이스 최대 n=40
			result = new int[41][2];
			int n = Integer.parseInt(rd.readLine());
			int[] a= fibonacci(n);
			System.out.println(a[0]+" "+a[1]);
		}
		
	}

	static int[] fibonacci(int n) {
		//계산 결과가 배열에 있으면 그 값을 리턴
		if(result[n][0]!=0)
			return result[n];
		if (n == 0) {
			//0의 개수 1, 1의 개수 0
			int[] a= {1,0};
			return a;
		} else if (n == 1) {
			//0의 개수 0, 1의 개수 1
			int[] a= {0,1};
			return a;
		} else {
			int[] a=fibonacci(n - 1);
			int[] b=fibonacci(n - 2);
			
			//fibonacci(n - 1)의 0과 1의 개수와 fibonacci(n - 2)의 0과 1의 개수를 더함
			int[] c= {a[0]+b[0],a[1]+b[1]};
			
			//이번 계산 결과 배열에 저장
			result[n]=c;
			return c;
		}
	}
}
