import java.util.*;
public class SegmentTree {
	public static int n = 10;
	public static int tree[] = new int[2*(n+2)];
	public static int lazy[] = new int[2*(n+2)];
	public static int A[] = new int[n];
	
	public static void build(int node, int start, int end)
	{
		
		if(start==end) {tree[node] = A[start];return;}
		int mid = (start+end)/2;
		build(2*node, start, mid);

		build(2*node+1, mid+1, end);
		tree[node] = tree[2*node] + tree[2*node+1];
	}
	
	public static void update(int node, int start, int end, int idx, int val)
	{
		if(start == end)
	    {
	        // Leaf node
	        A[idx] += val;
	        tree[node] += val;
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
        tree[node] = tree[2*node] + tree[2*node+1];
	}
	
	
	public static void updateRange(int node, int start, int end, int l, int r, int val)
	{
	    if(lazy[node] != 0)
	    { 
	        // This node needs to be updated
	        tree[node] += (end - start + 1) * lazy[node];    // Update it
	        if(start != end)
	        {
	            lazy[node*2] += lazy[node];                  // Mark child as lazy
	            lazy[node*2+1] += lazy[node];                // Mark child as lazy
	        }
	        lazy[node] = 0;                                  // Reset it
	    }
	    if(start > end || start > r || end < l)              // Current segment is not within range [l, r]
	        return;
	    if(start >= l && end <= r)
	    {
	        // Segment is fully within range
	        tree[node] += (end - start + 1) * val;
	        if(start != end)
	        {
	            // Not leaf node
	            lazy[node*2] += val;
	            lazy[node*2+1] += val;
	        }
	        return;
	    }
	    int mid = (start + end) / 2;
	    updateRange(node*2, start, mid, l, r, val);        // Updating left child
	    updateRange(node*2 + 1, mid + 1, end, l, r, val);   // Updating right child
	    tree[node] = tree[node*2] + tree[node*2+1];        // Updating root with max value 
	}

	public static int queryRange(int node, int start, int end, int l, int r)
	{
	    if(start > end || start > r || end < l)
	        return 0;         // Out of range
	    if(lazy[node] != 0)
	    {
	        // This node needs to be updated
	        tree[node] += (end - start + 1) * lazy[node];            // Update it
	        if(start != end)
	        {
	            lazy[node*2] += lazy[node];         // Mark child as lazy
	            lazy[node*2+1] += lazy[node];    // Mark child as lazy
	        }
	        lazy[node] = 0;                 // Reset it
	    }
	    if(start >= l && end <= r)             // Current segment is totally within range [l, r]
	        return tree[node];
	    int mid = (start + end) / 2;
	    int p1 = queryRange(node*2, start, mid, l, r);         // Query left child
	    int p2 = queryRange(node*2 + 1, mid + 1, end, l, r); // Query right child
	    return (p1 + p2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		n = 5;
		tree = new int[2*(n+2)];
		build(1,0,5);		//the tree[] start from 1, 0 and 5 are index of A array
		
		for(int i = 1; i < 2*n+4; i++) {
			//System.out.print(tree[i]+" ");
		}
		update(1,0,5,0,2);
		for(int i = 1; i < 2*n+4; i++) {
			//System.out.print(tree[i]+" ");
		}
		System.out.println(queryRange(1,0,5,2,4));
	}

}
