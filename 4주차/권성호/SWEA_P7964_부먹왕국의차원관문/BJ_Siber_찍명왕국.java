package BJ.Siber.찍명왕국;

//swexpert 7964 부먹왕국

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.StandardSocketOptions;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_Siber_찍명왕국 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int num = sc.nextInt();
			int lim = sc.nextInt();
			// 0뻔째와 마지막 관문 포함해서  +2 크게 잡음
			boolean[] arr = new boolean[num + 2];
			for (int i = 1; i <= num; i++) {
				if (sc.nextInt() == 1) {
					arr[i] = true;
				}
			}
			//0번째랑 , 마지막 n+1에는 차원관문이 있음
			arr[0]=true;
			arr[num+1]=true;
			int sum = 0;
			int now = 0;
			int move;
			// 0뻔째와 마지막 관문 포함해서  +2 크게 잡음
			while(now<num+2) {
				boolean tmp = false;
				for(int i=lim;i>0;i--) {
					move=now+i;
					if(move<num+2 && arr[move]) {
						now=move;
						tmp =true;
						break;
					}
				}
				if(tmp==false) {
					now=now+lim;
					sum++;
				}
			}
			if(now>num)sum--;
			System.out.println("#"+tc+" "+(sum));

		}
	}

}