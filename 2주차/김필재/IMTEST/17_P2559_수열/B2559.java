
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B2559 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String s[] = rd.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		String input[] = rd.readLine().split(" ");
		
		Queue<Integer> queue = new LinkedList<>();
		//초기값을 입력조건에서의 최소값으로(모든 수가 -100일때)
		int max=-100*n;
		int sum=0;
		
		//앞에서 k개만큼 큐에 넣고 합 구함
		for(int i=0;i<k;i++) {
			queue.offer(Integer.parseInt(input[i]));
			sum+=Integer.parseInt(input[i]);
		}
		if(sum>max)
			max=sum;
		
		//큐에 앞의 수 빼고 새로운 값을 넣으면서 합 계산
		for(int i=k;i<n;i++) {
			sum-=queue.poll();
			queue.offer(Integer.parseInt(input[i]));
			sum+=Integer.parseInt(input[i]);
			if(sum>max)
				max=sum;
			//System.out.println(sum);
		}
		System.out.println(max);
	}

}
