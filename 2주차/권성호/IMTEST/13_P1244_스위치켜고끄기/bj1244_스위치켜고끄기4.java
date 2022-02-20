package bj1244_스위치켜고끄기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1244_스위치켜고끄기4 {

	static int[] lights;

	//스위치 상태 바꾸는 함수
	static void change(int[] arr, int index) {

		if (arr[index] == 1) arr[index] = 0;
		else arr[index] = 1;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		lights = new int[num];
		for (int i = 0; i < num; i++)
			lights[i] = Integer.parseInt(st.nextToken());
		int person = Integer.parseInt(br.readLine());

		//사람 수가 1명이상 일 때 반복
		while (person > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int card = Integer.parseInt(st.nextToken());

			// 남자
			// 배수만큼 스위치 상태 바꿈
			if (sex == 1) {
				// 남자가 뽑은 수의 배수만큼 1->0 0->1 바꾸기
				for (int i = 1; i <= num / card; i++) {
					change(lights, card * i - 1);
					// if(lights[card*i]==1) lights[card*i] = 0;
					// else lights[card*i] = 1;
				}

				// 여자
			} else {
				// 뽑은 카드 숫자 인덱스는 반드시 바꿔줌
				change(lights, card - 1);
				int i = 2;
				// card-1은 뽑은 카드 왼쪽 인덱스
				// card+i-2는 뽑은 카드 오른쪽 인덱스
				while (card + i - 2 < num && card - i >= 0) {
					if (lights[card - i] == lights[card + i - 2]) {
						change(lights, card - i);
						change(lights, card + i - 2);
						i++;
					//뽑은 카드의 왼쪽과 오른쪽이 다른 스위치 상태면 종료
					} else
						break;

				}
			}
			person--;

		}
		// lights.length로 해줘도 되고 num으로 해줘도 됨
		for (int i = 0; i < lights.length; i++) {
			System.out.print(lights[i]+" ");
			//20번마다 줄 바꿈 , 이것때문에 형식 오류가 백준에서 계속 뜸
			if((i+1) % 20 ==0 ) System.out.println();
		}

	}

}
