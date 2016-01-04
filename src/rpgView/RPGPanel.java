package rpgView;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

import rpgModel.Monster;
import rpgController.RPGAppController;
import javax.swing.event.ChangeListener;

public class RPGPanel extends JPanel
{

	private SpringLayout baseLayout;
	private RPGAppController baseController;
	private JButton attackButton;
	private JLabel health;
	private JCheckBox mobStats;
	private JLabel name;
	private JLabel description;
	
	public RPGPanel(RPGAppController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		attackButton = new JButton("ATTACK");
		health = new JLabel("20/20");
		mobStats = new JCheckBox("Show monster's stats");
		name = new JLabel("the name");
		
		
		
		//setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.ORANGE);
		this.add(attackButton);
		this.add(mobStats);
		this.add(name);
		this.add(description)
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, attackButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, attackButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, mobStats, 0, SpringLayout.NORTH, attackButton);
		baseLayout.putConstraint(SpringLayout.WEST, mobStats, 2, SpringLayout.EAST, attackButton);
	}
	
	private void setupListeners()
	{
		ChangeListener mobStats = new ChangeListener()
		{
			public void stateChanged(ChangeEvent changeEvent) 
			{
				
			}
		});
	}
}

