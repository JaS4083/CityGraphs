import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class GraphCommand {
	Graph gr;
	GraphWay rw;
	int delta;
	int d = 30;
	protected GraphCommand() {
		
		gr = new Graph();
		rw = new GraphWay(gr);
		delta = countVert();
		assingXY();
	}
	
	protected int countVert() {
		int count = 0;
		Graph.Vertex gvr = rw.graph.root;
		
		while (gvr != null) {
			count++;
			gvr = gvr.next;
		}
		return count;
	}
	
	
	int panelSize;
	int level = 100;
	public void assingXY() {
		System.out.println("AssingXY");
		Graph.Vertex vRoot = rw.graph.root;
		System.out.println(vRoot.name);
		
		for (int i = 1; i <= ((int) Math.sqrt(delta)) *2; i ++ ) {
			int panelSize = 900;
			
			for (int j = 1; j <= i; j ++) {
				int dx = panelSize/(i+1);
				if(vRoot != null) {
		
			
					vRoot.x =(dx *j) +15; 
					vRoot.y = level*i - 50;
					//System.out.println(vRoot.x + " " + vRoot.y);
					vRoot = vRoot.next;
				}
			}
		
		}	
	}
	
	public void printXY() {
Graph.Vertex gvr = rw.graph.root;
		
		while (gvr != null) {
			System.out.println(gvr.x + " " + gvr.y);
			gvr = gvr.next;
		}
	}
	
	public static void main (String [] args) {
		GraphCommand grfCom = new GraphCommand();
		
		System.out.println(grfCom.delta);
		grfCom.printXY();
		
	
	}
	
	public void drawVert(Graphics2D gg) {
		Graph.Vertex vRoot = rw.graph.root;
		while (vRoot != null) {
			gg.setColor(Color.GREEN);
			gg.setStroke(new BasicStroke(3));
			gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			gg.drawOval(vRoot.x-15, vRoot.y-15, d, d);
			
			
			
		
			Graph.Edge ed = vRoot.edRoot;
			while(ed != null) {
				gg.setColor(Color.RED);
				gg.setStroke(new BasicStroke(2));
				gg.drawLine(vRoot.x, vRoot.y, ed.toVrt.x, ed.toVrt.y);
				
				ed = ed.next;
			}
			
			String text = vRoot.name;
			gg.setColor(Color.DARK_GRAY);
			gg.setStroke(new BasicStroke(2));
			gg.drawString(text, vRoot.x-15, vRoot.y-15);
			
			vRoot = vRoot.next;
			
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	

}
