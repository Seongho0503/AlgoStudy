package D4.sw4050;


//하나씩 임폴트 하는게 보기가 안 좋아 상위 패키지를 사용

import java.io.*; 
/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;*/
import java.util.*;
/*import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;*/

/*
 번호 : SW4050 
 제목 : 재관이의 대량할인
 난이도 : D4 (인데 D3 같음)
 접근법 : 
 1) 큰 값끼리 묶을 수록 더 높은 할인률이 적용 됨
 2) 3개씩 묶는 기준을 고민
 리스트에 값들을 담은후 정렬만 해주면 쉽게 풀 수 있는 문제
 값을 내림차순 정렬시킨 후 3개씩 자르기 (3개 미만이면 그냥 더하기)
  10 9 6 /4 4 3/2
  6    3   
 
 느낀점 : D2~D4난이도 알고리즘에서 요구하는 개념은
 1) tc에 맞게 입력을 잘 받고 그 값들을 활용하는 능력
 2) 정렬, 배열(맵) 같은 문제들이 반복적으로 나오고 있어 그 부분을 집중적으로 파기
 */
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		 //1) tc 한 줄 읽어들임
		int tc = Integer.parseInt(br.readLine());
		// 1번) throws  NumberFormatException, IOException 2)try catch 예외 처리
		
		//tc 횟수 만큼 반복
		for (int t = 1; t <= tc; ++t) {
			//배열대신 리스트를 사용한 이유 : 배열의 크기가 정해져 있지 않아서 N 값에 따라 배열의 길이가 달라짐(N을 신경 안써도 됨)
			List<Integer> list = new ArrayList<>();
			//2) 옷 개수를 입력 받음
			int N = Integer.parseInt(br.readLine());
			// 3)하나씩 입력 받음(공백단위로) 
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; ++i) { 
				list.add(Integer.parseInt(st.nextToken(" "))); 
				}
			//컬렉션 타입 내림차순 정렬 방법  Collections.sort(list, Collections.reverseOrder()); 아님 // Comparator
			Collections.sort(list, Collections.reverseOrder());
			int sum = 0;
			for (int i = 0; i < list.size(); ++i) { 
				//i+! % 3 == 0이면 3번째 요소(무료이므로) 이므로 총 합에 계산을 안한다. 
				if((i+1) % 3 == 0) continue; 
				sum += list.get(i); 
				}
			System.out.println("#" + t + " " +sum);
		}
		
	}
}
