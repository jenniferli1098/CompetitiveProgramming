import java.util.*;
public class Nukit {
	public static Map <String,Integer> state = new HashMap<>(); 
	//1 = true;
	public static int find(String s) {
		if(state.containsKey(s)) {
			return state.get(s);
		}
		String [] temp = s.split(" ");
		int [] arr = new int[4];
		for(int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		int t[][] = {{2,1,0,2},{1,1,1,1},{0,0,2,1},{0,3,0,0},{1,0,0,1}};
		int nar [] = new int[4];
		int sum = 0;
		for(int j = 0; j < 5; j++) {
			nar[0] = arr[0]-t[j][0];
			nar[1] = arr[1]-t[j][1];
			nar[2] = arr[2]-t[j][2];
			nar[3] = arr[3]-t[j][3];
			if(nar[0]<0||nar[1]<0||nar[2]<0||nar[3]<0)continue;
			String w = nar[0]+" "+nar[1]+" "+nar[2]+" "+nar[3];
			if(find(w)==0) {
				state.put(s, 1);
				return 1;
			}
		}
		state.put(s, 0);
		return 0;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = 0; i < n; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			int d = input.nextInt();
			String s = a+" "+b+" "+c+" "+d;
			if(find(s)>0) {
				System.out.println("Patrick");
			}else {
				System.out.println("Roland");
			}
		}
	}

}
