
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//시간 초과로 실패
//재귀호출이라 입력값의 길이가 길면 안되는듯


public class Solution_3307 {
	static int max;
	//static List<Integer> li= new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(rd.readLine());
		for (int t = 0; t < testcase; t++) {
			int n = Integer.parseInt(rd.readLine());
			String input[]=rd.readLine().split(" ");
			int input2[]=new int[input.length];
      //input2에 int형으로 바꿔서 저장
      for(int i=0;i<input.length;i++) {
           input2[i]=Integer.parseInt(input[i]);
      }
      //최대 길이
			max=0;
			find(input2,0,0,0,false);
			System.out.println("#"+(t+1)+" "+max);
		}
		
	}
  
  //햄버거 문제와 같이 재귀적으로 둘 중 하나는 선택하고 하나는 선택 안하는 식으로 모든 경우의 수 탐색
	static void find(int[] arr, int index, int current, int sum, boolean include) {
		System.out.println("index: "+index+" current:"+current+" sum:"+sum+" arr: "+li);
		
		//배열 끝까지 가면 종료
		if(index>=arr.length) {
			if(max<sum) {
				max=sum;
				return;
			}
			else
				return;
		}
    
    //직전의 숫자를 선택하여 포함했고, 그 숫자보다 현재 숫자가 작으면 종료
		if(include&&arr[index]<current) {
			if(max<sum) {
				max=sum;
				return;
			}
			else
				return;
		}
		//li.add(arr[index]);
    //이번 숫자 선택하는 경우
		find(arr,index+1,arr[index],sum+1,true);
		
		//li.remove(li.size()-1);
    //이번 숫자 선택하지 않는 경우
		find(arr,index+1,current,sum,false);
		
		
	}

}
