package rpgController;

import rpgModel.Goblin;
import rpgView.RPGFrame;
import rpgModel.Monster;
import rpgView.RPGPanel;
import rpgModel.Attacking;
import rpgView.RPGPanel;
import rpgController.MobTurnSequence;

public class RPGAppController extends Goblin
{
	private Goblin firstGoblin;
	private RPGFrame baseFrame;
	protected static int goblinNumber;
	private Goblin Goblin; 
	private int playerHealthMax;
	private int playerHealthCurrent;
	private int playerAccuracy;
	private int playerStrength;
	private int playerMagic;
	private int playerDodge;
	private int playerAttack;
	private int playerArmor;
	private int playerAttackMin;
	private int playerAttackSpeed;
	private int playerLevel;
	public int liveMonster;
	private static String narrationText;
	public boolean isPlayersTurn;
	
	public void start()
	{
		Goblin = new Goblin();
		Monster [] tempGoblins = getFirstGoblin().getGoblins();
		narrationText = "you see a" + tempGoblins[goblinNumber].getName();
		String myNamePlayer = baseFrame.getResponse("What is your name");
		firstGoblin.setNamePlayer(myNamePlayer);
		baseFrame.setTitle(myNamePlayer + "'s hipster project");
		isPlayersTurn = true;
		
	} 
	public RPGAppController()
	{
		firstGoblin = new Goblin();
		baseFrame = new RPGFrame(this);
		goblinNumber = (int)(Math.random()*5);
		
		this.playerHealthMax = 20;
		this.playerHealthCurrent = 20;
		this.playerAccuracy = 0;
		this.playerStrength = 0;
		this.playerMagic = 0;
		this.playerDodge = 10;
		this.playerAttack = 0;
		this.playerAttackMin = 1;
		this.playerArmor = 0;
		this.playerAttackSpeed = 1;
		this.playerLevel = 1;
		this.liveMonster = 1;
		RPGAppController.narrationText = "";
		
		if(isPlayersTurn == false)
		{
			MobTurnSequence myMobTurnSequence = new MobTurnSequence();
		}
		else
		{
			
		}
		
	}
	
	
	
	public RPGAppController(int playerHealthMax, int playerAccuracy, int playerStrength, int playerMagic, int playerDodge, int playerAttack, int playerArmor, int playerAttackMin, int playerAttackSpeed, int playerLevel)
	{
		this.playerHealthMax = playerHealthMax;
		this.playerHealthCurrent = playerHealthCurrent;
		this.playerAccuracy = playerAccuracy;
		this.playerStrength = playerStrength;
		this.playerMagic = playerMagic;
		this.playerDodge = playerDodge;
		this.playerAttack = playerAttack;
		this.playerAttackMin = playerAttackMin;
		this.playerArmor = playerArmor;
		this.playerAttackSpeed = playerAttackSpeed;
		this.playerLevel = playerLevel;
		this.liveMonster = liveMonster;
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
	
	public int getLiveMonster() 
	{
		return liveMonster;
	}
	public void setLiveMonster(int liveMonster) 
	{
		this.liveMonster = liveMonster;
	}
	public int getPlayerHealthCurrent() 
	{
		return playerHealthCurrent;
	}
	public void setPlayerHealthCurrent(int playerHealthCurrent) 
	{
		this.playerHealthCurrent = playerHealthCurrent;
	}
	public static int getGoblinNumber() 
	{
		return goblinNumber;
	}

	public void setGoblinNumber(int goblinNumber) 
	{
		this.goblinNumber = (int)(Math.random()*5);
	}

	public Goblin getFirstGoblin() 
	{
		return firstGoblin;
	}
	
	public RPGFrame getBaseFrame() 
	{
		return baseFrame;
	}
	
	public int getPlayerHealthMax() 
	{
		return playerHealthMax;
	}

	public void setPlayerHealthMax(int playerHealthMax) 
	{
		this.playerHealthMax = playerHealthMax;
	}

	public int getPlayerAccuracy() 
	{
		return playerAccuracy;
	}

	public void setPlayerAccuracy(int playerAccuracy) 
	{
		this.playerAccuracy = playerAccuracy;
	}

	public int getPlayerStrength() 
	{
		return playerStrength;
	}

	public void setPlayerStrength(int playerStrength) 
	{
		this.playerStrength = playerStrength;
	}

	public int getPlayerMagic() 
	{
		return playerMagic;
	}

	public void setPlayerMagic(int playerMagic) 
	{
		this.playerMagic = playerMagic;
	}

	public int getPlayerDodge() 
	{
		return playerDodge;
	}

	public void setPlayerDodge(int playerDodge) 
	{
		this.playerDodge = playerDodge;
	}

	public int getPlayerAttack() 
	{
		return playerAttack;
	}

	public void setPlayerAttack(int playerAttack) 
	{
		this.playerAttack = playerAttack;
	}

	public int getPlayerArmor() 
	{
		return playerArmor;
	}

	public void setPlayerArmor(int playerArmor) 
	{
		this.playerArmor = playerArmor;
	}

	public int getPlayerAttackMin() 
	{
		return playerAttackMin;
	}

	public void setPlayerAttackMin(int playerAttackMin) 
	{
		this.playerAttackMin = playerAttackMin;
	}

	public int getPlayerAttackSpeed()
	{
		return playerAttackSpeed;
	}

	public void setPlayerAttackSpeed(int playerAttackSpeed) 
	{
		this.playerAttackSpeed = playerAttackSpeed;
	}

	public int getPlayerLevel() 
	{
		return playerLevel;
	}

	public void setPlayerLevel(int playerLevel)
	{
		this.playerLevel = playerLevel;
	}

	
}
