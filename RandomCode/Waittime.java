import java.util.*;
public class Waittime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> phones = new ArrayList<Integer>();
		int [] arr = new int[101];
		boolean [] wait = new boolean [101];
		int q = input.nextInt();
		for(int j = 0; j < q; j++) {
			String p = input.next();
			int x = input.nextInt();
			if(p.equals("W")) {
				for(int i = 0; i <phones.size();i++) {
					if(wait[phones.get(i)])arr[phones.get(i)]+=x-1;
				}
			}else if(p.equals("R")) {
				if(phones.indexOf(x)<0) {
					phones.add(x);
				}
				wait[x] = true;
				for(int i = 0; i <phones.size();i++) {
					if(wait[phones.get(i)])arr[phones.get(i)]++;
				}
				
			}else {
				wait[x] = false;
				for(int i = 0; i <phones.size();i++) {
					if(wait[phones.get(i)])arr[phones.get(i)]++;
				}
			}
			
		}
		phones.sort(null);
		for(int i = 0; i <phones.size();i++) {
			if(wait[phones.get(i)]) {
				System.out.println(phones.get(i) +" -1");
			}else {
				System.out.println(phones.get(i) +" "+arr[phones.get(i)]);
			}
		}
		
	}

}
