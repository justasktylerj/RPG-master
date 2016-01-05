package rpgModel;

public class Monster 
{
	private int mobHealthMax;
	private String name;
	private String description;
	private int strength;
	private int magic;
	private int dodge;
	private int attack;
	private int armor;
	private int attackMin;
	
	// strength is used for accuracy, extra damage, 
	//dodge is used to avoid attacks
	//armor reduces damage
	//magic is for spell accuracy, spell damage, magic resistance
	//attack is max damage
	//attack min is lowest damage
	
	public Monster()
	{
		this.mobHealthMax = 0;
		this.name = "";
		this.description = "";
		this.strength = 0;
		this.magic = 0;
		this.dodge = 0;
		this.attack = 0;
		this.attackMin = 0;
		this.armor = 0;
	}

	public Monster(int mobHealthMax, String name, String description, int strength, int magic, int dodge, int attack, int attackMin, int armor)
	{
		this.mobHealthMax = mobHealthMax;
		this.name = name;
		this.description = description;
		this.strength = strength;
		this.magic = magic;
		this.dodge = dodge;
		this.attack = attack;
		this.attackMin = attackMin;
		this.armor = armor;
		
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

	public void setName(String Name) 
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

	public int getStrength() 
	{
		return strength;
	}

	public void setStrength(int strength) 
	{
		this.strength = strength;
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


