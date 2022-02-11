package P2628_종이자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2628 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int Dot = Integer.parseInt(br.readLine());
		ArrayList<Integer> X = new ArrayList<>();
		ArrayList<Integer> Y = new ArrayList<>();

		for (int d = 0; d < Dot; d++) {
			st = new StringTokenizer(br.readLine());
			int Type = Integer.parseInt(st.nextToken());
			if (Type == 1)
				X.add(Integer.parseInt(st.nextToken()));
			else if (Type == 0)
				Y.add(Integer.parseInt(st.nextToken()));
		}

		X.add(0);
		X.add(R);
		Y.add(0);
		Y.add(C);
		X.sort(null);
		Y.sort(null);

		int area = 0;
		for (int i = 0; i < X.size() - 1; i++)
			for (int j = 0; j < Y.size() - 1; j++)
				area = Math.max(area, (Y.get(j + 1) - Y.get(j)) * (X.get(i + 1) - X.get(i)));

		System.out.println(area);
	}
}
