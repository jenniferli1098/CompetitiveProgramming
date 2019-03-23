import java.util.*;
public class PairProgramming {

	static ArrayList<Integer> adj [];
	static boolean[] vis;
	static boolean[] node;
	static int[] min;
	static int [] max;
	static int [] parent;
	static boolean [] q;
	static int [] children;
	public static void child(int nd) {
		vis[nd]=true;
		
		for(int j = 0; j < adj[nd].size(); j++){
			int i = adj[nd].get(j);
			if(!vis[i]) {
				child(i);
				children[nd] +=children[i]+1;
			}
		}
	}
	public static void dfs(int nd){
		vis[nd]=true;
		boolean uncertain = q[nd];
		int ma = 0;
		int mi = 0;
		if(!node[nd]) {	//is incorrect the number of errors is at least one
			ma++;
			mi++;
		}
		
		for(int i = 0; i < adj[nd].size(); i++){
			
			int j = adj[nd].get(i);
			
			if(!vis[j]){	
				if(!node[nd]&&!q[nd]){	// changes the child node to different
					node[j] = !node[j];
					
				}
				dfs(j);
				
				int total = children[j]+1;
				if(uncertain) {
					//max (right, wrong)
					ma+= Math.max(max[j], total-min[j]+1);
					mi+= Math.min(min[j], total-max[j]+1);
				}else if(node[nd]) {
					ma += max[j];
					mi += min[j];
				}else {
					ma +=total-min[j];
					mi +=total-max[j];
					
				}
					
				
			}
		}
		max[nd] = ma;
		min[nd] = mi;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		adj = new ArrayList[N+1];
		vis = new boolean[N+1];
		node = new boolean[N+1];
		min = new int[N+1];
		max = new int[N+1];
		parent = new int[N+1];
		children = new int[N+1];
		q = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i <= N; i++) {
			String s = input.next();
			if(s.equals("C")) {
				parent[i] = -1;
				String c = input.next();
				node[i] = true;
				if(c.equals("WA")) {
					node[i] = false;
				}else if(c.equals("?")) {
					q[i] = true;
				}
			}else {
				int p= input.nextInt();
				parent[i]  = p;
				adj[i].add(p);
				adj[p].add(i);
				String c = input.next();
				node[i] = true;
				if(c.equals("WA")) {
					node[i] = false;
				}else if(c.equals("?")) {
					q[i] = true;
				}
			}
			
		}
		
		int cMin = 0;
		int cMax = 0;
		for(int i = 1; i <= N; i++ ) {
			if(parent[i] == -1) {
				child(i);
				System.out.println(children[i]);
				vis = new boolean[N+1];
				dfs(i);
				cMin+=min[i];
				cMax+=max[i];
			}
			
		}
		
		System.out.println(cMin+" "+cMax);
		

	}

}
