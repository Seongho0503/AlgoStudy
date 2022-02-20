package bj2628_종이자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2628_종이자르기4 {
	static int mRow;
	static int mCol;

	static int[] colmap;
	static int[] rowmap;
	
	// 가장 큰 사이즈를 찾는 함수
	// 원리 : size 변수는 자르는 위치로  배열에 자르는 위치를 1로 저장해 놓는다
	// maxSize 함수는 그 1위치를 찾아서 가장 큰 길이를 반환한다.
	static int maxSize(int[] map) {
		int cnt = 0;
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			// 자르는 위치 1를 찾았을 때
			if (map[i] == 1 ) {
				max = Math.max(max, cnt);
				cnt = 1;
			// 탐색이 배열 끝까지 왔을 때
			}else if (i == (map.length-1)) {
				max = Math.max(max, cnt+1);
				cnt = 1;
			// 못 찾았으면  크기 1증가
			}else cnt++;
	
		}
		//가장 큰 길이 반환
		return max;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//세로
		int col  = Integer.parseInt(st.nextToken());
		//가로
		int row  = Integer.parseInt(st.nextToken());
		// 배열에 자르는 위치를 1로 저장할 것
		colmap = new int [col];
		rowmap = new int [row];
		int num = Integer.parseInt(br.readLine());
		
		while(num>0) {
			//가로 일 때 0은 가로
			st = new StringTokenizer(br.readLine(), " ");
			int dic = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			// 가로는 0
			if(dic == 0) {
			      rowmap[size]=1;
			//세로 일 때 1은 세로	
			}else {
				colmap[size]=1;
			}
			num--;
		}
		
		int mRow = maxSize(rowmap);
		int mCol = maxSize(colmap);		
		//System.out.println(mRow); 디버깅
		//System.out.println(mCol); 디버깅
		System.out.println(mCol * mRow);
	}

}
