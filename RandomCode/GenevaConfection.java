import java.util.*;
public class GenevaConfection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int k = 0; k < n; k++) {
			int w = in.nextInt();
			Stack <Integer> top = new Stack<>();
			Stack <Integer> middle = new Stack<>();
			for(int i = 0; i  < w; i++) {
			top.push(in.nextInt());
			}
			int cur = 1;
			boolean pass = true;
			while(cur<=w&&pass) {
				pass = false;
				if(!top.empty()&&top.peek()==cur) {
					pass=  true;
					top.pop();
				}else if(!middle.empty()&&middle.peek()==cur) {
					pass=  true;
					middle.pop();
				}else {
					while(!top.empty()) {
						if(top.peek()==cur) {top.pop();pass = true;break;}
						else {
							middle.push(top.peek());
							top.pop();
						}
					}
					if(!pass) {
						//System.out.println("doesn't work"+cur);
					}
				}
				cur++;

			}
			if(pass) {
				System.out.println("Y");
			}else {

				System.out.println("N");
			}
		}
		
	}

}
