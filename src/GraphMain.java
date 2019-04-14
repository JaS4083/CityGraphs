
public class GraphMain {

	public static void main(String[] args) {
		String from = "SPeterburg";
		String to = "Black_Sea";
		Graph gr = new Graph();
		GraphWay rw = new GraphWay(gr);
		new GraphFrame();

		
		rw.findWays(from, to);
		
		System.out.println(rw.ways.toString());
		
		
		Graph minDis = rw.ways.get(0);
		for (int i = 1; i < rw.ways.size(); i ++) {
			if(rw.ways.get(i).distance < minDis.distance) minDis = rw.ways.get(i);
		}
		System.out.println("The shortest way from " + from + " to " + to+ " \n");
		minDis.printWay();
		System.out.println(" \n");
		
	if (rw.ways.size() >0) System.out.println("And other ways: ");
	
		for(Graph g: rw.ways) {			
			if(g != minDis) g.printWay();	
			System.out.println("**********************");
		}	
	
	
	}
}
