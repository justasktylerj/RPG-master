package rpgModel;

import rpgView.RPGFrame;
import javax.swing.JLabel;
import rpgModel.Goblin;
import rpgView.RPGFrame;
import rpgModel.Monster;
import rpgView.RPGPanel;
import rpgView.RPGPanel;
import rpgController.MobTurnSequence;
import rpgController.RPGAppController;

public class Mechanics extends HeroStats
{
	private Goblin firstGoblin;
	private RPGFrame baseFrame;
	public static int goblinNumber;
	protected Goblin Goblin; 
	private int attackBonus;
	private int attackingBonus;
	private int damageTakenPlayer;
	private int damageTakenMonster;
	private int monsterAttacksTotal;
	private int monsterArmor;
	private int monsterDamage;
	private int monsterMinDamage;
	public boolean liveMonster;
	private int hitContestMonster;
	private int hitContestPlayer;
	public int randGoblin;
	public static String narrationText;
	public boolean isPlayersTurn;
	public String narration1Text;
	public String narration2Text;
	public String narration3Text;
	
	public Mechanics()
	{
		firstGoblin = new Goblin();
		
		Monster [] tempGoblins = getGoblins();
		this.liveMonster = true;
		this.hitContestMonster = 0;
		this.hitContestPlayer = 0;
		this.monsterDamage = 0;
		this.monsterAttacksTotal = 1;
		
		
	}
	
	public void changeText()
	{
		String narration3Text = narration2Text;
		String narration2Text = narration1Text;
		String narration1Text = narrationText;
	}
	
	public void attackMonster()
	 {
			 Monster [] tempGoblins = getGoblins();
			 
			 
			 hitContestPlayer = playerAccuracy + (int)(Math.random()*20);
				if(hitContestPlayer >= tempGoblins[goblinNumber].getDodge())
				{
					damageMonster();
					narrationText = "You hit " + tempGoblins[goblinNumber].getName();
				}
				else
				{
					narrationText = "You miss " + tempGoblins[goblinNumber].getName();
				}
				changeText();
	 }
	 
	public void damageMonster()
	 {
		 Monster [] tempGoblins = getGoblins();
			
			damageTakenMonster = playerAttackMin + (int)(Math.random()*playerAttack) - tempGoblins[goblinNumber].getArmor();
			if(damageTakenMonster <= 0)
			{
				damageTakenMonster = 0;
			}
			else
			{
				tempGoblins[goblinNumber].setMobHealthCurrent(tempGoblins[goblinNumber].getMobHealthCurrent() - damageTakenMonster);	
			}
			
			if(tempGoblins[goblinNumber].getMobHealthCurrent() <= 0)
			{
				liveMonster = false;
				tempGoblins[goblinNumber].setMobHealthCurrent(0);
				narrationText = "you killed the " + tempGoblins[goblinNumber].getName();
			}
	 }
	
	public void attackPlayer()
		{
			Monster [] tempGoblins = getGoblins();
			multipleAttacks();
		}
		
	public void multipleAttacks()
		{
			Monster [] tempGoblins = getGoblins();
			
			for( int monsterAttacksTotal = 0; monsterAttacksTotal >= tempGoblins[goblinNumber].getAttackSpeed(); monsterAttacksTotal++)
			{
				goblinNumber = getGoblinNumber();
				playerDodge = getPlayerDodge();
				hitContestMonster = tempGoblins[goblinNumber].getAccuracy() + (int)(Math.random()*20);
				if(hitContestMonster >= playerDodge)
				{
					damagePlayer();
					narrationText = tempGoblins[goblinNumber].getName() + " hits you";
				}
				else
				{
					narrationText = "you dodge " + tempGoblins[goblinNumber].getName() + "'s attack";
				}
				changeText();
			
			}
		}
		
	public void damagePlayer()
		{
			Monster [] tempGoblins = getGoblins();
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
				setPlayerHealthCurrent(playerHealthCurrent - damageTakenPlayer);
				if(playerHealthCurrent <= 0)
				{
					narrationText = "you died";
				}
			}
			
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
	
	public boolean getLiveMonster() 
	{
		return liveMonster;
	}
	
	public void setLiveMonster(boolean liveMonster) 
	{
		this.liveMonster = liveMonster;
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
	
}
