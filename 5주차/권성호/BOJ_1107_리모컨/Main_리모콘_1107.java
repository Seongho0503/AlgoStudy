package SWEA.D3;

// 메모리 : 67200 kb
// 시간 : 200 ms
// 코드길이 2011 b

import java.io.*;
import java.util.*;

public class Main_리모콘_1107 {
 
    public static void main(String[] args) throws NumberFormatException, IOException  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// 채널 개수
        N = Integer.parseInt(br.readLine());
        // 고장난 버튼의 개수
        M = Integer.parseInt(br.readLine());
       control = new boolean[10];
        if(M != 0) {
        	//고장난 버튼
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int button = Integer.parseInt(st.nextToken());
               control[button] = true;
            }
        }
        // +, - 로만 이동
        //처음 시작 위치는 문제에서 100번이기 때문에 절대값을 취해줌
        int ans = Math.abs(N-100);
        // 한번에 이동 가능한지? (최소값)
        int canmove = canMove(N);
        if(canmove != -1){
            ans = Math.min(ans, canmove);
        }

        int count = 1;
        boolean flag = true;
        // flag가 바뀌거나(체널이 0보다 작아지거나) 
        while (flag && count < ans) {
            int plus = N + count;
            int minus = N - count;
            //+버튼을 누르면 현재채널에서 +1 이동
            int plus_move = canMove(plus);
            // - 를 누ㅡ르면 -1 채널로 이동
            int minus_move = canMove(minus);
            if(minus_move != -1){
                ans = Math.min(ans, minus_move + count);
                flag = false;
            }
            if(plus_move != -1){
                ans = Math.min(ans, plus_move + count);
                flag = false;
            }
            count++;
        }
        System.out.println(ans);
    }
    static int N, M;
    static boolean[]control;
    static int canMove(int a){
        if(a < 0)
            return -1;
        String num = String.valueOf(a);
        for(int i = 0; i < num.length(); i++){
            if(control[num.charAt(i) - '0'])
                return -1;
        }
        // 리모콘을 클릭하는 횟수를 반환
        return num.length();
    }
}