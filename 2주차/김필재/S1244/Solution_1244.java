import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(rd.readLine());
		for (int i = 0; i < testcase; i++) {
			String input[] = rd.readLine().split(" ");
			char[] num = input[0].toCharArray();
			List numbers = new ArrayList();

			
			//입력받은 숫자들을 numbers 리스트에 저장
			for (int j = 0; j < num.length; j++) {
				numbers.add(num[j]);
			}
			
			
			//내림차순으로 정렬하여 상금 최대값을 max 리스트에 저장
			Arrays.sort(num);
			List max = new ArrayList();
			for (int j = num.length - 1; j >= 0; j--) {
				max.add(num[j]);
			}
			
			
			//교환 횟수 num2에 저장
			int num2 = Integer.parseInt(input[1]);

			
			//numbers의 첫번째 숫자(인덱스 j)부터 시작하여 다른 숫자와 교환
			for (int j = 0; j < numbers.size(); j++) {
				
				// 횟수 남았지만 이미 최대값과 동일할 때
				if (numbers.equals(max)) {
					if (num2 % 2 == 0) {
						break;
					} 
					
					// 같은 숫자가 두개 이상 있으면 종료
					else {
						Set<Integer> Set = new HashSet<>(numbers);
						if (Set.size() != numbers.size()) {
							break;
						}
						// 없으면 제일 뒤의 두자리 바꿈
						else {
							Object temp = numbers.get(numbers.size() - 1);
							numbers.set(numbers.size() - 1, numbers.get(numbers.size() - 2));
							numbers.set(numbers.size() - 2, temp);
							break;
						}
					}
				}

				// 현재 비교할 인덱스의 값이 max의 해당 인덱스의 값하고 같을 때에는 교환을 하지 않고 다음 자리로 넘어감
				if (numbers.get(j).equals(max.get(j))) {
					continue;
				}
				
				
				// 현재 위치의 숫자와 바꿀 숫자의 인덱스를 저장 : 
				//max 리스트에서 현재 위치의 숫자와 같은 위치의 숫자의 값의 numbers리스트에서의 위치(이미 교환한 앞의 숫자들은 제외) = 뒤의 나머지 숫자들 중 가장 큰 값
				int index = numbers.subList(j, numbers.size()).lastIndexOf(max.get(j)) + j;
				
				// 뒤에 동일한 큰 숫자들이 여러개일 때 처리---------------------------------------
				//기본적으로 뒤의 숫자들 중 가장 큰 값하고 바꾸지만, 동일한 값이 여러 개 일 경우 어느 위치의 숫자와 바꿔야 적절할 지 최종 값인 max와 비교하여 위치를 선정
				//index2에는 현재 위치의 숫자 뒤의 숫자들 중 중복되는 큰 숫자들의 인덱스를 저장
				List<Integer> index2 = new ArrayList();
				if (numbers.subList(j, numbers.size()).indexOf(max.get(j)) != numbers.subList(j, numbers.size())
						.lastIndexOf(max.get(j))) {
					
					// max 리스트에서 현재 숫자의 위치와 같은 위치의 숫자들을 numbers에서 탐색하여 임시 인덱스 리스트 index2에 저장
					// = numbers의 뒤에 있는 중복되는 큰 값들의 인덱스
					index2.add(numbers.subList(j, numbers.size()).indexOf(max.get(j)) + j);
					for (int k = 0;; k++) {
						if (!numbers.subList(index2.get(k) + 1, numbers.size()).contains(max.get(j))) {
							break;
						} else {
							index2.add(numbers.subList(index2.get(k) + 1, numbers.size()).indexOf(max.get(j))
									+ index2.get(k) + 1);
						}
					}
					
					// 현재 숫자를 뒤의 중복되는 큰 숫자들 중 어떤 위치의 숫자와 바꿀 지
					// numbers:[3, 2, 8, 8, 8]
					//	    ^
					// index2:[2,3,4]
					//	     ^
					// max:[8, 8, 8, 3, 2]
					//	         ^
					for (int l : index2) {
						if (max.get(l).equals(numbers.get(j)))
							index = l;
					}

				}

				// 현재 위치의 숫자 (j)와 index위치의 값 교환
				numbers.set(index, numbers.get(j));
				numbers.set(j, max.get(j));	//가장 큰 수는 max에서 가져옴

				
				// 바꿀 횟수가 없으면 종료
				if (--num2 <= 0) {
					break;
				}

			}
			System.out.print("#"+(i+1)+" ");
			for(Object a:numbers) {
				System.out.print(a);
			}
			System.out.println();
		}
	}

}
