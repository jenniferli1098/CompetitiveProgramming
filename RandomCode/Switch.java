import java.util.*;
public class Switch {
	public static Map <String, Integer> dis = new HashMap<String, Integer>();
	public static Set <String> vis = new HashSet<String>();
	public static void dfs(int node) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		String s= input.nextLine();
		String key = "";
		for(int i = 0; i < N; i++) {
			s+= input.next();key+="0";
		}
		vis.add(s);
		dis.put(s, 0);
		Queue<String>state = new LinkedList<String>();
		state.add(s);
		while(!state.isEmpty()) {
			String node = state.peek();state.remove();
			for(int i = 0; i < node.length();i++) {
				if(node.charAt(i)=='0') {
					String newnode = node.substring(0, i)+"1"+node.substring(i+1);
					//switch off all valid sequences
					while(newnode.indexOf("1111")>-1) {
						int ind = newnode.indexOf("1111");
						while(ind<newnode.length()&&newnode.charAt(ind)=='1') {
							newnode = newnode.substring(0, ind)+"0"+newnode.substring(ind+1);
							ind++;
						}
						//System.out.println(newnode);
					}
					if(!vis.contains(newnode)) {
						vis.add(newnode);
						state.add(newnode);
						dis.put(newnode, dis.get(node)+1);
					}
				}
			}
		}
		
		
		System.out.println(dis.get(key));
	}

}
