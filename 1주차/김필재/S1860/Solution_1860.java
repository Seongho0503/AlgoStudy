import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1860 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(rd.readLine());
		for(int i=0;i<testcase;i++) {
			String input=rd.readLine();
			String[] inputs = input.split(" ");
			int P_num=Integer.parseInt(inputs[0]);		//손님 수
			int sec=Integer.parseInt(inputs[1]);		//붕어빵 만드는데 걸리는 시간(초)
			int num=Integer.parseInt(inputs[2]);		//한번에 만드는 개수
			
			input=rd.readLine();
			inputs = input.split(" ");
			int come[]=new int[P_num];					//손님 오는 시간들 배열
			for(int j = 0;j<P_num;j++) {
				come[j]=Integer.parseInt(inputs[j]);
			}
			
			Arrays.sort(come);							//손님 오는 시간 순서대로 정렬	
			
			String possible="Possible";
			int index=0;								//come[]인덱스
			int current_num=0;							//현재 붕어빵 수(재고)
			
			//0초부터 시작하여 마지막 손님 오는 시간(초)까지 반복
			for(int t=0;t<=come[P_num-1];t++) {
				
				//붕어빵 만드는 주기마다 num개씩 붕어빵 재고 증가
				if(t!=0&&t%sec==0) {
					current_num+=num;
				}
				
				//손님 오는 시간이 되면 1개씩 재고 감소, 재고 없으면 Impossible
				if(t==come[index]) {
					index++;
					if(--current_num<0) {
						possible="Impossible";
						break;
					}
				}
			}
			System.out.println("#"+(i+1)+" "+possible);
		}
		
	}

}
