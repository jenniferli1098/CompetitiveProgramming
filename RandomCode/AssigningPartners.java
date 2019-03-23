import java.util.*;
public class AssigningPartners {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int s =  input.nextInt();
		Set<String>names = new HashSet<String>();
		Map <String,String>partner = new HashMap<String,String>();
		input.nextLine();
		String a = input.nextLine();
		String b = input.nextLine();
		String [] A = a.split(" ");
		String [] B = b.split(" ");
		//System.out.println(A.length);
		boolean good = true;
		for(int i = 0; i < s; i++) {
			if((names.contains(A[i])^names.contains(B[i]))) {
				good = false;
				break;
			}else if(names.contains(A[i])){
				if(!partner.get(A[i]).equals(B[i])) {good = false; break;}
			}else {
				if(A[i].equals(B[i])) {good = false; break;}
				names.add(A[i]);
				names.add(B[i]);
				partner.put(A[i], B[i]);
				partner.put(B[i], A[i]);
			}
		}
		if(good) {
			System.out.println("good");
		}else {
			System.out.println("bad");
		}
		
	}

}
