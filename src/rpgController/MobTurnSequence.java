package rpgController;

import rpgController.RPGAppController;

public class MobTurnSequence extends RPGAppController
{
	boolean isPlayersTurn = true;
	
	public MobTurnSequence()
	{
		attackPlayer();
	}
}
