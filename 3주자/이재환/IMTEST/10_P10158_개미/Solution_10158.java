package P10158_개미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10158 {
	//우,하,좌,상
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// 격자 공간
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		//시작점
		st = new StringTokenizer(br.readLine()," ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int T=Integer.parseInt(br.readLine());
		
		
		
		//단순하게 펼쳐서 생각해봤음 -> 이렇게 하니까 시간초과 안뜸
		if (((X + T) / W) % 2 == 0)
			X = (X + T) % (2 * W);
		else
			X = W - ((X + T) % W);

		if (((Y + T) / H) % 2 == 0)
			Y = (Y + T) % (2 * H);
		else
			Y = H - ((Y + T) % H);
		
		/* 백준 시간초과뜨는 코드
		int dx=1;
		int dy=1;
		
		for(int t=1;t<=T;t++){
			int nx = X + dx;
			int ny = Y + dy;

			//벽에 부딪히면 방향전환
			if (nx ==0||nx ==W)
				if(dx>0) dx=-1;
				else dx=1;
			if (ny ==0||ny ==H) 
				if(dy>0) dy=-1;
				else dy=1;
				
			X=nx;
			Y=ny;
		}
		*/
		//출력
		System.out.print(X+" "+Y);
			
	}
}