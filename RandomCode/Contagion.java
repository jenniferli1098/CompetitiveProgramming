import java.util.ArrayList;
import java.util.Scanner;
public class Contagion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		ArrayList<Long>adj[] = new ArrayList[N+1];
		long big = 1000000000;
		for(int i = 0; i <=N; i++) {
			adj[i] = new ArrayList<Long>();
		}
		//store edges
		for(int i = 0; i < M; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			long c = input.nextLong();
			adj[a].add(c*big+b);
			adj[b].add(c*big+a);
		}
		boolean[] mark = new boolean[N+1];
		long[] dis = new long[N+1];
		for(int i = 0; i <=N; i++) {
			dis[i] = big;
		}
		dis[1] = 0;
		while(true) {
			//find unmarked min distance
			int cur = 0;
			long min = big;
			for(int i = 1; i <=N; i++) {
				if(!mark[i]&&dis[i]<min) {
					cur = i;
					min = dis[i];
				}
			}
			//if none found
			if(cur==0)break;
			//mark cur
			mark[cur] = true;
			//check cur's neighbours
			for(int i = 0; i <adj[cur].size();i++) {
				int next = (int)(adj[cur].get(i)%big);
				long len = adj[cur].get(i)/big;
				if(dis[next] > dis[cur]+len) {
					dis[next]= dis[cur]+len;
				}
			}
		}
		for(int i = 1; i<=N; i++) {
			//if dis[i] is still big
			//then i cannot be reached from 1
			if(dis[i]==big)dis[i] =-1;
			System.out.println(dis[i]);
		}
		
	}

}
