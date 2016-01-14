package rpgModel;

import rpgView.RPGFrame;
import rpgView.RPGPanel;
import rpgModel.Monster;
import rpgModel.Mechanics;
import rpgController.MobTurnSequence;
import rpgController.RPGAppController;

public class HeroStats extends Goblin
{
	public int playerHealthMax;
	public int playerHealthCurrent;
	public int playerAccuracy;
	public int playerStrength;
	public int playerMagic;
	public int playerDodge;
	public int playerAttack;
	public int playerArmor;
	public int playerAttackMin;
	public int playerAttackSpeed;
	public int playerLevel;
	
	public HeroStats()
	{
		this.playerHealthMax = 20;
		this.playerHealthCurrent = 20;
		this.playerAccuracy = 0;
		this.playerStrength = 0;
		this.playerMagic = 0;
		this.playerDodge = 0;
		this.playerAttack = 3;
		this.playerAttackMin = 1;
		this.playerArmor = 0;
		this.playerAttackSpeed = 1;
		this.playerLevel = 1;
	}
	
	public HeroStats(int playerHealthMax, int playerHealthCurrent, int playerAccuracy, int playerStrength, int playerMagic, int playerDodge, int playerAttack, int playerArmor, int playerAttackMin, int playerAttackSpeed, int playerLevel, boolean liveMonster)
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
	}
	
	public int getPlayerHealthCurrent() 
	{
		return playerHealthCurrent;
	}
	
	public void setPlayerHealthCurrent(int playerHealthCurrent) 
	{
		this.playerHealthCurrent = playerHealthCurrent;
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
