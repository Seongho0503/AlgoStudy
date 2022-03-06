package SWEA.D3;

import java.util.*;

//메모리 : 13648 kb
//시간 : 148 ms
//코드길이 1026 b


public class Main_케빈베이켠의6단계법칙_1601_ver2 {
	static int[][] friends = new int[101][101];
	static int n, m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		//배열의 값 일괄 초기화 Arrays.fill
		// 나머지 칸은 최대값으로 초기화
		for(int i = 0; i < friends.length; i++)
			Arrays.fill(friends[i],  100 * 10000);

		// 본인이 본인한테 이동하는 것은 없다고 생각
		for(int i = 0; i < friends.length; i++)
			friends[i][i] = 0;
		
		for(int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			//친구관계
			// start 와 end는 서로 친구이며
			friends[start][end] = 1;
			friends[end][start] = 1;
		}
		floyd();
		int ret = Integer.MAX_VALUE;
		int answer = 101;
		for(int i = 0; i < 101; i++) {
			int sum = 0;
			for(int j = 0; j < 101; j++) {
				sum += friends[i][j];
			}
			if(ret > sum) {
				ret = sum;
				answer = i;
			}
		}
		sc.close();
		System.out.println(answer);
	}
	
	public static void floyd() {
		// 시작 노드
		for(int i = 0; i < 101; i++) {
			// 도착 노드
			for(int j = 0; j < 101; j++) {
				if(friends[j][i] == 0) continue;
				// 거쳐가는 중간 지점 노드
				for(int k = 0; k < 101; k++)
					// 최단경로 초기화
					friends[j][k] = Math.min(friends[j][k], friends[j][i] + friends[i][k]);
			}
		}
	}
	
}