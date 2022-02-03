package Sungho_S1860;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	    public static void main(String[] args) {
	        Scanner sc=new Scanner(System.in);
	        int t=sc.nextInt();
	        for(int a=1;a<=t;a++) {
	            String answer ="Possible";
	            //손님의 수 N, M초 마다 K의 개의 붕어빵을 만들 때 N,M,K가 주어지고 N명이 오는 시간을 입력받음
	            int n=sc.nextInt();
	            int m=sc.nextInt();
	            int k=sc.nextInt();
	            int[]time=new int[n];
	            for(int b=0;b<n;b++) {
	                time[b]=sc.nextInt();
	            } 
	            // 손님의 도착 시간을 빠른 순서대로 정렬
	            Arrays.sort(time); 
	            int index=0;
	            int count=0;
	            for(int b=0;b<=time[n-1];b++) {
	                if(b%m==0&&b!=0) { //손님이 도착한 시간에 만들 수 있는 최대 붕어빵 개수 구한다, 0초엔 붕어빵이 없다
	                    count+=k;
	                }
	                if(b==time[index]) {
	                    if(count==0) {
	                        answer="Impossible";
	                        break;
	                    }
	                    else {
	                        index++;
	                        count--;
	                    }
	                }
	            }
	            System.out.println("#"+a+" "+answer);
	        }
	        sc.close();
	    }
	}
	

