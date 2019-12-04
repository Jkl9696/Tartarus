import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	JFrame fwindow;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4 ;
	JTextArea mainTextArea;
	int playerHP, monsterHP, silverRing, roomcount;
	String weapon;
	String position;
	static int score = 0;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	
	public static void main(String[] args) {

	new Game();

	}
	
	public Game() {

	/**
	* creates frame to put our title 
	*/

	//creates now frame
	fwindow = new JFrame();

	// creates window that is 800 by 600 pixles
	fwindow.setSize(800, 600);

	//adds function on window to close
	fwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//sets backround color on the frame
	fwindow.getContentPane().setBackground(Color.black);

	// sets custom layout 
	fwindow.setLayout(null);

	//Actually shows the window

	con = fwindow.getContentPane();

	/**
	* creates new title text and panel
	*/

	titleNamePanel = new JPanel();
	// creates space for title screen on frame that was made (starts on 100x, 100y, and length and with )
	titleNamePanel.setBounds(100, 100, 600, 150);
	titleNamePanel.setBackground(Color.black);
	// sets name of game
	titleNameLabel = new JLabel("TARTARUS");
	titleNameLabel.setForeground(Color.white);
	//using font that was created 
	titleNameLabel.setFont(titleFont);
	//add to title panel
	titleNamePanel.add(titleNameLabel);
	// adds to the base frame made
	con.add(titleNamePanel);

	/**
	* creates new start button 
	*/

	startButtonPanel = new JPanel();
	startButtonPanel.setBounds(300, 400, 200, 100);
	startButtonPanel.setBackground(Color.black);

	startButton = new JButton("START");
	startButton.setForeground(Color.red);
	startButton.setBackground(Color.black);
	startButton.setFont(normalFont);
	// adds an action listener when u click the button it calls the result in the method 
	startButton.addActionListener(tsHandler);
	startButton.setFocusPainted(false);

	titleNamePanel.add(titleNameLabel);
	startButtonPanel.add(startButton);

	con.add(titleNamePanel);
	con.add(startButtonPanel);
	fwindow.setVisible(true);
	}

	public void createGameScreen() {
	/**
	* creates text area for the actual game
	*/
	titleNamePanel.setVisible(false);
	startButtonPanel.setVisible(false);

	mainTextPanel = new JPanel();
	mainTextPanel.setBounds(100, 100, 600, 250);
	mainTextPanel.setBackground(Color.black);
	con.add(mainTextPanel);

	// creates text in text area
	mainTextArea = new JTextArea("This is the main text area this game is going to be great and amazing");
	mainTextArea.setBounds(100, 100, 600, 250);
	mainTextArea.setBackground(Color.black);
	mainTextArea.setForeground(Color.white);
	mainTextArea.setFont(normalFont);
	mainTextArea.setLineWrap(true);
	mainTextArea.setEditable(false);
	mainTextPanel.add(mainTextArea);

	// creates player action list that they can do 
	choiceButtonPanel = new JPanel();
	choiceButtonPanel.setBounds(250, 350, 300, 150);
	choiceButtonPanel.setBackground(Color.black);
	choiceButtonPanel.setForeground(Color.white);
	choiceButtonPanel.setLayout(new GridLayout(4,1));
	con.add(choiceButtonPanel);

	// making the buttons for the choices that a player can choose
	// making of choice 1
	choice1 = new JButton("Choice 1");
	choice1.setBackground(Color.black);
	choice1.setForeground(Color.red);
	choice1.setFont(normalFont);
	choice1.setFocusPainted(false);
	choice1.addActionListener(choiceHandler);
	choice1.setActionCommand("c1");
	choiceButtonPanel.add(choice1);

	// making of choice 2
	choice2 = new JButton("Choice 2");
	choice2.setBackground(Color.black);
	choice2.setForeground(Color.red);
	choice2.setFont(normalFont);
	choice2.setFocusPainted(false);
	choice2.addActionListener(choiceHandler);
	choice2.setActionCommand("c2");
	choiceButtonPanel.add(choice2);

	// making of choice 3
	choice3 = new JButton("Choice 3");
	choice3.setBackground(Color.black);
	choice3.setForeground(Color.red);
	choice3.setFont(normalFont);
	choice3.setFocusPainted(false);
	choice3.addActionListener(choiceHandler);
	choice3.setActionCommand("c3");
	choiceButtonPanel.add(choice3);

	// making of choice 4
	choice4 = new JButton("Choice 4");
	choice4.setBackground(Color.black);
	choice4.setForeground(Color.red);
	choice4.setFont(normalFont);
	choice4.setFocusPainted(false);
	choice4.addActionListener(choiceHandler);
	choice4.setActionCommand("c4");
	choiceButtonPanel.add(choice4);

	// area for the hp and weapon
	playerPanel = new JPanel();
	playerPanel.setBounds(100, 15, 600, 50);
	playerPanel.setBackground(Color.black);
	playerPanel.setLayout(new GridLayout(1,4));
	con.add(playerPanel);

	// for hp label and number 
	hpLabel = new JLabel("HP: ");
	hpLabel.setFont(normalFont);
	hpLabel.setForeground(Color.white);
	playerPanel.add(hpLabel);
	hpLabelNumber = new JLabel ();
	hpLabelNumber.setFont(normalFont);
	hpLabelNumber.setForeground(Color.white);
	playerPanel.add(hpLabelNumber);

	// for weapon label
	weaponLabel = new JLabel("Weapon: ");
	weaponLabel.setFont(normalFont);
	weaponLabel.setForeground(Color.white);
	playerPanel.add(weaponLabel);
	weaponLabelName = new JLabel();
	weaponLabelName.setFont(normalFont);
	weaponLabelName.setForeground(Color.white);
	playerPanel.add(weaponLabelName);

	playerSetup();


	}
	public void playerSetup() {
	// TODO Auto-generated method stub
	playerHP = 15;
	monsterHP = 25;
	weapon = "Fist";
	// set the weapon created above in the game can put variable name and "...." text only for !!!strings!!!!
	weaponLabelName.setText(weapon);
	// only way to show int is by putting quotes and + int
	hpLabelNumber.setText("" + playerHP);

	townGate();
	}
	
	private void townGate() {
	// TODO Auto-generated method stub
	position = "townGate"; 

	mainTextArea.setText("You are at the gate of a quiet town.\n A menacing guard is standing in front of you.\n\n What do you do.");

	choice1.setText("Talk to guard");
	choice2.setText("Attack to guard");
	choice3.setText("Leave");
	choice4.setText("");
	}
	/**
	* @author Jared sullin 
	* this is a text adventure game like oregan trail the 
	* objective is to go to the village and win the heart of the guard 
	* 
	*/


	public class TitleScreenHandler implements ActionListener{

	public void actionPerformed(ActionEvent event) {
	// TODO Auto-generated method stub
	createGameScreen();
	
	
	}

	}
	public class ChoiceHandler implements ActionListener{

	public void actionPerformed(ActionEvent event) {
	// TODO Auto-generated method stub
	String yourChoice = event.getActionCommand();

	switch(position) {
	case"townGate":
	// switch (if your position is town gate) then case 1 dose a method etc...
	switch(yourChoice) {
	case "c1": 
	if(silverRing==1) {
	roomcount += 1;
	ending();
	
	}
	else {
	roomcount += 1;
	talkGuard(); 
	}
	break;
	case "c2": attackGuard();roomcount += 1; break;
	case "c3": crossRoad();roomcount += 1; break;
	case "c4": break;
	}
	break;
	case"talkGuard":
	switch(yourChoice) {
	case "c1" : townGate();roomcount += 1; break;
	}
	break;
	case"attackGuard":
	switch(yourChoice) {
	case "c1" : townGate();roomcount += 1; break;
	}
	break;
	case"crossRoad":
	switch(yourChoice) {
	case "c1": north();roomcount += 1; break;
	case "c2": east();roomcount += 1; break;
	case "c3": townGate();roomcount += 1; break;
	case "c4": west();roomcount += 1; break;
	}
	break;
	case "north":
	switch(yourChoice) {
	case "c1": crossRoad();roomcount += 1; break;
	case "c2": north2();roomcount += 1; break;
	}
	break;
	case"north2":
	switch(yourChoice) {
	case "c1": north();roomcount += 1; break;
	case "c2": smallChest();roomcount += 1; break;
	}
	break;
	case "smallChest":
	switch(yourChoice) {	
	case "c1": north2();roomcount += 1; break;
	}
	break;
	case "east":
	switch(yourChoice) {
	case "c1": crossRoad();roomcount += 1; break;
	case "c2":  emptyRoom();roomcount += 1; break;
	}
	break;
	case"emptyRoom":
	switch(yourChoice) {
	case "c1": east();roomcount += 1; break;
	case "c2": east2();roomcount += 1; break;
	}
	break;
	case"east2":
	switch(yourChoice) {
	case "c1": emptyRoom();roomcount += 1; break;
	}
	break;
	case"west":
	switch(yourChoice) {
	case "c1": fight();roomcount += 1; break;
	case "c2": crossRoad();roomcount += 1; break;
	}
	break;
	case"fight":
	switch(yourChoice) {
	case "c1": playerAttack();roomcount += 1; break;
	case "c2": crossRoad();roomcount += 1; break;
	case "c3": break;
	}
	break;
	
	
	//  if i wanted continuous play through buttons 
	//  but the scoring system would be off
	  
	//case"lose":
	//switch(yourChoice) {
	//case "c1": playerSetup(); break;
	//}
	//break;
	//case"ending":
	//switch(yourChoice) {
	//case "c1": playerSetup(); break;
	//}
	//break;	
	
	
	case"playerAttack":
	switch(yourChoice) {
	case "c1": 
	roomcount += 1;
	if(monsterHP<1) {
	win();
	}
	else {
	monsterAttack();
	}
	break;
	}
	break;
	case"monsterAttack":
	switch(yourChoice) {
	case "c1": 
	roomcount += 1;
	if(playerHP<1) {
	lose();
	}
	else {
	fight(); 
	}
	break;
	}
	break;
	case"win":
	switch(yourChoice) {
	case "c1": crossRoad();roomcount += 1; break;
	}
	break;
	}
	
	}
	
	


	public void talkGuard() {
	position = "talkGuard"; 
	
		mainTextArea.setText("Guard: Hello stranger.\n I have never seen you before.\n I'm sorry but I cannot let you enter this town. ");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	public void attackGuard() {

	position = "attackGuard"; 
	
	mainTextArea.setText("Guard: Hey dont be dumb.\n\n The guard fought back and hit you hard.\n (You receive 3 damage) ");
	playerHP = playerHP - 3;
		
	hpLabelNumber.setText("" + playerHP);
	choice1.setText(">");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");
	
	if(playerHP<1) {
		lose();
		}
	
	}

	public void north2() {
		position = "north2"; 

		mainTextArea.setText("You see a crazy old man.\n He walks up to you says you must defeat \n the hydra to win the heart of the guard");
		
		choice1.setText("Go south");
		choice2.setText("Go north");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void east2() {
		position = "east2"; 

		if(weapon.equals("Demonic Sword")) {
			mainTextArea.setText("You walk into a dark room and find a empty pedestal.");
			
			choice1.setText("Go west");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
			
		else {
			mainTextArea.setText("You see a crazy sword with a dark aura\n You pull it from its pedestal\n\n (You have Obtained the Demon Sword)");
			
			weapon = "Demonic Sword";
			weaponLabelName.setText(weapon);
			choice1.setText("Go west");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
	}
	
	public void crossRoad() {
	position = "crossRoad"; 

	mainTextArea.setText("You are at a crossroad in a labyrinth.\n If you go south, you will go back to the town.\n\n What do you do.");
	choice1.setText("Go north");
	choice2.setText("Go east");
	choice3.setText("Go south");
	choice4.setText("Go west");
	}

	public void north() {
	position = "north"; 
	
	mainTextArea.setText("There is a fountain.\n You drink the water and rest by the fountain.\n\n (Your HP is recovered by 2).");
	playerHP = playerHP + 2;

	hpLabelNumber.setText("" + playerHP);
	choice1.setText("Go south");
	choice2.setText("Go north");
	choice3.setText("");
	choice4.setText("");
	}

	public void east() {
	position = "east"; 
	if(weapon.equals("Demonic Sword")) {
		mainTextArea.setText("You walk into a dark room and find a empty chest.");
		
		choice1.setText("Go west");
		choice2.setText("Go east");
		choice3.setText("");
		choice4.setText("");

	}
	else {
		mainTextArea.setText("You walk into a dark room and find a chest.\n You open it and find a Long Sword.\n\n (You have obtained a Long Sword ).");

		weapon = "Long Sword";
		weaponLabelName.setText(weapon);
		choice1.setText("Go west");
		choice2.setText("Go east");
		choice3.setText("");
		choice4.setText("");
	}
	
	}
	
	public void setScore() {
		
		if(weapon.equals("Fist")) {
			score = roomcount * 1 ;
			}
		else if(weapon.equals("knife")) {
			score = roomcount * 5 ;
			}
		else if(weapon.equals("Long Sword")) {
			score = roomcount * 10 ;
			}
		else if(weapon.equals("Demonic Sword")) {
			score = roomcount * 15 ;
			}
	}
	
	public void west() {
	position = "west"; 

	mainTextArea.setText("You encounter a Hydra.\n What do you do.");

	choice1.setText("Fight");
	choice2.setText("Run");
	choice3.setText("");
	choice4.setText("");

	}

	public void fight() {
	position = "fight"; 

	mainTextArea.setText("Hydra HP: " + monsterHP + "\n\n What do you do.");

	choice1.setText("Attack");
	choice2.setText("Run");
	choice3.setText("");
	choice4.setText("");
	}
	
	public void playerAttack() {
	position = "playerAttack"; 

	int playerDamage = 0;

	if(weapon.equals("Fist")) {
	playerDamage = new java.util.Random().nextInt(5);
	}
	else if(weapon.equals("knife")) {
	playerDamage = new java.util.Random().nextInt(9);	
	}
	else if(weapon.equals("Long Sword")) {
	playerDamage = new java.util.Random().nextInt(15);
	}
	// broken am i right forget holy swords
	else if(weapon.equals("Demonic Sword")) {
	playerDamage = new java.util.Random().nextInt(30);
	}
	mainTextArea.setText("You attack the Monster and gave " + playerDamage + " damage!");

	monsterHP = monsterHP - playerDamage;

	choice1.setText(">");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");	
	}

	public void monsterAttack() {
	position = "monsterAttack"; 

	int monsterDamage = 0;

	monsterDamage = new java.util.Random().nextInt(6);

	mainTextArea.setText("The Hydra attack you and gave " + monsterDamage + " damage!");

	playerHP = playerHP - monsterDamage;

	hpLabelNumber.setText("" + playerHP);

	choice1.setText(">");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");

	}

	public void win() {
	position = "win";

	mainTextArea.setText("You deafeated the Hydra!\nThe Hydra dropped a ring!\n\n (You obtained a silver ring)");

	silverRing = 1;

	choice1.setText("Go east");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");


	}

	public void lose() {
	position = "lose";

	mainTextArea.setText("You are dead!\n\n(GAME OVER)");

	choice1.setText("");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");
	choice1.setVisible(false);
	choice2.setVisible(false);
	choice3.setVisible(false);
	choice4.setVisible(false);
	}

	public void ending() {
	position = "ending";

	mainTextArea.setText("Guard: Oh! You deafeated the monster!\n Thank you so much you are a true hero!\n Welcome to our town\n (<THE END>)");

	choice1.setText("");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");
	choice1.setVisible(false);
	choice2.setVisible(false);
	choice3.setVisible(false);
	choice4.setVisible(false);
	
	setScore();
	
	Scoring s = new Scoring();
	try {
		s.writing(score);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	public void emptyRoom() {
		
	position = "emptyRoom";
	
	mainTextArea.setText(" You walk into a empty room.\n\n What do you do.");
		
	choice1.setText("Go west");
	choice2.setText("Go east");
	choice3.setText("");
	choice4.setText("");
	
	}
	
	public void smallChest() {
		position = "smallChest";
		
		if(weapon.equals("Demonic Sword") || weapon.equals("Long Sword")) {
			mainTextArea.setText("You walk into a dark room and find a empty chest.\n\n What do you do.");
			
			choice1.setText("Go south");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");

		}
		else {
			mainTextArea.setText("You see a small chest in a dark room\n You open it and see a knife\n\n (You have Obtained a knife)");
			
			weapon = "knife";
			weaponLabelName.setText(weapon);
			choice1.setText("Go south");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
	}
	
	
	}
	}



