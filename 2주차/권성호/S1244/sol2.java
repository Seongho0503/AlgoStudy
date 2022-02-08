package Sw_1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol2 {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        //테케 순회
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
 
            st = new StringTokenizer(br.readLine(), " ");
            // 숫자들을 string으로 입력
            String s = st.nextToken();
            // 바꾸는 횟수
            int N = Integer.parseInt(st.nextToken());
             // 입력 받은 s를 int로 바꿔서 배열에 담음
            int[] nums = new int[s.length()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = s.charAt(i) - '0';
            }
            int index = 0;
            result = 0;
            // 순자들을 n번 바꿔준다
            isexchange(nums, N, index);
             
            System.out.println("#"+tc+" "+result);
        } 
    }
 
    public static void isexchange(int[] nums, int n, int index) {
        // 바꿀 수 있는 횟수가 없으면 그냥 담은 배열 출력
    	if (n == 0) {
            StringBuilder sb = new StringBuilder();
            for(int num : nums) {
                sb.append(num);
            }
             
            //Math.max()함수는 입력값으로 받은 0개 이상의 숫자 중 가장 큰 숫자를 반환
            // 큰 수 일 수록 숫자 단위가 크니깐 
            // 바꾸고 그것이 더 큰수면 종료시킴
            result = Math.max(Integer.parseInt(sb.toString()), result);
            return;
        }
 
        if(index == nums.length - 1) 
        	index = 0;
        //완전깊이탐색
        for (int i = index; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                swap(nums, i, j);
                isexchange(nums, n - 1, i + 1);
                swap(nums, i, j);
            }
        }
    }
     
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

