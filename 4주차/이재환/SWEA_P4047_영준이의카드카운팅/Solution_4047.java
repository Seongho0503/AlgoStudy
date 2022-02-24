package SWEA_P4047_영준이의카드카운팅;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int type = 0;
			int[][] card = new int[4][14];
			int flag=0;
			int s=13,d=13,h=13,c=13;
			
			String str = br.readLine();	
			for (int i = 0; i < str.length(); i += 3) {
				char ch = str.charAt(i);
				switch (ch) {
					case 'S': type = 0; s--; break;
					case 'D': type = 1; d--;break;
					case 'H': type = 2; h--;break;
					case 'C': type = 3; c--;break;
					default: break;
				}
				
				int num=(str.charAt(i + 1) - '0') * 10 + (str.charAt(i + 2) - '0');
				if(card[type][num]>0) {
					flag=1;
					break;
				}
				card[type][num]++;
			}
			
			if(flag==1)
				System.out.println("#"+t+" ERROR");
			else
				System.out.println("#"+t+" "+s+" "+d+" "+h+" "+c);
			
		}
	}
}