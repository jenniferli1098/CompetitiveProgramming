public class SegmentTreePractice {
	static int[] A = {1,2,3,1,2,3};
	static int [] tree;
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = 5;
		tree = new int[2*(n+2)];
		build(1,0,5);		//the tree[] start from 1, 0 and 5 are index of A array
		
		for(int i = 1; i < 2*n+4; i++) {
			//System.out.print(tree[i]+" ");
		}
		update(1,0,5,0,2);
		for(int i = 1; i < 2*n+4; i++) {
			System.out.print(tree[i]+" ");
		}
		//System.out.println(query(1,0,5,2,4));
	}
	static void build(int node, int start, int end) {
		if(start==end) {tree[node] = A[start];return;}
		int mid = (start+end)/2;
		build(2*node, start, mid);

		build(2*node+1, mid+1, end);
		tree[node] = tree[2*node] ^ tree[2*node+1];
	}
	static void update(int node, int start, int end, int idx, int val)	//update is adding an amount to 
	{
	    if(start == end)
	    {
	        // Leaf node
	        A[idx] ^= val;
	        tree[node] ^= val;
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
        tree[node] = tree[2*node] ^ tree[2*node+1];
	}
	static int query(int node, int start, int end, int l, int r) {	//adding sum of indices l-r
		if(r<start||end<l)return 0;
		if(l<=start&&end<=r) return tree[node];
		int mid = (start+end)/2;
		int p1 = query(2*node, start, mid, l, r);
		int p2 = query(2*node+1, mid+1, end, l, r);
		return p1^p2;
	}
}
