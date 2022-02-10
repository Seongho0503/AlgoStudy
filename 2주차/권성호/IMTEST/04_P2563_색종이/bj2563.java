package IMTEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 : 백준색종이 문제 2563
 * 이름 : 싸피7기 구미 5반 권성호
 * 접근법
  : 이 문제의 함정은 넓이를 구하는 것이다
   	흔히 사각형의 넓이는 가로x세로인데 초등학교 주입식 교육으로 사각형의 넓이하면 가로 ,세로의 단어가 먼저 떠오른다. 실제 그런 계산문제가 수학시간에 많았으니
   	그런데 이 문제의 핵심은 사각형으로 덮여진 검정색 부분을 찾는 것이다.
   	<핵심>
   	1) 사각형 넓이의 정의는 무엇일까?
   	 _____   
   	|    |  2x2 정사각형이 있을때 가로 x 세로 = 4이지만 , 다르게 생각하면 1x1 정사각형이 4개 있는 것이다. 1x1 정사각형의 넓이는 1이다. 
   	|____|  넓이가 1인 정사각형이 4개 있으니 이 사각형의 넓이는 4이다. (즉, 큰 사각형을 바라보지 않고 작은 사각형으로 문제를 볼 수 있어야 한다)
   	 
   	 이 문제도 사실 핵심은 저 사각형을 1x1 넓이가 1인 사각형으로 바라보아야 한다. 그래야 쉽다
   	 이 문제를 다르게 표현하면 1x1 넓이가 1인 사각형의 갯수는 ??  
   	 
   	 2) 서로 겹쳐진 부분은 100x100 도화지라고 문제에서 주어졌으니 사각형의 꼭지점 자표가 주어지면 거기서 가로 10, 세로 10만큼 이중 for으로 해당하는 사각형 영역을 1로 채운다.
   	    (배열의 int 초기값은 0이니 1인 부분은 사각형 부분 영역이다)
   	       서로 중복인 부분이 생기지 않게 이미 배열의 요소 1인 부분은 색종이가 덮여진 부분이니깐 이 부분은 if문으로 pass시킨다. 
   	 3) 색종이가 3개이므로 테스트케이스를 3번 반복한다.
   	 4) 결과는 정답!!! 매우 나이스!   
   	 
   	 느낀점 : 알고리즘 경험이 거의 없지만 생각보다 더 재미있고 많이 문제를 풀고 정리해야겠다.
   	 \
   	 
 */
public class bj2563 {
	//테스트 케이스 개수 = 색종이 개수
	static int T;
	// cnt는 검정색 작은 사각형 갯수의 합
	static int cnt=0;
	//문제에서 주어진 색종이의 가로x세로
	static int[][] map = new int[100][100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   T = Integer.parseInt(br.readLine());
	   
	   for(int tc = 1; tc<=T; tc++) {
		   StringTokenizer st = new StringTokenizer(br.readLine());
		   int row = Integer.parseInt(st.nextToken());
		   int col = Integer.parseInt(st.nextToken());
		   
		   //정사각의 가로, 세로는 동일한 길이니깐 입력박은 사각형 좌표부분에서 가로 +10 ,세로+10까지 for문 돌림 (색종이 영역)
		   // 만약 이 문제가 직사각형 문제 였다면 저 +10 부분만 직사각형에 따라 바꿔주면 될 듯 싶다
		   for(int i=row; i<row+10;i++) {
			   for(int j=col; j<col+10; j++) {
				   //이미 색종이가 덮어진 곳인지 중복체크
				   if(map[i][j] != 1) { 
					   //색종이가 덮힌 곳은 1로 초기화
					   map[i][j] = 1;		
					   //cnt는 검정색 작은 사각형 갯수의 합
					   cnt += 1;
				   }
			   }
		   }
		   
		   //System.out.println("#"+tc+" "+cnt); 디버깅용으로 색종이마다 각 색칠된 작은 사각형 개수 확인 해봄
	   }
	   System.out.println(cnt);
	}

}
