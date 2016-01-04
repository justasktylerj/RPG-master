package rpgModel;

public class Goblin 
{
	private Monster [] goblins;
	
	public Monster[] getGoblins() 
	{
		return goblins;
	}

	public void setGoblins(Monster[] goblins)
	{
		this.goblins = goblins;
	}

	public void goblinList()
	{

		this.goblins = new Monster[5];
		setupBooks();
	}
	
	private void setupBooks()
	{
		Monster goblin, goblinZombie, Zapper;
		goblin = new Monster();
		goblin.setMobHealthMax(10);
		goblin.setName("Goblin");
		goblin.setDescription("weak small green evil humaniods");
		goblin.setStrength(0);
		goblin.setMagic(0);
		goblin.setDodge(10);
		goblin.setAttackMin(1);
		goblin.setAttack(4);
		goblin.setArmor(0);
		
		goblinZombie = new Monster(5,"zombie Goblin", "undead goblins, risen from necromancy", 2, 2, 8, 2, 8, 0);
		
		Zapper = new Monster(20,"Goblin Zapper", "Smart Goblins that Wield Bombs", 1, 0, 12, 3, 12, 4);
		
		goblins[0] = goblin;
		goblins[1] = goblinZombie;
		goblins[2] = Zapper;
		goblins[3] = goblin;
		goblins[4] = goblin;
		goblins[5] = goblin;
		
		
		
	}
	
}
