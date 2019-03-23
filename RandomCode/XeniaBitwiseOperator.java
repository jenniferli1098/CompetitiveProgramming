import java.util.*;
public class XeniaBitwiseOperator {
	public static int tree[];
	public static int temp[];
	public static int A[];
	
	public static void build1(int node, int start, int end)
	{
	    if(start == end)
	    {
	    	//System.out.println("start = "+start+ " node = "+node);
	        // Leaf node will have a single element
	        tree[node] = temp[start];
	    }
	    else
	    {
	        int mid = (start + end) / 2;
	        // Recurse on the left child
	        build2(2*node, start, mid);
	        // Recurse on the right child
	        build2(2*node+1, mid+1, end);
	        // Internal node will have the sum of both of its children
	        tree[node] = tree[2*node] ^ tree[2*node+1];
	    }
	}
	public static void build2(int node, int start, int end)
	{
	    if(start == end)
	    {
	    	//System.out.println("start = "+start);
	        // Leaf node will have a single element
	        tree[node] = temp[start];
	    }
	    else
	    {
	        int mid = (start + end) / 2;
	        // Recurse on the left child
	        build1(2*node, start, mid);
	        // Recurse on the right child
	        build1(2*node+1, mid+1, end);
	        // Internal node will have the sum of both of its children
	        tree[node] = tree[2*node] | tree[2*node+1];
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int n = N;
		N = (int)Math.pow(2,N);
		tree = new int[2*N+2];
		temp = new int[N+2];
		A = new int[N+2];
		int M = input.nextInt();
		for(int i = 0; i < N;i++) {
			A[i] = input.nextInt();
		}
		System.arraycopy( A, 0, temp, 0, A.length );
		for(int i = 0; i < M; i++) {

			//System.arraycopy( A, 0, temp, 0, A.length );
			
			int p,b;
			p = input.nextInt();
			b = input.nextInt();
			temp[p-1] = b;
			
			
			if(n%2==0) {
				build1(1,0,N-1);
			}else {
				build2(1,0,N-1);
			}
			
			System.out.println(tree[1]);
		}
	}

}
