import java.util.*;

public class SimpleGraph {
	private ArrayList<ArrayList<Integer>> adj;
	private int n, m;
	private ArrayList<Integer> A,B;
	
	public SimpleGraph(int n){
		this.n = n;
		m = 0;
		A = new ArrayList<Integer>();
		B = new ArrayList<Integer>();
		adj = new ArrayList<ArrayList<Integer>>(n); // why not ArrayList<ArrayList<>>??
		
		for (int i = 0; i<n; i++){
			adj.add(new ArrayList<Integer>());	
		}
		System.out.format("Graph has %d nodes\n", adj.size());
	}
	
	public void addEdge(int i, int j){
		m++;
		adj.get(i).add(new Integer(j));
		adj.get(j).add(new Integer(i));
	}
	
	public void displayGraph(){
		System.out.format("Graph has %d nodes and %d edges\n", n, m);
		Iterator<ArrayList<Integer>> gIt = adj.iterator();
		while(gIt.hasNext()) {
			System.out.println(gIt.next().toString());
		}
	}
	
	public int edgeCount(){
		return m;
	}
	
	public int nodeCount(){
		return n;
	}
	
	public int computeMinimumCut(){
		return -1;
	}
	
	private void contractEdge(int i, int j) {
		// locate the edge
		
	}

}
