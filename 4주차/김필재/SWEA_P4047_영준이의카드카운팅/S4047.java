
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class S4047 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(rd.readLine());

		for (int t = 0; t < test; t++) {
			Map map = new HashMap<Character, Integer>();
			map.put('S', 0);
			map.put('D', 1);
			map.put('H', 2);
			map.put('C', 3);
			HashSet[] set = { new HashSet(), new HashSet(), new HashSet(), new HashSet() };
			String input = rd.readLine();
			int i;
			System.out.print("#" + (t + 1) + " ");
			for (i = 0; i < input.length() - 2; i++) {
				int size;
				int idx = (int) map.get(input.charAt(i));
				size = set[idx].size();
				set[idx].add((input.charAt(i + 1)) + "" + input.charAt(i + 2));
				if (size == set[idx].size()) {
					System.out.println("ERROR");
					break;
				}
				i += 2;
			}
			if (i == input.length()) {
				for (HashSet s : set)
					System.out.print(13 - s.size() + " ");
				System.out.println();
			}

		}

	}

}
