package BOJ17142_연구소3;

// 메모리 : 39200 kb  시간 : 752 ms
/** 문제 분석
* 1. 접근 : 전형적인 조합 + bfs(최단시간)  비슷한 문제는 소문난 칠공주
* 		       패턴이 정형화 되어있는 웰논
*         
*          바이러스를 m개 만큼 조합해서 구한뒤 bfs로 최단시간을 구한다*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ17142_연구소3_ver2 {
    // (바이러스 x좌표 , y좌표, 걸린시간)
	static class Virus {
        int x, y, time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N, M, ans, empty;
    static int[][] map;
    // 바이러스 관리 리스트 
    static ArrayList<Virus> viruses;
    static Virus[] active;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        active = new Virus[M];
        viruses = new ArrayList<>();
        empty = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    empty++;
                } else if (map[i][j] == 2) {
                	   // (바이러스 x좌표 , y좌표, 걸린시간)
                    viruses.add(new Virus(i, j, 0));
                }
            }
        }
        ans = Integer.MAX_VALUE;
        
        if (emptySpace == 0) {
            System.out.println(0);
        } else {
            combination(0, 0);
            // ans : 최단시간
            if (ans == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
        }
    }
    
    
    // 조합 : 바이러스 M개 뽑기
    static void combination(int start, int cnt) {
        if (cnt == M) {
            bfs(emptySpace);
        } else {
            for (int i = start; i < viruses.size(); i++) {          //ex)  5개 3개 묶는다면 /////  ///  /// /// 3가지
               // 바이러스 리스트에서 하나씩 뽑아 M개되면 bfs돌림 (조합)
            	active[cnt] = viruses.get(i);           
                combination(i + 1, cnt + 1);
            }
        }
    } // 
    

    // M개 뽑은 바이러스 퍼뜨리기
    static void bfs(int emptySpace) {
        Queue<Virus> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            Virus v = active[i];
            visited[v.x][v.y] = true;
            q.add(v);
        }

        while (!q.isEmpty()) {
            Virus now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dir[d][0];
                int ny = now.y + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 맵 밖인 경우
                if(visited[nx][ny]) continue; // 바이러스가 이미 active형태인 경우(이미 퍼진 경우)
                if(map[nx][ny] == 1) continue; // 벽인 경우

                if (map[nx][ny] == 0) {
                    empty--;
                }
                if (empty == 0) {
                    ans = Math.min(ans, now.time + 1);
                    return;
                }
                visited[nx][ny] = true;
                q.add(new Virus(nx, ny, now.time + 1));
            }
        }
    }

   
}
