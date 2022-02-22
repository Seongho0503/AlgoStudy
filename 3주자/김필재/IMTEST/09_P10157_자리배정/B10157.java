
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10157 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

		String input[] = rd.readLine().split(" ");
		int n1 = Integer.parseInt(input[0]);
		int n2 = Integer.parseInt(input[1]);
		int num = Integer.parseInt(rd.readLine());
		int arr[][] = new int[n1][n2];
		int n = 1;
		int x = 0;
		int y = 0;
		arr[x][y] = n++;
		
		//배열에 1씩 증가하면서 값 저장
		while (n != n1 * n2 + 1) {
			//오른쪽으로 이동
			while (y < n2 - 1) {
				if (arr[x][y + 1] != 0)
					break;
				arr[x][y + 1] = n++;
				y++;
			}
			//아래로 이동
			while (x < n1 - 1) {
				if (arr[x + 1][y] != 0)
					break;
				arr[x + 1][y] = n++;
				x++;

			}
			//왼쪽으로 이동
			while (y > 0) {
				if (arr[x][y - 1] != 0)
					break;
				arr[x][y - 1] = n++;
				y--;
			}
			//위로 이동
			while (x > 0) {
				if (arr[x - 1][y] != 0)
					break;
				arr[x - 1][y] = n++;
				x--;
			}
		}
		//k번째 관객의 좌표 찾기
		for(int i=0;i<n1;i++) {
			for(int j=0;j<n2;j++) {
				if(arr[i][j]==num) {
					System.out.println((i+1)+" "+(j+1));
					return;
				}
			}
		}
    //못찾았으면
		System.out.println("0");
	}
}
