package rpgController;

import rpgController.RPGAppController;
import rpgView.RPGFrame;

public class RPGAppController 
{
	private RPGFrame baseFrame;
	
	public RPGAppController()
	{
		baseFrame = new RPGFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public RPGFrame getBaseFrame() 
	{
		return baseFrame;
	}
}
