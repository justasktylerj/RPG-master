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
	public boolean isPlayersTurn;

	
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
	}
	
	public RPGAppController()
	{
		firstGoblin = new Goblin();
		baseFrame = new RPGFrame(this);
		Monster [] tempGoblins = getGoblins();
		
	}
	
	public boolean isPlayersTurn() 
	{
		return isPlayersTurn;
	}
	
	public void setPlayersTurn(boolean isPlayersTurn) 
	{
		this.isPlayersTurn = isPlayersTurn;
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
