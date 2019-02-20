import java.util.Scanner;
class edge{
	public int a;
	public int b;
	public int w;
	public edge(int a, int b, int w) {
		this.a = a;
		this.b = b;
		this.w = w;
		
	}
}
public class BellmanFord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		edge [] edges = new edge[M];
		int dis[] = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			edges[i] = new edge(input.nextInt(),input.nextInt(), input.nextInt());
		}
		
		for(int i = 1;i <=N; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		dis[1] = 0;
		for(int i = 1; i < N; i++) {
			for(edge e: edges) {
				int a = e.a;
				int b = e.b;
				int w = e.w;
				dis[b] = Math.min(dis[b], dis[a]+w);
			}
		}
		
		//check for negative cycle
		boolean neg = false;
		for(edge e: edges) {
			int a = e.a;
			int b = e.b;
			int w = e.w;
			if(dis[b]> dis[a]+w){
				neg = true;
				break;
			}
		}
		if(neg) {
			System.out.println("negative cycle");
		}
		
	}

}
/*
4 5
1 2 3
1 3 5
3 2 2
2 4 1
4 3 -7
*/
