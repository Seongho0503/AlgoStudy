
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
//메모리 293532kb	시간 484ms
//완전탐색으로 풀었다가 시간 초과되어서 백트래킹을 써서 간신히 줄였다. 현재 탐색 경로가 해가 될 가능성이 있는지 판단하기가 애매해서
//너무 진전이 없는 탐색 경로만 종료하도록 했다. 실행 시간 1초 단위로 단계를 나눠서 현재 이모티콘 개수를 저장한다. 각 단계에는 시간에 따라 
//이모티콘 개수의 최대값이 저장되며, 현재 탐색 경로가 시간상으로 5단계 이전의 개수보다도 적으면 종료하도록 했다.
public class B14226 {
	static int s;
	static int min_time = Integer.MAX_VALUE;
	static int complete;
	static int[] level;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		s = Integer.parseInt(rd.readLine());
		// 복사 붙여넣기 한 상태로 시작
		// 현재 화면 이모티콘 수
		int num = 2;
		// 현재 클립보드 이모티콘 수
		int current = 1;
		// 현재 시간
		int time = 2;
		level = new int[100];
		int[] state = { num, current, time };
		check(state);
		System.out.println(min_time);

	}

	// 복사 붙여넣기
	static int[] task1(int[] stat) {
		int[] state = stat.clone();
		// current는 num으로
		state[1] = state[0];
		// num은 2배로 증가
		state[0] *= 2;
		// time은 2증가
		state[2] += 2;
		return state;
	}

	// 붙여넣기
	static int[] task2(int[] stat) {
		int[] state = stat.clone();
		// num은 current만큼 증가
		state[0] += state[1];
		// time 1증가
		state[2] += 1;
		return state;
	}

	// 화면 1개 삭제
	static int[] task3(int[] stat) {
		int[] state = stat.clone();
		// num은 1감소
		state[0] -= 1;
		// time 1증가
		state[2] += 1;
		return state;
	}

	// level[시간] : 이모티콘 개수
	static void check(int[] state) {
		//탐색 경로 중 최초로 해당 단계에 도달했거나, 현재 탐색 경로가 기록보다 값이 클 때 갱신
		if (level[state[2]] == 0 || level[state[2]] < state[0]) {
			level[state[2]] = state[0];
		}
		//현재 탐색 경로가 기록보다 5단계 이상 뒤쳐질 경우 리턴
		if (state[2] > 5 && state[0] < s) {
			if (level[state[2] - 5] > state[0]) {
				return;
			}
		}
		//현재까지의 최소 시간보다 크면 리턴
		if (state[2] > min_time)
			return;
		//현재 화면의 이모티콘이 목표 개수보다 작을 경우
		if (state[0] < s) {
			check(task1(state));
			check(task2(state));
			check(task3(state));
		} 
		//현재 화면의 이모티콘이 목표 개수와 같을 경우
		else if (state[0] == s) {
			if (min_time > state[2]) {
				min_time = state[2];
			}
		} 
		//현재 화면의 이모티콘이 목표 개수 넘어갔을 경우
		else {
			state[2] += state[0] - s;
			if (min_time > state[2]) {
				min_time = state[2];
			}
		}
	}

}
