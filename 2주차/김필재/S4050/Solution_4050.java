import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Solution_4050 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(rd.readLine());
		for(int i=0;i<testcase;i++) {
			int sum=0;
			int n=Integer.parseInt(rd.readLine());
			
			//가격 배열 입력받아서 split후 int 배열로 변환
			String input[]=rd.readLine().split(" ");
			int c[]=new int[input.length];
			for(int j=0;j<input.length;j++) {
				c[j]=Integer.parseInt(input[j]);
				sum+=c[j];
			}
			
			//가격 순으로 정렬
			Arrays.sort(c);
			
			//가장 비싼 것부터 세 번째 옷의 값 순서대로 제거 
			for(int j=c.length-3;j>=0;j-=3) {
				sum-=c[j];
				System.out.println(c[j]);
			}
			System.out.println("#"+(i+1)+" "+sum);
		}
	}

}
