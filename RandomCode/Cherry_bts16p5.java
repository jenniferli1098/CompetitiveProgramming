import java.util.ArrayList;
import java.util.*;
class Pair{
	public int x;
	public int w;
	public Pair(int x, int y) {
		this.x=x;
		this.w=y;
	}
}
public class Cherry_bts16p5 {
	
	static ArrayList<Pair>[] adj;
	static int [] cherries;
	static boolean [] vis;
	static int [] total; //number of cherries
	static int [] weight;	//weight
	
	public static void dfs(int node) {
		vis[node] = true;
		total[node] = cherries[node];
		
		for(int x = 0; x< adj[node].size(); x++) {
			int i = adj[node].get(x).x;
			int w = adj[node].get(x).w;
			
			if(!vis[i]) {
				weight[i] = w;
				dfs(i);
				total[node]+=total[i];
				weight[node]+=weight[i];
			}
			
		}
	}
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		int N,C,K;
		N = input.nextInt();
		C = input.nextInt();
		K = input.nextInt();
		adj = new ArrayList[N+1];
		vis = new boolean[N+1];
		total = new int[N+1];
		weight = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			adj[i]=new ArrayList<Pair>();
		}
		
		cherries = new int[N+1];
		for(int i = 1; i <= N; i++) {
			cherries[i] = input.nextInt();
		}
		
		for(int i = 1; i <= N-1; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int w = input.nextInt();
			adj[a].add(new Pair(b,w));
			adj[b].add(new Pair(a,w));
		}
		weight[1] = 0;
		dfs(1);
		
		int count = 0;
		for(int i = 2; i <=N; i++) {
			if(total[i]>=C&&weight[i]<=K) {
				count++;
			}
		}
		System.out.println(count);
		
		
	}
}
