import java.util.*;
public class Height_rgss4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int [] nums = new int[N+1];
		int [] dp = new int[N+1];
		for(int i = 1; i <= N; i++) {
			nums[i] = input.nextInt();
		}
		
		dp[1] = nums[1];
		for(int i = 1; i <= N; i++ ) {
			dp[i] = nums[i];
			for(int k = 1; k <i; k++ ) {
				if(nums[k]<nums[i]) {
					dp[i] = Math.max(dp[i], dp[k]+nums[i]);
				}
			}
		}
		int max = dp[1];
		for(int k:dp) {
			if(k>max) {
				max = k;
			}
		}
		System.out.println(max);
		
		
	}

}
