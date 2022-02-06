package Sungho_S2805;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++) {
            int n = sc.nextInt();
            int sum=0;
            // 다이아 몬드 윗부분
            for(int i=n/2; i>=0; i--) { // 위에 행
                String s = sc.next(); // 한줄 스캔
                for(int j=i; j<n-i; j++) { // 열을 계산할 때 대칭이용 
                    sum += s.charAt(j)-'0'; // 해당 범위 값 다 더하기
                }
            }               
            // 다이아몬드 아랫부분
            for(int i=1; i<=n/2; i++) { // 아래 행 위에서 이미 가운데 체크했으니 1부터 시작
                String s = sc.next(); // 한줄 스캔
                for(int j=i; j<n-i; j++) {// 열을 계산할 때 대칭이용 
                    sum += s.charAt(j)-'0'; //해당 범위 값 다 더하기
                }
            }
            System.out.println("#" + t + " " + sum);
        }
    }
 
}
