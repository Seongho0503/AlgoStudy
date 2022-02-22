package P2578_빙고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2578 {
	static int [][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue=new LinkedList<Integer>();
		StringTokenizer st;
		map = new int[5][5];

		for(int i=0; i<5;i++) {
			st = new StringTokenizer(br.readLine()," ");
		    for(int j=0; j<5; j++)
		    	map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<5;j++)
				queue.offer(Integer.parseInt(st.nextToken()));
		}
		int count=0;
		for (int c = 0; c < 25; c++) {
			int n = queue.peek();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (n== map[i][j]) 
						map[i][j] = 0;			
				}	
			}
			queue.poll();
			count++;
			if(check()==true) break;
		}
		System.out.println(count);
				
	}

		
	static boolean check() {
		int cnt=0;
		int sum;
		//가로 검사
		for(int i=0; i<5;i++){
		    sum = 0;	 
		    for(int j=0; j<5; j++) sum += map[i][j]; 
		    if (sum == 0) cnt++;
		}
		//세로 검사
		for(int j=0; j<5;j++){
		    sum = 0;	 
		    for(int i=0; i<5; i++) sum += map[i][j];
		    if (sum == 0) cnt++;
		}
		//대각(좌우)
		sum = 0;
		for(int i=0; i<5;i++)
		    sum+= map[i][i];
	    if (sum == 0) cnt++;
	    //대각(우좌)
		sum = 0;	 
		for(int i=0; i<5;i++)
		    sum += map[i][4-i]; 
	    if (sum == 0) cnt++;
		
	    if(cnt>=3)
			return true;
		else
			return false;
	}
}
