package graph;
import java.util.*;

public class UndirectedGraph {
	private ArrayList<ArrayList<Integer>> adj;
	private int n, m;
	private ArrayList<Integer> A,B, nodeList;
	
	public SimpleGraph(int n){
		this.n = n;
		m = 0;
		A = new ArrayList<Integer>();
		B = new ArrayList<Integer>();
        nodeList = new ArrayList<Integer>();
		adj = new ArrayList<ArrayList<Integer>>(n); // why not ArrayList<ArrayList<>>??
		
		for (int i = 0; i<n; i++){
			adj.add(new ArrayList<Integer>());	
            nodeList.add(i);
		}
	}

    public int computeMinCut() {
        // while there are more than 2 nodes left
        // randomly select a node, randomly select a corresponding neighbour
        Random rg = new Random();
        while (n > 2) {
            int tail = nodeList.get(rg.nextInt(nodeList.size()));
            int head = tail;
            while (head == tail) {
                head = adj.get(tail).get(rg.nextInt(adj.get(tail).size()));
            }
            contractEdge(tail,head);
        }
        return m;
    }
    
    private void contractEdge(int i, int j) {
        // sort i and j in ascending order
        if (i > j) {
            int temp = i; i = j; j = temp;
        }
        // get all the nodes of head
        ArrayList<Integer> jNodes = adj.get(j);
        for (Integer jNeighbor : jNodes) {
            // add j's neighbors to i (except i itself)
            // also add i to j's neighbors
            if (!jNeighbor.equals(i)) {
                adj.get(jNeighbor).add(new Integer(i));
                adj.get(i).add(jNeighbor);
            } else {
                m--;
            }
            // remove all references to j
            adj.get(jNeighbor).remove(new Integer(j));
        }

        
        // remove all the self loops
        ArrayList<Integer> iNodes = adj.get(i); 
        while (iNodes.contains(new Integer(i))){
            int ind = iNodes.indexOf(new Integer(i));
            iNodes.remove(ind);
            m--;
        }
        
        // remove the node
        nodeList.remove(new Integer(j));
        // update number of nodes
        n--;
    }
	
	public void addEdge(int i, int j){
		adj.get(i).add(new Integer(j));
        if (!adj.get(j).contains(new Integer(i))) {
		    m++;
        }
	}
	
	public void displayGraph(){
		System.out.format("Graph has %d nodes and %d edges\n", n, m);
		Iterator<ArrayList<Integer>> gIt = adj.iterator();
		while(gIt.hasNext()) {
			System.out.println(gIt.next().toString());
		}
        System.out.println("Graph has the following nodes left: ");
        System.out.println(nodeList.toString());
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
	

}
