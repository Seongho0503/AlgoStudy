package IMTEST;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2605 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 몇명의 사람이 줄을 서?
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//배열로 하면 값이 바뀔 때 인덱스 까지 2번 고려해야 함 (swap 변수나 함수 쓰는 것이 더 복잡)
		List<Integer> list = new ArrayList<Integer>();
		list.add(-1);
		// 첫번째 온 아이가 0번째(1번) ->1번이 뽑은 수는 0번      ->   1
		// 두번째 온 아이가 1번째(2번) ->2번이 뽑은 수는 1번      ->   2 1
		// 세번째 온 아이가 2번째(3번) ->3번이 뽑은 수는 1번      ->   2 3 1
		// 네번째 온 아이가 3번째 (4번) ->4번이 뽑은 수는 3번      ->  4 2 3 1
		// 다섯뻔쨰 온 아이가 4번째(5번) -> 5번이 뽑은수는 2번   ->  4 2 5 3 1
		// 하다 보니 i를 처음 1부터 잡으면 편했겠다.....
		for(int i = 0 ; i < N ; i++) {
			int plus = Integer.parseInt(st.nextToken());
			//add(index, 값) 을 추가한다.  (값 = 이 문제에서는 몇 번째로 줄을 선 아이인지)
			list.add(i-plus,i);
		}
		
		
		for(int i = 1 ; i < N +1 ; i++) {
			System.out.print(list.get(i)+ " ");
		}
		
		
	}

}

/*5
0 1 1 3 2*/