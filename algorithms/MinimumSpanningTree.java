import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*

*/
public class MinimumSpanningTree {
	public static class edge implements Comparable <edge>{
		public int a;
		public int b;
		public int w;
		public edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
			
		}
		public int compareTo( edge o) {
            if(w>o.w) {
    			return 1;
    		}else if(w<o.w) {
    			return -1;
    		}
            if(a>o.a) {
    			return 1;
    		}else if(a<o.a) {
    			return -1;
    		}
            if(b>o.b) {
    			return 1;
    		}else if(b<o.b) {
    			return -1;
    		}
    		return 0;
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
		int n = input.nextInt();//nodes
		link = new int[n+1];
		size = new int[n+1];
		for(int i = 1; i <= n; i++) {
			link[i] = i;
			size[i] = 1;
		}
		int M = input.nextInt();
		edge [] edges = new edge[M];
		
		for(int i = 0; i < M; i++) {
			edges[i] = new edge(input.nextInt(),input.nextInt(), input.nextInt());
		}
		Arrays.sort(edges);
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
		System.out.println(cost);
	}

}
/*
6 8
1 2 3
1 5 5
2 5 6
2 3 5
3 4 9
3 6 3
4 6 7
5 6 2

 */
