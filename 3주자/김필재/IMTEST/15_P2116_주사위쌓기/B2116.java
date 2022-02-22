
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B2116 {
	static int sum=0;	//주사위 값의 합
	static List<String>[] list; //주사위 하나당 한 개의 리스트에 6개의 숫자 저장
	static int d[]= {5,3,4,1,2,0};	//마주보는 면 0:5, 1:3...
	static int n;	//주사위 수
	static int max=0;	//최대합
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(rd.readLine());
		list=new List[n];
		
		//리스트 초기화
		for(int i=0;i<n;i++)
			list[i]= new ArrayList<String>();
		
		//i번째 주사위 값들을 리스트에 저장 [2, 3, 1, 6, 5, 4]
		for(int i=0;i<n;i++) {
			String s[] = rd.readLine().split(" ");
			list[i]=Arrays.asList(s);
		}
		
		//첫 번째 주사위의 바닥면 돌려가며 6회 반복
		for(int i=0;i<6;i++) {	
			//이번 경우에서 합계
			sum=0;
			List<String> tempList=new ArrayList<>(list[0]);
			
			//첫 번째 주사위 윗면 숫자 저장
			String top=tempList.get(d[i]);	
			
			//바닥면 숫자 0으로
			tempList.set(i, "0");		
			
			//윗면 숫자 0으로
			tempList.set(d[i], "0");			
			
			//옆면중 최대값 더함
			sum+=Integer.parseInt(Collections.max(tempList));	
			
			//위에 올려놓을 다음 주사위
			start(top,1);
			
			max=Math.max(max, sum);
			
		}
		System.out.println(max);
		
	}
	
	static void start(String top,int idx) {
		if(idx==n) {
			return;
		}
		
		//현재 주사위 리스트 복사(원본 리스트 재사용 위해서)
		List<String> tempList=new ArrayList<>(list[idx]);
		
		
		//아래 주사위 윗면 번호에 해당하는 윗 주사위의 아랫면  인덱스
		int bottom = tempList.indexOf(top);
		
		//주사위 윗면 숫자 저장
		String top2=tempList.get(d[bottom]);	
		
		//바닥면 숫자 0으로
		tempList.set(bottom, "0");		
		
		//윗면 숫자 0으로
		tempList.set(d[bottom], "0");	
		
		//옆면중 최대값 더함
		sum+=Integer.parseInt(Collections.max(tempList));	
		
		//System.out.println("주사위 "+idx+" : "+"bottom : "+list[idx].get(bottom));
		//System.out.println("주사위 "+idx+" : "+"top: "+top2);
		//System.out.println("주사위 "+idx+" : "+tempList);
		//System.out.println("주사위 "+idx+" : "+"옆면 max:"+Collections.max(tempList)+" "+"  현재 sum: "+sum);
		
		//다음 주사위
		start(top2,idx+1);
	}

}
