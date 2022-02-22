
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2635 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int start = Integer.parseInt(rd.readLine());
		
		//규칙에 따라 만들 수 있는 개수 중 최대
		int max = 0;
		//최대일 때의 i값
		int maxnum=0;
		
		//두번째 수가 (첫번째 수 -0) 부터 (첫번째 수 -첫번째 수)일때 까지
		for (int i = start; i >=0; i--) {
			int count = 1;
			
			int n1 = start;
			int n2 = start - i;
			
			//규칙에 따라 0이하가 될 때까지 계산
			while (n1 >= 0&&n2>=0) {
				int tmp=n1-n2;
				n1=n2;
				n2=tmp;
				count++;
				//System.out.println("i: "+i+"  n1: "+n1+"  n2: "+n2+"  count: "+count);
			}
			
			//규칙에 따라 만들 수 있는 개수 중 최대값과 그 때의 i값 저장
			if(count>max) {
				maxnum=i;
				max=count;
			}
		}
		
		//결과 표시
		System.out.println(max);
		int n1 = start;
		int n2 = start - maxnum;
		System.out.print(n1+" ");
		while (n1 >= 0&&n2>=0) {
			System.out.print(n2+" ");
			int tmp=n1-n2;
			n1=n2;
			n2=tmp;
		}
		

	}

}
