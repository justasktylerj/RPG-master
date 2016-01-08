package rpgModel;

import rpgModel.Monster;
import rpgController.RPGAppController;
import rpgView.RPGPanel;

public class Attacking extends RPGAppController
{

	private RPGAppController attackController;
	private RPGPanel panelController;
	private int attackBonus;
	private int attackingBonus;
	private int dodgePlayer;
	private int monsterDodge;
	private int hitContestMonster;
	private int hitContestPlayer;
	private int playerDamage;
	private int playerDamageMin;
	private int monsterDamage;
	private int monsterMinDamage;
	private int damageTakenPlayer;
	private int damageTakenMonster;
	private int monsterAttacksTotal;
	private int monsterArmor;
	private int armorPlayer;
	

	
	
	
	public Attacking(RPGAppController attackController)
	{
		this.attackController = attackController;
		attackBonus = 0;
		dodgePlayer = 10;
		hitContestMonster = 0;
		hitContestPlayer = 0;
		armorPlayer = 0;
		monsterDamage = 0;
		monsterAttacksTotal = 1;
		attackingBonus = 0;
		monsterDodge = 0;
		monsterArmor = 0;
		playerDamage = 0;
		playerDamageMin = 0;
		
		
	}

	public Attacking() 
	{
		
	}

	public void attackPlayer()
	{
		Monster [] tempGoblins = attackController.getFirstGoblin().getGoblins();
		monsterAttacksTotal = tempGoblins[goblinNumber].getAttackSpeed();
		multipleAttacks();
	}
	
	public void multipleAttacks()
	{
		Monster [] tempGoblins = attackController.getFirstGoblin().getGoblins();
		if(monsterAttacksTotal >= 1)
		{
			goblinNumber = getGoblinNumber();
			attackBonus = tempGoblins[goblinNumber].getAccuracy();
			dodgePlayer = attackController.getPlayerDodge();
			hitContestMonster = attackBonus + (int)(Math.random()*20);
			if(hitContestMonster >= dodgePlayer)
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
		Monster [] tempGoblins = attackController.getFirstGoblin().getGoblins();
		armorPlayer = attackController.getPlayerArmor();
		monsterDamage = tempGoblins[goblinNumber].getAttackMin();
		monsterMinDamage = tempGoblins[goblinNumber].getAttack();
		damageTakenPlayer = monsterMinDamage + (int)(Math.random()*monsterDamage) - armorPlayer;
		if(damageTakenPlayer <= 0)
		{
			damageTakenPlayer = 0;
		}
		else
		{
			attackController.liveMonster = tempGoblins[goblinNumber].getMobHealthCurrent() - damageTakenPlayer;
		}
		
	}
	 public void attackMonster()
	 {
			 Monster [] tempGoblins = attackController.getFirstGoblin().getGoblins();
			 attackingBonus = attackController.getPlayerAccuracy();
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
		 Monster [] tempGoblins = attackController.getFirstGoblin().getGoblins();
			monsterArmor = tempGoblins[goblinNumber].getArmor();
			playerDamage = attackController.getPlayerAttack();
			playerDamageMin = attackController.getPlayerAttackMin();
			damageTakenMonster = playerDamageMin + (int)(Math.random()*playerDamage) - monsterArmor;
			if(damageTakenMonster <= 0)
			{
				damageTakenMonster = 0;
			}
			else
			{
				attackController.setPlayerHealthCurrent(attackController.getPlayerHealthCurrent() - damageTakenMonster);
			}
	 }
	
}
