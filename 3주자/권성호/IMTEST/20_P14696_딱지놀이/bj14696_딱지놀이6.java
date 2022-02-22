package bj14696_딱지놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14696_딱지놀이6 {
	// 2는 담을 수 있는 곳이 아니다 
	
	static BufferedReader br;
	//suffle은 카드를 입력받는 함수다. 
	// A,B 둘 다 같은 동작이 매번 반복되서 함수로 빼서 가독성을 높힘.
	static void suffle(int[][] arr, int k) throws IOException {
		
		//2번쭐 줄 부터 입력 받는 곳
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 카드 개수
		int carNumber = Integer.parseInt(st.nextToken());
		// 4=별 3=동그라미 2=네모 1=세모 배열의 인덱스에서 담음
		for(int i =0; i<carNumber; i++ ) {
			arr[k][Integer.parseInt(st.nextToken())-1] += 1 ;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		// 경기 round 횟수 입력 받음
		int num = Integer.parseInt(br.readLine());
		
		for(int tc =0 ; tc<num ; tc++) {
			//중요 배열 선언을 여기서 해줘야 함(그래야 매번 새로운 경기 때마다 배열안에 카드 숫자가 달라짐)
			//처음에  static으로 헀다가 오류나서 생각해보니 매 경기 때마다 초기화해줘야 함
			int[][] cards = new int[2][5]; 
			// A카드 받기
			suffle(cards, 0);
			// B카드 받기
			suffle(cards, 1);	

			// A가 이기면 A ,B가 이기면 B. 도형 4개가 다 같으면 D(무승부) 
			// 누군가 이기면 탈출 break
			for(int i=3; i>=0; i--) {
				if(cards[0][i] > cards[1][i]) {
					System.out.println("A");
					break;
				}else if (cards[0][i] < cards[1][i]) {
					System.out.println("B");
					break;
				}else if (cards[0][0] == cards[1][0] && i==0) {
					System.out.println("D");					
					break;
				}
				
			}
	
		}
		
	}
}
