import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Created by: Jesse Shellabarger and Chase Bishop
 */

public class GUI {
	private JFrame mainMenuFrame;
	private ArrayList<JFrame> activeFrames;

	public GUI() {
		this.activeFrames = new ArrayList<JFrame>();
		JFrame mainMenuFrame = new JFrame();
		this.activeFrames.add(mainMenuFrame);
		mainMenuFrame.setTitle("Login");
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		GUI g = new GUI();
		
		ImagePanel panel = new ImagePanel(new ImageIcon(
				"resources/LoginBG.png").getImage());
		g.activeFrames.get(0).getContentPane().add(panel);
		g.activeFrames.get(0).pack();
		panel.setVisible(true);
		
		//Title Label
		JLabel titleLabel = new JLabel();
		titleLabel.setText("<html><b>Horse Racing!</b><html>");
		titleLabel.setForeground(Color.CYAN);
		panel.add(titleLabel);
//		titleLabel.setLocation(panel.getWidth() * 1/2, panel.getHeight() * 3/4);
		titleLabel.setVisible(true);
		
		//Adding Username Label
		JLabel usernameLabel = new JLabel();
		usernameLabel.setText("Username: ");
		panel.add(usernameLabel);
		//set location in here
		usernameLabel.setVisible(true);
		
		
		g.activeFrames.get(0).setVisible(true);
	}

	public JFrame getMainMenuFrame() {
		return mainMenuFrame;
	}

	public void setMainMenuFrame(JFrame mainMenuFrame) {
		this.mainMenuFrame = mainMenuFrame;
	}
	
	public ArrayList<JFrame> getActiveFrames(){
		return this.activeFrames;
	}
	
	public void setActiveFrames(ArrayList<JFrame> newActiveFrames){
		this.activeFrames = newActiveFrames;
	}
}

class ImagePanel extends JPanel {

	private Image img;
	private int row;
	private int column;

	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}

	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getRow() {
		return this.row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getColumn() {
		return this.column;
	}

	public int getPixelX() {
		return this.column * 80 + 10;
	}

	public int getPixelY() {
		return this.row * 80 + 10;
	}

}
