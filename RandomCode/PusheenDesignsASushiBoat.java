import java.util.*;
public class PusheenDesignsASushiBoat {
	public static int fish[];
	public static int N;
	public static int MOD = 998244353;
	public static int find(int i, int k) {
		if(k==0)return 1;
		if(N-i<k)return 0;
		if(i>N)return 0;
		return (fish[i]%MOD*find(i+1,k-1)%MOD+find(i+1,k)%MOD)%MOD;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		 N = input.nextInt();
		int K = input.nextInt();
		fish = new int[N+5];
		for(int i = 0; i < N; i++) {
			int j = input.nextInt();
			fish[j]++;
			fish[j]%=MOD;
		}
		System.out.println(find(1,K));
	}

}
