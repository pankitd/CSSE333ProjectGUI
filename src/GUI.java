import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

/*
 * Created by: Jesse Shellabarger and Chase Bishop
 */

public class GUI {
	private JFrame mainMenuFrame;
	private ArrayList<JFrame> activeFrames;
	private String[] usernames = new String[3];

	public GUI() {
		this.activeFrames = new ArrayList<JFrame>();
		this.usernames[0] = "bishopcc";
		this.usernames[1] = "Tayler";
		this.usernames[2] = "Jesse";
		JFrame mainMenuFrame = new JFrame();
		this.activeFrames.add(mainMenuFrame);
		mainMenuFrame.setTitle("Login");
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		GUI g = new GUI();
		
		Image image = new ImageIcon("resources/LoginBG.png").getImage();
		ImagePanel panel = new ImagePanel(image);
		g.activeFrames.get(0).getContentPane().add(panel);
		
		//Title Label
		JLabel titleLabel = new JLabel("<html><b>Horse Racing!</b><html>");
		titleLabel.setForeground(Color.CYAN);
		panel.add(titleLabel, BorderLayout.NORTH);
//		titleLabel.setLocation(panel.getWidth() * 1/2, panel.getHeight() * 3/4);
		
		//Adding Username Label
		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setForeground(Color.GREEN);
		JTextField usernameText = new JTextField(15);
		usernameLabel.setLabelFor(usernameText);
		panel.add(usernameLabel, BorderLayout.WEST);
		panel.add(usernameText, BorderLayout.EAST);
		//set location in here
		
		//Add login button
		JButton loginButton = new JButton("Login");
		
//		loginButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				.activeFrames.get(0).setVisible(false);
//			}
//			
//		});
		
		panel.add(loginButton, BorderLayout.SOUTH);
		
		titleLabel.setVisible(true);
		usernameLabel.setVisible(true);
		g.activeFrames.get(0).pack();
		g.activeFrames.get(0).setVisible(true);
		g.activeFrames.get(0).setLocationRelativeTo(null);
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

//	public ImagePanel(String img) {
//		this(new ImageIcon(img).getImage());
//	}

	public ImagePanel(Image img) {
		super();
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(new BorderLayout());
		}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
