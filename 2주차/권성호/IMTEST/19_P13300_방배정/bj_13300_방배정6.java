package bj_13300_방배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_13300_방배정6 {

	//방개수
	static int numroom;
	// 최대인원
	static int max;
	// 여자, 남자 방 리스트
	static ArrayList <Integer> man  = new ArrayList<>(6);
	static ArrayList <Integer> girl  = new ArrayList<>(6);
	
	// 방 몇개 있는지 알아내는 함수
	static int Howmanyroom (ArrayList<Integer> list) {
		// 남 . 녀 따로 구분하기 위해서 초기화 0으로 시킴  
		numroom =0;
		for(int k = 0 ; k<list.size(); k++) {
			// 리스트 요소 값이 max(최대인원)과 딱 나누어 떨어질 때
			if(list.get(k) %max==0) {
				numroom+= list.get(k)/max;
				// 리스트 요소 값이 max 보다 클 때
			}else if( list.get(k) > max) {
				numroom= numroom + list.get(k)/max +1;
			}
			// 리스트 요소 값이 max 보다 작을 때
			else if(list.get(k)< max) {
				numroom++;
			}
			
		}
		return numroom;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		
		// if문에서 set함수를 사용하려면 
		// 리스트에 이미 값이 있어야 해서 0으로 초기화 시켜줌
		// 배열은 크기만 정해주면 자동 초기화 되는데 리스트는 크기 정해줘도 0으로 초기화 안되서 
		// 0값을 임의로 넣어줌 (혹시 이거 리스트도 자동초기화 하는 방법 아시는분 공유점) 
		for(int i=0; i<6;i++) {
			man.add(0);
			girl.add(0);
		}
		
		while (num > 0) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st1.nextToken());
			int grade = Integer.parseInt(st1.nextToken());
			
			
			//자문자답
			//리스트는 사이즈를 정해도 초기화가 안되나?? add 안하면 set을 사용 못하네 (set은 기존의 있던 인덱스에 추가하네)
			
			//남성
			if(sex==1) {    
				//grade 학년은 1학년부터 시작하고 index는 0부터 시작해서 1 뻄
				man.set(grade-1, man.get(grade-1)+1);
				
			// sex==0일때 여성 	
			} else {
				girl.set(grade-1, girl.get(grade-1)+1);
		
			}
			// 입력받은 학생 수 를 줄어들면서 while탈출 조건
			num--;
		}
		//남자 방수 + 여자방수
		System.out.println(Howmanyroom(man)+Howmanyroom(girl));
	}
}
