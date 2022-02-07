package myspace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//232888
//832888
public class Solution {
	static int N;
	static int[] price;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int ans =0;
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String str=st.nextToken();
	
			N = Integer.parseInt(st.nextToken());			
			price=new int[6];
			
			for(int i=0;i<str.length();i++)  
				price[i]=str.charAt(i)-'0';
			
			find_swap(0,0);
			
			for(int i=0;i<str.length();i++) 
				ans+=price[i]*Math.pow(10,str.length()-1-i);
			
			System.out.println("#" + t + " "+ans);
		}

		br.close();
	}
	//수업시간에 배운거로 한번 해보는중..
	public static void find_swap(int cnt,int start) {
			
		// 기본 파트
		if(cnt== N) {
			return;
		}
			
		for (int i = start; i < price.length; i++) {
			for(int j=i+1; j<price.length;j++) {
				
				
				
			}
		}
	}

}
	
