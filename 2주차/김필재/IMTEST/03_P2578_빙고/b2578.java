
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2578 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[][]=new int[5][5];
		for(int i=0;i<5;i++) {
			String input[]=rd.readLine().split(" ");
			for(int j=0;j<5;j++) {
				arr[i][j]=Integer.parseInt(input[j]);
			}
		}
		for(int i=0;i<5;i++) {
			String input[]=rd.readLine().split(" ");
			for(int j=0;j<5;j++) {
				find(arr,Integer.parseInt(input[j]));
				for(int k=0;k<5;k++) {
					for(int l=0;l<5;l++) {
						System.out.print(arr[k][l]+" ");
					}System.out.println();
				}System.out.println();
        //빙고 세줄 이상이면 종료
				if(check(arr)>=3) {
					System.out.println(((i)*5)+j+1);
					
					return;
				}
			}
		}
	}
  //번호 찾아서 0으로 만듬
	static void find(int[][] arr,int num) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(arr[i][j]==num) {
					arr[i][j]=0;
					return;
				}
			}
		}
	}
  //빙고 몇줄인지 검사
	static int check(int[][] arr) {
		int num=0;
		
		for(int i=0;i<5;i++) {
			int count=0;
			for(int j=0;j<5;j++) {
				if(arr[i][j]==0) {
					count++;
				}
			}
			if(count==5) {
				num++;
			}
		}
		
		for(int i=0;i<5;i++) {
			int count=0;
			for(int j=0;j<5;j++) {
				if(arr[j][i]==0) {
					count++;
				}
			}
			if(count==5) {
				num++;
			}
		}
		
		
		int count = 0;
		for (int j = 0; j < 5; j++) {
			if (arr[j][j] == 0) {
				count++;
			}
		}
		if (count == 5) {
			num++;
		}
		count=0;
		for(int j=0;j<5;j++) {
			if(arr[4-j][j]==0) {
				count++;
			}
		}
		if(count==5) {
			num++;
		}
		return num;
	}

}
