import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextRpg {
	
	// This uses the import that allows window creation for game to run
	JFrame gameWindow;
	// Creates container for use further down
	Container con;
	// Used to make game window inner components
	JPanel rpgTitlePanel, startButtonPanel, mainInstancePanel, playerChoiceButtonPanel, playerHudPanel;
	// Displays text on screen
	JLabel rpgTitleLabel;
	// Allows the game title font to be styled
	Font rpgTitleFont = new Font("Courier", Font.PLAIN, 50);
	Font plainFont = new Font("Courier", Font.PLAIN, 28);
	JButton startButton, optionOne, optionTwo, optionThree, optionFour;
	JTextArea mainInstanceTextArea;
	
	MainScreenHandler msHandler = new MainScreenHandler();

	public static void main(String[] args) {
		
		// Starts the new instance of the game
		new TextRpg();
	}
	
	public TextRpg() {
		
		// Initializes new JFrame window as well as adding title
		gameWindow = new JFrame("Astria: Land of the Abyss");
		// Sets windows width and height
		gameWindow.setSize(900, 700);
		// Adds function that allows you to close the game window
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Sets background color for game window
		gameWindow.getContentPane().setBackground(Color.black);
		// Disables default layout 
		gameWindow.setLayout(null);
		con = gameWindow.getContentPane();
		
		// Creates space for title
		rpgTitlePanel = new JPanel();
		// Sets space dimensions for the title
		rpgTitlePanel.setBounds(50, 150, 780, 150);
		rpgTitlePanel.setBackground(Color.black);
		rpgTitleLabel = new JLabel("ASTRIA: Land of the Abyss");
		rpgTitleLabel.setForeground(Color.orange);
		rpgTitleLabel.setFont(rpgTitleFont);
		rpgTitlePanel.add(rpgTitleLabel);
		con.add(rpgTitlePanel);
		
		// Creates start button and space for game
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(250, 300, 400, 100);
		startButtonPanel.setBackground(Color.black);
		con.add(startButtonPanel);
		
		startButton = new JButton("BEGIN");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.black);
		startButton.setFont(plainFont);
		startButton.addActionListener(msHandler);
		startButtonPanel.add(startButton);
		
		// Actually makes game window visible
		gameWindow.setVisible(true);
	}
	
	public void astriaGameScreenCreation() {
		
		// Hides text rpg's main screen upon game start
		rpgTitlePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		// The beginning of the rpg
		mainInstancePanel = new JPanel();
		mainInstancePanel.setBounds(100, 100, 600, 250);
		mainInstancePanel.setBackground(Color.black);
		con.add(mainInstancePanel);
		
		// Handles text box area for the beginning instance of game
		mainInstanceTextArea = new JTextArea("Main text test");
		mainInstanceTextArea.setBounds(100, 100, 600, 250);
		mainInstanceTextArea.setBackground(Color.black);
		mainInstanceTextArea.setForeground(Color.white);
		mainInstanceTextArea.setFont(plainFont);
		mainInstanceTextArea.setLineWrap(true);
		mainInstancePanel.add(mainInstanceTextArea);
		
		// Handles buttons for players to make choices
		playerChoiceButtonPanel = new JPanel();
		playerChoiceButtonPanel.setBounds(250, 350, 300, 150);
		playerChoiceButtonPanel.setBackground(Color.black);
		playerChoiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(playerChoiceButtonPanel);
		
		// First button
		optionOne = new JButton();
		optionOne.setBackground(Color.black);
		optionOne.setForeground(Color.black);
		optionOne.setFont(plainFont);
		playerChoiceButtonPanel.add(optionOne);
		
		// Second Button
		optionTwo = new JButton();
		optionTwo.setBackground(Color.black);
		optionTwo.setForeground(Color.black);
		optionTwo.setFont(plainFont);
		playerChoiceButtonPanel.add(optionTwo);
		
		// Third Button
		optionThree = new JButton();
		optionThree.setBackground(Color.black);
		optionThree.setForeground(Color.black);
		optionThree.setFont(plainFont);
		playerChoiceButtonPanel.add(optionThree);
		
		// Fourth Button
		optionFour = new JButton();
		optionFour.setBackground(Color.black);
		optionFour.setForeground(Color.black);
		optionFour.setFont(plainFont);
		playerChoiceButtonPanel.add(optionFour);
		
		// For displaying player HUD above each instance
		playerHudPanel = new JPanel();
		playerHudPanel.setBounds(100, 15, 600, 50);
		playerHudPanel.setBackground(Color.red);
		playerHudPanel.setLayout(new GridLayout(1,4));
		con.add(playerHudPanel);
	}
	
	// The class below handles the transition from the title screen to main instance
	public class MainScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			astriaGameScreenCreation();
		}
	}
}
