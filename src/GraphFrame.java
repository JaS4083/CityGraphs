import javax.swing.JFrame;

public class GraphFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GraphPanel gp;
	GraphFrame(){
		setBounds(150, 150, 900, 600);
		gp = new GraphPanel();
		
		add(gp);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
