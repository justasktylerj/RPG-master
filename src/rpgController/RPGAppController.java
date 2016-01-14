package rpgController;

import javax.swing.JLabel;

import rpgModel.Goblin;
import rpgView.RPGFrame;
import rpgModel.Monster;
import rpgView.RPGPanel;
import rpgView.RPGPanel;
import rpgController.MobTurnSequence;
import rpgModel.Mechanics;

public class RPGAppController extends Mechanics
{
	private Goblin firstGoblin;
	private RPGFrame baseFrame;
	protected Mechanics Mechanics;
	public static String narrationText;
	public boolean isPlayersTurn;
	public String narration1Text;
	public String narration2Text;
	public String narration3Text;
	
	
	public void start()
	{
		Mechanics = new Mechanics();
		Goblin = new Goblin();
		randGoblin = (int)(Math.random()*6);
		goblinNumber = randGoblin;
		Monster [] tempGoblins = getGoblins();
		String myNamePlayer = baseFrame.getResponse("What is your name");
		firstGoblin.setNamePlayer(myNamePlayer);
		baseFrame.setTitle(myNamePlayer + "'s Dungeon");
		isPlayersTurn = true;
		this.narration1Text = new String("you see a " + tempGoblins[goblinNumber].getName());
		this.narration2Text = new String("The dungeon floor is cold, and musty");
		this.narration3Text = new String("Welcome to the dungeon");
		
	} 
	
	public RPGAppController()
	{
		firstGoblin = new Goblin();
		baseFrame = new RPGFrame(this);
		Monster [] tempGoblins = getGoblins();
		
	}
	
	public void changeText()
	{
		String narration3Text = narration2Text;
		String narration2Text = narration1Text;
		String narration1Text = narrationText;
	}
	
	
	public boolean isPlayersTurn() 
	{
		return isPlayersTurn;
	}
	
	public void setPlayersTurn(boolean isPlayersTurn) 
	{
		this.isPlayersTurn = isPlayersTurn;
	}
	
	public String getNarrationText() 
	{
		return narrationText;
	}
	
	public void setNarrationText(String narrationText) 
	{
		this.narrationText = narrationText;
	}
	
	public Goblin getFirstGoblin() 
	{
		return firstGoblin;
	}
	
	public RPGFrame getBaseFrame() 
	{
		return baseFrame;
	}

	
}
