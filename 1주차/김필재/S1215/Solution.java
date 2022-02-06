import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스 10회
		for (int i = 0; i < 10; i++) {
			char table[][] = new char[8][8];
			char table2[][] = new char[8][8];
			int result=0;
			int len=Integer.parseInt(rd.readLine());
			for(int j=0;j<8;j++) {
				table[j] = rd.readLine().toCharArray();
			}
			//인덱스를 반대로 입력하여 세로로 탐색 가능한 table 생성
			for(int k=0;k<8;k++) {
				for(int l=0;l<8;l++) {
					table2[k][l]=table[l][k];
				}
			}
			for(int k=0;k<8;k++) {
				for(int l=0;l<8;l++) {
					if(l+len<=8) {
						//좌표 기준 오른쪽 n칸 회문인지 비교 ---------------------------
						char temp[]=new char[8];
						//현재 위치에서 n칸만큼 잘라서 temp에 저장
						temp=Arrays.copyOfRange(table[k], l,l+len);
						StringBuffer sb = new StringBuffer(new String(temp));
						String reverse = sb.reverse().toString();
						//System.out.println(new String(temp)+"   "+reverse);
						if(reverse.equals(new String(temp))) {
							//1증가
							result++;
						}
						//----------------------------------------------------------
						
						//좌표 기준 아래쪽 n칸 회문인지 비교 ---------------------------
						temp=Arrays.copyOfRange(table2[k], l,l+len);	//table 세로 부분을 자르기 위해 table2 사용
						sb = new StringBuffer(new String(temp));
						reverse = sb.reverse().toString();
						if(reverse.equals(new String(temp))) {
							//1증가
							result++;
						}
						//----------------------------------------------------------
					}
				}
			}
			System.out.println("#"+(i+1)+" "+result);
		}
	}
}
