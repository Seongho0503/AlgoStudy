package Algorizm.s1860;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_1860 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			String answer="Possible";
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int [] tmp = new int[n];
		
			//손님 체크
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<n;i++) 
				tmp[i]= Integer.parseInt(st.nextToken());
			
			Arrays.sort(tmp);
			// 손님 온 시간/만드는 시간 * 초당 만드는 갯수 = 만들수 있는 총 갯수 
 			for(int i=0;i<n;i++){
				int cnt = (tmp[i]/m) * k;
				if(cnt-(i+1)<0)
					answer="Impossible";
			}
			System.out.println("#"+t+" "+answer);
		}
		br.close();
	}
}
