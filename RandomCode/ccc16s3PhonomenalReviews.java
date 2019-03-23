import java.util.*;

public class ccc16s3PhonomenalReviews {

	static ArrayList<Integer>[] adj;
	static int N, M;
	static int[] parent;
	static int[] phoRest;
	static boolean[]isPho;
	static boolean[] vis;
	static int[] numChild;
	static boolean[] discarded;

	static int dis[];
	public static void dfs(int node) {
		vis[node] = true;
		for (int j = 0; j < adj[node].size(); j++) {
			int i = adj[node].get(j);
			if (!vis[i]) {
				parent[i] = node;
				numChild[node]++;
				dfs(i);
			}
		}
	}
	public static void dfsDis(int node) {
		vis[node] = true;
		for (int j = 0; j < adj[node].size(); j++) {
			int i = adj[node].get(j);
			if (!vis[i]&&!discarded[i]) {
				dis[i] = dis[node]+1;
				dfsDis(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		M = input.nextInt();
		adj = new ArrayList[N];
		parent = new int[N];
		phoRest = new int[M];
		isPho = new boolean[N];
		vis = new boolean[N];
		dis = new int[N];
		discarded = new boolean[N];
		numChild = new int[N];
		for(int i= 0; i < N; i++) {
			numChild[i] = 0;
		}
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			phoRest[i] = input.nextInt();
			isPho[phoRest[i]] = true;
		}
		for (int i = 0; i < N - 1; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		int root = phoRest[0];
		dfs(root);
		
		int total=N-1;
		for (int x = 0; x < N; x++) {
			int i=x;
			while(numChild[i]==0&&!isPho[i]&&numChild[i]==0) {     
				numChild[parent[i]]--;
				discarded[i] = true;
				total--;
				i=parent[i];
			}
		}
		

		
		//finding the distance
		for(int i=0;i<N;i++){
			//reset vis and dis arrays
			vis[i]=false;
			dis[i]=0;
		}
		dfsDis(root);
		int maxInd = 0;
		for(int i = 0; i < dis.length;i++) {
			if(dis[maxInd]<dis[i]) {
				maxInd = i;
			}
		}
		
		for(int i=0;i<N;i++){
			//reset vis and dis arrays
			vis[i]=false;
			dis[i]=0;
		}
		
		dfsDis(maxInd);
		
		for(int i = 0; i < dis.length;i++) {
			if(dis[maxInd]<dis[i]) {
				maxInd = i;
				
			}
		}
		System.out.println(total*2-dis[maxInd]);
		
		

	}
}
