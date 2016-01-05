package rpgModel;

public class Monster 
{
	private int mobHealthMax;
	private String name;
	private String description;
	private int accuracy;
	private int magic;
	private int dodge;
	private int attack;
	private int armor;
	private int attackMin;
	private int attackSpeed;
	
	// strength is used for accuracy, extra damage, 
	//dodge is used to avoid attacks
	//armor reduces damage
	//magic is for spell accuracy, spell damage, magic resistance
	//attack is max damage
	//attack min is lowest damage
	
	public Monster()
	{
		this.mobHealthMax = 0;
		this.name = "empty";
		this.description = "empty";
		this.accuracy = 0;
		this.magic = 0;
		this.dodge = 0;
		this.attack = 0;
		this.attackMin = 0;
		this.armor = 0;
		this.attackSpeed = 1;
	}

	public Monster(int mobHealthMax, String name, String description, int accuracy, int magic, int dodge, int attack, int attackMin, int armor, int attackSpeed)
	{
		this.mobHealthMax = mobHealthMax;
		this.name = name;
		this.description = description;
		this.accuracy = accuracy;
		this.magic = magic;
		this.dodge = dodge;
		this.attack = attack;
		this.attackMin = attackMin;
		this.armor = armor;
		this.attackSpeed = attackSpeed;
		
	}
	public int getAttackSpeed() 
	{
		return attackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) 
	{
		this.attackSpeed = attackSpeed;
	}

	public int getMobHealthMax() 
	{
		return mobHealthMax;
	}

	public void setMobHealthMax(int mobHealthMax) 
	{
		this.mobHealthMax = mobHealthMax;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public int getAccuracy() 
	{
		return accuracy;
	}

	public void setAccuracy(int accuracy) 
	{
		this.accuracy = accuracy;
	}

	public int getMagic() 
	{
		return magic;
	}

	public void setMagic(int magic) 
	{
		this.magic = magic;
	}
	
	public int getDodge()
	{
		return dodge;
	}
	
	public void setDodge(int dodge)
	{
		this.dodge = dodge;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	
	public int getArmor()
	{
		return armor;
	}
	
	public void setArmor(int armor)
	{
		this.armor = armor;
	}
	
	public int getAttackMin()
	{
		return attackMin;
	}
	
	public void setAttackMin(int attackMin)
	{
		this.attackMin = attackMin;
	}
}


