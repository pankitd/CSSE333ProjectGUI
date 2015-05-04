import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
		
		Image image = new ImageIcon("resources/trackBackground.jpg").getImage();
		ImagePanel panel = new ImagePanel(image);
		g.activeFrames.get(0).getContentPane().add(panel);
		
		//Username Label
		JLabel titleLabel = new JLabel();
		titleLabel.setText("<html><b>Horse Racing</b><html>");
		titleLabel.setForeground(Color.BLACK);
		Font titleFont = titleLabel.getFont();
		titleLabel.setFont(new Font(titleFont.getName(), 4, 14));
		titleLabel.setSize(110, 25);
		panel.add(titleLabel);
		titleLabel.setLocation(
				panel.getWidth() / 2 - (titleLabel.getWidth() /2),
				panel.getHeight() / 4 - titleLabel.getHeight());
		titleLabel.setVisible(true);
		
		//Username Label
		JLabel usernameLabel = new JLabel();
		usernameLabel.setText("<html><b>Username: </b><html>");
		usernameLabel.setForeground(Color.BLACK);
		Font usernameFont = usernameLabel.getFont();
		usernameLabel.setFont(new Font(usernameFont.getName(), 4, 14));
		usernameLabel.setSize(110, 25);
		panel.add(usernameLabel);
		usernameLabel.setLocation(
				panel.getWidth() / 2 - usernameLabel.getWidth(),
				panel.getHeight() / 2 - usernameLabel.getHeight()*3/2);
		usernameLabel.setVisible(true);
		
		//Password Label
		JLabel passwordLabel = new JLabel();
		passwordLabel.setText("<html><b>Password: </b><html>");
		passwordLabel.setForeground(Color.BLACK);
		Font passwordFont = passwordLabel.getFont();
		passwordLabel.setFont(new Font(passwordFont.getName(), 4, 14));
		passwordLabel.setSize(110, 25);
		panel.add(passwordLabel);
		passwordLabel.setLocation(
				panel.getWidth() / 2 - passwordLabel.getWidth(),
				panel.getHeight() / 2 - passwordLabel.getHeight() * 1/2);
		passwordLabel.setVisible(true);
		
		//Username Textbox
		JTextField usernameText = new JTextField();
		usernameText.setSize(110, 25);
		Font usernameBoxFont = usernameText.getFont();
		usernameLabel.setFont(new Font(usernameBoxFont.getName(), 4, 14));
		panel.add(usernameText);
		usernameText.setLocation(panel.getWidth() / 2, panel.getHeight() / 2
				- usernameLabel.getHeight() * 3/2);
		usernameText.setVisible(true);
		
		// password Textbox
		JTextField passwordText = new JTextField();
		passwordText.setSize(110, 25);
		Font passwordBoxFont = passwordText.getFont();
		passwordLabel.setFont(new Font(passwordBoxFont.getName(), 4, 14));
		panel.add(passwordText);
		passwordText.setLocation(panel.getWidth() / 2 , panel.getHeight() / 2
				- passwordLabel.getHeight() * 1 / 2);
		passwordText.setVisible(true);
		
		// Set up Login Button
		JButton loginButton = new JButton();
		loginButton.setSize(110, 25);
		loginButton.setText("Login");
		loginButton.setLocation(
				(panel.getWidth() / 2) - loginButton.getWidth() * 1/2,
				(panel.getHeight() / 2) + (loginButton.getHeight()));
		panel.add(loginButton);
		loginButton.addActionListener(g.new LoginListener());
		loginButton.setVisible(true);

		
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
	
	public void createQueryWindow() {
		this.activeFrames.get(0).setVisible(false);
		
		JFrame queryFrame = new JFrame("And... They're Searching!");
		queryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.activeFrames.add(queryFrame);
		
		Image image = new ImageIcon("resources/trackBackground.jpg").getImage();
		JPanel queryPanel = new ImagePanel(image);
		queryPanel.setVisible(true);
		
		queryFrame.add(queryPanel);
		queryFrame.pack();
		queryFrame.setVisible(true);
		queryFrame.setLocationRelativeTo(null);
	}
	
	class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			createQueryWindow();
			
		}
	}
}



class ImagePanel extends JPanel {

	private Image img;

	public ImagePanel(Image img) {
		super();
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
}
