import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Surfing {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		
		int ind = 0;
		Map<String,Integer> map = new HashMap<>();

		Map<Integer,String> smap = new HashMap<>();
		ArrayList<Integer> adj[] = new ArrayList[100];
		for(int i = 0; i  < 100; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0; i < N; i++) {
			String k = input.readLine();
			if(!map.containsKey(k)) {
				map.put(k, ind);
				smap.put(ind, k);
				ind++;
			}
			int from = map.get(k);
			k = input.readLine();
			while(!k.equals("</HTML>")) {
				while(k.contains("<A HREF=\"")) {
					String web = k.substring(k.indexOf("\"")+1, k.indexOf("\"", k.indexOf("\"")+1));
					//System.out.println(web);
					k = k.substring(k.indexOf("\"", k.indexOf("\"")+1)+1);
					int to=-1;
					if(!map.containsKey(web)) {
						//System.out.println(ind);
						map.put(web, ind);
						smap.put(ind, web);
						ind++;
					}
					to = map.get(web);
					adj[from].add(to);
					System.out.println("Link from "+smap.get(from)+" to "+smap.get(to));
					
				}
				k = input.readLine();
			}
			
		}
		boolean marked[] = new boolean[ind];
		Queue<Integer> q = new LinkedList<>();
		String a = input.readLine();
		while(!a.equals("The End")){
			marked = new boolean[ind];
			q = new LinkedList<>();
			String b = input.readLine();
			int to = map.get(b);
			int from = map.get(a);
			q.add(from);
			marked[from] = true;
			while(!q.isEmpty()) {
				int node = q.peek();q.remove();
				for(int i = 0; i < adj[node].size();i++) {
					if(!marked[adj[node].get(i)]) {
						marked[adj[node].get(i)]=true;
						q.add(adj[node].get(i));
					}
				}
			}
			if(marked[to]) {
				System.out.println("Can surf from "+ a +" to "+b+".");
			}else {
				System.out.println("Can't surf from "+ a +" to "+b+".");
			}	
			a = input.readLine();
			
		}
	}

}
