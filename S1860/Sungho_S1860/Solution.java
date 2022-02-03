package Sungho_S1860;
/*
 * 문제 : 삼성sw D3 1860 진기의 붕어빵
 * 풀이 : 권성호
 * 날짜 : 2022.02.02
 * 핵심 : 손님이 왔을 때 빵 줄 수 있니??  빵을 미리 계산하여 손님 왔을 때 빵 개수가 0이 아니면 빵을 줄 수 있다
 * 주의 : 0초일 떄는 빵이 0개이고, 손님은 빵 1개씩 가져간다. 
 */
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	    public static void main(String[] args) {
	        Scanner sc=new Scanner(System.in);
	        int t=sc.nextInt();
	        for(int a=1;a<=t;a++) { // 테케 돌릴 횟수
	            String answer ="Possible"; // 기본 셋팅을 가능이라 설정하고 빵 줄 수 없을 때 불가능이라 바꾸면 됨 , flag 변수  
	            //손님의 수 N, M초 마다 K의 개의 붕어빵을 만들 때 N,M,K가 주어지고 N명이 오는 시간을 입력받음
	            int n=sc.nextInt();
	            int m=sc.nextInt();
	            int k=sc.nextInt();
	            int[]time=new int[n];
	            for(int b=0;b<n;b++) {
	                time[b]=sc.nextInt();
	            } 
	            // 손님의 도착 시간을 빠른 순서대로 정렬 why? 손님이 오늘 시간대가 정렬이 안되어 있음
	            Arrays.sort(time); 
	            int index=0;// 첫번째 손님
	            int count=0;// 빵의 개수
	            for(int b=0;b<=time[n-1];b++) { //b초
	                if(b%m==0&&b!=0) { //빵이 완성될 때마다 빵 추가됨 , 0초엔 붕어빵이 없다
	                    count+=k;
	                }
	                if(b==time[index]) { // 손님이 왔을 때  빵있니??
	                    if(count==0) {
	                        answer="Impossible"; //빵 불가능해
	                        break; // 반복문 for 탈출
	                    }
	                    else {// 빵 줄 수 있을 때 기본 초기값이 possible이니 그냥 출력하면 됨
	                        index++; //다음 손님 받을 준비
	                        count--; //손님이 빵 한개 가니깐 빵 한개 빼기 , 만약 이 문제가 손님 마다 빵 가져가는 개수가 다르다면 이 부분만 바꾸면 됨
	                    }
	                }
	            }
	            System.out.println("#"+a+" "+answer);
	        }
	        sc.close();
	    }
	}
	

