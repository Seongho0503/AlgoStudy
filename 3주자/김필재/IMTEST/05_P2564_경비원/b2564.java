
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Store {
	int dir;// 방향
	int idx;// 위치
	int dis;// 거리
}

public class b2564 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String input[] = rd.readLine().split(" ");
		int num1 = Integer.parseInt(input[0]);// 가로
		int num2 = Integer.parseInt(input[1]);// 세로
		int n = Integer.parseInt(rd.readLine());
		Store[] st = new Store[n + 1];
		 
		for (int i = 0; i < n+1; i++) {
			st[i]=new Store();
			String input2[] = rd.readLine().split(" ");
			st[i].dir = Integer.parseInt(input2[0]);
      
			int idx = Integer.parseInt(input2[1]);
      
      //네 변을 펴서 일자로 만드는 느낌으로
      //우측 상단 꼭지점을 0으로 하여 북-서-남-동 이렇게 일자로 만들어 인덱스 그만큼 조정
			switch (st[i].dir) {
			case 1:
				st[i].idx=num1-idx;
				break;
			case 3:
				st[i].idx=num1+idx;
				break;
			case 2:
				st[i].idx=num1+num2+idx;
				break;
			case 4:
				st[i].idx=num1+num2+num1+(num2-idx);
				break;
			}
		}
		int mydir = st[n].dir;
		int myidx = st[n].idx;
		int result=0;
		for (int i = 0; i < n+1; i++) {
			int a=Math.abs(myidx-st[i].idx);
			int b1=(num1*2)+(num2*2)-myidx+st[i].idx;
			int b2=(num1*2)+(num2*2)-st[i].idx+myidx;
			int b;
			if(b1<b2)
				b=b1;
			else 
				b=b2;
			if(a<b)
				st[i].dis=a;
			else
				st[i].dis=b;
			result+=st[i].dis;
			//System.out.println("idx: "+st[i].idx+" dis:"+st[i].dis );
		}
		System.out.println(result);
	}

}
