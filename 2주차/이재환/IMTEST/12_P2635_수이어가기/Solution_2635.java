package P2635_수이어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
100
*/
public class Solution_2635 {
	static int cnt;
	static Queue <Integer> queue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int First= Integer.parseInt(br.readLine());
		
		queue = new LinkedList<>();
		
		cnt=2;
		int idx=0;
		int max=0;
		for(int i=First/2;i<=First;i++) {
			if(cal(2,First,i)>max) {
				max=cal(2,First,i);
				idx=i;
			}
		}
		queue.clear();
		queue.offer(First);
		queue.offer(idx);
		cal(2,First,idx);
		
		//출력
		System.out.println(max);		
		while(!queue.isEmpty())
			System.out.print(queue.poll()+" ");

	}
	
	public static int cal(int cnt,int first, int second){
		int third = first-second;
		if(third<0)
			return cnt;
		queue.offer(third);
		return cal(++cnt,second,third);
	}
}
