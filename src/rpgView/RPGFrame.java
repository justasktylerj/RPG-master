package rpgView;

import rpgController.RPGAppController;
import javax.swing.*;

public class RPGFrame extends JFrame
{
	private RPGAppController baseController;
	private RPGPanel basePanel;
	
	public RPGFrame(RPGAppController baseController)
	{
		this.baseController = baseController;
		basePanel = new RPGPanel(baseController);
		setupFrame();
	}
	
	public String getResponse(String prompt)
	{
		String response = JOptionPane.showInputDialog(this, prompt);
		return response;
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public RPGAppController getBaseController()
	{
		return baseController;
	}
}


