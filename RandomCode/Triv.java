import java.util.*;



public class Triv {

	public static class pair implements Comparable <pair>{
		public int first;
		public int second;
		
		public pair(int a, int b) {
			this.first = a;
			this.second = b;
		}
		public int compareTo( pair b) {
			if(first>b.first) {
    			return 1;
    		}else if(first<b.first) {
    			return -1;
    		}
    		else if(second>b.second) {
    			return -1;
    		}else if(second<b.second) {
    			return 1;
    		}
    				
    		return 0;
        }

		
	}
	
	
	
	
	
	public static boolean[]vis;
	public static int [] dis;
	public static int []parent;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		parent = new int[N];
		boolean [] isPho = new boolean [N];
		for(int i = 0; i < M; i++) {
			int k = input.nextInt();
			isPho[k] = true;
		}
		ArrayList<Integer> adj[] = new ArrayList[N];
		for(int i = 0; i<N; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0; i<N-1; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		dis = new int[N];
		vis = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		//assume 0 as root first
		vis[0] = true;
		parent[0] = 0;
		q.add(0);
		dis[0] = 0;
		int totalDis = 0;
		while(!q.isEmpty()) {
			//System.out.println("Hi");
			int node = q.peek();q.remove();
			for(int i = 0; i < adj[node].size(); i++) {
				int next = adj[node].get(i);
				if(parent[node]!=next) {
					parent[next] = node;
					dis[next] = dis[node]+1;
					q.add(next);
				}
				//System.out.println(next+" "+dis[next]);
				
			}
		}
		
		//oops i misread
		int root = -1;
		int maxdist = 0;
		for(int i = 0; i < N; i++) {
			if(isPho[i]) {
				//System.out.println(i+" "+dis[i]);
				if(dis[i]>maxdist) {
					maxdist = dis[i];
					root = i;
				}
			}
		}

		//System.out.println(7+" "+dis[7]);
		//set root as max
		dis = new int[N];
		vis = new boolean[N];
		parent = new int[N];
		vis[root] = true;
		parent[root] = root;
		
		q.add(root);
		maxdist = 0;
		while(!q.isEmpty()) {
			//System.out.println("Hi");
			int node = q.peek();q.remove();
			for(int i = 0; i < adj[node].size(); i++) {
				int next = adj[node].get(i);
				if(parent[node]!=next) {
					parent[next] = node;
					dis[next] = dis[node]+1;
					
					q.add(next);
					if(isPho[next]) {
						if(dis[next]>maxdist) {
							maxdist = dis[next];
						}
						//process distance
						totalDis+=2*findlength(next);
					}
				}
				
			}
		}
		//System.out.println(root+" "+dis[root]);
		//System.out.println(maxdist);
		System.out.println(totalDis-maxdist);
	
		
		
		
	}
	public static int findlength(int next) {
		// TODO Auto-generated method stub
		if(vis[next]) {
			return 0;
		}
		vis[next] = true;
		return 1+findlength(parent[next]);
	}

}