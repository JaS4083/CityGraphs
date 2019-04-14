import java.io.Serializable;

public class Graph implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vertex root = null;
	Vertex pointer = null;
	int distance = 0;
	
	
	class Vertex implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Vertex next;
		String name;
		Edge edRoot;
		Edge pointer;
		
		int x,y;
		
		public Vertex(String name) {
			this.name = name;
			this.edRoot = null;
			this.next = null;
		}
	}
	
	class Edge implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Edge next;
		Vertex toVrt;
		int val;
		
		public Edge(Vertex toVrt, int val) {
			this.toVrt = toVrt;
			this.val = val;
		}
	}
	
	public Vertex addVertex(String name) {
		Vertex nVert = new Vertex(name);
		Vertex tmp;
		if((tmp = findVertex(nVert)) != null) {return tmp;}
		
		if(root == null) {
			root = nVert;
			pointer = nVert;
		} else {
			pointer.next = nVert;
			pointer = nVert;
		}
		return nVert;
	}
	
	protected Vertex findVertex(Vertex vr) {
		
		Vertex from = root;
		Vertex tmp = null;
		while(from != null) {
			if(from.name.equals(vr.name)) tmp = from;
			from = from.next;
		} 
		return tmp;
	}
	
	protected Vertex findVertex(String name) {  // TODO протестить перегруженный метод findVertex

		Vertex from = root;
		Vertex tmp = null;
		while(from != null) {
			if(from.name.equals(name)) { tmp = from; break;}
			from = from.next;
		} 
		return tmp;
	}
	
	public Edge addEdge(String from, String to, int val) {
		distance +=val;
		Vertex fromVrt = addVertex(from);
		Vertex dis = addVertex(to);
		
		Edge nEdge = new Edge(dis, val);
		Edge tmp = null;
		
		if ((tmp = findEdge(fromVrt, nEdge)) != null) { return tmp;}
		
		if(fromVrt.edRoot == null) {
			fromVrt.edRoot = nEdge;
			fromVrt.pointer = nEdge;
		} else {
			fromVrt.pointer.next = nEdge;
			fromVrt.pointer = nEdge;	
		}
		return nEdge;
	}
	
	protected Edge findEdge(Vertex from, Edge dist) {
		Edge edgRoot = from.edRoot;
		Edge ret = null;
		while(edgRoot != null) {
			if(edgRoot.toVrt.name.equals(dist.toVrt.name)) { ret = edgRoot;}
			
			edgRoot = edgRoot.next;
		}
		return ret;
	}
	
	public void printWay() {
		Vertex start = root;
		while (start != null) {
			Edge ed = start.edRoot;
			while (ed != null) {
				System.out.println(start.name + " to " + ed.toVrt.name + " " + ed.val);	
				ed = ed.next;
			}
			start = start.next;
		}
		System.out.println(" distance - " + distance + "km");
	}
	
	
	public Graph clone() throws CloneNotSupportedException {
		
		Graph clonedObj = new Graph();
		clonedObj = (Graph) super.clone();
		
		return clonedObj;	
	}
	
	
	

	

}
