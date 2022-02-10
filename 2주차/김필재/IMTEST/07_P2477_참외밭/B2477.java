
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class data{
	int d;
	int len;
	public data(int d, int len) {
		super();
		this.d = d;//방향
		this.len = len;//길이
	}
	
}
public class B2477 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		data d[]=new data[12];
		int n=Integer.parseInt(rd.readLine());
		
		
		
		//사각형 안쪽에 있는 두 변의 인덱스 저장
		int x=0;
		int y=0;
		for(int i=0;i<12;i++) {
			if(i<6) {
			String input[]=rd.readLine().split(" ");
			d[i]=new data(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
			}
			//안쪽으로 들어갈 때에는 2개의 방향이 반복됨. ex)423131 -> 3131 여기에서 가운데 13이 안쪽의 두 변
			//반복되는 부분이 시작과 끝에 걸쳐 있는 경우를 검사하기 위해 한번 이어붙임 ex)314231 이면 검사하기 어려우므로 314231314231 로 만듬
			if(i>=6) {
				d[i]=new data(d[i-6].d,d[i-6].len);
			}
		}
		//반복되는 부분 검사
		for(int i=3;i<12;i++) {
			if(d[i-3].d==d[i-1].d&&d[i-2].d==d[i].d) {
				x=i-2;
				y=i-1;
			}
		}
		
		//System.out.println(d[x].len+" "+d[y].len);
		int x2=99;
		int y2=99;
		//안쪽 두 변과 이어붙일 나머지 두 변을 찾음(같은 방향의)
		for(int i=0;i<6;i++) {
			if(d[i].d==d[x].d&&d[i].len!=d[x].len) {
				x2=i;
			}
			if(d[i].d==d[y].d&&d[i].len!=d[y].len) {
				y2=i;
			}
		}
		//안쪽 변의 길이가 나머지 변의 길이와 같아서 값이 안들어간경우
		if(x2==99) {
			x2=x;
		}
		if(y2==99) {
			y2=y;
		}
		//System.out.println("변 1:"+(d[x].len+d[x2].len)+"  변 2:"+(d[y].len+d[y2].len));
		int result=(d[x].len+d[x2].len)*(d[y].len+d[y2].len)-(d[x].len)*(d[y].len);
		System.out.println(result*n);
		
		
	}

}
