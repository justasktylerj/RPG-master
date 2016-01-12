package rpgController;

import rpgModel.Goblin;
import rpgView.RPGFrame;
import rpgModel.Monster;
import rpgView.RPGPanel;

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
	private int attackBonus;
	private int attackingBonus;
	private int playerStrength;
	private int playerMagic;
	private int playerDodge;
	private int playerAttack;
	private int playerArmor;
	private int playerAttackMin;
	private int playerAttackSpeed;
	private int playerLevel;
	private int damageTakenPlayer;
	private int damageTakenMonster;
	private int monsterAttacksTotal;
	private int monsterArmor;
	private int monsterDamage;
	private int monsterMinDamage;
	public int liveMonster;
	private int monsterDodge;
	private int hitContestMonster;
	private int hitContestPlayer;
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
		attackBonus = 0;
		hitContestMonster = 0;
		hitContestPlayer = 0;
		monsterDamage = 0;
		monsterAttacksTotal = 1;
		attackingBonus = 0;
		monsterDodge = 0;
		monsterArmor = 0;
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
	
	
	public void attackMonster()
	 {
			 Monster [] tempGoblins = getFirstGoblin().getGoblins();
			 attackingBonus = getPlayerAccuracy();
			 monsterDodge = tempGoblins[goblinNumber].getDodge();
			 hitContestPlayer = attackingBonus + (int)(Math.random()*20);
				if(hitContestPlayer >= monsterDodge)
				{
					damageMonster();
				}
			 attackPlayer();
			
	 }
	 
	 public void damageMonster()
	 {
		 Monster [] tempGoblins = getFirstGoblin().getGoblins();
			monsterArmor = tempGoblins[goblinNumber].getArmor();
			playerAttack = getPlayerAttack();
			playerAttackMin = getPlayerAttackMin();
			damageTakenMonster = playerAttackMin + (int)(Math.random()*playerAttack) - monsterArmor;
			if(damageTakenMonster <= 0)
			{
				damageTakenMonster = 0;
			}
			else
			{
				setPlayerHealthCurrent(getPlayerHealthCurrent() - damageTakenMonster);
			}
	 }
	
	 public void attackPlayer()
		{
			Monster [] tempGoblins = getFirstGoblin().getGoblins();
			monsterAttacksTotal = tempGoblins[goblinNumber].getAttackSpeed();
			multipleAttacks();
		}
		
		public void multipleAttacks()
		{
			Monster [] tempGoblins = getFirstGoblin().getGoblins();
			if(monsterAttacksTotal >= 1)
			{
				goblinNumber = getGoblinNumber();
				attackBonus = tempGoblins[goblinNumber].getAccuracy();
				playerDodge = getPlayerDodge();
				hitContestMonster = attackBonus + (int)(Math.random()*20);
				if(hitContestMonster >= playerDodge)
				{
					damagePlayer();
				}
				monsterAttacksTotal--;
				if(monsterAttacksTotal >= 1)
				{
					multipleAttacks();
				}
				else
				{
					
				}
				
			}
		}
		
		public void damagePlayer()
		{
			Monster [] tempGoblins = getFirstGoblin().getGoblins();
			playerArmor = getPlayerArmor();
			monsterDamage = tempGoblins[goblinNumber].getAttackMin();
			monsterMinDamage = tempGoblins[goblinNumber].getAttack();
			damageTakenPlayer = monsterMinDamage + (int)(Math.random()*monsterDamage) - playerArmor;
			if(damageTakenPlayer <= 0)
			{
				damageTakenPlayer = 0;
			}
			else
			{
				liveMonster = tempGoblins[goblinNumber].getMobHealthCurrent() - damageTakenPlayer;
			}
			
		}
	public int getAttackBonus() 
	{
		return attackBonus;
	}
	public void setAttackBonus(int attackBonus) 
	{
		this.attackBonus = attackBonus;
	}
	public int getAttackingBonus() 
	{
		return attackingBonus;
	}
	public void setAttackingBonus(int attackingBonus) 
	{
		this.attackingBonus = attackingBonus;
	}
	public int getDamageTakenPlayer() 
	{
		return damageTakenPlayer;
	}
	public void setDamageTakenPlayer(int damageTakenPlayer) 
	{
		this.damageTakenPlayer = damageTakenPlayer;
	}
	public int getDamageTakenMonster() 
	{
		return damageTakenMonster;
	}
	public void setDamageTakenMonster(int damageTakenMonster) 
	{
		this.damageTakenMonster = damageTakenMonster;
	}
	public int getMonsterAttacksTotal() 
	{
		return monsterAttacksTotal;
	}
	public void setMonsterAttacksTotal(int monsterAttacksTotal) 
	{
		this.monsterAttacksTotal = monsterAttacksTotal;
	}
	public int getMonsterArmor() 
	{
		return monsterArmor;
	}
	public void setMonsterArmor(int monsterArmor) 
	{
		this.monsterArmor = monsterArmor;
	}
	public int getMonsterDamage() 
	{
		return monsterDamage;
	}
	public void setMonsterDamage(int monsterDamage) 
	{
		this.monsterDamage = monsterDamage;
	}
	public int getMonsterMinDamage() 
	{
		return monsterMinDamage;
	}
	public void setMonsterMinDamage(int monsterMinDamage) 
	{
		this.monsterMinDamage = monsterMinDamage;
	}
	public int getMonsterDodge() 
	{
		return monsterDodge;
	}
	public void setMonsterDodge(int monsterDodge) 
	{
		this.monsterDodge = monsterDodge;
	}
	public int getHitContestMonster() 
	{
		return hitContestMonster;
	}
	public void setHitContestMonster(int hitContestMonster) 
	{
		this.hitContestMonster = hitContestMonster;
	}
	public int getHitContestPlayer() 
	{
		return hitContestPlayer;
	}
	public void setHitContestPlayer(int hitContestPlayer) 
	{
		this.hitContestPlayer = hitContestPlayer;
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
