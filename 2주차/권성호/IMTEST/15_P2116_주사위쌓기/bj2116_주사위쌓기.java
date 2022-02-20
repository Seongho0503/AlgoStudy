package bj2116_주사위쌓기;
		
		import java.io.*;
		import java.util.StringTokenizer;

		public class bj2116_주사위쌓기 {
		    static int[][] dices;
		    static int n;
		    // 인덱스 값 0~5 6개
		    static int[] map = {5, 3, 4, 1, 2, 0};

		    public static void main(String[] args) throws IOException {
		        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        n = Integer.parseInt(br.readLine());
		        //2차원 배열에 주사위 정보 저장
		        dices = new int[n][6];
		        for (int i = 0; i < n; i++) {
		            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		            for (int j = 0; j < 6; j++) {
		                dices[i][j] = Integer.parseInt(st.nextToken());
		            }
		        }
		        int ans = 0;
		        //주사 위 각 면을 바닥으로 하는 경우는 경우의 수는 총 6가지가 나온다. 
		        // A-F , B-D , C-E 총 6가지 (마주보는 것도 바닥에 따라 경우의 수가 달라져서 각자 세야 함)
		        for (int i = 0; i < 6; i++) {
		        	// 위의 6가지 경우에서 최대값을 갱신함 
		            ans = Math.max(ans, findCase(dices[0][i], 0));
		        }
		        //int 타입을 string 타입으로 출력하기 위해
		        System.out.println(String.valueOf(ans));
		    
		    }

		    private static int findCase(int botValue, int cur) {
		        if (cur == n) {
		            return 0;
		        }
		        int index = -1;
		        for (int i = 0; i < 6; i++) {
		            if (botValue == dices[cur][i]) {
		                index = i;
		                break;
		            }
		        }

		        int curMax = 0;
		        for (int i = 0; i < 6; i++) {
		        	// 아랫부분과 윗면을 제외한 최대값을 구한다
		            if (dices[cur][i] != botValue && i != map[index]) {
		                curMax = Math.max(curMax, dices[cur][i]);
		            }
		        } // 재귀함수를 통해 최대 면의 값을 넘겨준다.
		        // 윗면과 밑면을 제외한 4면의 최대값을 누적하면 되지만 누적합 계산을 안 하는 이유는
		        // 재귀로 회전시켜 보면서 4면 중 최대 값만 구하면 되기 때문에
		        return (curMax + findCase(dices[cur][map[index]], cur + 1));
		    }

}
