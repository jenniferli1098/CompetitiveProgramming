import java.util.Scanner;
public class Marathon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int N,Q;
		N = input.nextInt();
		Q = input.nextInt();
		int [] pSum = new int[N+1];
		pSum[0] = 0;
		for(int i = 1; i <= N; i++) {
			pSum[i] = input.nextInt()+pSum[i-1];
		}
		for(int i = 0; i < Q; i++) {
			int a,b;
			a = input.nextInt();
			b = input.nextInt();
			System.out.println(pSum[N]-pSum[b]+pSum[a-1]);
			//System.out.println(i);
		}
	}

}
