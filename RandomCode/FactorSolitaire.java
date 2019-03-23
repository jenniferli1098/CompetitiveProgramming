import java.util.*;
public class FactorSolitaire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int val[] = new int[5000000];
		int N = input.nextInt();
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		while(!q.isEmpty()) {
			int node = q.peek();q.remove();
			//System.out.println(node);
			for(int i = 1; i <node;i++) {
				//System.out.println("hi");
				
				if((int)(node/(i+1))*(i+1)==node) {
					//System.out.println("hi");
					int next = node-node/(i+1);
					//System.out.println(next);
					//System.out.println(val[next]);
					if(val[next]==0) {
						val[next] = i+val[node];
						q.add(next);
						break;
					}
				}
			}
			
		}
		System.out.println(val[1]);
	}

}