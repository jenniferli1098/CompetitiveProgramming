import java.util.*;
import java.io.*;
public class ToweringTowers {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int N;
		Stack <Integer> H = new Stack<Integer>();
		Stack <Integer> I = new Stack<Integer>();
		String[] tokens = in.readLine().split(" ");
		N = Integer.parseInt(tokens[0]);
		tokens=in.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			int h = Integer.parseInt(tokens[i]);
			while(!H.empty()&&h>=H.peek()) {
				H.pop();
				I.pop();
			}
			if(H.empty()) {
				System.out.format("%d ",i);
			}
			else {
				System.out.format("%d ", i-I.peek());
			}
			I.push(i);
			H.push(h);
		}
		
	}

}
