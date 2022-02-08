package sw_3307;



	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;

	public class sw3307 {

		// 문자 길이
		static int N;
		// 테이스 케이스 횟수
		static int T;
		// 부분수열 최대 길이[최장 부분 수열의 길이]
		static int max;
		// 입력 값들을 저장
		static int[] arr;
		// 탐색할 배열-길이를 담음
		static int[] search;
		
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			T = Integer.parseInt(br.readLine());
					
			for (int t = 1; t <= T; t++) {
				max = 0;
				N = Integer.parseInt(br.readLine());
				arr = new int[N];
				search = new int[N];
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 배열안에 입력 값 초기화
				for (int i = 0; i < N; i++) {
					// search 배열은 요소 값들을 저장용x -> arr의 최소 크기는 숫자가 하나 있는 경우임 
					//숫자가 한개 수열의 배열 크기는 1이기 때문에 search에 1 초기화
					//search는 부분수열의 최대 길이를 담음 
					search[i] = 1; 
					arr[i] = Integer.parseInt(st.nextToken());
					searching(i);
				}
				
				System.out.println("#" + t + " " + max);
			}
			
			br.close();
		}
		//탐색 함수
		private static void searching(int i) {
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && search[j] + 1 > search[i]) {
					search[i] = search[j]+ 1;
				}
			}
			//max는 static 멤버이기 때문에 함수 리턴타입을 void 로 해줌
			max = search[i];
		}

}
