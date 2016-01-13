package rpgController;

import rpgController.RPGAppController;
import rpgModel.Mechanics;

public class MobTurnSequence extends Mechanics
{
	boolean isPlayersTurn = true;
	public MobTurnSequence()
	{
		attackPlayer();
		changeText();
	}
}
