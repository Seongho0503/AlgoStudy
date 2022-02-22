
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//기둥 xy값 저장 클래스
class xy {
	Integer x;
	Integer y;

	public xy(int x, int y) {
		super();
		this.x = x;
		this.y = y;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(x:" + x + " y:" + y + ")";
	}
}

public class B2304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		List<xy> xylist = new ArrayList<xy>();
		int n = Integer.parseInt(rd.readLine());
		for (int i = 0; i < n; i++) {
			String input[] = rd.readLine().split(" ");
			xylist.add(new xy(Integer.parseInt(input[0]), Integer.parseInt(input[1])));

		}

		// x값 기준으로 정렬
		Collections.sort(xylist, (o1, o2) -> o1.x.compareTo(o2.x));
		//System.out.println(xylist.toString());
		int sum = 0;
		int x = xylist.get(0).x;
		int y = xylist.get(0).y;
		int idx = 0;
		if(xylist.size()==1) {
			sum+=y;
		}
		
		//높이가 높아지는 상태인지
		boolean up=true;
		
		while (idx < xylist.size()-1) {
			idx++;
			// 인덱스 임시 저장
			int tmp = idx;

			// 더 높은 기둥이 나올 때까지 우측으로 탐색
			while ( idx< xylist.size()) {
				if(xylist.get(idx).y > y ) {
					break;
				}
				idx++;
			}
			if(idx== xylist.size())idx--;
			
			// 더 높은 기둥 있으면
			if (xylist.get(idx).y > y) {
				//높이 높아지는중
				up=true;
				// 이전 기둥에서 현재 기둥 전까지의 넓이 더함(길이*높이)
				sum += (xylist.get(idx).x - x) * y;
				tmp = idx;
			} 
			// 더 높은 기둥 없으면
			else {
				// 인덱스 다시 되돌림
				idx = tmp;
				
				//높이가 높아지는 중이었으면
				if(up) {
					// 현재 기둥만큼의 넓이 저장
					sum += y;
				}
				
				//높이 낮아지는 중
				up=false;
				int max = 0;
				int max_idx = 0;

				// 오른쪽에서 가장 높은 기둥 탐색
				while (idx < xylist.size()) {
					if (xylist.get(idx).y > max) {
						max = xylist.get(idx).y;
						max_idx = idx;
					}
					idx++;
				}
				if(idx== xylist.size())idx--;
				
				// 오른쪽에서 가장 높은 기둥까지의 넓이 더함
				sum += (xylist.get(max_idx).x - x) * xylist.get(max_idx).y;
				tmp = max_idx;
			}
			// 인덱스 마지막 처리 지점으로 이동
			idx = tmp;
			x = xylist.get(idx).x;
			y = xylist.get(idx).y;
			//System.out.println(sum);
			//높이 높아지는 상태일 때에 현재 마지막 기둥일 경우 넓이가 더해지지 않은 상태이므로
			if(idx==xylist.size()-1&&up==true) {
				sum+=xylist.get(idx).y;
			}
		}
		System.out.println(sum);

	}

}
