import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GraphPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	GraphPanel(){
	setBounds(0, 0, 900, 600);
	setBackground(Color.LIGHT_GRAY);
	
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		GraphCommand gcm = new GraphCommand();
		
		System.out.println("Paint");
		gcm.drawVert((Graphics2D)g);
			
			
		}
}
