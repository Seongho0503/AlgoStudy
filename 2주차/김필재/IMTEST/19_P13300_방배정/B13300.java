
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B13300 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//6개의 학년 2개의 성별
		int a[][]=new int[6][2];
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String s[] = rd.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int sum=0;
		for(int i=0;i<n;i++) {
			s = rd.readLine().split(" ");
			int b1 = Integer.parseInt(s[0]);
			int a1 = Integer.parseInt(s[1]);
			a[a1-1][b1]++;
		}
		
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<2;j++) {
				if(a[i][j]>0) {
					//나머지 있으면 방 한개 더 추가
					if(a[i][j]%k!=0)
						sum+=1;
					sum+=a[i][j]/k;
				}
			}
		}
		
		System.out.println(sum);
	}

}
