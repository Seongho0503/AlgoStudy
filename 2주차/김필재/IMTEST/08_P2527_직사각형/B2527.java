
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//뭔가 틀려서 수정 필요..

public class B2527 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
			
		for(int t=0;t<4;t++) {
			
			String s[]=rd.readLine().split(" ");
			int input1[]=new int[4];//사각형 1의 xypq
			int input2[]=new int[4];//사각형 2의 xypq
			for(int j=0;j<4;j++) {
				input1[j]=Integer.parseInt(s[j]);
				
			}
			for(int j=4;j<8;j++) {
				input2[j-4]=Integer.parseInt(s[j]);
				
			}
			//공통부분 없음 -왼쪽 사각형 p가 오른쪽 사각형 x보다 작음, 위쪽 사각형 y가 아래쪽 사각형 q보다 큼 + 서로 반대인 경우
			if(input1[2]<input2[0]||input1[1]>input2[3]||input2[2]<input1[0]||input2[1]>input1[3]) {
				System.out.println("d");
			}
			//점이 겹치는 경우 - 점이 하나라도 일치할 때
			else if(input1[0]==input2[0]&&input1[1]==input2[1]||input1[0]==input2[0]&&input1[3]==input2[3]||
					input1[2]==input2[2]&&input1[3]==input2[3]||input1[1]==input2[1]&&input1[2]==input2[2]) {
				System.out.println("c");
			}
			//선분 겹치는 경우 - 사각형1의x = 사각형2의p,사각형1의y!=사각형2의q  1 y= 2 q, 1 x!= 2 p  + 반대
			else if(input1[0]==input2[2]&&input1[1]!=input2[3]||input1[1]==input2[3]&&input1[0]!=input2[2]||
					input2[0]!=input1[2]&&input2[1]==input1[3]||input2[1]!=input1[3]&&input2[0]==input1[2]) {
				System.out.println("b");
			}
			else
				System.out.println("a");
		}
	}
	
}
