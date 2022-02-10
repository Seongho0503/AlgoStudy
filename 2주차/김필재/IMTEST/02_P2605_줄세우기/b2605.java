
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b2605 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String n = rd.readLine();
		String input[]=rd.readLine().split(" ");
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<Integer.parseInt(n);i++) {
			list.add(i-Integer.parseInt(input[i]),i+1);
		}
		System.out.println(list);
	}

}
