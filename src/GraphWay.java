import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class GraphWay {
	Graph graph;
	
	ArrayList<Graph>  ways;
	
	protected GraphWay (Graph graph) {
		this.graph = graph;
		initWays();

		ways = new ArrayList<>();
	}
	
	
	public void initWays() {
		graph.addEdge("SPeterburg", "Moscow", 717);
		graph.addEdge("SPeterburg", "Riga", 576);
		graph.addEdge("SPeterburg", "Talin", 370);
		graph.addEdge("Talin", "Warslaw", 637);
		graph.addEdge("Talin", "Riga", 313);
		graph.addEdge("Warslaw", "Kyiv", 793);
		graph.addEdge("Riga", "Kyiv", 1046);
		graph.addEdge("Kyiv", "Kharkiv", 476);
		graph.addEdge("Moscow", "Voronezh", 545);
		graph.addEdge("Moscow", "Saratov", 854);
		graph.addEdge("Moscow", "Riga", 914);
		graph.addEdge("Moscow", "Kyiv", 1023);
		graph.addEdge("Kyiv", "Odessa", 473);
		graph.addEdge("Voronezh", "Kharkiv", 338);
		graph.addEdge("Voronezh", "Rostov", 586);
		graph.addEdge("Saratov", "Rostov", 861);
		graph.addEdge("Saratov", "Volgograd", 392);
		graph.addEdge("Volgograd", "Rostov", 476);
		graph.addEdge("Rostov", "Zaporozhie", 424);
		graph.addEdge("Kharkiv", "Zaporozhie", 298);
		graph.addEdge("Zaporozhie", "Sevastopol", 455);
		graph.addEdge("Zaporozhie", "Odessa", 520);
		graph.addEdge("Odessa", "Black_Sea", 5);
		graph.addEdge("Sevastopol", "Black_Sea", 5);
		graph.addEdge("Puposransk", "Pupogorsk", 5);
		
		
	}
	
	public void printWay() {
		
		Graph.Vertex start = graph.root;
		while (start != null) {
			Graph.Edge ed = start.edRoot;
			while (ed != null) {
				System.out.println(start.name + " to " + ed.toVrt.name + " " + ed.val);	
				ed = ed.next;
			}
			start = start.next;
		}
	}
	
	public void findWays(String from, String to) {
	
		Graph graph1 = new Graph();	
		Graph.Vertex vr = graph.findVertex(from);	
		
		getWays(vr, to, graph1, ways);
	}
	public void getWays(Graph.Vertex vr, String to, Graph graphs, ArrayList<Graph> ways ) {
		if (vr.name.equals(to)) {ways.add(graphs); return;}
		Graph.Edge eg = vr.edRoot;
		
		while (eg != null) {
			if(eg.toVrt.edRoot != null || eg.toVrt.name.equals(to)) {
				
				byte [] data = cloneObj(graphs);
				

					Graph nGraph = deCloneObj(data);
					
					nGraph.addEdge(vr.name, eg.toVrt.name, eg.val);
					
					getWays(eg.toVrt, to, nGraph, ways);
			}
			
			
			eg = eg.next;
		}
		
	}
	
	public byte[] cloneObj(Graph graph) {
		byte [] byteData = null;
		try {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(graph);
		oos.flush();
		oos.close();
		bos.close();
		byteData = bos.toByteArray();
		}catch( IOException e) {
			e.printStackTrace();
		}
		return byteData;
		
	}
	
	public Graph deCloneObj(byte [] data) {
		Graph graph = null;
		try {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		 graph = (Graph) new ObjectInputStream(bais).readObject();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
		return graph;
	}
	
	
//	public static void main(String [] args) {
//		Graph graph = new Graph();
//	
//		GraphWay rw = new GraphWay(graph);
//		
//		rw.findWays("SPeterburg", "Sevastopol");
//		System.out.println(rw.ways.toString().length());
//		for (Graph g: rw.ways) {
//			g.printWay();
//		}
//	}
}
