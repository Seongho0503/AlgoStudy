import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class b2309 {
	static List<Integer> list = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();
	static boolean exit=false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int input[]= new int[9];
		for(int i=0;i<9;i++) {
			input[i]= Integer.parseInt(rd.readLine());
		}
		search(input,0,0,0);
		System.out.println(list2);
		Collections.sort(list2);
		for(int i:list2)
			System.out.println(i);
	}
	
  //재귀함수 완전탐색
	static void search(int[] input,int idx,int sum,int num) {
		//System.out.println(list+" "+sum);
		if(sum>100||num>7||exit) {
			return;
		}
		if(sum==100&&num==7) {
			list2.addAll(list);
			exit=true;
			return;
		}
		if(idx==9) {
			return;
		}
		list.add(input[idx]);
		search(input,idx+1,sum+input[idx],num+1);
	
		list.remove(list.size()-1);
		search(input,idx+1,sum,num);
	}

}
