import java.util.*;
public class Cyphertext {
	public static boolean vis[][] = new boolean[401][250];
	public static int dis[][] = new int[401][250];
	public static void main(String [] args) {
		//System.out.println(-3/-2);
		//System.out.println(st);
		Scanner input = new Scanner(System.in);
		String s = input.next();
		int n = input.nextInt();
		int sY = 250;
		int sX = 200;
		int x = -1+sX;
		int y = -5+sY;
		boolean safe = true;
		while(safe&&!s.equals("q")) {
			int dx,dy;
			switch(s) {
				case "u":
					dx = 0;
					dy = 1;
					break;
				case "l":
					dx = -1;
					dy = 0;
					break;
				case "r":
					dx = 1;
					dy = 0;
					break;
				case "d":
					dx = 0;
					dy = -1;
					break;
				default:
					dx = 0;
					dy = 0;
					break;
			}
			for(int i = 1; i <=n;i++) {
				//;
				//;
				if(vis[x+dx*i][y+dy*i]) {
					safe = false;
					break;
				}else {
					vis[x+dx*i][y+dy*i] = true;
				}
			}
			x+=dx*n;
			y+=dy*n;
			if(safe) {
				System.out.println((x-sX)+" "+(y-sY)+" safe");
			}else {
				System.out.println((x-sX)+" "+(y-sY)+" DANGER");
			}
			s = input.next();
			n = input.nextInt();
		}
	}
}

