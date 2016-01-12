package rpgController;

import rpgController.RPGAppController;
import rpgView.RPGPanel;

public class RPGRunner 
{
	public static void main (String [] args)
	{
		RPGAppController myController = new RPGAppController();
		myController.start();
	}
}
