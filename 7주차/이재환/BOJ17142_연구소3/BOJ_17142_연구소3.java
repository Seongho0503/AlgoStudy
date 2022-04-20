package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Gold 4
//메모리:39364KB 시간:196ms
public class BOJ_17142_연구소3 {
	static int N,M;
	static int map[][];
	static LinkedList<CO> virus;
	static CO active[];
	static int ans;
	
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	
	static class CO{
		int y,x,time;
		public CO(int y, int x, int time) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map= new int[N][N];
		virus = new LinkedList<>();
		active = new CO[M];
		int blank=0;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) virus.add(new CO(i,j,1));
				if(map[i][j]==0) blank++;
			}
		}
		
		if(blank ==0) {
			System.out.println(0);
			return;
		}
		
		ans=Integer.MAX_VALUE;
		Combination(0,0,blank);
		
		//
		if(ans==Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(ans);
		
	}
	
	//M개의 활성화 바이러스 선택
	static void Combination(int start, int select,int blank) {
		if(select==M) {
			BFS(blank);
			return;
		}
		
		for(int i=start; i<virus.size();i++) {
				active[select]=virus.get(i);
				Combination(i+1, select+1,blank);
		}
	}
	
	//BFS
	static void BFS(int blank) {
		Queue<CO> queue = new LinkedList<>();
		boolean visit[][]= new boolean[N][N];
	
		for(int i=0;i<M;i++) {
			queue.offer(active[i]);
			visit[active[i].y][active[i].x]=true;
		}
		
		while(!queue.isEmpty()) {
			CO cur = queue.poll();
		
			for(int d=0;d<4;d++) {
				int nx=cur.x+dx[d];
				int ny=cur.y+dy[d];
		
				if(nx<0||ny<0||nx>=N||ny>=N||visit[ny][nx]||map[ny][nx]==1) continue;
				
				if(map[ny][nx]==0) blank --;
	
				if(blank ==0)
					ans = Math.min(ans, cur.time);
				
				queue.offer(new CO(ny,nx,cur.time+1));
				visit[ny][nx]=true;
			}
				
		}
		
	}

}
