import java.util.*;
public class XORSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int A = 0;
		int B = 0;
		int presum[] = new int[N+1];
		presum[0] = 0;
		for(int i = 0; i < N; i++) {
			int k = input.nextInt();
			presum[i+1]= k^presum[i];
			//System.out.println(presum[i+1]);
		}
		
		int maxdp[] = new int[N+1];
		int mindp[] = new int[N+1];
		for(int i = 1;i < N+1; i++) {
			mindp[i] = 1<<29;
			for(int k = 0; k < i; k++) {
				//System.out.println((presum[i]^presum[k])+" "+mindp[k]);
				maxdp[i] = Math.max(((presum[i]^presum[k])+maxdp[k]),maxdp[i]);
				mindp[i] = Math.min(((presum[i]^presum[k])+mindp[k]),mindp[i]);
				
				//System.out.println(mindp[i]);
			}
			//System.out.println(mindp[i]+" "+maxdp[i]);
		}
		System.out.println(maxdp[N]-mindp[N]);
		
	}

}
