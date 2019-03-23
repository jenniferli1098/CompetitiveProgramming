import java.util.*;
import java.io.*;
public class Riceballs {
	static BufferedReader br;
	static StringTokenizer st;
	static boolean [][]vis;
	static int [][]max;
	static int [] arr;
	public static int find(int a, int b) {
		if(vis[a][b]) {return max[a][b];}

		vis[a][b] = true;
		if(a==b) {
			return arr[a];
		}
		if(b-a==1&&arr[a]==arr[b]) {
			return max[a][b] = arr[a]*2;
		}
		if(b-a==1&&arr[a]!=arr[b]) {
			return max[a][b] = -1;
		}
		//nested
		if(arr[a]==arr[b]&&find(a+1,b-1)>0) {
			return max[a][b] = find(a+1,b-1)+arr[a]*2;
		}
		//separate
		for(int i = 0; i+a<b;i++) {
			if(find(a,a+i)>0&&find(a+i+1,b)>0&&find(a,a+i)==find(a+i+1,b)) {
				return  max[a][b]=find(a,a+i)+find(a+i+1,b);
			}
		}
		return -1;
	}
	public static void main(String[] args) throws  IOException{
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = readInt();
		max = new int[T][T];
		vis = new boolean[T][T];
		arr = new int[T];
		for(int i = 0; i < T; i++) {arr[i] = readInt();}
		int max = 0;
		for(int i = 0; i < T; i++) {
			for(int k = 0; k+i < T; k++) {
				//System.out.println(arr[k]+" "+arr[i+k]+" "+find(k,i+k));
				max = Math.max(max,find(k,i+k));
				
			}
		}
		System.out.println(max);
	}
	static String next () throws IOException {
	    while (st == null || !st.hasMoreTokens())
	      st = new StringTokenizer(br.readLine().trim());
	    return st.nextToken();
	  }

	  static long readLong () throws IOException {
	    return Long.parseLong(next());
	  }

	  static int readInt () throws IOException {
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
