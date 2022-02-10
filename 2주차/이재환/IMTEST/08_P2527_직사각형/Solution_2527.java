package P2527_직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2527 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<4;i++) {
			st=new StringTokenizer(br.readLine());
			int x1= Integer.parseInt(st.nextToken());
			int y1= Integer.parseInt(st.nextToken());
			int p1= Integer.parseInt(st.nextToken());
			int q1= Integer.parseInt(st.nextToken());
			int x2= Integer.parseInt(st.nextToken());
			int y2= Integer.parseInt(st.nextToken());
			int p2= Integer.parseInt(st.nextToken());
			int q2= Integer.parseInt(st.nextToken());
		
			//만나는부분 없을때
			if(p1<x2||p2<x1||q1<y2||q2<y1)
				System.out.println("d");
			// 점, 선분
			else if(x1==p2)
				if((y1==q2)||(q1==y2))
					System.out.println("c");
				else 
					System.out.println("b");
			
			else if(p1==x2)
				if((y1==q2)||(q1==y2))
					System.out.println("c");
				else
					System.out.println("b");
			
			else if(q1==y2)
				if((y1==q2)||(x1==p2))
					System.out.println("c");
				else
					System.out.println("b");
			
			else if(y1==q2)
				if((p1==x2)||(q1==y2))
					System.out.println("c");
				else
					System.out.println("b");
			
			//나머지 겹치는 부분
			else System.out.println("a");

		}
	}
}
