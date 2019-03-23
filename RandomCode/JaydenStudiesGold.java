import java.util.ArrayList;
import java.util.Scanner;
public class JaydenStudiesGold {

	static boolean [] vis;
	static int [] dis;
	static ArrayList<Integer>[] adj;
	public static void main(String [] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		dis = new int [N+1];	
		vis = new boolean[N+1];
		adj = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i <N-1; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			
			adj[a].add(b);
			adj[b].add(a);
		}
		dfs(1);
		int maxInd = 0;
		for(int i = 0; i < dis.length;i++) {
			if(dis[maxInd]<dis[i]) {
				maxInd = i;
			}
		}
		
		dis = new int [N+1];	
		vis = new boolean[N+1];
		dfs(maxInd);
		maxInd = 0;
		int maxDis = 0;
		for(int i = 0; i < dis.length;i++) {
			if(dis[maxInd]<dis[i]) {
				maxInd = i;
				maxDis = dis[i];
			}
		}
		System.out.println(maxDis);
		
	}
	
	public static void dfs(int node) {
		vis[node] = true;
		for(int i = 0; i < adj[node].size();i++) {
			if(!vis[adj[node].get(i)]) {
				dis[adj[node].get(i)] = dis[node]+1;
				dfs(adj[node].get(i));
			}
		}
	}
}
