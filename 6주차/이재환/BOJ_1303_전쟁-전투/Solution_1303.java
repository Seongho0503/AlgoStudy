import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Silver 1 
//메모리:13736KB 시간:100ms
public class BOJ_1303_전쟁_전투 {
	static int N,M;

	static char map[][];
	static boolean visit[][];
	
	//4방 탐색
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	static class CO{
		int x,y,cnt;
		public CO(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		//배열, 변수 선언
		map= new char[M][N];
		visit = new boolean[M][N];
		int w_sum=0;
		int b_sum=0;
		
		// map 정보 입력
		for(int i=0;i<M;i++) {
			String str= br.readLine();
			for(int j=0;j<N;j++)
				map[i][j]=str.charAt(j);
		}
			
		//BFS
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					if(map[i][j]=='W') 
						w_sum+=bfs(new CO(j,i,1));
					else if(map[i][j]=='B') 
						b_sum+=bfs(new CO(j,i,1));
				}
			}
		}
		
		System.out.println(w_sum+" "+b_sum);
	}
	
	//BFS (4방 탐색을 통해 같은 색을 가진 모든 인접부분 찾기)
	static int bfs(CO start) {
		Queue<CO> queue= new LinkedList<>();
		queue.offer(start);
		visit[start.y][start.x]=true;
		int count=1;
		
		while(!queue.isEmpty()) {
			CO cur = queue.poll();
	
			for(int d=0;d<4;d++) {
				int nx=cur.x+dx[d];
				int ny=cur.y+dy[d];	
				if(nx<0 || nx>=N || ny<0 || ny>=M ||visit[ny][nx]) continue;
				
				if(map[cur.y][cur.x]==map[ny][nx]) {
					queue.offer(new CO(nx,ny,++count));
					visit[ny][nx]=true;
				}
			}
		
		}
		return count*count;
	}
	
	
	
}

