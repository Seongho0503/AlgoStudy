import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//Gold 4 
//메모리:13384KB 시간:92ms
public class BOJ_14226_이모티콘 {
	static int S;
	static boolean visit[][];// 현재 이모티콘 수, 저장된 클립보드 수

	static class Emo{
		int num;
		int clip_num;
		int time;
		public Emo(int num, int clip_num, int time) {
			super();
			this.num = num;
			this.clip_num = clip_num;
			this.time = time;
		}
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S= Integer.parseInt(br.readLine());
		
		bfs(new Emo(1,0,0));
		
	}
	
	//BFS
	static void bfs(Emo start){
		visit = new boolean[1001][1001];
		Queue<Emo> queue = new LinkedList<>();
		queue.add(start);
		visit[start.num][start.clip_num]=true;
		
		while(!queue.isEmpty()) {
			Emo cur = queue.poll();
			
			if(cur.num == S) {
				System.out.println(cur.time);
				return;
			}
			
			//1.복사
			//저장된 클립보드 갯수와 저장할 클립보드 수(현재 이모티콘 수)가 다를때 복사
			//복사에 대한 방문 처리 (다음 이모티콘 수 = 현재 이모티콘 수)
			if(cur.num != cur.clip_num && !visit[cur.num][cur.num]) {
				queue.offer(new Emo(cur.num,cur.num,cur.time+1));
				visit[cur.num][cur.num]=true;
			}
			
			//2. 붙여넣기
			// 클립보드 수 존재(1개 이상) && 붙여넣기 했을 때 S개 이하 일때 붙여넣기 진행
			// 붙여넣기에 대한 방문 처리 (다음 이모티콘 수 = 현재 이모티콘 수 + 클립보드 수)
			if(cur.clip_num>0 && cur.num+cur.clip_num<=S && !visit[cur.num+cur.clip_num][cur.clip_num]) {
				queue.offer(new Emo(cur.num+cur.clip_num,cur.clip_num,cur.time+1));
				visit[cur.num+cur.clip_num][cur.clip_num]=true;
			}
			//3. 삭제
			// 현재 이모티콘 수가 1개 이상일 때 삭제
			// 삭제에 대한 방문처리 (다음 이모티콘 수 = 현재이모티콘 수 - 1)
			if(cur.num >0 && !visit[cur.num-1][cur.clip_num]) {
				queue.offer(new Emo(cur.num-1,cur.clip_num,cur.time+1));
				visit[cur.num-1][cur.clip_num]=true;
			}		
			
		}
		
	}
	
}
