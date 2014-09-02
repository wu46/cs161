import java.util.*;
import java.io.*;
import graph.*;
public class TestSimpleGraph{
    private static UndirectedGraph G;
	public static void main(String args[]){
        initGraph();
//        initTestGraph2();
//        G.displayGraph();
        int nCut = G.computeMinCut();
        System.out.format("%d cuts \n", nCut);
//        G.displayGraph();
	}

    private static void initTestGraph() {
        G = new UndirectedGraph(10);
        G.addEdge(0,1);
        G.addEdge(1,2);
        G.addEdge(2,3);
        G.addEdge(0,2);
        G.addEdge(0,3);
    }
    private static void initTestGraph2() {
        G = new UndirectedGraph(5);
        G.addEdge(0,1);
        G.addEdge(1,2);
        G.addEdge(2,3);
        G.addEdge(3,4);
        G.addEdge(0,4);
        G.addEdge(0,3);
        G.addEdge(1,3);
    }

    private static void initGraph() {
		G = new UndirectedGraph(200);

        String fname = "kargerMinCut.txt";
//        String fname = "kargerMinCutSimple.txt";
        Scanner sc = null;

        try { 
            sc = new Scanner(new File(fname));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        while (sc.hasNextLine()) {
            String line = sc.nextLine(); 
            String[] nodes = line.split("\\s");
            int tail = Integer.parseInt(nodes[0]) - 1;
            for (int i = 1; i < nodes.length; i++) {
                int head = Integer.parseInt(nodes[i]) - 1;
                G.addEdge(tail,head);
            }
        }
    }
}
