package rpgModel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import rpgModel.Goblin;
import rpgModel.Monster;
import rpgController.RPGAppController;
import rpgView.RPGFrame;
import rpgView.RPGPanel;

public class Attacking extends RPGAppController
{

	private RPGAppController attackController;
	private int attackBonus;
	private int dodgePlayer;
	private int hitContest;
	private int armorPlayer;
	private int monsterDamage;
	private int monsterMinDamage;
	private int damageTakenPlayer;
	private int monsterAttacksTotal;
	
	
	public Attacking(RPGAppController attackController)
	{
		this.attackController = attackController;
		attackBonus = 0;
		dodgePlayer = 10;
		hitContest = 0;
		armorPlayer = 0;
		monsterDamage = 0;
		monsterAttacksTotal = 1;
		
	}
	public void attackMonster()
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
			hitContest = attackBonus + (int)(Math.random()*20);
			if(hitContest >= dodgePlayer)
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
			attackController.setPlayerHealthCurrent(attackController.getPlayerHealthCurrent() - damageTakenPlayer);
		}
	}
}
