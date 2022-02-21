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
		
		//첫번째 수 입력
		int First= Integer.parseInt(br.readLine());
		
		queue = new LinkedList<>();
		
		cnt=2; //최대 갯수(초기값)
		int idx=0;
		int max=0;
		
		//(가능한 최대 갯수, 두번째 수 구하기)
		for(int i=First/2;i<=First;i++) {
			if(cal(2,First,i)>max) {
				max=cal(2,First,i);
				idx=i;
			}
		}
		//큐 초기화
		queue.clear();
		
		//첫 번째 수 입력
		queue.offer(First);
		
		//두번째 수 입력
		queue.offer(idx);
		
		//세번째~MAX번째 수 계산
		cal(2,First,idx);
		
		//출력
		System.out.println(max);		
		while(!queue.isEmpty())
			System.out.print(queue.poll()+" ");

	}
	
	//세번째 값 만들기 (가능하면 재귀, 불가능하면 최대 갯수 return)
	public static int cal(int cnt,int first, int second){
		int third = first-second;
		if(third<0)
			return cnt;
		queue.offer(third);
		return cal(++cnt,second,third);
	}
}
