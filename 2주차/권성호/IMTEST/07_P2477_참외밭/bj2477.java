package IMTEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

// 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4로 나타낸다.
// 1 -2 / 3- 4



public class bj2477 {
	//입력 받은 방향 값 중 
	//변수명에 row 는 가로이고 2번쨰 줄부터 입력 값에서 맨 앞에 방향 값 중 동, 서 방향 값들을 담음 
	//변수명에 col 는 세로이고 2번쨰 줄부터 입력 값에서 맨 앞에 방향 값 중 북, 남 방향 값들을 담음
	// 변수명에 B이 있으면 가로 값 중에서 가장 큰 값을 뜻함
	// Brow는 동,서 방향 중 가장 큰 값
	// Bcol는 북,남 방향 중 가장 큰 값
	// S는 small 이란 뜻으로 가장 작은 값을 의미함
	// 내가 왜 가로,세로 중 가장 큰 값들과 가장 작은 값들을 찾았냐면 그림 참고!! (글로 설명이 어렵다 이 문제)
	static int Brow, Bcol;
	static int Srow, Scol;
	static int num;
	
	
	//가장 큰 변과 가장 작은 변의 길이 찾기 
	static void isBig(int k, int m) {
		//k가 1, 2 는 동,서 가로 방향이다 
		if(k<3) { 
			// 맨 처음에 Brow는 선언만 했으니 초기값이 0이다 = 아직 입력 값이 없을 때 = 가장 큰 가로, 세로도 안 정해졌으니
			// 이 경우에는 가장 큰 값 (가로든 세로든) 처음 입력이 들어온 값으로 한 번 초기화를 해준다
			// 이 부분이 왜 필요하냐면 Srow나 Scol은 처음에 0이 디폴트 값인데 (입력 값을 한 번 안 넣어주면) (Srow >m ) 이 조건식을 성립하는 경우가 없다 (0>m) 인데 
			// 한번 맨 작은 값들을 입력 값을 한 번 넣어주는 작업이 필요하다 (*부분 주석 적은 곳)
			
			if(Brow == 0) Brow =Srow = m; // *
			if(Brow < m) Brow = m; // 가장 긴 가로 길이를 갱신시킴
			else if(Srow >m ) Srow =m;  // 가장 작은 가로 길이를 갱신시킴
		// k가 3,4는 북, 남 세로 방향이다	
		}else if(k>=3) {
			if(Bcol == 0) Bcol =Scol = m; //*
			if(Bcol <m) Bcol = m; // 가장 긴 세로 길이를 갱신시킴
			else if(Scol >m ) Scol =m; // 가장 작은 세로 길이를 갱신시킴
		}
	}
	public static void main(String[] args) /*throws NumberFormatException, IOException */{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			num = Integer.parseInt(br.readLine());
			String str;
			//내가 이 문제에서 가장 머리아픈 부분  bufferedReader에서 readline은 공백포함해서 입력 받는데 마지막 입력 1 100까지 하고 출력을 안하는 거임
			// 100 입력받고 개행문자가 (엔터)가 없으니 출력이 안되서 
			//try ~ catch문으로 입력을 끝냄
			// 이문제는 테케 수가 없어서 다들 while 조건문을 숫자로 하지 말고 해보는 것도 좋을 듯
			// 테케 수가 안 정해져있는 알고리즘 문제를 EOR 문제라고 한데 (사용자가 알아서 입력 값이 없으면 종료 시키는 문제)
			// br.readline이 읽을게 없으면 null return하는 것으로 알고 있어서 조건식을 저리 짰는데도 NoSuchElementException 이 떠서
			// catch로 잡아서 강제로 종료시킴
			while( (str =br.readLine()) != null) { // 이부분 조건식 + catch문으로 입력 값이 없을 때 종료시킴
				StringTokenizer st = new StringTokenizer(str);
				int k = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				// 스위치로 입력 값을 방향과 길이로 나누어서 동,서는 가로이니깐 둘이 묶고 남,북은 세로이니깐 둘이 묶어서 함수에 넓음
				switch(k) {
				case 1: // 동쪽
				case 2:  // 서쪽
					isBig(k,m);
					break;
				case 3: // 남쪽
				case 4: // 북쪽
					isBig(k,m);
					break;
				}	
				//System.out.println("합"+((Bcol*Brow)-(Scol*Srow))*num); 디버깅용
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NoSuchElementException e) {
			//가장 큰 길이(가로x세로)로 만든 사각형에서 가장 작은 길이(가로x세로)로 만든 사각형을 빼주고 양배추 개수 num(7)을 곱함
			System.out.println(((Bcol*Brow)-(Scol*Srow))*num); 
		}	
		//System.out.println("Bcol" + Bcol + "Brow" + Brow); 디버깅용
		///System.out.println("Scol" + Scol + "Srow" + Srow);	디버깅용
	}

}
