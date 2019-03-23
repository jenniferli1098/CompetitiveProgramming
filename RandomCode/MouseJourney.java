import java.util.*;
public class MouseJourney {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int y = input.nextInt();
		int ways [][] = new int[x+1][y+1];
		boolean vis [][] = new boolean[x+1][y+1];
		int k = input.nextInt();
		for(int i = 0; i < k; i++) {
			int q = input.nextInt();
			int w = input.nextInt();
			vis[q][w] = true;
		}
		Queue<Integer> xs = new LinkedList<Integer>();
		Queue<Integer> ys = new LinkedList<Integer>();
		xs.add(1);
		ys.add(1);
		ways[1][1] = 1;
		while(!xs.isEmpty()) {
			
			int nx = xs.peek(); xs.remove();
			int ny = ys.peek(); ys.remove();
			if(vis[nx][ny])continue;
			int tex = nx+1;
			int tey = ny;
			if(tex<=x&&tey<=y) {
				ways[tex][tey] += ways[nx][ny];
				xs.add(tex);
				ys.add(tey);
			}
			tex = nx;
			tey = ny+1;
			if(tex<=x&&tey<=y) {
				ways[tex][tey] += ways[nx][ny];
				xs.add(tex);
				ys.add(tey);
			}
			vis[nx][ny]= true;
		}
		System.out.println(ways[x][y]);
		
	}

}
