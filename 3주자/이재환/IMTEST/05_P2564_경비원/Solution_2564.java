
package P2564_경비원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2564 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N =Integer.parseInt(st.nextToken());
		int S =Integer.parseInt(br.readLine());
		int[] stores = new int[S]; 
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			
			if(dir==1) stores[i]=pos;
			else if(dir==2) stores[i]=M+N+M-pos;
			else if(dir==3) stores[i]=M+N+M+N-pos;
			else if(dir==4) stores[i]=M+pos;	
		}
		int len=0;
		st = new StringTokenizer(br.readLine());
		int dir=Integer.parseInt(st.nextToken());
		int pos=Integer.parseInt(st.nextToken());
		if(dir==1) len=pos;
		else if(dir==2) len=M+N+M-pos;
		else if(dir==3) len=M+N+M+N-pos;
		else if(dir==4) len=M+pos;	
		
		int sum=0;
		for (int i = 0; i < S; i++) 
			sum+=Math.min(Math.abs(stores[i]-len),2*M+2*N-Math.abs(stores[i]-len));
	
		System.out.println(sum);

	}
}
