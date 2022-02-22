
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

		int testcase = Integer.parseInt(rd.readLine());
		for (int i = 0; i < testcase; i++) {
			String s1[] = rd.readLine().split(" ");
			String s2[] = rd.readLine().split(" ");
			long score1=0;
			long score2=0;
			for(int j=1;j<=Integer.parseInt(s1[0]);j++) {
				//한 종류의 딱지 최대 100개이므로 1000의 거듭제곱으로 표현
				score1+=Math.pow(1000, Integer.parseInt(s1[j]));
			}
			for(int j=1;j<=Integer.parseInt(s2[0]);j++) {
				//한 종류의 딱지 최대 100개이므로 1000의 거듭제곱으로 표현
				score2+=Math.pow(1000, Integer.parseInt(s2[j]));
			}
			System.out.println(score1+" "+score2);
			if(score1>score2)
				System.out.println("A");
			else if(score1<score2)
				System.out.println("B");
			else {
				System.out.println("D");
			}
		}
	}

}
