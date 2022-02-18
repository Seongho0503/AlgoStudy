
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(rd.readLine());
		int sw[] = new int[n + 1];
		String input[] = rd.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			sw[i + 1] = Integer.parseInt(input[i]);
		}
		int a = Integer.parseInt(rd.readLine());
		
		//학생 수만큼 반복
		for (int i = 0; i < a; i++) {
			input = rd.readLine().split(" ");
			switch (Integer.parseInt(input[0])) {
			//남학생
			case 1:
				//배수의 스위치 바꿈
				for (int j = Integer.parseInt(input[1]); j < sw.length; j += Integer.parseInt(input[1])) {
					if (sw[j] == 0) {
						sw[j] = 1;
					} else {
						sw[j] = 0;
					}
				}
				break;
			//여학생
			case 2:
				
				//해당 번호의 스위치를 바꿈
				if(sw[Integer.parseInt(input[1])]==0) {
					sw[Integer.parseInt(input[1])]=1;
				}
				else
					sw[Integer.parseInt(input[1])]=0;
				
				//번호+1,번호-1 반복하여 같으면 바꿈, 다르면 종료
				for (int j = Integer.parseInt(input[1])+1, k = Integer.parseInt(input[1])-1; k > 0
						&& j < sw.length; j++, k--) {
					if (sw[j] == sw[k]) {
						
							if (sw[j] == 0) {
								sw[j] = 1;
							} else {
								sw[j] = 0;
							}
							if (sw[k] == 0) {
								sw[k] = 1;
							} else {
								sw[k] = 0;
							}
						
						
					} else {
						break;
					}
				}
				break;
			}
		}
		//출력
		for (int i = 1; i < sw.length; i++) {
			System.out.print(sw[i]);
			if (i % 20 == 0)
				System.out.println();
			else
				System.out.print(" ");
		}
	}

}
