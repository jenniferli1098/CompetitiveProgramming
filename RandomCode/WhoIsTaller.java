import java.util.*;
public class WhoIsTaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		ArrayList<Integer> taller [] = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			taller[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			taller[a].add(b);
		}
		boolean [] marked = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		int s = input.nextInt();
		int e = input.nextInt();
		boolean isTaller = false;
		q.add(s);
		while(!q.isEmpty()&&!isTaller) {
			int node = q.peek();q.remove();
			for(int i= 0; i < taller[node].size();i++) {
				if(!marked[taller[node].get(i)]) {
					marked[taller[node].get(i)]=true;
					q.add(taller[node].get(i));
					if(taller[node].get(i)==e) {
						isTaller = true;
						break;
					}
				}
			}
		}
		
		
		if(marked[e]) {
			System.out.println("yes");
		}else {
			boolean [] rmarked = new boolean[N+1];
			q = new LinkedList<>();
			q.add(e);
			boolean isShorter = false;
			while(!q.isEmpty()&&!isShorter) {
				int node = q.peek();q.remove();
				for(int i= 0; i < taller[node].size();i++) {
					if(!rmarked[taller[node].get(i)]) {
						rmarked[taller[node].get(i)]=true;
						q.add(taller[node].get(i));
						if(taller[node].get(i)==s) {
							isShorter = true;
							break;
						}
					}
				}
			}
			if(rmarked[s]){
				System.out.println("no");
			}else {

				System.out.println("unknown");
			}
		}

			
	}

}
