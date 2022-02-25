package P2559_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2559 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		int[] temp = new int[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine(), " ");

		for(int i=0;i<N;i++)
			temp[i]=Integer.parseInt(st.nextToken());
		int max=Integer.MIN_VALUE;
	
		
		int sum=0;
		for(int i=0;i<K;i++) {
			sum+=temp[i];
			queue.offer(temp[i]);
		}

		max=Math.max(sum, max);
		
		for(int i=K;i<N;i++) {
			sum-=queue.poll();
			queue.offer(temp[i]);
			sum+=temp[i];
			
			max=Math.max(sum, max);
		}
							
		System.out.println(max);

	}
}
