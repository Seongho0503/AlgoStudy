
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B2628 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String s[] = rd.readLine().split(" ");
		int x= Integer.parseInt(s[0])*2;
		int y= Integer.parseInt(s[1])*2;
		int arr[][]=new int[y+1][x+1];
		for (int i = 0; i < y/2; i++) {
			for (int j = 0; j < x/2; j++) {
				arr[i][j]=2;
			}
		}
		int n = Integer.parseInt(rd.readLine());
		List<Integer> a0=new ArrayList<Integer>();//0 : 가로로 자를 위치들
		List<Integer> a1=new ArrayList<Integer>();//1 : 세로로 자를 위치들
		for (int i = 0; i < n; i++) {
			String input[] = rd.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			if(a==0) {
				a0.add(b);
			}
			else {
				a1.add(b);
			}
			
			
			
		}
		//자를 위치 0에 가까운 순으로 정렬 - 자를 때 한줄씩 밀어내므로
		Collections.sort(a0);
		Collections.sort(a1);
		//System.out.println(a0.toString());
		//System.out.println(a1.toString());
		
		//가로로 자르는 경우
		for(int i = 0; i < a0.size(); i++) {
			//자르는 줄을 1로 만들것이기 때문에 자르는 줄부터 끝까지 한줄씩 뒤로 옮김
			for (int l = y-2; l >= a0.get(i)+i; l--) {
				for (int j = 0; j < x; j++) {
					arr[l+1][j]=arr[l][j];
				}
			}
			//자르는 줄을 1로 만듬
			for(int j=0;j<x;j++) {
				arr[a0.get(i)+i][j]=1;
			}
		}
		
		//세로로 자르는 경우
		for(int i = 0; i < a1.size(); i++) {
			for (int l = x-2; l >= a1.get(i)+i; l--) {
				for (int j = 0; j < y; j++) {
					arr[j][l+1]=arr[j][l];
				}
			}
			for(int j=0;j<y;j++) {
				arr[j][a1.get(i)+i]=1;
			}
		}
		
		
		int max=0;
		
		//각 부분의 넓이 체크 - 2로 표시한 부분이 있으면 그곳에서 시작하여 검사하고, 검사한 부분은 0으로 만듬
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				
				if(arr[i][j]==2) {
					for (int k = 0; k < y; k++) {
						for (int l = 0; l < x; l++) {
							System.out.print(arr[k][l]);
						}
						System.out.println();
					}
					
					max=Math.max(max,check(arr,i,j));
					
					
				}
				
			}
		}
		System.out.println(max);
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println(max);
	}
	
	//각 부분의 넓이 구하기
	static int check(int[][] arr,int i_start,int j_start) {
		int i=i_start;
		int j=j_start;
		int sum=0;
		while(true) {
			//2이면 0으로 만들고 넓이 1 추가
			if(arr[i][j]==2) {
				arr[i][j]=0;
				sum++;
				
			}
			
			//while 반복에 따라 우측으로 탐색하며 0이나 1 만나면 시작 부분의 한칸 아래로 이동하여 2일 경우 다시 우측으로 탐색
			if(arr[i][j+1]==1||arr[i][j+1]==0) {
				if(arr[i+1][j_start]==2) {
					i++;
					j=j_start-1;
				}
				else {
					break;
				}
			}
			j++;
		}
		System.out.println(sum);
		return sum;
	}

}
