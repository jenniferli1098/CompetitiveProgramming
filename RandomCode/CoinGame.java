import java.util.*;

public class CoinGame {
	public static Map<String, Integer> dis = new HashMap<String, Integer>();
	//public static Collection<Float> vals = new HashSet<Float>();
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		//int k = 0b101;
		//System.out.println(k);
		int N = input.nextInt();
		while(N!=0) {
			String end = "";
			String start = "";
			for(int i = 0; i <N;i++) {
				int k = input.nextInt();
				for(int j = 0; j < N; j++) {
					if(j==k-1) {
						start+="1";
					}else {
						start+="0";
					}
					if(j==i) {
						end+="1";
					}else {
						end+="0";
					}
				}
			}
			dis.put(start, 0);
			boolean works = false;
			Queue<String>state = new LinkedList<String>();
			state.add(start);
			while(!state.isEmpty()&&!works) {
				String s = state.peek();state.remove();
				int [] pos = new int [N];
				for(int i = 0; i < N; i++) {
					pos[i] = s.indexOf('1',N*i)-N*i;
					if(pos[i]>=N) {
						pos[i] = -1;
					}
				}
				String newnode;
				for(int i = 1; i < N; i++) {
					//if(pos[i]==i)continue;
					if((pos[i-1]>pos[i]&&pos[i]>=0)||(pos[i-1]<0&&pos[i]>=0)) {
						newnode = s.substring(0, N*(i-1)+pos[i])+"1"+s.substring(N*(i-1)+pos[i]+1,N*(i)+pos[i])+"0"+s.substring(N*(i)+pos[i]+1);
						//System.out.println(newnode);
						if(!dis.containsKey(newnode)) {
							
							dis.put(newnode, dis.get(s)+1);
							if(newnode.equals(end)) {
								works = true;
								break;
							}
							state.add(newnode);
						}
					}
				}
				for(int i = 0; i+1 < N; i++) {

					//if(pos[i]==i)continue;
					if((pos[i+1]>pos[i]&&pos[i]>=0)||(pos[i+1]<0&&pos[i]>=0)) {
						newnode = s.substring(0, N*(i)+pos[i])+"0"+s.substring(N*(i)+pos[i]+1,N*(i+1)+pos[i])+"1"+s.substring(N*(i+1)+pos[i]+1);
						if(!dis.containsKey(newnode)) {
							
							dis.put(newnode, dis.get(s)+1);
							if(newnode.equals(end)) {
								works = true;
								break;
							}
							state.add(newnode);
						}
					}
				}
				
			}
			if(dis.containsKey(end)) {
				System.out.println(dis.get(end));
			}else {
				System.out.println("IMPOSSIBLE");
			}
			dis = new HashMap<String, Integer>();
			N = input.nextInt();
		}
	}
}
