package P14696_딱지놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//별4>동그라미3>네모2>세모1 -> 무승부

public class Solution_14696 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			int A[]=new int[5];
			int B[]=new int[5];
			//A 딱지 입력
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			for (int j = 0; j < a; j++) {
				int tmp=Integer.parseInt(st.nextToken());
				A[tmp]++;	
			}

			//B 딱지 입력
			st = new StringTokenizer(br.readLine());
			int b=Integer.parseInt(st.nextToken());
			for (int j = 0; j < b; j++) {
				int tmp=Integer.parseInt(st.nextToken());
				B[tmp]++;	
			}
			
			//딱지 갯수 비교
			char ans='0';
			for(int k=4;k>0;k--) {
				if(A[k]>B[k]) {
					ans='A';
					break;
				}
				else if(A[k]<B[k]) {
					ans='B';
					break;
				}
				ans='D';
			}

			System.out.println(ans);		
		}

	}
}
