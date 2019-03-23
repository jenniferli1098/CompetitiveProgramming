import java.util.*;

public class dmopc15c3p4Contagion {

	static int[] x;
	static int[] y;
	static int[] dis;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long big = 1000000000;

		int N = input.nextInt();
		x = new int[N + 1];
		y = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			x[i] = input.nextInt();
			y[i] = input.nextInt();
		}

		int Ind = input.nextInt();

		
		
		long Q = input.nextInt();
		Arrays.sort(dis);
		for (int a = 0; a < Q; a++) {
			long h = input.nextInt();
			int ind = 2;
			while (dis[ind] <= h) {
				ind++;
			}
			ind--;
			System.out.println(ind);
		}

	}

}
