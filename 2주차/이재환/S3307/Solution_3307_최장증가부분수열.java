package P3307;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최장 증가 부분 수열의 정의
//어떤 임의의 수열이 주어질 때, 이 수열에서 몇 개의 수들을 제거해서 부분수열을 만들 수 있다.
//이때 만들어진 부분수열 중 오름차순으로 정렬된 가장 긴 수열을 최장 증가 부분 수열이라 한다.

public class Solution_3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {	
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			int len[] = new int[N];
		
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				len[i]=1;
			}
			
			int max=0;
			//수열의 2번째 인덱스부터 비교 시작(1번째 인덱스 -> 비교 무의미)
			for (int i = 1; i < N; i++) {
				//현재 수보다 왼쪽에 있고 낮은 수 중에서 
				//낮은 수 길이>현재 높은 수 길이 => 현재 인덱스 길이 최신화 -> 현재 길이 = 이전 수 길이 +1  
				for (int j = 0; j <i; j++) 
					if(arr[j]<arr[i] && len[i]<len[j]+1) 
						len[i]=len[j]+1;	
				
				max=Math.max(max, len[i]);
			}
	
			System.out.println("#" + t+" " +max);	
	
		}
	}
	
}

