
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		/*
		 * M[j] - stores the index k of the smallest value of X[k] at
		 * P[k] - stores the index of the predecessor of X[k]
		 */
		int N = 10;
		//int [] X = new int[N];
		int [] X = {1,2,3,4,7,6,7,10,9,10};
		int [] P = new int[N];
		int [] M = new int[N+1];
		int L = 0;
		for(int i = 0; i < N; i++) {
			//binary search for the largest positive j<=L
			//such that X[M[j]] <= X[i]
			int lo = 1;
			int hi = L;
			while(lo<=hi) {
				int mid = (lo+hi+1)/2;
				if(X[M[mid]] <= X[i]) {
					lo= mid+1;
				}else {
					hi = mid-1;
				}
			}
			//After searching, lo is 1 greater than the
			// length of the longest prefix of X[i]
			int newL = lo;
			
			// The predecessor of X[i] is the last index of 
			// the subsequence of length newL-1
			P[i] = M[newL-1];
			M[newL] = i;
			if(newL>L) {
				//if we've found a subsequence longer than before, update L
				L = newL;
			}
			
		}
		int [] S = new int [L];
		int k = M[L];
		for(int i = L-1; i >=0; i--) {
			S[i] = X[k];
			k = P[k];
			System.out.println(S[i]);
		}
		
	}

}
