package ployd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//플로이드 와샬 방법으로 풀면 더 간단할거 같은데 
//bfs dfs 공부중이라 bfs로 풀어봤음

//메모리 : 11976KB,  시간: 96ms
public class BOJ_1389_케빈베이컨의6단계법칙 {
	static int N,M;
	static boolean visit[];
	static int sum[];
	static int[][] graph;
	static class CO{
		int v;
		int distance;
		public CO(int v, int distance) {
			super();
			this.v = v;
			this.distance = distance;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		
		sum=new int[N+1]; //정점(1~N)까지 올수 있는 거리의 합 : 케빈 베이컨의 수
		
		//입력 받기
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from =Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			graph[from][to]=graph[to][from]=1;
		}

		//1~N까지 각각 bfs 
		for(int i=1;i<=N;i++) {
			visit=new boolean[N+1];
			bfs(new CO(i,0));
		}
		
		
		//가장 작은 케빈 베이컨의 수 찾기
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) 
			min=Math.min(min, sum[i]);
		
		//케빈 베이컨의 수가 가장 작은 사람 중 번호가 가장 작은 사람 출력
		for (int i = 1; i <= N; i++) {
			if(sum[i]==min) {
				System.out.println(i);
				return;
			}
		}
		
	}
	
	//bfs
	static void bfs(CO start) {
		Queue<CO> queue = new LinkedList<>();
		queue.offer(start);
		visit[start.v]=true;
		
		while(!queue.isEmpty()) {
			CO cur=queue.poll();
			
			for(int i=1;i<=N;i++) {
				if(graph[cur.v][i]==1&&!visit[i]) {
					queue.offer(new CO(i,cur.distance+1));
					visit[i]=true;
					sum[i]+=cur.distance+1;
				}
			}
		}
		
	}
}
