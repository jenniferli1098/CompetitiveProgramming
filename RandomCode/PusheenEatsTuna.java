import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
class quad{
	public int a,b,c,d,t;
	public quad(int a, int b, int c, int d, int t) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.t = t;
		
	}
}
public class PusheenEatsTuna {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int X = input.nextInt(), Y = input.nextInt();
		int W = input.nextInt();
		int sx = input.nextInt(),sy = input.nextInt();
		int rx = input.nextInt(), ry = input.nextInt();
		ArrayList<Integer> wx = new ArrayList<>();
		ArrayList<Integer> wy = new ArrayList<>();
		for(int i = 0; i < W; i++) {
			wx.add(input.nextInt());
			wy.add(input.nextInt());
		}
		boolean processed[][][][] = new boolean[X+1][Y+1][2*X+4][2*Y+4];
		Comparator<quad> quadComparator = new Comparator<quad>() {
            @Override
            public int compare(quad a, quad b) {
            	//this is the negative comparison
                if(a.t<b.t) {
        			return 1;
        		}else if(a.t>b.t) {
        			return -1;
        		}
        		return 0;
            }
        };
        PriorityQueue<quad> q = new PriorityQueue<>(quadComparator);
        //check if possible
        if(1<=X) {
        //processed[1][0][1+X][0+Y] = true;
        q.add(new quad(1,0,1,0,1));
        }
        if(1<=Y) {
        //processed[0][1][0+X][1+Y] = true;
        q.add(new quad(0,1,0,1,1));
        }
        
        ArrayList<Integer> times = new ArrayList<>();
       // q.add(new pair(-dis[x],x));
		while(!q.isEmpty()) {
			int x = q.peek().a;
			int y = q.peek().b;
			int vx = q.peek().c;
			int vy = q.peek().d;
			int t = q.peek().t;
			q.remove();
			if(x==rx&&y==ry&&vx==0&&vy==0) {
				times.add(t);
			}
			if(processed[x][y][vx+X][vy+Y])continue;
			//System.out.println("hi");
			processed[x][y][vx+X][vy+Y] = true;
			int trans[][] = {{0,0},{0,1},{0,-1},{1,0},{-1,0}};
			for(int i = 0; i < 5; i++) {
				int nvx = vx+trans[i][0];
				int nvy = vy+trans[i][1];
				int nx = x+nvx;
				int ny = y+nvy;
				boolean works = true;
				if(!(nx<=X&&nx>=0&&ny<=Y&&ny>=0)) {
					//System.out.println("hi");
					works = false;
					continue;
				}
				for(int j = 0; j < wx.size();j++) {

					//System.out.println("hi");
					if(wx.get(j)==nx&&wy.get(j)==ny) {
						works = false;
						continue;
					}
				}
				if(works) {
					//System.out.println("hi");
					q.add(new quad(nx,ny,nvx,nvy,t+1));
				}
			}
			
		}
		if(times.isEmpty()) {
			System.out.println(-1);
		}else {
			times.sort(null);
			System.out.println(times.get(0));
		}


		
		
	}

}
