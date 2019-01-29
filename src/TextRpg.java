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
	JPanel rpgTitlePanel, startButtonPanel, currentInstancePanel, playerChoiceButtonPanel, playerHudPanel;
	// Displays text on screen
	JLabel rpgTitleLabel, manaLabel, manaLabelNum, magickaLabel, magickaLabelNum, equippedLabel, equippedLabelName;
	// Allows the game title font to be styled
	Font rpgTitleFont = new Font("Courier", Font.PLAIN, 50);
	Font plainFont = new Font("Courier", Font.PLAIN, 28);
	JButton startButton, optionOne, optionTwo, optionThree, optionFour;
	JTextArea currentInstanceTextArea;
	int playerMana, playerMagicka, enemyMana, mysteryBox;
	String item, position;
	
	MainScreenHandler msHandler = new MainScreenHandler();
	OptionHandler optionHandler = new OptionHandler();

	public static void main(String[] args) {
		
		// Starts the new instance of the game
		new TextRpg();
	}
	
	public TextRpg() {
		
		// Initializes new JFrame window as well as adding title
		gameWindow = new JFrame("Astria: Land of the Abyss");
		// Sets windows width and height
		gameWindow.setSize(1440, 900);
		// Adds function that allows you to close the game window
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Sets background color for game window
		gameWindow.getContentPane().setBackground(Color.black);
		// Disables default layout 
		gameWindow.setLayout(null);
		gameWindow.setResizable(false);
		con = gameWindow.getContentPane();
		
		// Creates space for title
		rpgTitlePanel = new JPanel();
		// Sets space dimensions for the title
		rpgTitlePanel.setBounds(350, 150, 780, 150);
		rpgTitlePanel.setBackground(Color.black);
		rpgTitleLabel = new JLabel("ASTRIA: Land of the Abyss");
		rpgTitleLabel.setForeground(Color.orange);
		rpgTitleLabel.setFont(rpgTitleFont);
		rpgTitlePanel.add(rpgTitleLabel);
		con.add(rpgTitlePanel);
		
		// Creates start button and space for game
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(550, 300, 400, 100);
		startButtonPanel.setBackground(Color.black);
		con.add(startButtonPanel);
		
		startButton = new JButton("BEGIN");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.orange);
		startButton.setBorderPainted(false);
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
		currentInstancePanel = new JPanel();
		currentInstancePanel.setBounds(100, 100, 600, 250);
		currentInstancePanel.setBackground(Color.black);
		con.add(currentInstancePanel);
		
		// Handles text box area for the beginning instance of game
		currentInstanceTextArea = new JTextArea();
		currentInstanceTextArea.setBounds(100, 100, 800, 250);
		currentInstanceTextArea.setBackground(Color.black);
		currentInstanceTextArea.setForeground(Color.white);
		currentInstanceTextArea.setFont(plainFont);
		currentInstanceTextArea.setLineWrap(true);
		currentInstancePanel.add(currentInstanceTextArea);
		
		// Handles buttons for players to make choices
		playerChoiceButtonPanel = new JPanel();
		playerChoiceButtonPanel.setBounds(250, 350, 300, 150);
		playerChoiceButtonPanel.setBackground(Color.black);
		playerChoiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(playerChoiceButtonPanel);
		
		// First button
		optionOne = new JButton("Option One");
		optionOne.setBackground(Color.black);
		optionOne.setForeground(Color.black);
		optionOne.setFont(plainFont);
		optionOne.addActionListener(optionHandler);
		optionOne.setActionCommand("opt1");
		playerChoiceButtonPanel.add(optionOne);
		
		// Second Button
		optionTwo = new JButton("Option Two");
		optionTwo.setBackground(Color.black);
		optionTwo.setForeground(Color.black);
		optionTwo.setFont(plainFont);
		optionTwo.addActionListener(optionHandler);
		optionTwo.setActionCommand("opt2");
		playerChoiceButtonPanel.add(optionTwo);
		
		// Third Button
		optionThree = new JButton("Option Three");
		optionThree.setBackground(Color.black);
		optionThree.setForeground(Color.black);
		optionThree.setFont(plainFont);
		optionThree.addActionListener(optionHandler);
		optionThree.setActionCommand("opt3");
		playerChoiceButtonPanel.add(optionThree);
		
		// Fourth Button
		optionFour = new JButton("Option Four");
		optionFour.setBackground(Color.black);
		optionFour.setForeground(Color.black);
		optionFour.setFont(plainFont);
		optionFour.addActionListener(optionHandler);
		optionFour.setActionCommand("opt4");
		playerChoiceButtonPanel.add(optionFour);
		
		// For displaying player HUD above each instance
		playerHudPanel = new JPanel();
		playerHudPanel.setBounds(25, 15, 1400, 50);
		playerHudPanel.setBackground(Color.black);
		playerHudPanel.setLayout(new GridLayout(1, 4));
		con.add(playerHudPanel);
		
		// Each of the actual HUD items (Mana)
		manaLabel = new JLabel("Mana:");
		manaLabel.setFont(plainFont);
		manaLabel.setForeground(Color.red);
		playerHudPanel.add(manaLabel);
		manaLabelNum = new JLabel();
		manaLabelNum.setFont(plainFont);
		manaLabelNum.setForeground(Color.white);
		playerHudPanel.add(manaLabelNum);
		
		// Magicka
		magickaLabel = new JLabel("Magicka:");
		magickaLabel.setFont(plainFont);
		magickaLabel.setForeground(Color.magenta);
		playerHudPanel.add(magickaLabel);
		magickaLabelNum = new JLabel();
		magickaLabelNum.setFont(plainFont);
		magickaLabelNum.setForeground(Color.white);
		playerHudPanel.add(magickaLabelNum);
		
		// Item Equipped in hand
		equippedLabel = new JLabel("Equipped:");
		equippedLabel.setFont(plainFont);
		equippedLabel.setForeground(Color.lightGray);
		playerHudPanel.add(equippedLabel);
		equippedLabelName = new JLabel();
		equippedLabelName.setFont(plainFont);
		equippedLabelName.setForeground(Color.white);
		playerHudPanel.add(equippedLabelName);
		
		playerStats();
	}
	
	public void playerStats() {
		
		// player base stats
		playerMana = 20;
		playerMagicka = 15;
		item = "Dagger";
		
		manaLabelNum.setText("" + playerMana);
		magickaLabelNum.setText("" + playerMagicka);
		equippedLabelName.setText(item);
		
		mainEntrance();
	}
	
	public void mainEntrance() {
		
		position = "mainEntrance";
		currentInstanceTextArea.setText("You arrive at the entrance of a large city. \nThere is is a guard outside of the gate watching you. \nWhat is your next move?");
		optionOne.setText("Speak to Guard");
		optionTwo.setText("Shove guard");
		optionThree.setText("Leave");
		optionFour.setText("Sigh");
	}
	
	public void guardConversation() {
		
		position = "guardConversation";
		currentInstanceTextArea.setText("Greetings traveler. I have not seen you around these parts. \nI cannot grant you passage, please return with the proper seal of approval");
		optionOne.setText("back");
		optionTwo.setText("...");
		optionThree.setText("...");
		optionFour.setText("...");
		
	}
	
	public void shoveGuard() {
		
		position = "shoveGuard";
		currentInstanceTextArea.setText("The guard shoves you with his shield using great force. \nTry that again and you'll get the spear. \nYou hit the ground. (You take 3 fall damage)");
		playerMana = playerMana - 3;
		manaLabelNum.setText("" + playerMana);
		optionOne.setText("get up & leave");
		optionTwo.setText("...");
		optionThree.setText("...");
		optionFour.setText("...");		
	}
	
	public void crossRoad() {
		
		position = "crossRoad";
		currentInstanceTextArea.setText("You are back at the crossroads. \nIf you follow the Southern path you will return to the city.");
		optionOne.setText("Head North");
		optionTwo.setText("Head East");
		optionThree.setText("Head South");
		optionFour.setText("Head West");
	}

	public void northernRoute() {
		
		position = "northernRoute";
		currentInstanceTextArea.setText("You see a willow tree with ample shade. \nIt may be time for a short nap. \n\n(You awake and regain 2 mana points)");
		playerMana = playerMana + 2;
		manaLabelNum.setText("" + playerMana);
		optionOne.setText("Head South");
		optionTwo.setText("...");
		optionThree.setText("...");
		optionFour.setText("...");
	}
	
	public void easternRoute() {
		
		position = "easternRoute";
		currentInstanceTextArea.setText("You see some rubble and what looks like a hat. \nAs you search around you discover a clothed skeleton and a rapier!!\n\n(You have obtained a rapier)");
		item = "Rapier";
		equippedLabelName.setText(item);
		optionOne.setText("Head West");
		optionTwo.setText("...");
		optionThree.setText("...");
		optionFour.setText("...");
	}
	
	public void westernRoute() {
		
		position = "westernRoute";
		currentInstanceTextArea.setText("You are walking down the path and hear rustling off to your right. \nAs you walk closer you see the club of a troll. \nIt has spotted you");
		optionOne.setText("Quickly Attack");
		optionTwo.setText("Escape");
		optionThree.setText("...");
		optionFour.setText("...");
	}
	
	public void attack() {
		
		position = "attack";
		currentInstanceTextArea.setText("Enemy Mana: " + enemyMana + "\n\nWhat is your next move?");
		optionOne.setText("Quick Attack");
		optionTwo.setText("Escape");
		optionThree.setText("...");
		optionFour.setText("...");
	}
	
	public void playerTurn() {
		
		position = "playerTurn";
		
		int playerDmg = 0;
		
		if(item.contentEquals("Dagger")) {
			playerDmg = new java.util.Random().nextInt(3);
		} else if(item.equals("Rapier")) {
			playerDmg = new java.util.Random().nextInt(12);
		}
		
		currentInstanceTextArea.setText("You swung at the monster and dealt" + playerDmg + " damage to it's mana!");
		enemyMana = enemyMana - playerDmg;
		
		optionOne.setText("Head back");
		optionTwo.setText("...");
		optionThree.setText("...");
		optionFour.setText("...");
	}
	
	public void enemyTurn() {
		
		position = "enemyTurn";
		
		int enemyDmg = 0;
		
		enemyDmg = new java.util.Random().nextInt(6);
		
		currentInstanceTextArea.setText("The enemy flinched but lunged at you for an attack and landed  " + enemyDmg + " to your mana!");
		
		playerMana = playerMana - enemyDmg;
		manaLabelNum.setText("" + playerMana);
		
		optionOne.setText("Head Back");
		optionTwo.setText("...");
		optionThree.setText("...");
		optionFour.setText("...");
	}
	
	public void enemyDeath() {
		
		position = "enemyDeath";
		
		currentInstanceTextArea.setText("Congratulations! You defeated the enemy. \nYou search it's corpse and find a mysterious box.\n\n(You decide to place the box in your inventory)");
		
		mysteryBox = 1;
		
		optionOne.setText("Head East");
		optionTwo.setText("...");
		optionThree.setText("...");
		optionFour.setText("...");
	}
	
	public void enemyVictory() {
		
		position = "enemyVictory";
		
		currentInstanceTextArea.setText("Unfortunately your weakness has resulted in your death!\n\n");
		
		optionOne.setText("");
		optionTwo.setText("");
		optionThree.setText("");
		optionFour.setText("");
		optionOne.setVisible(false);
		optionTwo.setVisible(false);
		optionThree.setVisible(false);
		optionFour.setVisible(false);
	}
	
	public void tempQuestEnd() {
		
		position = "tempQuestEnd";
		
		currentInstanceTextArea.setText("You return to the gate of the city. \nThe guard sees the box in your bag. " + "Guard: You defeated the troll king?!\n Well strange traveler, I suppose I could let you pass");
		
		optionOne.setText("");
		optionTwo.setText("");
		optionThree.setText("");
		optionFour.setText("");
		optionOne.setVisible(false);
		optionTwo.setVisible(false);
		optionThree.setVisible(false);
		optionFour.setVisible(false);
		
	}
	
	
	// The class below handles the transition from the title screen to main instance
	public class MainScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			astriaGameScreenCreation();
			
		}

	}
	
	public class OptionHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			String playerOption = event.getActionCommand();
			
            switch(position)
            {
            case "mainEntrance":
                switch(playerOption){
                case "opt1":
                    if(mysteryBox == 1)
                    {
                        tempQuestEnd();
                    }
                    else
                    {
                        guardConversation();
                    }
                    break;
                case "opt2":
                    shoveGuard();
                    break;
                case "opt3":
                    crossRoad();
                    break;
                }
                break;
            case "guardConversation":
                switch(playerOption)
                {
                case "opt1":
                    mainEntrance();
                    break;
                }
                break;
            case "shoveGuard":
                switch(playerOption)
                {
                case "opt1":
                    mainEntrance();
                    break;
                }
                break;
            case "crossRoad":
                switch(playerOption)
                {
                case "opt1":
                    northernRoute();
                    break;
                case "opt2":
                    easternRoute();
                    break;
                case "opt3":
                    mainEntrance();
                    break;
                case "opt4":
                    westernRoute();
                    break;
                }
                break;
            case "northernRoute":
                switch(playerOption)
                {
                case "opt1":
                    crossRoad();
                    break;
                }
                break;
            case "easternRoute":
                switch(playerOption)
                {
                case "opt1":
                    crossRoad();
                    break;
                }
                break;
            case "westernRoute":
                switch(playerOption)
                {
                case "opt1":
                    attack();
                    break;
                case "opt2":
                    crossRoad();
                    break;
                }
                break;
            case "attack":
                switch(playerOption)
                {
                case "opt1":
                    playerTurn();
                    break;
                case "opt2":
                    crossRoad();
                    break;
                }
                break;
            case "playerTurn":
                switch(playerOption)
                {
                case "opt1":
                    if(enemyMana < 1)
                    {
                        enemyDeath();
                    }
                    else
                    {
                        enemyTurn();
                    }
                    break;
                }
                break;
            case "enemyTurn":
                switch(playerOption)
                {
                case "opt1":
                    if(playerMana < 1)
                    {
                        enemyVictory();
                    }
                    else
                    {
                        attack();
                    }
                    break;
                }
                break;
            case "enemyDeath":
                switch(playerOption)
                {
                case "opt1":
                    crossRoad();
                }
                break;

            }
		}
	}
}
