import java.util.*;
public class BalancedTree {
	public static long [] dp ;
	public static int n;
	public static HashMap<Integer, Long> mp = new HashMap<>();
	public static long find(int N) {
		/*if(N<=n/2&&dp[N]!=0) {
			return dp[N];
		}*/
		
		if( N <= Math.sqrt(n) && dp[N]!=0) return dp[N];
		if(N>=(int)Math.sqrt(n)&& mp.containsKey(N)) return mp.get(N);
		
		long sum = 0;
		
		for(int i = 1; i <= (int)Math.sqrt(N);i++) {
			if(i!=1) {
				sum+=find(N/i);
			}
			sum+=((N/(i))-(N/(i+1)))*find(i);
		}
		if((int)Math.sqrt(N)==N/(int)Math.sqrt(N)) {
			sum-=find((int)Math.sqrt(N));
		}
		//sum+=(N-(N/2))*find(1);
		if(N<=(int)Math.sqrt(n)) {
			dp[N] = sum;
		}else{
			mp.put(N, sum);
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		 n = input.nextInt();
		dp = new long[(int)Math.sqrt(n) + 5];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		// mp.put(1, (long)1);
		// mp.put(2, (long)1);
		// mp.put(3, (long)2);
		System.out.println(find(n));
	}

}
