package P2309_일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_2309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		int sum=0;
		//입력 받기 + 합계 구하기 
		for(int i=0;i<9;i++) {
			int input=Integer.parseInt(br.readLine());
			list.add(input);
			sum+=input;
		} 	
		
		// 두 난쟁이 찾기
		for(int i=0;i<9;i++) {
			if(list.size()==7) break;
			for(int j=i+1;j<9;j++) {
				if(list.get(i)+list.get(j)==sum-100) {
					list.remove(j);
					list.remove(i);
					break;
				}	
			}
		}
		// 오름차순 정렬 후 출력
		list.sort(null);
		for(int x: list)
			System.out.println(x);
	}
}
