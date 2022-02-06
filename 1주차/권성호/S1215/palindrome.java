package Sungho_S1215;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class palindrome {   //클래스 부분에서는 변수 선언, 메서드 선언 등 밖에 할 수 없고, 저런 로직 부분은 모두 메서드 내에 써 주셔야 합니다. 메서드 내에서만 로직을 넣을 수 있어요 'ㅁ'
	
	static int add=0;
	static int num;
	//static int leng;
	static int cnt;
	static int first = 0;
	static int last = 0;
	static String[] arr = new String[7];// 가로 8줄 세로 8줄  한 줄에 하나씩
	static String[] arr_c = new String[7];//
	
	public static void circh(int i, int n) {        //ex) 4개씩 묶는 다면
		String word = arr[i];
		System.out.println(word);
		  //word.length()/2
		for( ; first<8 ; first++) {			
			if(word.charAt(first) != word.charAt(n-last-1+add)) { // 0번째랑 3번째랑 같음 -> n-1 재귀호출 -> fist++ 안되고 break 한 뒤  1 
				//first =0;
				first++;
				add++;
				continue;
				//circh(n); // first ++ 되고 탈출되는지 확인
			}else if((first)==(n-1-last+add)) {
				System.out.println("동일 인덱스" +first);
				System.out.println("라스트값"+last);
				cnt++;
				//first=last =0;
				last=0;
				add+=n-1;
				//first++;
				if(first==6 && num>2) {
					return;//break;
				}
				if(first==8) {
					return;
				}
				continue;
			}                                      // aaaccccc  // bbbbbbb // adcfdddd   1) 다른경우 2칸이 늘어짐
			else {
				last++;
				continue;
				
				//first++;
				//System.out.println("설마" + "add : "+ add + "last: "+last +"first : "+ first );
				//circh(i, n);
			//}
	    }
	}
}
	public static void fromFile() throws FileNotFoundException{
			
			try {
					File file = new File("input.txt");
					FileReader filereader = new FileReader(file);
					 BufferedReader buf = new BufferedReader(filereader);
                     String line ="";                                                             //Scanner sc  = new Scanner(new File(url.getPath()));					                                                                             // int tc = sc.nextInt();
					                                                                             //sc.nextLine();
		                                                                //    for( int test_case = 0; test_case <tc; test_case++) {
					while((line = buf.readLine()) !=null) {
						 // 다음 읽을 정보가 있다면
						//int num = buf.read(); 
						//System.out.println(line);  // line 은 몇개를 묶을 거니? 디버깅용
						//배열에 한 라인씩 값을 넣기
						//for(int i= 0; i<arr.length-2; i++) {
						 	arr[0] = buf.readLine();//buf.readLine();// 라인단위로 정보 얻기 (예: CBCABBAC)	
						//}	
						int cirnum = Integer.parseInt(line);
						//for(int i=0; i<9-cirnum ; i++) { //for(int i=0 ; i< 9-cirnum; i++) {
						System.out.println(cirnum+"개 만큼 묶어주세요");	
						
						
						for(int i=0; i<8; i++) {
							arr[i] = buf.readLine();
							circh( i,  cirnum);
							
						}
						
						System.out.println("같은횟수"+ cnt);
					}
					buf.close();
			 	}catch (IOException e) {
			 		System.out.println("파일이 없습니다");
			    }
	
	 }
	public static void main(String[] args) throws FileNotFoundException {
		
		fromFile();
		
		for( String x : arr) {
			System.out.println(x);
		}
		System.out.println(arr[1]);
	}

}
