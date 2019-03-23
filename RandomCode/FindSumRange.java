import java.util.Scanner;
public class FindSumRange {
	
	public static int n;
	public static int tree[];
	//public static int lazy[] = new int[2*n];
	public static int A[];
	
	public static void build(int node, int start, int end)
	{
	    if(start == end)
	    {
	        // Leaf node will have a single element
	        tree[node] = A[start];
	    }
	    else
	    {
	        int mid = (start + end) / 2;
	        // Recurse on the left child
	        build(2*node, start, mid);
	        // Recurse on the right child
	        build(2*node+1, mid+1, end);
	        // Internal node will have the sum of both of its children
	        tree[node] = tree[2*node] + tree[2*node+1];
	    }
	}
	
	public static void update(int node, int start, int end, int idx, int val)
	{
	    if(start == end)
	    {
	        // Leaf node
	        A[idx] += val;
	        tree[node] += val;
	    }
	    else
	    {
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
	        tree[node] = tree[2*node] + tree[2*node+1];
	    }
	}
	
	public static int queryRange(int node, int start, int end, int l, int r)
	{
	    if(start > end || start > r || end < l)
	        return 0;         // Out of range
	    if(start >= l && end <= r)             // Current segment is totally within range [l, r]
	        return tree[node];
	    int mid = (start + end) / 2;
	    int p1 = queryRange(node*2, start, mid, l, r);         // Query left child
	    int p2 = queryRange(node*2 + 1, mid + 1, end, l, r); // Query right child
	    return (p1 + p2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		tree = new int[2*(n+2)];

		A = new int[n+1];
		for(int i = 0; i < n; i++) {
			A[i] = input.nextInt();
		}
		build(1,0,n-1);
		int M = input.nextInt();
		for(int k = 0; k < M; k++) {
			String s = input.next();
			int a = input.nextInt();
			int b = input.nextInt();
			if(s.equals("Q")) {
				System.out.println(queryRange(1,0,n-1,a-1,b-1));
			}else {
				int diff = b-queryRange(1,0,n-1,a-1,a-1);
				
				update(1,0,n-1,a-1,diff);
			}
		}
	}

}
