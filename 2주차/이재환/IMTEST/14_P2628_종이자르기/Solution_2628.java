package P2628_종이자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2628 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//가로 세로 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		//점선 갯수 입력
		int Dot = Integer.parseInt(br.readLine());
		
		
		ArrayList<Integer> X = new ArrayList<>(); //세로로 자르는 점선
		ArrayList<Integer> Y = new ArrayList<>(); //가로로 자르는 점선

		//TYPE에 따라서 점선 해당 리스트(가로 OR 세로)에 넣어주기
		for (int d = 0; d < Dot; d++) {
			st = new StringTokenizer(br.readLine());
			int Type = Integer.parseInt(st.nextToken());
			if (Type == 1)
				X.add(Integer.parseInt(st.nextToken()));
			else if (Type == 0)
				Y.add(Integer.parseInt(st.nextToken()));
		}

		// 첫점과 끝점 더해주기
		X.add(0);
		X.add(R);
		Y.add(0);
		Y.add(C);
		
		//점선을 차례대로 정렬
		X.sort(null);
		Y.sort(null);
		
		

		//종이조각 넓이 = X점선 간의 거리 *각 Y점선 간의 거리
		//넓이 중 최댓값 구하기
		int area = 0;
		for (int i = 0; i < X.size() - 1; i++)
			for (int j = 0; j < Y.size() - 1; j++)
				area = Math.max(area, (Y.get(j + 1) - Y.get(j)) * (X.get(i + 1) - X.get(i)));

		//출력
		System.out.println(area);
	}
}
