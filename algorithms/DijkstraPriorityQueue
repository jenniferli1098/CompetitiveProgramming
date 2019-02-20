import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class DijkstraPriorityQueue {
    public static class pair{
        public int first;
        public int second;

        public pair(int a, int b) {
            this.first = a;
            this.second = b;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Comparator<pair> pairComparator = new Comparator<pair>() {
            @Override
            public int compare(pair a, pair b) {
                if(a.first>b.first) {
        			return 1;
        		}else if(a.first<b.first) {
        			return -1;
        		}
        		return 0;
            }
        };
		
		
		int N = input.nextInt();
		int M = input.nextInt();
		ArrayList<pair>adj[] = new ArrayList[N+1];
		for(int i = 0; i <=N; i++) {
			adj[i] = new ArrayList<pair>();
		}
		for(int i = 0; i < M; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			adj[a].add(new pair(b,c));
			adj[b].add(new pair(a,c));
		}
		int INF = Integer.MAX_VALUE;
		int [] dis = new int[N+1];
		boolean[] processed = new boolean[N+1];
		for(int i = 1; i <=N; i++) {
			dis[i] = INF;
		}
		int x = 1; //beginning
		PriorityQueue<pair> q =new PriorityQueue<>(pairComparator);
		dis[x] = 0;
		q.add(new pair(-dis[x],x));
		while(!q.isEmpty()) {
			int a = q.peek().second;
			q.remove();
			if(processed[a])continue;
			processed[a] = true;
			for(pair o: adj[a]) {
				int b = o.first;
				int w = o.second;
				if(dis[a]+w<dis[b]) {
					dis[b] = dis[a]+w;
					q.add(new pair(-dis[b],b));
				}
			}
		}
		System.out.println(dis[3]);
		
	}

}

/*
5 6
1 5 1
1 4 9
1 2 5
2 3 2
3 4 7
4 5 2
*/
