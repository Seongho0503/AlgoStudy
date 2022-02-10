
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2491 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
				int n = Integer.parseInt(rd.readLine());
				int countUp=1;
				int countDown=1;
				int maxU=1;
				int maxD=1;
				String input[] = rd.readLine().split(" ");
				for(int i=1;i<n;i++) {
					//System.out.println(Integer.parseInt(input[i-1])+" "+Integer.parseInt(input[i]));
          
          //커질때
					if(Integer.parseInt(input[i-1])<Integer.parseInt(input[i])) {
						countUp++;
						maxU=Math.max(countUp, maxU);
						maxD=Math.max(countDown, maxD);
						countDown=1;
						
					}
          //작아질때
					else if(Integer.parseInt(input[i-1])>Integer.parseInt(input[i])) {
						countDown++;
						maxD=Math.max(countDown, maxD);
						maxU=Math.max(countUp, maxU);
						countUp=1;
					}
          //같을때
					else {
						countDown++;
						countUp++;
						maxD=Math.max(countDown, maxD);
						maxU=Math.max(countUp, maxU);
					}
				}
				System.out.println(Math.max(maxU, maxD));
	}

}
