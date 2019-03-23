import java.util.Scanner;

public class DynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int D = input.nextInt();
		int K = input.nextInt();
		int [][] prices = new int [K][D];
		int [][] total = new int[(1<<K)][D];
		//System.out.println(1<<K);
		for(int d = 0; d < D; d++) {
			for(int k = 0; k < K; k++) {
				prices[k][d] = input.nextInt();
			}
		}
		//initiate first ones

		for(int k = 1; k < (1<<K); k++) {
			total[k][0] = 1<<30;
		}
		for(int x = 0; x< K; x++) {
			total[1<<x][0] = prices[x][0];
			//System.out.println(total[1<<x][0]);
		}
		for(int d = 1; d < D; d++) {
			for(int k = 0; k < (1<<K); k++) {
				total[k][d] = total[k][d-1];
				
				for(int x = 0; x < K; x++) {
					//if item is already picked yet
					if((k&(1<<x))>0) {
						//System.out.println(prices[x][d]);
						total[k][d] = Math.min(total[k][d], total[k-(1<<x)][d-1]+prices[x][d]);
					}
				}
			}
		}
		//System.out.println(total[7][3]);
		System.out.println(total[(1<<K)-1][D-1]);

		/*
		for(int d = 0; d < D; d++) {
			for(int k = 0; k < (1<<K); k++) {
				System.out.print(total[k][d]+" ");
			}
			System.out.println();
		}
		*/
		
	}

}
/*
7 3
6 8 5
9 2 3
5 6 9
2 2 7
8 7 3
9 5 5
1 7 1
6 2 4
*/