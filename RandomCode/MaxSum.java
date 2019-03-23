import java.util.*;
public class MaxSum {
	static long[] A;
	static long [] tree;
	static int n;
	static long MOD = 100000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt()-1;
		A = new long[n+1];
		tree = new long[2*(n+2)];
		for(int i = 0; i < n+1; i++) {
			A[i] = (long)input.nextInt();
		}
		build(1,0,n);
		int k = input.nextInt();
		for(int i = 0; i < k; i++) {
			String s = input.next();
			int a = input.nextInt();
			int b = input.nextInt();
			if(s.equals("Q")) {
				long q = query(1,0,n,a-1,b-1);
				
				System.out.println(q/MOD+q%MOD);
			}else {
				update(1, 0, n, a-1, b);
			}
		}
		
	}
	static void build(int node, int start, int end) {
		if(start==end) {tree[node] = A[start];return;}
		int mid = (start+end)/2;
		build(2*node, start, mid);

		build(2*node+1, mid+1, end);
		long [] arr = new long[4];
		arr[0] = tree[2*node]%MOD;
		arr[1] = tree[2*node]/MOD;
		arr[2] = tree[2*node+1]%MOD;
		arr[3] = tree[2*node+1]/MOD;
		Arrays.sort(arr);
		
		tree[node] = arr[2]*MOD+arr[3];
	}
	static void update(int node, int start, int end, int idx, int val)	//update is adding an amount to 
	{
	    if(start == end)
	    {
	        // Leaf node
	        A[idx] = val;
	        tree[node] = val;
	        return;
	    }
        int mid = (start + end) / 2;
        if(start <= idx && idx <= mid)
        {
            // If idx is in the left child, recurse on the left child
            update(2*node, start, mid, idx, val);
        }
        else
        {
            // if idx is in the right child, recurse on the right child
            update(2*node+1, mid+1, end, idx, val);
        }
        // Internal node will have the sum of both of its children
        long [] arr = new long[4];
		arr[0] = tree[2*node]%MOD;
		arr[1] = tree[2*node]/MOD;
		arr[2] = tree[2*node+1]%MOD;
		arr[3] = tree[2*node+1]/MOD;
		Arrays.sort(arr);
		
		tree[node] = arr[2]*MOD+arr[3];
	}
	static long query(int node, int start, int end, int l, int r) {	//adding sum of indices l-r
		if(r<start||end<l)return 0;
		if(l<=start&&end<=r) return (tree[node]);
		int mid = (start+end)/2;
		long p1 = query(2*node, start, mid, l, r);
		long p2 = query(2*node+1, mid+1, end, l, r);
		long [] arr = new long[4];
		arr[0] = p1%MOD;
		arr[1] = p1/MOD;
		arr[2] = p2%MOD;
		arr[3] = p2/MOD;
		Arrays.sort(arr);
		
		return arr[2]*MOD+arr[3];
	}
}
