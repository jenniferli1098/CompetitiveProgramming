import java.util.*;
public class RoboThieves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		in.nextLine();
		char[][]map = new char[N][M];
		boolean[][]marked = new boolean[N][M];
		int dis[][] = new int[N][M];
		ArrayList<Integer>xcon = new ArrayList<>();
		ArrayList<Integer>ycon = new ArrayList<>();
		int [] start = new int[2];

		ArrayList<Integer>cx = new ArrayList<>();
		ArrayList<Integer>cy = new ArrayList<>();
		
		ArrayList<Integer>xe = new ArrayList<>();
		ArrayList<Integer>ye = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String s = in.nextLine();
			for(int k = 0; k < M; k++) {
				dis[i][k] = 1<<30;
				char c = s.charAt(k);
				map[i][k] = c;
				if(c=='W') {
					marked[i][k] = true;
				}
				else if(c=='C') {
					cx.add(i);
					cy.add(k);
					
				}
				else if(c=='S') {
					start[0] = i;
					start[1] = k;
					dis[i][k] = 0;
					//marked[i][k] = true;
				}
				else if(c=='.') {
					xe.add(i);
					ye.add(k);
				}
				else {//conveyor
					xcon.add(i);
					ycon.add(k);
				}
			}
		}
		for(int i = 0;i < cx.size();i++) {
			int x=  cx.get(i);
			int y = cy.get(i);
			int a = x;
			while(map[a][y]!='W') {
				marked[a][y] = true;
				a++;
			}
			 a = x;
			while(map[a][y]!='W') {
				marked[a][y] = true;
				a--;
			}
			a = y;
			while(map[x][a]!='W') {
				marked[x][a] = true;
				a--;
			}
			a = y;
			while(map[x][a]!='W') {
				marked[x][a] = true;
				a++;
			}
		}
		for(int i = 0;i < xcon.size();i++) {
			int x = xcon.get(i);
			int y = ycon.get(i);
			marked[x][y] = false;
		}
		
		Queue<Integer> xs = new LinkedList<Integer>();
		Queue<Integer> ys = new LinkedList<Integer>();
		if(!marked[start[0]][start[1]]) {
		xs.add(start[0]);ys.add(start[1]);
		}
		while(!xs.isEmpty()) {
			int x = xs.peek(); xs.remove();
			int y = ys.peek(); ys.remove();
		
			if("UDRL".contains(""+map[x][y])) {
				int nx = 0;
				int ny = 0;
				if(map[x][y]=='U') {
					nx = x-1;
					ny = y;
				}else if(map[x][y]=='D') {
					nx = x+1;
					ny = y;
					//System.out.println("hi");
				}
				else if(map[x][y]=='L') {
					nx = x;
					ny = y-1;
				}else if(map[x][y]=='R') {
					nx = x;
					ny = y+1;
				}
				if(!marked[nx][ny]) {
					//marked[nx][ny]=true;
					if(dis[x][y]<dis[nx][ny]) {
						dis[nx][ny] = dis[x][y];
						xs.add(nx);
						ys.add(ny);
					}
				}
				continue;
			}
			int trans [][]= {{0,1},{0,-1},{1,0},{-1,0}};
			for(int i = 0; i < 4; i++) {
				int nx = x+trans[i][0];
				int ny = y+trans[i][1];
				if(!marked[nx][ny]) {
					//marked[nx][ny]=true;
					if(dis[x][y]+1<dis[nx][ny]) {
						dis[nx][ny] = dis[x][y]+1;
						xs.add(nx);
						ys.add(ny);
					}
					
				}
			}
		}
		for(int i = 0; i < xe.size(); i++) {
			if(dis[xe.get(i)][ye.get(i)]<(int)(1<<30)) {
				System.out.println(dis[xe.get(i)][ye.get(i)]);
			}else {
				System.out.println(-1);
			}
		}
		
		
		
	}

}

/*
7 5
WWWWW
WS.WW
WDWCW
W...W
WR.DW
W.L.W
WWWWW
1
1
2
-1
2
3
-1
*/