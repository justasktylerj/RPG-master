package rpgModel;

public class Goblin  
{
	
	private String namePlayer;
	private Monster[] goblins;
	public static int randGoblin;

	public Goblin()
	{
		this.namePlayer ="";
		this.goblins = new Monster[6];
		setupGoblins();
	}
	
	private void setupGoblins()
	{
		Monster goblin, goblinZombie, zapper;
		goblin = new Monster();
		goblin.setMobHealthMax(10);
		goblin.setMobHealthCurrent(10);
		goblin.setName("Goblin");
		goblin.setDescription("weak small green evil humaniods");
		goblin.setAccuracy(0);
		goblin.setMagic(0);
		goblin.setDodge(10);
		goblin.setAttackMin(1);
		goblin.setAttack(4);
		goblin.setArmor(0);
		goblin.setAttackSpeed(1);
		goblin.setFinder(0);
		
		goblinZombie = new Monster(5, 5,"zombie Goblin", "undead goblins risen from necromancy", 2, 2, 8, 2, 8, 0, 1, 1);
		
		zapper = new Monster(20, 20,"Goblin Zapper", "Smart Goblins that Wield Bombs", 1, 0, 12, 3, 12, 4, 1, 2);
		
		goblins[0] = goblin;
		goblins[1] = goblinZombie;
		goblins[2] = zapper;
		goblins[3] = goblin;
		goblins[4] = goblin;
		goblins[5] = goblin;
	
		
	}
	
	public String getNamePlayer() 
	{
		return namePlayer;
	}

	public void setNamePlayer(String namePlayer) 
	{
		this.namePlayer = namePlayer;
	}
	
	public Monster[] getGoblins()
	{
		return goblins;
	}
	
	public void setGoblins(Monster[] goblins)
	{
		this.goblins = goblins;
	}
}
