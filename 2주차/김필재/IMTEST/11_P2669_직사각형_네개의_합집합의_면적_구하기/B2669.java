
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2669 {
	static int sum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[][]=new int[101][101];

		for(int i=0;i<4;i++) {
			String input[]=rd.readLine().split(" ");
			check(arr,Integer.parseInt(input[0]),Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]));
		}
		System.out.println(sum);
	}
	
	
	static void check(int[][] arr, int a, int b,int c, int d) {
		for(int i=b;i<d;i++) {
			for(int j=a;j<c;j++) {
				if(arr[i][j]==0) {
					arr[i][j]=1;
					sum++;
				}
			}
		}
	}
	
}
