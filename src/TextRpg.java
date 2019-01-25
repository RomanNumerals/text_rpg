import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextRpg {
	
	// This uses the import that allows window creation for game to run
	JFrame gameWindow;
	// Creates container for use further down
	Container con;
	// Used to make game window inner components
	JPanel rpgTitlePanel, startButtonPanel;
	// Displays text on screen
	JLabel rpgTitleLabel;
	// Allows the game title font to be styled
	Font rpgTitleFont = new Font("Courier", Font.PLAIN, 50);
	Font plainFont = new Font("Courier", Font.PLAIN, 28);
	JButton startButton;

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
		startButtonPanel.add(startButton);
		
		// Actually makes game window visible
		gameWindow.setVisible(true);
	}
}
