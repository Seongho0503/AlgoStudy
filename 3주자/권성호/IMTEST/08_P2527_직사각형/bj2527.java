package IMTEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2527 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i =0 ; i<4; i++) {
		// 첫번째 직사각형 (x,y,p,q) = (row1,col1,row2,col2)
		int row1 = Integer.parseInt(st.nextToken());
		int col1 = Integer.parseInt(st.nextToken());
		int row2 = Integer.parseInt(st.nextToken());
		int col2 = Integer.parseInt(st.nextToken());
		
		// 두 번쨰 직사각형 위와 동일 매칭
		int row3 = Integer.parseInt(st.nextToken());
		int col3 = Integer.parseInt(st.nextToken());
		int row4 = Integer.parseInt(st.nextToken());
		int col4 = Integer.parseInt(st.nextToken());
		
		//디폴트 값을 설정한 이유는 if문 한 개를 더 안 만들기 위해서
		char result = 'a';

		// 점(c)은 사각형 r1의 모든 꼭지점을 하나씩 매칭해서 확인 
		if((row1 == row4 && col1 == col4) || (row2 == row3 && col1 == col4) || (row1 == row4 && col2 == col3) || (row2 == row3 && col2 == col3)) 
			result = 'c';
		// 선분(b)은 꼭지점 x,y중 하나는 맞고 하나는 다를 경우.
		else if((row2 == row3 && col2 != col3) || (row1 == row4 && col2 != col3) || (row2 != row3 && col1 == col4) && (row1 != row4 && col1 == col4)) 
			result = 'b';
		// 안 겹칠 때(d)는 (첫번째 사각형을 기준으로) 두번째 사각형이 기준의 범위가 겹치지 않을 때.
		else if(row2 < row3 || row4 < row1 || col2 < col3 || col4 < col1) 
			result = 'd';
		System.out.println(result);
		}
		
	}
}	

/*3 10 50 60 100 100 200 300
45 50 600 600 400 450 500 543
11 120 120 230 50 40 60 440
35 56 67 90 67 80 500 600*/