import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sol_1215 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		char[][] map = new char[8][8];
		int ans = 0;

		for (int tc = 0; tc < 10; tc++) {

			int length = Integer.parseInt(br.readLine());

			for (int i = 0; i < 8; ++i) {
				for (int j = 0; j < 8; ++j) {
					map[i][j] = br.readLine().charAt(j);
				}
			}
			
			if (length == 1) {
				System.out.println("#" + tc + " " + 64);
				continue;
			}

			for (int i = 0; i < 8; ++i) {
				for (int j = 0; j < 8; ++j) {
					if (length == 2 && map[i][j] == map[i][j + 1])
						ans++;

				}
			}

		
			
			
			
			
			
			
			
			
			
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
	}
}
