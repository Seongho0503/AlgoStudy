
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//거의 되는 것 같지만 시간초과..

public class B10158 {
	private static int[] dx = {1,1,-1,-1};  //0:우상 1:우하 2:좌상 3:좌하
	private static int[] dy = {1,-1,1,-1};  
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
			
		
			String s[]=rd.readLine().split(" ");
			int w =Integer.parseInt(s[0]);
			int h =Integer.parseInt(s[1]);
			String s2[]=rd.readLine().split(" ");
			int x =Integer.parseInt(s2[0]);
			int y =Integer.parseInt(s2[1]);
			int t=Integer.parseInt(rd.readLine());
			//우상 방향으로 시작
			int dir=0;
			
			while(t!=0) {
				
				//경계면까지 남은 거리
				int dis=0;
				switch (dir) {
				case 0:
					dis=Math.min(w-x, h-y);
					break;
				case 1:
					dis=Math.min(w-x, y);
					break;
				case 2:
					dis=Math.min(x, h-y);
					break;
				case 3:
					dis=Math.min(x, y);
					break;

				}
				//시간이 공간 경계면에 닿을 시간 초과하여 남아 있으면
				if(t>dis) {
					System.out.println("t: "+t+"  x: "+x+"  y: "+y+"  dir: "+dir);
					//경계에 닿을 때까지 이동, 시간 그만큼 감소
					t-=dis;
					x = x + (dx[dir]*dis);
					y = y + (dy[dir]*dis);
					System.out.println("t: "+t+"  x: "+x+"  y: "+y+"  dir: "+dir+"  x이동: "+(dx[dir]*dis)+"  y이동:  "+(dy[dir]*dis));
				}
				else {
					x = x + (dx[dir]*t);
					y = y + (dy[dir]*t);
					t=0;
				}
				//0:우상 1:우하 2:좌상 3:좌하
				//꼭지점일 경우
				if(x==0&&y==0) {
					dir=0;
				}
				else if(x==w&&y==0) {
					dir=2;
				}
				else if(x==0&&y==h) {
					dir=1;
				}
				else if(x==w&&y==h) {
					dir=3;
				}
				//현재 우상 방향이고, 위쪽 경계 닿으면 
				else if(y==h&&dir==0)
					dir=1;
				//현재 우상 방향이고, 오른쪽 경계 닿으면 
				else if(x==w&&dir==0)
					dir=2;
				//현재 우하 방향이고, 아래쪽 경계 닿으면 
				else if(y==0&&dir==1)
					dir=0;
				//현재 우하 방향이고, 오른쪽 경계 닿으면 
				else if(x==w&&dir==1)
					dir=3;
				//현재 좌상 방향이고, 왼쪽 경계 닿으면 
				else if(x==0&&dir==2)
					dir=0;
				//현재 좌상 방향이고, 위쪽 경계 닿으면 
				else if(y==h&&dir==2)
					dir=3;
				//현재 좌하 방향이고, 왼쪽 경계 닿으면 
				else if(x==0&&dir==3)
					dir=1;
				//현재 좌하 방향이고, 아래쪽 경계 닿으면 
				else if(y==0&&dir==3)
					dir=2;
			}
			System.out.println(x+" "+y);
			
			
		}
	
}
