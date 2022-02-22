package IMTEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 *  이클립스에서 예제는 잘 돌아가는데 백준에서 실패가 뜬다
 *  분명 반례가 있다는 건데 코드가 아직 디테일 하지 못한 거 같다.
 *  생각해본 반례는  만약 del 일 6이라면  (1,5) (2,3) (3,2) (5,1) 올 수 있다 (같은 키는 없으니 (3,3)제외)
 *  나는 밑에 코드 for문 (i,j)라고 가정할 떄 나는 분명 하나만이라도 찾으면 정렬 후 요소 출력한 뒤 return 시켜서 프로그램 종료 시켰는데 
 *  어디서 반례 빈틈이 생긴거지??? 
 *  
 */
public class bj2309ver2 {

	static int sum = 0;
	static int del = 0;
	static int[] arr = new int[9];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i]; // 난쟁이의 합을 모두 더한 것
		}
		del = sum - 100; // 가짜 난쟁이 2명의 합 
		for (int i = 0; i < arr.length; i++) { ///난쟁이 1 
			for (int j = i+1; j < arr.length-1; j++) { //난쟁이 2
				if (del == arr[i] + arr[j]) { 
					arr[i] = arr[j] = 0; //가짜 난쟁이 0으로 만듬
					Arrays.sort(arr); // 오름차순 정렬
					for (int k = 2; k < 9; k++) {
						System.out.println(arr[k]);
					}
					return;
				}
			}
		}
	}

}
