package IMTEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2564 {
	// 직사각형의 가로와 세로
	static int ROW,COL;
	// 모든 위치들의 합
	static int SUM;
	// sum2 변수는 사용을 안 하려고 했는데 상점의 위치를 다 배열안에 입력받고
	// 마지막 자신의 위치를 따로 저장할 방법이 생각나지 않았음
	// 그래서 생각한 것이 sum= 3가게의 위치 + 자신의 위치
	// sum2 = 3가게의 위치 + 자신의 위치 + 자신의 위치
	// sum2는 자신의 위치가 2번 더해졌으니 sum2-sum1하면 자신의 위치가 나옴
	static int SUM2;
	// 나는 이 문제를 1차원 배열로 풀었음
	// <그림참고> 직사각형을 직선으로 펴서 계산했음
	// 이렇게 1차원으로 선으로 생각한 이유는 3가게의 위치나, 자신의 위치가 직사각형 안에 있는 것이 아니라 모두 직사각형의 변에 있음
	
	static int[] arr;
	
	// 이것은 3가가의 상점과 자신의 위치를 벡터로 바꿔서 위치 정보를 배열에 저장
	static void wherestore(int dir, int idx) {
		switch(dir) {
		case 1://  북쪽
			arr[0+(10-idx)] += (10-idx);
			break;
		case 2: // 남쪽
			arr[ROW+COL+idx] += ROW+COL+idx;	
			break;
		case 3: // 서쪽
			arr[ROW+idx] += ROW+idx;
			break;
		case 4: //동쪽
			arr[ROW+COL+ROW+idx] += ROW+COL+ROW+idx;
			break;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		arr = new int[(ROW+COL)*2];
		
		int store = Integer.parseInt(br.readLine());
		
		for(int i =0; i<store+1;i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()); // 방향 (북, 서, 남, 동)
			int idx = Integer.parseInt(st.nextToken()); // 위치 정보
			wherestore(dir, idx);			
			if(i==store) {
				for(int storesum : arr) {
					SUM += storesum;
				}
				// 자신의 위치를 찾기 위해 마지막에 한 번 더 함수를 호출함
				wherestore(dir, idx);
				for(int storesum : arr) {
					SUM2 += storesum;
				}
			}
		}
		System.out.println(SUM-2*(SUM2-SUM));
		
	}

}
