import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(rd.readLine());
		for(int i=0;i<testcase;i++) {
			int n=Integer.parseInt(rd.readLine());		//농장의 크기 n
			int sum=0;									//농작물 가치 합
			int mid=n/2;								//농장 크기 중간 지점의 값
			int start=mid;								//더할 부분의 인덱스 시작
			int end=mid;								//더할 부분의 인덱스 끝
			
			
			//맨 윗줄부터 시작하여 마름모 가장 넓은 부분의 줄 까지
			for(int k=0;k<=mid;k++) {
				String input=rd.readLine();
				
				//그 줄에서 마름모 범위에 해당하는 값만 sum에 더함
				for(int j=start;j<=end;j++) {
					sum+=((int)input.charAt(j)- '0');
				}
				
				//매 줄마다 인덱스 범위를 앞 뒤 한칸씩 늘려 마름모 형태를 만듬
				start--;end++;
				
			}
			start++;end--;
			
			
			//마름모 가장 넓은 부분 바로 밑줄부터 제일 아래 줄 까지
			for(int k=0;k<mid;k++) {
				String input=rd.readLine();
				
				start++;end--;
				
				for(int j=start;j<=end;j++) {
					sum+=((int)input.charAt(j)- '0');
				}
				
			}
			System.out.println("#"+(i+1)+" "+sum);
			
		}
		
		
	}
	
}
