package IMTEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10163 {
	// for문 안에서 사용하기 위해 static 처리
	static int P, Q, W, H;
	// 도화지 
	static int[][] colp = new int[1001][1001];
	// 각 색종이의 넓이 세는 배열
	static int[] cnt;
			
	// 1번  1채워짐 cnt[0]
	// 2번  2채워짐 cnt[1]
	// 3번  3채워짐 cnt[2]

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		cnt = new int[N];
		for(int tc =1; tc<=N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			P = Integer.parseInt(st.nextToken()); //x값
		    Q = Integer.parseInt(st.nextToken()); //y값
		    W = Integer.parseInt(st.nextToken()); //가로
		    H = Integer.parseInt(st.nextToken()); //높이(세로)
		    //System.out.println("p" + P + "w"+ W);
		    // 증감식 조건 (매우 중요했다) <- 이것 때문에 고생했다. 
		    // P와 Q를 고정 값으로 사용하는 방법은 지역변수에 저장했다
		    for(int row =P;row<P+W;row++) {
		    	for(int col = Q; col<Q+H; col++) {	
		    		// 배열의 요소가 자신의 값(tc)과 다른 경우 +1 씩 넓이 더하기
		    		if(colp[row][col] != tc ) cnt[tc-1] +=1;
		    		// 자신의 값보다 작은 요소(=이전 색종이) && / tc가 1일 때는 뺄게 없어서 안되고 && 이미 배열 값이 0이 경우에는 안 뺀다)
		    		if(colp[row][col] < tc && tc != 1 && colp[row][col] != 0) cnt[colp[row][col]-1] -=1;
		    		// 자신의 요소 채우기 (비교용)
		    		colp[row][col] = tc;
		    		//cnt++;//if(colp[P][Q])
		    	}
		    }
		 
		    //System.out.println(cnt);
		}
		for(int i = 0; i<N; i++) {
	    	System.out.println(cnt[i]);
	    }
	}

}


/*for(;P<P+W;P++) {\
	for(;Q<Q+H;Q++) {	*/