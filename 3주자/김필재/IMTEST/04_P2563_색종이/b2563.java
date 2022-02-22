
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[][]=new int[100][100];
		int testcase = Integer.parseInt(rd.readLine());
		for(int i=0;i<testcase;i++) {
			String input[]=rd.readLine().split(" ");
			check(arr,Integer.parseInt(input[0]),Integer.parseInt(input[1]));
		}
		System.out.println(sum(arr));
	}
  
  //붙인 색종이 공간만큼 1로 만듬
	static void check(int[][] arr, int a, int b) {
		for(int i=b-1;i<b+9;i++) {
			for(int j=a-1;j<a+9;j++) {
				arr[i][j]=1;
			}
		}
	}
  //넓이 구하기
	static int sum(int[][] arr) {
		int sum=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]==1)
					sum++;
			}
		}
		return sum;
	}
	
}
