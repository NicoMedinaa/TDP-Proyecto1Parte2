
public class Main {

	public static void main (String[] args) {
		
		DiGrafo g = new DiGrafo();
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		g.addNode(4);
		
		g.addEdge(1, 2);
		g.addEdge(1, 5);
		g.addEdge(1, 2);
		
		g.removeNode(4);
		g.removeNode(7);
		
		g.removeEdge(1, 2);
		g.removeEdge(1, 2);
		g.removeEdge(1, 5);
	}
}
