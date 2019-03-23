import java.util.*;
public class gates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet <Integer> gates = new TreeSet <Integer>();
		Scanner input = new Scanner(System.in);
		int G = input.nextInt();
		for(int i = 0; i <= G; i++) {
			gates.add(i);
		}
		int N = input.nextInt();
		int m = 0;
		for(int k = 0; k < N; k++) {
			int l = input.nextInt();
			int g = gates.floor(l);
			if(g==0) {
				break;
			}
			gates.remove(g);
			m++;
		}
		System.out.println(m);
		
	}

}
