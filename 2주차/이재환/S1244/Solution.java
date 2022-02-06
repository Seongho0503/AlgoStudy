package myspace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int ans =0;
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String str=st.nextToken();
	
			int n = Integer.parseInt(st.nextToken());			
			int [] num=new int[6];
			
			for(int i=0;i<str.length();i++)  
				num[i]=str.charAt(i)-'0';
			
			int max=num[0];
			int temp;
			int Mid=0;
			int id=0;
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<str.length();j++) {
		
					if(num[j]>=max){
						max=num[j];
						Mid=j;
						if(num[j]==max)
							id=j;
					}
				}
				if(num[Mid]>=num[i]) {
					if(Mid>id&&num[Mid]<num[id]) {
					temp=num[i];
					num[i]=num[Mid];
					num[Mid]=temp;
					}
					else
					{
						temp=num[i];
						num[i]=num[Mid];
						num[Mid]=temp;
						
					}
				}
		
			}
			
			for(int i=0;i<str.length();i++) 
				ans+=num[i]*Math.pow(10,str.length()-1-i);
			
			System.out.println("#" + t + " "+ans);
		}

		br.close();
	}
}
	
