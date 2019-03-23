import java.util.*;
public class WordTransfomation {

	public static int modu= 31;
	public static int getVal(String s) {
		if(s.length()==1){return (int)s.charAt(0)-96;}
	    else{
	        return (int)s.charAt(0)-96+modu*getVal(s.substring(1,s.length()));
	    }
	}
	public static boolean isConnected(int a, int b){
	    int diff = Math.abs(a-b);
	    while(diff%modu==0){
	        diff/=modu;
	    }
	    return diff<modu;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		input.nextLine();
		for(int a = 0; a < N; a++) {
			ArrayList<Integer>words = new ArrayList<Integer>();
			String e = input.nextLine();
			while(!e.equals("*")) {
				words.add(getVal(e));
				e = input.nextLine();
			}
			int Size = words.size();
			boolean[][] adj = new boolean [Size][Size];
			for(int i = 0; i < Size; i++){
		        for(int k = i+1; k < Size; k++){
		            if(isConnected(words.get(i),words.get(k))){
		                adj[i][k] = true;
		                adj[k][i] = true;
		            }
		        }
		    }
			
			//demands
			String l = input.nextLine();
			while(l.length()>0) {
				String [] sf = l.split(" ");
				int st = getVal(sf[0]);
				int en = getVal(sf[1]);
				int X = -1;
				int Y = -1;
				for(int i = 0; i < Size;i++) {
					if(words.get(i)==st) {
						X = i;
					}
					if(words.get(i)==en) {
						Y = i;
					}
					if(X>=0 && Y>=0) {break;}
				}
				int [] dis = new int [Size];
				boolean [] vis = new boolean [Size];
				Queue <Integer> nodes = new LinkedList<Integer>();
				nodes.add(X);
				vis[X] = true;
				while(!nodes.isEmpty()){
		            int n = nodes.remove();
		            for(int i = 0; i < Size;i++){
		            	if(adj[n][i] && !vis[i]) {
		                    vis[i] = true;
		                    dis[i] = dis[n]+1;
		                    nodes.add(i);
		                }
		            	
		            }
		            if(vis[Y]==true){break;}
		            
		        }
				System.out.println(sf[0]+" "+sf[1]+" "+dis[Y]);
	            l = input.nextLine();
				
			}
			
			
		}

	}

}
