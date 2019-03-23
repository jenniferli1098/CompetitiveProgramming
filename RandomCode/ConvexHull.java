import java.util.*;
class Triple{

    public int dest;
    public int hull;
    public int time;

    public Triple(int dest, int hull, int time) {
        this.dest = dest;
        this.hull = hull;
        this.time = time;
    }
}
public class ConvexHull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int INF = (int)1<<30;
		//System.out.println(INF);
		int K = input.nextInt();
		int N = input.nextInt();
		int S = input.nextInt();
		int [][] state = new int [N+1][K]; //0 = time, 1 = hulle size
		ArrayList<Triple> routes[] = new ArrayList[N+1];
		for(int i = 0; i < N+1;i++) {
			routes[i] = new ArrayList<>();
		}
		for(int i = 0; i < S; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int t = input.nextInt();
			int h = input.nextInt();
			routes[a].add(new Triple(b,h,t));

			routes[b].add(new Triple(a,h,t));
		}
		int A = input.nextInt();
		int B = input.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i < N+1; i++) {
			if(i==A)continue;
			for(int k = 0; k < K; k++) {
				state[i][k] = INF;
			}
		}
		ArrayList<Integer>tms = new ArrayList<>();
		boolean [] proc = new boolean[N+1];
		q.add(A);
		proc[A] = true;
		while(!q.isEmpty()){
			int node = q.peek();q.remove();
			proc[node] = false;
			
			//System.out.println("hi");
			
			//iterate through routes
			for(int i = 0; i < K;i++) {
				for(Triple v: routes[node]) {
					int nxtnode = v.dest;
					int nxttime = state[node][i]+v.time;
					int nxthull = i+v.hull;
					if(nxthull<K&&(nxttime<state[nxtnode][nxthull])) {
						state[nxtnode][nxthull]=nxttime;
						if(!proc[nxtnode]) {
							proc[nxtnode] = true;
							q.add(nxtnode);
						}
					}
				}
				
			}
				//System.out.println("hi");
				
				
		}
		for(int k = 0; k < K; k++) {
			tms.add(state[B][k]);
		}
		/*
		if(state[B][K-3]>=(1<<29)) {
			System.out.println(-1);
		}else {
			System.out.println(state[B][K-1]);
		}*/

		tms.sort(null);
		if(tms.get(0)<INF) {
		System.out.println(tms.get(0));
		}else {
			System.out.println(-1);
		}
	}

}

/*
10 4 7
1 2 4 4
1 3 7 2
3 1 8 1
3 2 2 2
4 2 1 6
3 4 1 1
1 4 6 12
1 4
*/
