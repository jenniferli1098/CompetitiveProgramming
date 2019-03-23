import java.util.*;

public class AnimalFarm {
	public static class edge{
		public int a;
		public int b;
		public int w;
		public edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
			
		}
	}
	static int link[];
	static int size[];
	public static boolean same(int a, int b) {
		return find(a)==find(b);
	}
	public static int find(int x) {
		if(x!=link[x])return find(link[x]);
		return x;
	}
	public static void unite(int a, int b) {
		a = find(a);
		b = find(b);
		if(size[a]<size[b]) {
			a^=b;
			b^=a;
			a^=b;
		}
		size[a]+=size[b];
		link[b] = a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		//Node[] nd = new Node[N];
		int edge[][] = new int[N*8][3];
		Map<Integer, Integer> weight = new HashMap<>(); //what index for edge
		int ind = 0;
		for(int i = 1; i <=N; i++) {
			int e = input.nextInt();
			int [] p = new int[e];
			int [] w = new int[e];
			for(int k = 0; k < e; k++) {
				p[k] = input.nextInt();
			}
			for(int k = 0; k < e; k++) {
				w[k] = input.nextInt();
			}
			//process node
			for(int k = 0; k < e ;k++) {
				//System.out.println(p[k]+" "+p[(k+1)%e]);
				int ed = p[k]+p[(k+1)%e]*10000;
				int ed2 = p[k]*10000+p[(k+1)%e];
				if(weight.containsKey(ed)) {
					edge[weight.get(ed)][2] = i;
				}else {
					weight.put(ed, ind);
					weight.put(ed2, ind);
					edge[ind][0] = w[k];
					edge[ind][1] = i;
					ind++;

				}
			}

		}
		//System.out.println(ind);
		link = new int[N+1];
		size = new int[N+1];
		for(int i = 1; i <= N; i++) {
			link[i] = i;
			size[i] = 1;
		}
		int M = ind;
		edge [] edges = new edge[M];
		for(int i = 0; i < M; i++) {
			edges[i] = new edge(edge[i][1],edge[i][2],edge[i][0]);
		}
		Arrays.sort(edges,new Comparator<edge>() {
		    public int compare(edge a, edge b) {
		        return Integer.compare(a.w, b.w);
		    }
		});
		int cost = 0;
		for(int i = 0; i < M; i++) {
			int a = edges[i].a;
			int b = edges[i].b;
			int w = edges[i].w;
			if(!same(a,b)) {
				unite(a,b);
				cost+=w;
			}
		}
		//cost is including outside
		for(int i = 1; i <= N; i++) {
			link[i] = i;
			size[i] = 1;
		}
		edges = new edge[M];
		for(int i = 0; i < M; i++) {
			edges[i] = new edge(edge[i][1],edge[i][2],edge[i][0]);
		}
		Arrays.sort(edges,new Comparator<edge>() {
		    public int compare(edge a, edge b) {
		        return Integer.compare(a.w, b.w);
		    }
		});
		int ncost = 0;
		for(int i = 0; i < M; i++) {
			int a = edges[i].a;
			int b = edges[i].b;
			int w = edges[i].w;
			if((a!=0&&b!=0)&&!same(a,b)) {
				unite(a,b);
				ncost+=w;
			}
		}
		
		
		System.out.println(Math.min(ncost, cost));
	}

}
