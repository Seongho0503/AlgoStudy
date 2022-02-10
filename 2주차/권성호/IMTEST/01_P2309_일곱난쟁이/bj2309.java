package IMTEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2309 {
	// 9난쟁이의 키의 합
	static int sum = 0;
	// 원래 7난쟁이의 키의 합이 100이니 sum-100은 100에서 초과하는 가짜난쟁이의 키의 합 
	static int del = 0;
	//9난쟁이의 키를 각각 배열에 저장
	static int[] arr = new int[9]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			//요소 값(키의 값)을 배열에 담으면서 sum도 구해 놓음
			sum += arr[i];
		}
		// 100에서 넘어가는 키의 합 (100에서 초과하는 값을 구한 뒤 del로 가짜 난쟁이를 찾기로 계획)
		del = sum - 100;
		
		// 하나의 배열에 다른 인덱스 사용해서 값 찾기
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<i; j++) { //j<i 이부분이 매우 중요하다!!(2개의 난쟁이(인덱스) 중복을 막음	처음에 잘 못 짠 조건식for(int j=0; j<arr.length; j++) { // 처움에 arr.length까지 하니 요소 값이 줄복 됨
				 // 생각해보니 값 한개만 되는 경우도 있네, 그래서 값 한개만 del인 경우를 체크함
				//난쟁이 한 명이 del을 모두 차지하는 경우들응 제외시킴 ex) 한명의 난쟁이가 초과 분량을 혼자 다 채울 수 있으니, 그리고 두 난쟁이를 더했을 때 del이 되는 경우를 찾음 
				if(arr[i]!=del && arr[j]!=del && del == arr[i]+arr[j]) { 
					// 두 난쟁이를 찾으면 그 값을 0으로 초기화함 (출력할 때 0인 요소는 제외시키기 위해서)
					arr[i]=arr[j]=0; 
					// 찾으면 탈출 (여기서 궁금한게) break 한 개면 안쪽 for문 만 탈출하지 않나?? 바깥 for문도 한번에 탈출하는 방법이 없을까???
					break;
				}
			}
		}
		// 출력 값들이 모두 정렬되어 있어 배열 오름차순 정렬을 해줌
		Arrays.sort(arr);
		//사실 가짜 난쟁이의 키의 값이 모두 0이여서 for문을 int k=2; k<9 이렇게 잡아도 됨 (가짜 난쟁이의 요소 값이 모두 0이므로 arr[0], arr[1]번째에 가짜 난쟁이가 있으니깐)
		// 그냥 직관적이여서 if문으로 요소가 0인 가짜 난쟁이를 제외하고 출력했는데 생각해보니깐 이미 앞에서 정렬을 해줬으니 그것을 또 활용하려면 for문 조건식을 k=2부터 시작해서 뽑아주면 가짜 난쟁이가 출력이 안됨
		// k=2로 출력하는 게 더 효율적인데 if문방법도 있다는 것을 확인하기 위해 코드를 그냥 가져감
		for (int k=0; k<9; k++) {
			//0인 거 빼고 출력
			if(arr[k]!= 0)
			 System.out.println(arr[k]);
		}
	}

}


/*왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.*/