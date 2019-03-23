import java.util.*;


import java.io.*;
public class MinimumCostFlow {
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
		
	static BufferedReader br;
	static StringTokenizer st;
	
	static edge[] initial;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = readInt();
		int M = readInt();
		int D = readInt();
		link = new int[M+1];
		size = new int[M+1];
		for(int i = 1; i <= M; i++) {
			link[i] = i;
			size[i] = 1;
		}
		edge[] pump = new edge[M];
		 initial = new edge[N-1];
		int cost = 0;
		for(int i = 0; i < M; i++) {
			int a = readInt();
			int b = readInt();
			int c = readInt();
			if(i<N-1) {
				cost+=c;
				initial[i] = new edge(a,b,c);
			}
			
			pump[i] = new edge(a,b,c);
		}
		
		Arrays.sort(pump);
		int changed = 0;
		for(int i = 0; i < M; i++) {
			int a = pump[i].a;
			int b = pump[i].b;
			int w = pump[i].w;
			if(!same(a,b)) {
				unite(a,b);
				if(!contains(pump[i])) {
					changed++;
				}
			}
		}
		System.out.println(changed);
		
		
		
		
	}
	
	public static boolean contains(edge e) {
		for(int i = 0; i < initial.length;i++) {
			if(initial[i].compareTo(e)==0) {
				return true;
			}
		}
		return false;
	}
	static String next () throws IOException {
	    while (st == null || !st.hasMoreTokens())
	      st = new StringTokenizer(br.readLine().trim());
	    return st.nextToken();
	  }

	  static long readLong () throws IOException {
	    return Long.parseLong(next());
	  }

	  static int readInt() throws IOException {
	    return Integer.parseInt(next());
	  }

	  static double readDouble () throws IOException {
	    return Double.parseDouble(next());
	  }

	  static char readCharacter () throws IOException {
	    return next().charAt(0);
	  }

	  static String readLine () throws IOException {
	    return br.readLine().trim();
	  }
}
