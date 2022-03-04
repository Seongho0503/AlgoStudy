//메모리:15008kb	시간:124ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1012 {
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,1,-1};
	static int m;
	static int n;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(rd.readLine());
		for(int t=0;t<test;t++) {
			int count=0;
			String s[]=rd.readLine().split(" ");
			m=Integer.parseInt(s[0]);
			n=Integer.parseInt(s[1]);
			int k=Integer.parseInt(s[2]);
			arr=new int[n][m];
			for(int i=0;i<k;i++) {
				s=rd.readLine().split(" ");
				arr[Integer.parseInt(s[1])][Integer.parseInt(s[0])]=1;
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]==1) {
						count++;
						check(i,j);
					}
				}
			}
			
			System.out.println(count);
		}
	}
  //사방 탐색해서 0으로 만듬
	static void check(int i,int j) {
		arr[i][j]=0;
		for(int k=0;k<4;k++) {
			int nx=i+dx[k];
			int ny=j+dy[k];
			if(nx<0||nx>=n||ny<0||ny>=m||arr[nx][ny]==0)
				continue;
			else
				check(nx,ny);
		}
	}

}
