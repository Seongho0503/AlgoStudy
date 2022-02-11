package IMTEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 *  
 */
public class bj2309ver3 {

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
		for (int i = 0; i < arr.length-1; i++) { ///난쟁이 1 
			for (int j = i+1; j < arr.length; j++) { //난쟁이 2
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
