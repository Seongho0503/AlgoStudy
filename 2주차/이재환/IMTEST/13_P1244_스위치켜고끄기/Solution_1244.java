package P1244_스위치켜고끄기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1244 {
	//남자 처리
	static int[] man(int num, int[] sw) {
		int cnt = (sw.length) / num; // 배수
		for (int i = 1; i <= cnt; i++) {
			if (sw[num * i - 1] == 0)
				sw[num * i - 1] = 1;
			else if (sw[num * i - 1] == 1)
				sw[num * i - 1] = 0;
		}
		return sw;
	}
	//여자처리
	static int[] woman(int num, int[] sw) {
		num = num - 1;
		for (int i = 0; i <= num; i++) {
			if (num - i >= 0 && num+i<sw.length) {
				if((sw[num - i] == sw[num + i])) {
					if (sw[num - i] == 1)
						sw[num - i] = sw[num + i] = 0;
					else if (sw[num - i] == 0)
						sw[num - i] = sw[num + i] = 1;
				}
				else if(sw[num - i] != sw[num + i]) 
					return sw;	
			}
		}
		return sw;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//스위치 갯수 입력
		int n=Integer.parseInt(br.readLine());
		int[] sw = new int[n];	
	
		//스위치 정보 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			sw[i]=Integer.parseInt(st.nextToken());
		
		//학생 수 입력
		int sn=Integer.parseInt(br.readLine());
		int [][] student = new int[sn][2];
	
		//학생 정보 입력
		for(int i=0;i<sn;i++) {
			st=new StringTokenizer(br.readLine());
			student[i][0]=Integer.parseInt(st.nextToken());	//남 :1 여:2
			student[i][1]=Integer.parseInt(st.nextToken()); //받은 수
		}
		
		//남자면 남자처리 함수 호출 -여자면 여자처리 함수 호출
		for(int i=0;i<sn;i++) {
			if(student[i][0]==1)
				sw=man(student[i][1],sw);
			else if(student[i][0]==2)
				sw=woman(student[i][1],sw);	
		}
		
		for (int i = 0; i < n-1; i++) {
	        System.out.print(sw[i]+" ");
	        if (i % 20== 19) 
	            System.out.println();         
	    }
	        
		System.out.println(sw[n-1]);
	}
	
}	