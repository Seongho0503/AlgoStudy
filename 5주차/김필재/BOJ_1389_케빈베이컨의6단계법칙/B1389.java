import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

//라이브 수업 자료 bfs를 참고하여 만들었음.
public class B1389 {

	static int min_sum=Integer.MAX_VALUE;
	static int min_N=0;
	static int N;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 수
		int C = sc.nextInt(); // 간선 수
		
		int[][] adjMatrix = new int[N+1][N+1]; // 정점수 크기로 생성
		
		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// 무향이므로 간선 하나로 양방향 처리 
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		//모든 정점을 시작지점으로 bfs실행
		for(int i=1;i<N+1;i++) {
			bfs(adjMatrix,i);
		}
		//합이 가장 작은 정점 출력
		System.out.println(min_N);
	}
public static void bfs(int[][] adjMatrix,int start) {
		//큐에 정점, 단계 저장
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		boolean[] visited = new boolean[N+1];
		
		//시작 정점, 0단계
		Integer[] st={start,0};
		queue.offer(st);
		
		visited[start] = true;
		int sum=0;
		while(!queue.isEmpty()) {
			Integer[] temp= queue.poll();
			int current = temp[0];
			//방문 정점별 단계의 합을 sum에 저장
			sum+=temp[1];
			
			for (int j = 1; j < N+1; j++) {
				if(!visited[j] && adjMatrix[current][j]!=0) {
					//방문 정점에는 현재 정점에 비해 단계 1증가
					Integer[] tmp={j,temp[1]+1};
					queue.offer(tmp);
					visited[j] = true;
				}
				
			}
		}
		//합이 가장 작으면
		if(sum<min_sum) {
			min_sum=sum;
			min_N=start;
		}
	}
}

