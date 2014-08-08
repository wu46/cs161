public class TestSimpleGraph{
	public static void main(String args[]){
		System.out.println("Starting TestSimpleGraph...");
		SimpleGraph G = new SimpleGraph(10);
		G.addEdge(0,1);
		G.displayGraph();
	}
}
