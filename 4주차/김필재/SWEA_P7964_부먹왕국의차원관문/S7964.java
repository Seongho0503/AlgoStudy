
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S7964 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(rd.readLine());
		for(int t=0;t<test;t++) {
			String s[]=rd.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int d=Integer.parseInt(s[1]);
			s=rd.readLine().split(" ");
			//왼쪽 마지막 차원관문과의 거리
			int distance=0;
			//차원관문 개수
			int count=0;
			for(int i=0;i<n;i++) {
				//이번 도시 차원관문 없으면
				if(Integer.parseInt(s[i])==0)
					distance++;
				else
					distance=0;
				//거리가 제한거리와 같아지면
				if(distance==d) {
					count++;
					distance=0;
				}
			}
			System.out.println("#"+(t+1)+" "+count);
		}
	}

}
